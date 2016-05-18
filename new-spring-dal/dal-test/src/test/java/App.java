
import javax.annotation.Resource;




import one.rangp.dal.test.service.BaseServices;
import one.rangp.dal.test.service.UserService;
import one.rangp.metadata.dao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring.xml")
public class App 
{
	@Resource
	private BaseServices userService;
	@Test
	public void addUser(){
		User user = new User("张三", "南京");
		user.setUserId(1);
		// 通过userId 区间路由
//		 userService.addEntitys(user.getUserId(),user);
//		 user.setUserId(100);
//		 userService.addEntitys(user.getUserId(),user);
		
		// 通过名字路由
		// userService.addEntitysByName(user);
		
		// 一次连接切换路由两次  写不同的库 必须在servie 外面切换 但是读可以在 里面切换
		// 演示一个例子
	    //user.setUserId(55);
		// userService.addEntitysSwitch(user.getUserId(),user);
		
		// 读写分离演示  addEntitysByReadOnly
		//user.setUserId(100);
		// userService.addEntitysByReadOnly(user.getUserId(),user);
		
	}
}
