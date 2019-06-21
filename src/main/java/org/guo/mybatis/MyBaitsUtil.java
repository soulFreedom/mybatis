package org.guo.mybatis;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBaitsUtil {
	
	private static final Log log = LogFactory.getLog(MyBaitsUtil.class);
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	public static void initMyBatisConf() throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		if (sqlSessionFactory == null) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);			
		}
		
		//非线程安全的。
//		SqlSession session = sqlSessionFactory.openSession();
		
		log.info("init myBatis conf succ..");
		
	}
	
	public static SqlSession getSqlSession() throws Exception{
		initMyBatisConf();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	public static void main(String[] args) throws Exception{
		initMyBatisConf();
	}
	
}
