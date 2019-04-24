import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zw.MyMaven.pojo.User;
import com.zw.MyMaven.service.UserService;

/**
 * 
 * 类描述：测试用例
 * 作者： LiuJinrong  
 * 创建日期：2018年12月28日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class MyTest {
	
	@Test
	public void add(){
		
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService = app.getBean("userService", UserService.class);
		
		User user = new User();
		user.setUsername("jack");
		user.setSex("男");
		userService.add(user);
	}

}
