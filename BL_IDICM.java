package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_IDICM;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.WebDriver;

public class BL_IDICM extends PO_IDICM {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();
    BL_BatchSummary bat = new BL_BatchSummary(driver, TC_ID);

    public BL_IDICM(WebDriver driver, String TC_ID) {
        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Gaurav
     **************************************************************************************************************/


    public void timeReportIDICM() throws Exception {
        try {
            action.explicitWait(driver, timeReport, 60L, "ElementToBeClickable");
            action.javascriptExecutorClick(driver, "xpath", timeReport, "IDI CM Time Report Link");
            action.isElementDisplayed(driver, "xpath", timeReportPage, "IDICM Time Report Page");
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function timeReportIDICM is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }


    public void timeReportGenerateIDICM() throws Exception {
        try {
            action.explicitWait(driver, batchSumStartDate, 60L, "visibilityOfElementLocated");
            action.isElementDisplayed(driver, "xpath", batchSumStartDate, "Batch Summary Date");
            action.click(driver, "xpath", batchSumStartDate, "Batch Summary Date");
            action.getWindowHandle(driver, "CDH");
            action.javascriptExecutorClick(driver, "xpath", date01, "Batch Summary Date : Date 01");
            action.getWindowHandle(driver, "CDH Reports");
            action.javascriptExecutorClick(driver, "xpath", generateReport, "Generate Report Button ");
            action.isElementDisplayed(driver, "xpath", timeReportResult, "IDICM Time Report Result");
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function timeReportGenerateIDICM is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }


    public void timeRepScreenFieldValidationIDICM() throws Throwable {
        try {
            action.explicitWait(driver, batchName, 60L, "visibilityOfElementLocated");
            action.isElementDisplayed(driver, "xpath", batchName, "Batch Name");
            action.isElementDisplayed(driver, "xpath", source, "IDICM Source Field is visible");
            action.isElementDisplayed(driver, "xpath", destination, "IDICM Destination Field");
            action.isElementDisplayed(driver, "xpath", receivedInCM, "Received in CM");
            action.isElementDisplayed(driver, "xpath", completedInCM, "Completed in CM");
            action.isElementDisplayed(driver, "xpath", totalDaysInCM, "Total days in CM");
            action.isElementDisplayed(driver, "xpath", totalDocumentsInCM, "Total Documents in CM");
            Extent_Reporting.Log_Pass_Screenshot( "All fields validated on IDI CM time report page", driver);
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function timeRepScreenFieldValidationIDICM is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }

    public void exportIDICMReport() throws Throwable {
        try {
            action.explicitWait(driver, exportReport, 60L, "ElementToBeClickable");
            action.javascriptExecutorClick(driver, "xpath", exportReport, "Export Report");
            bat.acceptAlert(driver);
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function exportIDICMReport is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }
}