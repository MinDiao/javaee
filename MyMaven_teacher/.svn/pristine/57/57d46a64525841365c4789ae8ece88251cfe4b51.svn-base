import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zw.MyMaven.pojo.User;
import com.zw.MyMaven.service.UserService;

public class MyTest {

	@Test
	public void add(){
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = app.getBean("userService",UserService.class);
		User user = new User();
		user.setUsername("jack");
		user.setSex("男");
		userService.add(user);
	}
}
