conn = new Mongo("10.206.19.224:27017");
db = conn.getDB("nubia_browser_test");
db.getCollection('hour_summary_statistic_mid').remove({create_time:{$lt:1472659200}})

