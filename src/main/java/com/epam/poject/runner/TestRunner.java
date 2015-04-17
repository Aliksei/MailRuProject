package com.epam.poject.runner;

import com.epam.poject.tests.MailRuTest;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class TestRunner {

    public static void main(String[] args){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {MailRuTest.class,Listener.class});
        testng.addListener(tla);
        testng.run();
    }
}

