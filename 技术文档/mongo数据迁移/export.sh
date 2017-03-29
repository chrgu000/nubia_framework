#!/bin/sh
cd /data/program/mongodb3.2.4/bin
./mongo 10.26.235.195:27017 export.js >> bak_tables.json
#JSON="bak_tables.json"
#echo $JSON
#for i in `cat $JSON`
#do
#./mongoexport -h 10.206.19.224:27017 -d nubia_browser_test -c ${i//\"/} -o /data/bak/20170307/${i//\"/}.json
#done
