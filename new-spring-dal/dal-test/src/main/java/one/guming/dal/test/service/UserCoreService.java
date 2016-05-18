package one.rangp.dal.test.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



import one.dal.support.annotation.DataSource;
import one.rangp.metadata.dao.entity.User;
import one.rangp.metadata.dao.mapper.UserDao;
@Service
public class UserCoreService{
	
	@Resource
	private UserDao userdao;

	public void addEntitys(@DataSource(field="userId") Integer userId, User t) {
		userdao.addUser(t);
		
	}

}
