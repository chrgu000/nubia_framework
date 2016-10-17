conn = new Mongo("10.206.19.224:27017");
db = conn.getDB("nubia_browser_test");
var tables = db.getCollectionNames();
for(var i = 0 ; i < tables.length; i ++){
	if(getBoolean(tables[i])){
	    db.getCollection(tables[i]).drop();
		printjsononeline(tables[i]);
	}
}

function getBoolean(str){
   if(parseInt(str.split("_")[4]) < 20160301){
      return true;
   }else{
      return false;
   }
}
