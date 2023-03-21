/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.historymaster.datamanager.impl;

import com.finlogic.tms.historymaster.datamanager.HistoryMasterDataManager;
import com.finlogic.util.persistence.SQLTranUtility;
import com.finlogic.util.persistence.SQLUtility;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author njuser
 */
@Repository
public class HistoryMasterDataManagerImpl implements HistoryMasterDataManager {

    private final String CONNECTION_ALIAS = "njindiainvest_offline";

    private final SQLUtility sqlUtility = new SQLUtility();
    private final SQLTranUtility sqlTranUtility = new SQLTranUtility();

    @Override
    public List getUserHistory() throws Exception {
        StringBuilder query = new StringBuilder();
        query.append(" SELECT HM.USERCODE,UL.USERNAME,HM.LAST_LOGIN,HM.LOGIN_HITS");
        query.append(" FROM TMS_USER_HISTORY_MAST HM INNER JOIN TMS_USER_LOGIN UL");
        query.append(" ON HM.USERCODE = UL.USERCODE;");

        return sqlUtility.getList(CONNECTION_ALIAS, query.toString());
    }
}
