/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.profile.datamanager.impl;

import com.finlogic.tms.profile.bean.ProfileFormBean;
import com.finlogic.tms.profile.datamanager.ProfileDataManager;
import com.finlogic.util.CommonMember;
import com.finlogic.util.persistence.SQLUtility;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author njuser
 */
@Repository(value = "ProfileDataManager")
public class ProfileDataManagerImpl implements ProfileDataManager{
    
    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();
    
    @Override
    public int updateProfile(ProfileFormBean profileFormBean , String usercode) throws SQLException, ClassNotFoundException
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();        
        
        query.append(" UPDATE TMS_USER_MAST SET FIRSTNAME = :FIRSTNAME , ");
        query.append(" LASTNAME = :LASTNAME , ");
        query.append(" DOB = :DOB , ");
        query.append(" PHONE_NO = :PHONE_NO , ");
        query.append(" GENDER = :GENDER");
        query.append(" WHERE USERCODE = :USERCODE");
        
        map.put("FIRSTNAME", profileFormBean.getTxtFname());
        map.put("LASTNAME", profileFormBean.getTxtLname());
        map.put("DOB",profileFormBean.getDob());
        map.put("PHONE_NO",profileFormBean.getMobNo());
        map.put("GENDER", profileFormBean.getGender());
        map.put("USERCODE", usercode);
        
        CommonMember.appendLogFile("@Repository :: ProfileDataManagerImpl ::  updateProfile :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: ProfileDataManagerImpl :: updateProfile :: map :: " + map);
        
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
    @Override
    public List getProfile(String usercode) throws SQLException, ClassNotFoundException
    {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();        
        
        query.append(" SELECT FIRSTNAME , LASTNAME , DOB , PHONE_NO , GENDER FROM TMS_USER_MAST ");
        query.append(" WHERE USERCODE = :USERCODE");
        
        map.put("USERCODE", usercode);
        
        CommonMember.appendLogFile("@Repository :: ProfileDataManagerImpl ::  getProfile :: query :: " + query.toString());
        CommonMember.appendLogFile("@Repository :: ProfileDataManagerImpl :: getProfile :: map :: " + map);
        
        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }
    
}
