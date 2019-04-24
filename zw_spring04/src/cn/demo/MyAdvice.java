package cn.demo;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * 类描述：通知类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月24日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class MyAdvice {
	
	/**
	 * 
	 * 方法描述:前通知
	 */
	public void doBefore(){
		System.out.println("前通知...");
	}
	
	/**
	 * 
	 * 方法描述:后通知
	 */
	public void doAfter(){
		System.out.println("后通知...");
	}
	
	/**
	 * 
	 * 方法描述:返回后通知
	 */
	public void doReturnAfter(){
		System.out.println("返回后通知...");
	}
	
	/**
	 * 
	 * 方法描述:异常通知
	 */
	public void doThrow(){
		System.out.println("异常通知...");
	}
	
	/**
	 * 
	 * 方法描述: 环绕通知
	 * @param jp
	 * @return 返回类型时Object,传参连接点,需要抛出异常
	 * @throws Throwable
	 */
	public Object doAround(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("环绕通知开启...");
		// 执行被增强的方法
		Object obj = jp.proceed();
		System.out.println("环绕通知结束...");
		return obj;
	}

}
