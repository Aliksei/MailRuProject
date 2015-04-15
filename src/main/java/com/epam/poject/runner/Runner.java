package com.epam.poject.runner;

import com.epam.poject.driver.webdriverFactory.DriverManagerFactory;
import com.epam.poject.tests.MailRuTest;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Runner {

    public static void main(String[] args){
        DriverManagerFactory factory = new DriverManagerFactory();
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {MailRuTest.class});
        testng.addListener(tla);
        testng.run();
    }
}

