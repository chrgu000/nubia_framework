#!/bin/sh
cd /data/program/mongodb-2.4.9/bin
./mongoexport -h 10.206.19.224:27017 -d nubia_browser_test -c hour_summary_statistic_mid -q '{create_time:{$lt:1472659200}}' -o /data/bak/20161017/hour_summary_statistic_mid.json

