package com.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate q;

	public void insertUser(UserBean user) {
		q.update("insert into users (firstname,lastname,email,password,gender) values(?,?,?,?,?)", user.getFirstName(),
				user.getLastName(), user.getEmail(), user.getPassword(), user.getGender());
	}

	public List<UserBean> getAllUsers() {
		List<UserBean> users = q.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}

	public boolean verify(String email) {
		if (q.query("select * from users where email=?", new BeanPropertyRowMapper<UserBean>(UserBean.class),
				new Object[] { email }) == null) {
			return false;
		}
		return true;
	}

	public void deleteUser(int userId) {
		q.update("delete from users where userid=?", userId);
	}

	public UserBean userInfo(int userId) {
		UserBean user = q.queryForObject("select * from users where userId=? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { userId });
		return user;
	}

	public List<UserBean> searchInfo(String name) {
//		System.out.println(name);
//		name = StringUtils.quote(name+"%");
		name = name + "%";
//		 String name1  = name.toUpperCase()+"%";
		List<UserBean> users = q.query("select * from users where firstname ilike ?",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { name });

		return users;
	}
}
