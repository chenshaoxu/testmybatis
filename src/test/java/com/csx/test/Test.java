package com.csx.test;


import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSON;
import com.csx.mybatis.dao.ArticleMapper;
import com.csx.mybatis.dao.UserMapper;
import com.csx.mybatis.model.Article;
import com.csx.mybatis.model.User;

public class Test {
	private static Reader reader;
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			reader = Resources.getResourceAsReader("Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println("date1:"+df.format(new Date()));
		SqlSession session = sqlSessionFactory.openSession();
		int id = (int)(Math.random()*100);
		String uuid = UUID.randomUUID().toString();
		System.out.println("random id is:"+id);
		try {
			UserMapper usermapper = (UserMapper) session.getMapper(UserMapper.class);
			User user = (User) usermapper.selectUserByID(id);
			
			if(user == null){				
				User user2 = new User();
				user2.setId(id);
				user2.setUsername("chen");
				user2.setUserage((int)(Math.random()*100));
				user2.setUseraddress(uuid);
				usermapper.insert(user2);
							
			}else{
				user.setUsername("nihaoa");
				user.setUserage(230);
				usermapper.updateByPrimaryKey(user);
			}
			session.commit();	
			//usermapper.deleteByID(1);
			//session.commit();
			//System.out.println(JSON.toJSONString(usermapper));
			List<User> users = usermapper.selectUsers("s");
			System.out.println(JSON.toJSONString(users));
			System.out.println("count:"+usermapper.countAll());
			
			ArticleMapper articlemapper = session.getMapper(ArticleMapper.class);
			List<Article> at = articlemapper.getUserArticles(2);
			System.out.println("find id is "+(2)+" size:"+at.size());
			System.out.println(JSON.toJSONString(at));
			System.out.println("date2:"+df.format(new Date()));
		} finally {
			session.close();
		}
	}

}
