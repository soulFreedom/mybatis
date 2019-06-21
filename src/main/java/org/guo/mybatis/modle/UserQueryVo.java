package org.guo.mybatis.modle;

import java.util.List;

public class UserQueryVo {
	
	//传入多个id查询用户信息。
	private List<Integer> ids;
	//包装所需要的查询条件。
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}
