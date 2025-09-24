package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_FAQ;
import com.metlife.components.pageobjects.PO_TextinsightBreaker;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BL_FAQ extends PO_FAQ {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_FAQ(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void FAQ() throws Exception {
        try {

            Thread.sleep(2000);

            //=====================================user login========================================================
            action.inputText(driver, "xpath", username, "priyanka.p1@metlife.com", "username");
            action.inputText(driver, "xpath", password, "Metlife@123", "password");
            action.click(driver, "xpath", btn_submit, "submit");
            //==========================================create page with generic template=============================
            action.click(driver, "xpath", sites, "site icon is clicked");
            action.click(driver, "xpath", btn_create, "Create button");
            action.click(driver, "xpath", create_page, "Create Page");
            action.click(driver, "xpath", Generic_template, "select generic content template");
            action.click(driver, "xpath", btn_next, "click next button");
            //================================================enter title of page======================================
            action.inputText(driver, "xpath", browser_title, "FAQtest", "Enter Page title");
            action.inputText(driver, "xpath", page_title, "FAQ", "Enter Page title");
            action.click(driver, "xpath", btn_create2, "click create ");
            action.click(driver, "xpath", btn_open, "open page ");
            //=========================================switch to another page =========================================
            action.switchToWindowUsingTitle(driver, "stage");
            Thread.sleep(2000);
            Rerun();
            //=========================================configure the component===========================================
            action.click(driver, "xpath", click_comp, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            action.inputText(driver, "xpath", componentid, "12345", "compid field");
            action.inputText(driver, "xpath", Title, "FAQ", "title");
            action.inputText(driver, "xpath", Expand_Button, "Expand All", " field");
            action.inputText(driver, "xpath", Collapse_Button, "Collapse All", " field");


            action.explicitWait(driver,add_faq, 120L , "visibilityOfElementLocated").click();
            Thread.sleep(5000);
            action.inputText(driver, "xpath", Question, "Product Overview", "copy field");
            action.inputText(driver, "xpath", Answer, "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo.", "copy field");
            action.inputText(driver, "xpath", label, "label", "copy field");

            action.explicitWait(driver,add_faq, 120L , "visibilityOfElementLocated").click();
            Thread.sleep(5000);
            action.inputText(driver, "xpath", Question2, "Product Overview", "copy field");
            action.inputText(driver, "xpath", Answer2, "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo.", "copy field");
            action.inputText(driver, "xpath", label2, "label", "copy field");

            action.explicitWait(driver,autoopen, 120L, "visibilityOfElementLocated").click();
            Thread.sleep(3000);
            action.explicitWait(driver,accesstab, 120L, "visibilityOfElementLocated").click();
            action.inputText(driver, "xpath", expandtab, "Expand All", " field");
            action.inputText(driver, "xpath", collapsedtab, "Collapse All", " field");
            Thread.sleep(2000);
            action.explicitWait(driver, Done, 160L, "visibilityOfElementLocated").click();

//=================================swicth to frame==========================================================
            WebElement frm = driver.findElement(By.tagName("iframe"));
            action.switchToIFrameByFrameElement(driver,frm, 120L);
            action.explicitWait(driver, menu, 120L, "visibilityOfElementLocated").click();
            Thread.sleep(2000);
            action.explicitWait(driver, publish, 120L, "visibilityOfElementLocated").click();


        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }

        //=============================================================================================================
    }

    public void Rerun() throws Exception {
        try {

            Thread.sleep(2000);
            //===================================== select compt from search==========================================
            action.click(driver, "xpath", comp_holder, "click on the overlay");
            action.click(driver, "xpath", add_comp, "click on adding comp icon");
            action.inputText(driver, "xpath", enter_comp, "FAQ", "Enter component name for search");
            action.click(driver, "xpath", select_comp, "faq select");
            Thread.sleep(2000);
            driver.navigate().refresh();

        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }

    }


}
