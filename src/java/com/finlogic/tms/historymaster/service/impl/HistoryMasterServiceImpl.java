/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.historymaster.service.impl;

import com.finlogic.tms.historymaster.datamanager.HistoryMasterDataManager;
import com.finlogic.tms.historymaster.service.HistoryMasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service
public class HistoryMasterServiceImpl implements HistoryMasterService {

    @Autowired
    HistoryMasterDataManager historyMasterDataManager;

    @Override
    public List getUserHistory() throws Exception {
        return historyMasterDataManager.getUserHistory();
    }
}
