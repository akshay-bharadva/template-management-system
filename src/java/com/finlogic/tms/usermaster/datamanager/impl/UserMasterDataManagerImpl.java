/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.usermaster.datamanager.impl;

import com.finlogic.tms.usermaster.bean.UserMasterFormBean;
import com.finlogic.tms.usermaster.datamanager.UserMasterDataManager;
import com.finlogic.util.CommonMember;
import com.finlogic.util.persistence.SQLTranUtility;
import com.finlogic.util.persistence.SQLUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author njuser
 */
@Repository
public class UserMasterDataManagerImpl implements UserMasterDataManager {

    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();
    private final SQLTranUtility sqlTranUtility = new SQLTranUtility();

    @Override
    public List UserTypeList() throws Exception {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ID,TYPE FROM TMS_USER_TYPE");

        return sqlUtility.getList(CONNECTION_ALIAS, query.toString());
    }

    @Override
    public int UsersCount() throws Exception {
        StringBuilder query = new StringBuilder();
        query.append("SELECT COUNT(*) FROM TMS_USER_LOGIN WHERE USER_TYPE = 2");

        return sqlUtility.getIntValue(CONNECTION_ALIAS, query.toString());
    }

    @Override
    public int AdminCount() throws Exception {
        StringBuilder query = new StringBuilder();
        query.append("SELECT COUNT(*) FROM TMS_USER_LOGIN WHERE USER_TYPE = 1");

        return sqlUtility.getIntValue(CONNECTION_ALIAS, query.toString());
    }

    @Override
    public List UserList(String filterType) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();
        query.append(" SELECT UL.USERCODE,UL.USERNAME,UL.EMAIL,UL.LAST_LOGIN,UT.TYPE");
        query.append(" FROM TMS_USER_LOGIN UL JOIN TMS_USER_TYPE UT ON UL.USER_TYPE = UT.ID");

        if (filterType != null && !filterType.equals("0")) {
            query.append(" WHERE UL.USER_TYPE = :FILTER_TYPE");
            map.put("FILTER_TYPE", filterType);
        }
        query.append(" ORDER BY USERNAME;");

        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public List getUserData(String Usercode) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();

        query.append("SELECT USERCODE,USERNAME,EMAIL,PASSWORD,ISACTIVE,USER_TYPE FROM TMS_USER_LOGIN ");
        query.append("WHERE USERCODE = :USERCODE;");

        map.put("USERCODE", Usercode);

        return sqlUtility.getList(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public int addUserDetails(UserMasterFormBean userMasterFormBean) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();

        query.append(" INSERT INTO TMS_USER_LOGIN(USERCODE,USERNAME,EMAIL,PASSWORD,ISACTIVE,USER_TYPE) ");
        query.append(" VALUES (uuid(),:USERNAME,:EMAIL,md5(:PASSWORD),:ISACTIVE,:USER_TYPE)");

        map.put("USERNAME", userMasterFormBean.getUserName());
        map.put("ISACTIVE", userMasterFormBean.getChkActive());
        map.put("USER_TYPE", userMasterFormBean.getUsertype());
        map.put("EMAIL", userMasterFormBean.getEmail());
        map.put("PASSWORD", userMasterFormBean.getPassword());

        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

    @Override
    public int updateUserDetail(UserMasterFormBean userMasterFormBean) throws Exception {
        StringBuilder query = new StringBuilder();
        Map map = new HashMap();

        query.append("UPDATE TMS_USER_LOGIN SET ISACTIVE = :ISACTIVE , USER_TYPE = :USER_TYPE ");
        query.append("WHERE USERCODE = :USERCODE;");

        map.put("ISACTIVE", userMasterFormBean.getChkActive());
        map.put("USER_TYPE", userMasterFormBean.getUsertype());
        map.put("USERCODE", userMasterFormBean.getUsercode());

        CommonMember.appendLogFile("isactive : " + userMasterFormBean.getChkActive() + "user type : " + userMasterFormBean.getUsertype() + "usercode : " + userMasterFormBean.getUsercode());
        return sqlUtility.persist(CONNECTION_ALIAS, query.toString(), new MapSqlParameterSource(map));
    }

}
