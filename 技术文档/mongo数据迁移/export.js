conn = new Mongo("10.26.235.195:27017");
db = conn.getDB("nubia_browser");
var tables = db.getCollectionNames();
for(var i = 0 ; i < tables.length; i ++){
	if(isNeed(tables[i])){
		printjsononeline(tables[i]);
		db.getCollection(tables[i]).drop();
	}
}

function isNeed(tableName){
	if(tableName.indexOf('org_box_nav_info') > -1){
		var date = tableName.split("_")[4];
			if(date <= '20161231'){
				return true;
			}	
	}
	if(tableName.indexOf('org_icon_nav_info') > -1){
		var date = tableName.split("_")[4];
			if(date <= '20161231'){
				return true;
			}	
	}
	if(tableName.indexOf('org_search_detail_info') > -1){
		var date = tableName.split("_")[4];
			if(date <= '20161231'){
				return true;
			}	
	}
	if(tableName.indexOf('org_search_info') > -1){
		var date = tableName.split("_")[3];
			if(date <= '20161231'){
				return true;
			}	
	}
	if(tableName.indexOf('org_summary_info') > -1){
		var date = tableName.split("_")[3];
			if(date <= '20161231'){
				return true;
			}	
	}
	if(tableName.indexOf('org_url_info') > -1){
		var date = tableName.split("_")[3];
			if(date <= '20161231'){
				return true;
			}	
	}
}

