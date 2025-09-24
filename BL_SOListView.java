package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_SOListView;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BL_SOListView extends PO_SOListView {

    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public  BL_SOListView (WebDriver driver, String TC_ID){

        this.driver = driver;
        this.TC_ID = TC_ID;
    }


    /**************************************************************************************************************
     * @throws Throwable
     * @author Pratibha
     **************************************************************************************************************/

    public void listView() throws Exception {
        try {

            //driver.switchTo().defaultContent();
            action.click(driver,"xpath",searchIcon,"search icon is clicked");
            action.inputText(driver,"xpath",searchpage,"Insurance","Enter input to search");
            action.click(driver,"xpath",searchbtn,"Make a Search");
            action.waitUntilExist(driver,search_result,200L);




        }
        catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail( "Function listView is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }
    }

}
