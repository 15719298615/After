package com.ys.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
/**
 * 
 * @author ys
 *
 */
public class Demo {
	/**
	 * Junit4 单元测试插件
	 * 
	 * 直接测试方法，不用编写主方法
	 * 
	 * 在需要运行的方法上添加@Test
	 * 
	 * 方法强制有要求
	 * 		必须是public
	 * 		必须是没有返回值的
	 * 		没有参数
	 * 		当前项目中不要有Test类
	 */
	@Test
	public void testInsert(){

		Jedis jedis = new Jedis("ip地址",6379);
/*		String result = jedis.set("address","咸阳");//新增
		System.out.println(result);
		*/
		
		/*String result = jedis.get("address");//查
		System.out.println(result);*/
		
//		String result = jedis.set("address", "北京");//修改
//		System.out.println(result);
		
//		Long result = jedis.del("address");//删除
//		System.out.println(result);
		
	}
	
}
