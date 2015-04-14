package com.epam.poject.runner;

import org.apache.log4j.Logger;
import org.testng.*;

public class Listener implements ISuiteListener, ITestListener, IConfigurationListener {


    private static Logger LOG = Logger.getLogger(Listener.class);

    public void onTestStart(ITestResult iTestResult) {
        LOG.info("The "+iTestResult.getMethod().getMethodName()   +   "  is running  from  " +iTestResult.getTestClass().getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
    }

    public void onTestFailure(ITestResult iTestResult) {
    }

    public void onTestSkipped(ITestResult iTestResult) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }

    public void onConfigurationSuccess(ITestResult iTestResult) {
    }

    public void onConfigurationFailure(ITestResult iTestResult) {
    }

    public void onConfigurationSkip(ITestResult iTestResult) {
    }

    public void onStart(ISuite iSuite) {
    }

    public void onFinish(ISuite iSuite) {
    }
}
