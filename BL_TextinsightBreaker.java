package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_TextinsightBreaker;
import com.metlife.components.pageobjects.PO_Wysiwyg;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BL_TextinsightBreaker extends PO_TextinsightBreaker {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_TextinsightBreaker(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void TextinsightBreaker() throws Exception {
        try {

            Thread.sleep(2000);

            //=====================================user login========================================================
            action.inputText(driver,"xpath",username,"priyanka.p1@metlife.com","username");
            action.inputText(driver,"xpath",password,"Metlife@123","password");
            action.click(driver,"xpath",btn_submit,"submit");
            //==========================================create page with generic template=============================
            action.click(driver,"xpath",sites,"site icon is clicked");

            action.click(driver,"xpath",btn_create,"Create button");
            action.click(driver,"xpath",create_page,"Create Page");
            action.click(driver,"xpath",Generic_template,"select generic content template");
            action.click(driver,"xpath",btn_next,"click next button");
            //================================================enter title of page======================================
            action.inputText(driver,"xpath",browser_title,"TextinsightBreaker","Enter Page title");
            action.inputText(driver,"xpath",page_title,"TextinsightBreaker","Enter Page title");
            action.click(driver,"xpath",btn_create2,"click create ");
            action.click(driver,"xpath",btn_open,"open page ");
            //=========================================switch to another page =========================================
            action.switchToWindowUsingTitle(driver, "stage");
            Thread.sleep(2000);
            Rerun();
            //=========================================configure the component===========================================
            // action.explicitWait(driver,click_comp, 120L , "visibilityOfElementLocated").click();
            action.click(driver, "xpath", click_comp, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            Rerun2();

//            action.inputText(driver, "xpath", componentid, "12345", "compid field");
//            action.inputText(driver, "xpath", eyebrow, "Our latest Sustainability Report", "eyebrow field");
//            action.inputText(driver, "xpath", headlinetext, "Register online today to access and manage your MetLife benefits", "headline field");
//            action.inputText(driver, "xpath", copy, "MetLife’s 2024 Sustainability Report demonstrates how we live up to our purpose, contributing to a more confident futures as an employer, an investor and a provider of financial solutions and expertise", "copy field");
//            action.explicitWait(driver,cta_checkbox, 120L , "visibilityOfElementLocated").click();

            //============================================dropdown ==============================================
            WebElement variation1 = driver.findElement(By.xpath(stylefield));
            variation1.click();
            WebElement variationli = action.explicitWait(driver,stylelist, 120L , "visibilityOfElementLocated");
            WebElement vcick = variationli.findElement(By.xpath(Styleselect));
            vcick.click();
//            action.inputText(driver, "xpath", ctatext, "12345", "compid field");
//            action.inputText(driver, "xpath", ctalink, "12345", "compid field");

            WebElement variationopen2= driver.findElement(By.xpath(openin));
            variationopen2.click();
            WebElement variopen = action.explicitWait(driver, openlist, 120L, "visibilityOfElementLocated");
            WebElement varclick = variopen.findElement(By.xpath(openselect));
            varclick.click();
            action.explicitWait(driver,Done, 120L , "visibilityOfElementLocated").click();


            Rerun();
            //=========================================configure the component===========================================
            // action.explicitWait(driver,click_comp, 120L , "visibilityOfElementLocated").click();
            action.click(driver, "xpath", drag2ndcomp, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            Rerun2();
            action.explicitWait(driver,Done, 120L , "visibilityOfElementLocated").click();
            action.explicitWait(driver,menu, 120L , "visibilityOfElementLocated").click();
            action.explicitWait(driver,publish, 120L , "visibilityOfElementLocated").click();



        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }

        //=============================================================================================================
    }

    public void Rerun() throws Exception
    {
        try {

            Thread.sleep(2000);
            //===================================== select compt from search==========================================
            action.click(driver, "xpath", comp_holder, "click on the overlay");
            action.click(driver, "xpath", add_comp, "click on adding comp icon");
            action.inputText(driver, "xpath", enter_comp, "Text insight Breaker", "Enter component name for search");
            action.click(driver, "xpath", select_comp, "TextinsightBreaker select");
            Thread.sleep(2000);
            driver.navigate().refresh();

            } catch (Exception t)
        {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }

    }

    public void Rerun2() throws Exception
    {
        try {
            action.inputText(driver, "xpath", componentid, "12345", "compid field");
            action.inputText(driver, "xpath", eyebrow, "Our latest Sustainability Report", "eyebrow field");
            action.inputText(driver, "xpath", headlinetext, "Register online today to access and manage your MetLife benefits", "headline field");
            action.inputText(driver, "xpath", copy, "MetLife’s 2024 Sustainability Report demonstrates how we live up to our purpose, contributing to a more confident futures as an employer, an investor and a provider of financial solutions and expertise", "copy field");
            action.explicitWait(driver,cta_checkbox, 120L , "visibilityOfElementLocated").click();

            action.inputText(driver, "xpath", ctatext, "12345", "compid field");
            action.inputText(driver, "xpath", ctalink, "12345", "compid field");




        } catch (Exception t)
        {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }

    }


}
