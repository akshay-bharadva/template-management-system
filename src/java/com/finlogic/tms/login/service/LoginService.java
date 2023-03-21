/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.login.service;

import com.finlogic.tms.login.bean.LoginFormBean;
import java.util.List;

/**
 *
 * @author njuser
 */
public interface LoginService {
    
    public int insertUserLoginDetail(LoginFormBean loginFormBean) throws Exception;
   
    public int verifyUser(LoginFormBean loginFormBean) throws Exception;
    
    public List getUserCode(LoginFormBean loginFormBean) throws Exception;
    
    public int checkEmailExist(String email) throws Exception;
    
    public int checkUserNameExist(String userName) throws Exception;

    public int getLoginHitCount(LoginFormBean loginFormBean) throws Exception;

    public int addToHistory(LoginFormBean loginFormBean) throws Exception;

    public int updateHistory(LoginFormBean loginFormBean, int counthits) throws Exception;
}

