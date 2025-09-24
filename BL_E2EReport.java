package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_E2EReport;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.*;
import org.openqa.selenium.*;

public class BL_E2EReport extends PO_E2EReport {
    public static WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_E2EReport(WebDriver driver, String TC_ID) {
        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     *
     * @author Gaurav
     **************************************************************************************************************/

    public void e2EReportLink() throws Exception {
        try {
            action.explicitWait(driver, e2eReportLink, 60L, "ElementToBeClickable");
            action.javascriptExecutorClick(driver, "xpath", e2eReportLink, "End to End Report Link ");
            action.isElementDisplayed(driver, "xpath", e2eReportPage, "E2E report page");
            action.isElementDisplayed(driver, "xpath", startDate, "E2E Start Date");
            action.isElementDisplayed(driver, "xpath", endDate, "E2E End Date");
            action.isElementDisplayed(driver, "xpath", source, "E2E Source");
            action.isElementDisplayed(driver, "xpath", destination, "E2E Destination");
            action.isElementDisplayed(driver, "xpath", statusDD, "E2E Status");
            action.isElementDisplayed(driver, "xpath", batchName, "E2E BatchName");
            action.isElementDisplayed(driver, "xpath", generateButton, "E2E Generate button");
            Extent_Reporting.Log_Pass_Screenshot( "All fields are visible on E2E report search screen", driver);

        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function e2EReportLink is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }


    public void generateE2EReport() throws Exception {
        try {
            action.explicitWait(driver, generateButton, 60L, "ElementToBeClickable");
            action.javascriptExecutorClick(driver, "xpath", generateButton, "E2E Generate Button");
            action.isElementDisplayed(driver, "xpath", resultsTotal, "E2E Report Generate Page");

        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function generateE2EReport is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }


    public void validateE2EReportField() throws Exception {
        try {
            action.explicitWait(driver, batchNameField, 60L, "visibilityOfElementLocated");
            action.isElementDisplayed(driver, "xpath", batchNameField, "E2E Batch_Name_Field");
            action.isElementDisplayed(driver, "xpath", sourceField, "E2E Source_Field");
            action.isElementDisplayed(driver, "xpath", destinationField, "E2E Destination_Field");
            action.isElementDisplayed(driver, "xpath", timeSentBySource, "E2E Time_Sent_by_Source_Field");
            action.isElementDisplayed(driver, "xpath", timeReceived, "E2E Time_Received_Field");
            action.isElementDisplayed(driver, "xpath", statusUpdateTimeStamp, "E2E Status_Update_Time_Stamp_Field");
            action.isElementDisplayed(driver, "xpath", status, "E2EStatus_Field");
            action.isElementDisplayed(driver, "xpath", finalFileCount, "E2EFinal_File_Count_Field");
            action.isElementDisplayed(driver, "xpath", pageCount, "E2EPage_Count_Field");
            action.isElementDisplayed(driver, "xpath", size, "E2ESize_Field");
            action.isElementDisplayed(driver, "xpath", cdhSystem, "E2ECDH_System_Field");
            Extent_Reporting.Log_Pass_Screenshot( "All fields validated on End to End Report screen", driver);

        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function validateE2EReportField is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }
}