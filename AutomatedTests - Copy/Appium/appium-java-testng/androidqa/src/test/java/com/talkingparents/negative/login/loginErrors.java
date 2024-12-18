package com.talkingparents.negative.login;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import com.talkingparents.setUpConfigNative;
import com.talkingparents.pageobjectsandroid.Login.*;


public class loginErrors extends setUpConfigNative{



    @Test (priority = 1, dataProvider="getErrorData")
        public void loginTest_negativeFlow(String email, String password) throws MalformedURLException, URISyntaxException{
            
            //Sign into account
            loginPages loginpage = new loginPages(driver);
            loginpage.signInAction(email, password);
            

        }
















    
}
