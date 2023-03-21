/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.usermaster.service.impl;

import com.finlogic.tms.usermaster.bean.UserMasterFormBean;
import com.finlogic.tms.usermaster.datamanager.UserMasterDataManager;
import com.finlogic.tms.usermaster.service.UserMasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service
public class UserMasterServiceImpl implements UserMasterService {

    @Autowired
    UserMasterDataManager userMasterDataManager;

    @Override
    public List UserTypeList() throws Exception {
        return userMasterDataManager.UserTypeList();
    }

    @Override
    public int UsersCount() throws Exception {
        return userMasterDataManager.UsersCount();
    }

    @Override
    public int AdminCount() throws Exception {
        return userMasterDataManager.AdminCount();
    }

    @Override
    public List UserList(String filterType) throws Exception {
        return userMasterDataManager.UserList(filterType);
    }

    @Override
    public List getUserData(String Usercode) throws Exception {
        return userMasterDataManager.getUserData(Usercode);
    }

    @Override
    public int addUserDetails(UserMasterFormBean userMasterFormBean) throws Exception {
        return userMasterDataManager.addUserDetails(userMasterFormBean);
    }

    @Override
    public int updateUserDetail(UserMasterFormBean userMasterFormBean) throws Exception {
        return userMasterDataManager.updateUserDetail(userMasterFormBean);
    }

}
