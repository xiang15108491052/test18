package com.lovo.test18.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		String resource = "SqlMapConfig.xml";

		try {
			//以流的形式读取总配置文件
			InputStream in = Resources.getResourceAsStream(resource);
			//创建连接工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		//使用同一个工厂对象获取不同的session对象
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}

}
