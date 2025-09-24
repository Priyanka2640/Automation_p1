package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_BatchSummary;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.Common_Functions;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BL_BatchSummary extends PO_BatchSummary {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();


    public BL_BatchSummary(WebDriver driver, String TC_ID) {
        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Gaurav
     **************************************************************************************************************/

    public void defaultBatchSumReportPageDisplay() throws Exception {
        try {
            driver.manage().window().maximize();
            action.isElementDisplayed(driver, "xpath", batchSummaryReportHeader, "Batch Summary Report Header");
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function defaultBatchSumReportPageDisplay is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }

    public void exportBatchReport() throws Throwable {
        try {
            action.explicitWait(driver, exportReportBtn, 60L, "ElementToBeClickable");
            action.javascriptExecutorClick(driver, "xpath", exportReportBtn, "Export Report");
            acceptAlert(driver);
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function exportBatchReport is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }

    public void generateBatchSummaryReport() throws Exception {
        try {
            action.click(driver, "xpath", startDate, "Batch Summary Start Date ");
            String StartDateValue;
            if (Common_Functions.getCurrentDate().replace("/", "").charAt(2) == '0') {
                StartDateValue = Common_Functions.getCurrentDate().replace("/", "").substring(3, 4);
            } else {
                StartDateValue = Common_Functions.getCurrentDate().replace("/", "").substring(2, 4);
            }
            action.switchToWindowUsingTitle(driver, "CDH");
            driver.manage().window().maximize();
            String DateValue = "//a[text()='" + StartDateValue + "']";
            action.javascriptExecutorClick(driver, "xpath", DateValue, "Date " + StartDateValue);
            action.switchToWindowUsingTitle(driver, "CDH Reports ");
            action.selectDropBoxByStaticIndex(driver, "xpath", systemListCDH, "Documaker", 15, 13, "Documaker");
            action.javascriptExecutorClick(driver, "xpath", addButton, "Button Add");
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function generateBatchSummaryReport is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }

    public void validateBatchSumReportFields() throws Exception {
        try {
            action.explicitWait(driver, date, 60L, "visibilityOfElementLocated");
            action.isElementDisplayed(driver, "xpath", date, "Batch Summary Report : Date Field");
            action.isElementDisplayed(driver, "xpath", source, "Batch Summary Report : Source Field");
            action.isElementDisplayed(driver, "xpath", batchCount, "Batch_Summary_Report : Batch_Count_Field");
            action.isElementDisplayed(driver, "xpath", fileCount, "Batch Summary Report : File_Count Field");
            action.isElementDisplayed(driver, "xpath", pageCount, "Batch Summary Report : Page_Count Field ");
            action.isElementDisplayed(driver, "xpath", cdhSystem, "Batch Summary Report: CDH_System Field");
            action.isElementDisplayed(driver, "xpath", errorCount, "Batch Summary Report : Error_Count Field");
            Extent_Reporting.Log_Pass_Screenshot( "All fields validated successfully in BatchSummaryReport Screen", driver);
        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function validateBatchSumReportFields is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }

    public void acceptAlert(WebDriver driver) {
        try {
            Alert alert = action.waitForAlertPresent(driver);
            if (!alert.equals(null)) {
                alert.accept();
                Extent_Reporting.Log_Pass_Screenshot( " Alert Accepted", driver);
            }
        } catch (Exception e) {

        }
    }
}