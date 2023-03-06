/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.login.service.impl;

import com.finlogic.tms.login.datamanager.LoginDataManager;
import com.finlogic.tms.login.bean.LoginFormBean;
import com.finlogic.tms.login.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService{
    
    @Autowired
    LoginDataManager loginDataManager;

    @Override
    public int insertUserLoginDetail(LoginFormBean loginFormBean) throws Exception {
        
        return loginDataManager.insertUserLoginDetail(loginFormBean);
    }

    @Override
    public int verifyUser(LoginFormBean loginFormBean) throws Exception {
        
        return loginDataManager.verifyUser(loginFormBean);
    }
    
    @Override
    public List getUserCode(LoginFormBean loginFormBean) throws Exception {
        
        return loginDataManager.getUserCode(loginFormBean);
    }

    @Override
    public int checkEmailExist(String email) throws Exception {
        return loginDataManager.checkEmailExist(email);
    }
    
    @Override
    public int checkUserNameExist(String userName) throws Exception {
        return loginDataManager.checkUserNameExist(userName);
    }
    
}
