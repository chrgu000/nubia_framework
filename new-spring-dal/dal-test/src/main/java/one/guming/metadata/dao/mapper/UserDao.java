package one.rangp.metadata.dao.mapper;

import org.springframework.stereotype.Repository;

import one.rangp.metadata.dao.BaseDao;
import one.rangp.metadata.dao.entity.User;
@Repository
public interface UserDao  extends BaseDao{
	
	public void addUser(User user);

}
