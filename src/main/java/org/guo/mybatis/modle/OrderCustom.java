package org.guo.mybatis.modle;

/**
 *订单查询扩展类
 * @author pc
 *
 */
//通过此类映射订单和用户的查询结果，让此类继承较多的pojo类。

public class OrderCustom extends Order{
	private String username;
	private String email;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
