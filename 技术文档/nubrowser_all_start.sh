#!/bin/bash

#instructions: this is the start script of nubrowser in 223, it will be triggered when a system reboot happens
#the whole procedure:
#redis->activemq->nubrowser-admin->nubrowser-admin-test->nubrowser->nubrowser_test->upgrade->push->jpush->nginx->curl test
#test whether a sevice is available:
#curl -I -m 10 -o /dev/null -s -w %{http_code} admin.browser-dev.server.ztemt.com.cn
#ps -ef | grep redis | grep -v grep
#jps -l | grep activemq

tomcatShellDir=/data/program/tomcat-8.0.11/bin/;
redisShellDir=/data/program/redis-3.0.0-rc4/etc/;
activemqShellDir=/data/program/activemq/apache-activemq-5.11.1-one/bin;
nginxShellDir=/data/program/nginx-1.7.8/sbin/;
jpushRootDir=/data/wwwroot/nubia_browser_jpush/;
adminDomainToTest=http://admin.browser-dev.server.ztemt.com.cn;
javaBinDir=/data/program/jdk-1.8.0_45/bin/;

#start redis
/bin/bash $redisShellDir'/init.sh';
count=`ps aux | grep redis | grep -v grep | wc -l`;
overTime=30;
timeCount=0;
until [ $count -gt 0 ]
do
   sleep 3;
   timeCount+=3;
   if [ $timeCount -gt $overTime ]
   then
	   echo "fail to start redis in "$overTime" seconds, exit now."
	   exit 1;
   fi
   count=`ps aux | grep redis | grep -v grep | wc -l`;
done

#start activemq
/bin/bash /data/program/activemq/apache-activemq-5.11.1-one/bin/activemq start;
count=`jps -l | grep activemq | wc -l`;
overTime=60;
timeCount=0;
until [ $count -gt 0 ]
do
   sleep 3;
   timeCount+=3;
   if [ $timeCount -gt $overTime ]
   then
	   echo "fail to start activemq in "$overTime" seconds, exit now."
	   exit 1;
   fi
   count=`jps -l | grep activemq | wc -l`;
done

#start web service
cd $tomcatShellDir;
./nubrowser-admin.sh start
sleep 1
./nubrowser_admin_test.sh start
sleep 1
./nubrowser.sh start
sleep 1
./nubrowser_test.sh start
sleep 1
./upgrade.sh start
sleep 1
./nubrowser_push.sh start
sleep 1

cd $jpushRootDir;
nohup $javaBinDir'java' -Xms512m -Xmx512m -classpath .:lib/* com.ztemt.push.controller.Main &

cd $nginxShellDir;
./nginx
count=`ps -ef | grep nginx | grep -v grep | wc -l`;
overTime=30;
timeCount=0;
until [ $count -gt 0 ]
do
   sleep 3;
   timeCount+=3;
   if [ $timeCount -gt $overTime ]
   then
	   echo "fail to start nginx in "$overTime" seconds, exit now."
	   exit 1;
   fi
   count=`ps -ef | grep nginx | grep -v grep | wc -l`;
done
sleep 3
./nginx -s reload

echo "all done!test now."
#TODO check the availability of the programe
httpCode=`curl -I -m 20 -o /dev/null -s -w %{http_code} $adminDomainToTest`;
if [ $httpCode -eq 200 ]
then
	echo "connect to "$adminDomainToTest" ok."
	exit 0;	
else
	echo "fail to connect to "$adminDomainToTest" ,httpcode: "$httpCode;
	exit 1;
fi

exit 0;

