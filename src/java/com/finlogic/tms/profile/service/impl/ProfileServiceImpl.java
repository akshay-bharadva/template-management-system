/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.profile.service.impl;

import com.finlogic.tms.profile.bean.ProfileFormBean;
import com.finlogic.tms.profile.datamanager.ProfileDataManager;
import com.finlogic.tms.profile.service.ProfileService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service(value = "ProfileService")
public class ProfileServiceImpl implements ProfileService{
    
    @Autowired
    ProfileDataManager profileDataManager;
    
    @Override
    public int updateProfile(ProfileFormBean profileFormBean , String usercode) throws SQLException, ClassNotFoundException
    {
        return profileDataManager.updateProfile(profileFormBean, usercode);
    }
    
    @Override
    public List getProfile(String usercode) throws SQLException, ClassNotFoundException
    {
        return profileDataManager.getProfile(usercode);
    }
    
}
