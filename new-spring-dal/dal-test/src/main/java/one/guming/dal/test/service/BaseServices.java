package one.rangp.dal.test.service;

import one.rangp.metadata.dao.entity.User;

public interface BaseServices{
	
	void addEntitys(Integer userId,User t);

	void addEntitysByName(User user);

	void addEntitysSwitch(Integer userId, User user);

	void addEntitysByReadOnly(Integer userId, User user);
	
	

}
