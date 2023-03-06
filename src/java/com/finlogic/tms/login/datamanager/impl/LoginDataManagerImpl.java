/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.login.datamanager.impl;

import com.finlogic.tms.login.datamanager.LoginDataManager;
import com.finlogic.tms.login.bean.LoginFormBean;
import com.finlogic.util.CommonMember;
import com.finlogic.util.persistence.SQLUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author njuser
 */

@Repository(value = "LoginDataManager")
public class LoginDataManagerImpl implements LoginDataManager{

    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();

    @Override
    public int insertUserLoginDetail(LoginFormBean loginFormBean) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append(" INSERT INTO TMS_USER_LOGIN(USERCODE,USERNAME,EMAIL,PASSWORD) ");
        query.append(" VALUES (uuid(),:USERNAME,:EMAIL,md5(:PASSWORD))");

        map.put("USERNAME", loginFormBean.getUserName());
        map.put("EMAIL", loginFormBean.getEmail());
        map.put("PASSWORD", loginFormBean.getPassword());

//        CommonMember.appendLogFile("@Repository :: InsertUserLoginDetail :: query:- " + query.toString());
//        CommonMember.appendLogFile("@Repository :: InsertUserLoginDetail :: map :- " + map);

        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public int verifyUser(LoginFormBean loginFormBean) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();

        query.append(" SELECT COUNT(*) FROM TMS_USER_LOGIN ");
        query.append(" WHERE PASSWORD = md5(:PASSWORD) AND (EMAIL = :EMAIL OR USERNAME = :USERNAME)");

        map.put("EMAIL", loginFormBean.getEmail());
        map.put("USERNAME", loginFormBean.getUserName());
        map.put("PASSWORD", loginFormBean.getPassword());

        CommonMember.appendLogFile("@Repository :: InsertUserLoginDetail :: query:- " + query.toString());
        CommonMember.appendLogFile("@Repository :: InsertUserLoginDetail :: map :- " + map);
        return sqlUtility.getIntValue(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public List getUserCode(LoginFormBean loginFormBean) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();

        query.append(" SELECT USERCODE,TYPE FROM TMS_USER_LOGIN UL INNER JOIN ");
        query.append(" TMS_USER_TYPE UT ON UL.USER_TYPE = UT.ID ");
        query.append(" WHERE PASSWORD = md5(:PASSWORD) AND (EMAIL = :EMAIL OR USERNAME = :USERNAME)");

        map.put("EMAIL", loginFormBean.getEmail());
        map.put("USERNAME", loginFormBean.getUserName());
        map.put("PASSWORD", loginFormBean.getPassword());

        CommonMember.appendLogFile("@Repository :: getUserCode :: query:- " + query.toString());
        CommonMember.appendLogFile("@Repository :: getUserCode :: map :- " + map);
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public int checkEmailExist(String email) throws Exception{
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("select COUNT(*) FROM TMS_USER_LOGIN ");
        query.append("WHERE EMAIL = :EMAIL");
        
        map.put("EMAIL", email);
        
        CommonMember.appendLogFile("@Repository :: CheckEmail :: query:- " + query.toString());
        CommonMember.appendLogFile("@Repository :: CheckEmail :: map :- " + map);
        
        return sqlUtility.getIntValue(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public int checkUserNameExist(String userName) throws Exception{
        
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        
        query.append("select COUNT(*) FROM TMS_USER_LOGIN ");
        query.append("WHERE USERNAME = :USERNAME");
        
        map.put("USERNAME", userName);
        
        CommonMember.appendLogFile("@Repository :: CheckUserName :: query:- " + query.toString());
        CommonMember.appendLogFile("@Repository :: CheckUserName :: map :- " + map);
        
        return sqlUtility.getIntValue(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
}

