/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.template.datamanager.impl;

import com.finlogic.tms.template.datamanager.TemplateDataManager;
import com.finlogic.util.persistence.SQLUtility;
import org.springframework.stereotype.Repository;

/**
 *
 * @author njuser
 */
@Repository(value = "TemplateDataManager")
public class TemplateDataManagerImpl implements TemplateDataManager {

    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();
}
