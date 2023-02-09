/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * author : Dipak Bhoova reqId :12385 onDate :06-12-2010
 */

public class CommonMember
{
    //No of records to be displayed

    public static String strErrorLogFilePath = finpack.FinPack.getProperty("tomcat1_path") + "/webapps/tms/log/";

    public static void appendLogFile(String data)
    {
        //Get current date

        Date curDate = new Date();
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy HH:MM a");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currDateStr = sdf.format(curDate);
        String DrawLine = "-----------------------------------------------------------------------------------------------------------------\n";
        data = DrawLine + "\n" + data + "\n" ;
        finutils.errorhandler.ErrorHandler.PrintInLog(strErrorLogFilePath + "tms-log-" + currDateStr + ".txt", data);

    }

    public static void errorHandler(Exception ex)
    {
        Date curDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currDateStr = sdf.format(curDate);
        String DrawLine = "----------------------------------------------------------------------------------------------------------------\n";
        finutils.errorhandler.ErrorHandler.PrintInLog(strErrorLogFilePath + "tms-log-"
                + currDateStr + ".txt", DrawLine + ex.getMessage());
    }
}