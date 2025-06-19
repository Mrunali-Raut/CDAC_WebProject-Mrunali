package org.daoImpl;

import org.dao.UserDAO;
import org.model.pojo.User;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class UserDaoImpl implements UserDAO {

	@Override
	public boolean saveUser(User user) {
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
			if (inputStream == null) throw new RuntimeException("Property file not found");

			Properties dbProps = new Properties();
			dbProps.load(inputStream);

			String url = dbProps.getProperty("connection.url");
			String dbUser = dbProps.getProperty("connection.username");
			String dbPass = dbProps.getProperty("connection.password");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, dbUser, dbPass);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO user (username, password, name, email, city) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getCity());

			int rows = ps.executeUpdate();
			ps.close(); conn.close();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean loginUser(String username, String password) {
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
			if (inputStream == null) throw new RuntimeException("Property file not found");

			Properties dbProps = new Properties();
			dbProps.load(inputStream);

			String url = dbProps.getProperty("connection.url");
			String dbUser = dbProps.getProperty("connection.username");
			String dbPass = dbProps.getProperty("connection.password");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, dbUser, dbPass);

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);

			boolean found = ps.executeQuery().next();
			ps.close(); conn.close();

			return found;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
