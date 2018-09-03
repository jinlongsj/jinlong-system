package com.jinlong.system.model.po.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/**
 * 用户基础信息
 * @author 肖学进
 */
@Data
public class UserBasePO implements Serializable, UserDetails {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8340608768492225753L;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 角色ID
	 */
	private Integer roleId;
	
	/**
	 * 所属角色用户的扩展表ID
	 */
	private Integer affiliatedId;
	
	/**
	 * 用户注册时间
	 */
	private Date registerTime;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 用户手机号码
	 */
	private String mobilePhone;
	
	/**
	 * 用户邮箱
	 */
	private String email;
	
	/**
	 * 用户状态
	 */
	private Integer state;
	

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	
}