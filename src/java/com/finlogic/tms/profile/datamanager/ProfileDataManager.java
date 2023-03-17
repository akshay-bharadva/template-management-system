/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.profile.datamanager;

import com.finlogic.tms.profile.bean.ProfileFormBean;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author njuser
 */
public interface ProfileDataManager {
 
    public int updateProfile(ProfileFormBean profileFormBean , String usercode) throws SQLException, ClassNotFoundException;
    
    public List getProfile(String usercode) throws SQLException, ClassNotFoundException;
}
