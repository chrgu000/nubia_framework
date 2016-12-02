#!/bin/sh
cd /data/program/mongodb-2.4.9/bin
./mongo 10.206.19.224:27017 drop.js >> bak_tables.json
JSON="bak_tables.json"
echo $JSON
for i in `cat $JSON`
do
./mongoexport -h 10.206.19.224:27017 -d nubia_browser_test -c ${i//\"/} -o /data/bak/20161017/${i//\"/}.json
done
