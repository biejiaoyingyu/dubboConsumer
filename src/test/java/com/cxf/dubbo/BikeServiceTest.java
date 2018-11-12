package com.cxf.dubbo;

import com.cxf.dubbo.callBack.CallBackListener;
import com.cxf.dubbo.entities.Phone;
import com.cxf.dubbo.entities.User;
import com.cxf.dubbo.service.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class BikeServiceTest
{
	
	private ApplicationContext ctx = null;
	private BikeService service = null;

	@Before
	public void setUp() throws Exception
	{
		ctx = new ClassPathXmlApplicationContext("classpath:dubbo/dubbo-*.xml");
		service = (BikeService)ctx.getBean("bikeService");
	}

	@Test
	public void test()
	{
		service.qryAllBike().forEach(System.out::println);
	}

	@Test
	public void test5(){
		CallbackService callbackService = (CallbackService) ctx.getBean("callbackService");
		callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallBackListener(){
			public void changed(String msg) {
				System.out.println("callback1:" + msg);
			}
		});
		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test6() {
		BookService bookService = (BookService)ctx.getBean("onCallback");
		bookService.getOneBook4Callback(5);
		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test7() {
		Integer id = 1;
		UserService userService = (UserService)ctx.getBean("userService");
		User user = userService.getUserById( id) ;
		System.out.println(user.getName());
	}

	@Test
	public void test8() {
		Integer id = 1;
		PhoneService phoneService = (PhoneService)ctx.getBean("phoneService");
		Phone phone = phoneService.getPhoneById(id);
		System.out.println(phone);
	}
}
