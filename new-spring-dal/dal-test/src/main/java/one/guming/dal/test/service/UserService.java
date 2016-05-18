package one.rangp.dal.test.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import one.dal.support.annotation.DataSource;
import one.rangp.metadata.dao.entity.User;
import one.rangp.metadata.dao.mapper.UserDao;
/**
 * @author rangaopan
 *
 */
@Service
public class UserService implements BaseServices{
	@Resource
	private UserCoreService userCoreService;
	
	@Resource
	private UserDao userdao;

	/* 根据userId路由
	 * @see one.rangp.dal.test.service.BaseServices#addEntitys(java.lang.Integer, one.rangp.metadata.dao.entity.User)
	 */
	public void addEntitys(@DataSource(field="userId") Integer userId, User t) {
		userdao.addUser(t);
		
	}
	
	/** 根据datasource 名称路由
	 * @param t dataSourceKey
	 */
	@DataSource(name="dataSourceKey2")
	public void addEntitysByName(User t) {
		userdao.addUser(t);
		
	}
	
	/** 如果是读写分离的情况 可以通过readOnly 解析
	 * @param userId
	 * @param t
	 */
	public void addEntitysByReadOnly(@DataSource(field="userId",readonly=false) Integer userId, User t) {
		userdao.addUser(t);
		
	}
	
	/** 在一次连接中切库
	 * @param userId
	 * @param t
	 */
	public void addEntitysSwitch(@DataSource(field="userId") Integer userId, User t) {
		User userTemp = new User("李四", "北京");
		if(t.getUserId()>=100){
			userTemp.setUserId(7);
		} else{
			userTemp.setUserId(186);
		}
		userCoreService.addEntitys(userTemp.getUserId(), userTemp);
		userdao.addUser(t);
	}


}
