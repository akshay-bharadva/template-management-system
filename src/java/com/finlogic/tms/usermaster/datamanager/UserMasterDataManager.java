/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.usermaster.datamanager;

import com.finlogic.tms.usermaster.bean.UserMasterFormBean;
import java.util.List;

/**
 *
 * @author njuser
 */
public interface UserMasterDataManager {

    public List UserTypeList() throws Exception;

    public int UsersCount() throws Exception;

    public int AdminCount() throws Exception;

    public List UserList(String filterType) throws Exception;

    public List getUserData(String Usercode) throws Exception;

    public int addUserDetails(UserMasterFormBean userMasterFormBean) throws Exception;

    public int updateUserDetail(UserMasterFormBean userMasterFormBean) throws Exception;

}
