package automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig(){
        File src = new File("./Configuration/config.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        }catch(Exception e){
            System.out.println("Exception is "+ e.getMessage());
        }
    }
    public String getApplicationURL(){
        String url = pro.getProperty("baseURL");
        return url;
    }
    public String getUserName(){
        String username = pro.getProperty("username");
        return username;
    }
    public String getPassword(){
        String password = pro.getProperty("password");
        return password;
    }
    public String getChromePath(){
        String chromepath = pro.getProperty("chromePath");
        return chromepath;
    }
    public String getAddBlockPath(){
        String addBlockPath = pro.getProperty("addBlockerPath");
        return addBlockPath;
    }
    public String getFirefoxPath(){
        String firefoxpath = pro.getProperty("firefoxPath");
        return firefoxpath;
    }
    public String getIEPath(){
        String iePath = pro.getProperty("iePath");
        return iePath;
    }
    public String getTestRailURL(){
        String testRailUrl = pro.getProperty("RAILS_ENGINE_URL");
        return testRailUrl;
    }
    public String getTestRailTestRunID(){
        String testRunID = pro.getProperty("TEST_RUN_ID");
        return testRunID;
    }
    public String getTestRailUsername(){
        String testRailusername = pro.getProperty("TESTRAIL_USERNAME");
        return testRailusername;
    }
    public String getTestRailPassword(){
        String testrailPassword = pro.getProperty("TESTRAIL_PASSWORD");
        return testrailPassword;
    }
    public String getTestCasePassedStatus(){
        String testCasePassedStatus = pro.getProperty("TEST_CASE_PASSED_STATUS");
        return testCasePassedStatus;
    }
    public String getTestCaseFailedStatus(){
        String testCaseFailedStatus = pro.getProperty("TEST_CASE_FAILED_STATUS");
        return testCaseFailedStatus;
    }


}
