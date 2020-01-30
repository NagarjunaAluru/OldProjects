package com.galaxe.gst.dao.login;

import com.galaxe.gst.models.login.Users;


/**
 * 
 * @author naluru
 *
 */
public interface LoginDao {
	Users findByUserName(String username);
}
