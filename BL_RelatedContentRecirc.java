package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Herocategorydialog;
import com.metlife.components.pageobjects.PO_RelatedContentRecirc;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class BL_RelatedContentRecirc extends PO_RelatedContentRecirc {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_RelatedContentRecirc(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void RelatedContentRecirc() throws Exception {
        try {
            Thread.sleep(2000);
            //=====================================user login========================================================
            action.inputText(driver, "xpath", username, "priyanka.p1@metlife.com", "username");
            action.inputText(driver, "xpath", password, "Metlife@123", "password");
            action.click(driver, "xpath", btn_submit, "submit");
            //==========================================create page with generic template=============================
            action.click(driver, "xpath", sites, "site icon is clicked");
            action.click(driver, "xpath", metlifes, "site icon is clicked");
            action.click(driver, "xpath", usss, "site icon is clicked");
            action.click(driver, "xpath", homepages, "site icon is clicked");
            //===========================move into metlife folder===========================================================================================
            action.click(driver, "xpath", automation, "site icon is clicked");
            action.click(driver, "xpath", btn_create, "Create button");
            action.click(driver, "xpath", create_page, "Create Page");
            action.click(driver, "xpath", Generic_template, "select generic content template");
            action.click(driver, "xpath", btn_next, "click next button");
            //================================================enter title of page======================================
            action.inputText(driver, "xpath", browser_title, "RelatedContentRecirc", "Enter Page title");
            action.inputText(driver, "xpath", page_title, "RelatedContentRecirc", "Enter Page title");
            action.click(driver, "xpath", btn_create2, "click create ");
            action.click(driver, "xpath", btn_open, "open page ");
            //=========================================switch to another page =========================================
            action.switchToWindowUsingTitle(driver, "stage");
            Thread.sleep(2000);
            Rerun();
            //=========================================configure the component===========================================
            action.click(driver, "xpath", click_comp, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            Rerun2();
            action.inputText(driver, "xpath", seetext, "see text", "Enter Page title");
            action.inputText(driver, "xpath", seeurl, "#", "Enter Page title");
            action.explicitWait(driver, sidebutton, 160L, "visibilityOfElementLocated").click();
            action.inputText(driver, "xpath", nextrcr, "next", "Enter Page title");
            action.inputText(driver, "xpath", previous, "previous", "Enter Page title");
            action.inputText(driver, "xpath", seeallrcr, "seeall", "Enter Page title");

            action.explicitWait(driver, Done, 160L, "visibilityOfElementLocated").click();
            Thread.sleep(1000);
            //===========================================2nd variation=================================================
            Rerun();
            action.click(driver, "xpath", click_comp2, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            Thread.sleep(1000);
            WebElement layout = driver.findElement(By.xpath(layoutimage));
            layout.click();
            WebElement layoutli= action.explicitWait(driver, laylist,120L , "visibilityOfElementLocated");
            WebElement layoutsele = layoutli.findElement(By.xpath(layselect));
            layoutsele.click();
            Rerun2();
            action.inputText(driver, "xpath",subcaption, "subcaption check", "compid field");
            action.inputText(driver, "xpath", backimage, "/content/dam/Evolution-Mobile-Promo-Breaker.jpg", " field");
            action.inputText(driver, "xpath", titlevari, " eyeborw title", " field");
            action.explicitWait(driver, sidebutton, 160L, "visibilityOfElementLocated").click();
            action.inputText(driver, "xpath", nextrcr, "next", "Enter Page title");
            action.inputText(driver, "xpath", previous, "previous", "Enter Page title");
            action.inputText(driver, "xpath", seeallrcr, "seeall", "Enter Page title");
            action.explicitWait(driver, Done, 160L, "visibilityOfElementLocated").click();
            action.explicitWait(driver, menuicon, 160L, "visibilityOfElementLocated").click();
            action.explicitWait(driver, publishbutton, 180L, "visibilityOfElementLocated").click();
            Thread.sleep(1000);

           // action.explicitWait(driver, viewaspublish, 160L, "visibilityOfElementLocated").click();


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
            action.inputText(driver, "xpath", enter_comp, "related articles", "Enter component name for search");
            action.click(driver, "xpath", select_comp, " RelatedContentRecirc select");
            Thread.sleep(2000);
            driver.navigate().refresh();

        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }

    public void Rerun2() throws Exception {
        try {

            //===================================== component configure ==========================================
            action.inputText(driver, "xpath",headerrc, "header check", "compid field");
            action.click(driver, "xpath", checkboxrc, " RelatedContentRecirc select");
            Thread.sleep(1000);
            WebElement postion = driver.findElement(By.xpath(configuretyp));
            postion.click();
            WebElement postionli= action.explicitWait(driver, conflist,120L , "visibilityOfElementLocated");
            WebElement postionsele = postionli.findElement(By.xpath(manual));
            postionsele.click();
            //========================================type dropdown====================================================================
            Thread.sleep(1000);
            WebElement type = driver.findElement(By.xpath(selecttyp));
            type.click();
            WebElement typlist= action.explicitWait(driver, seleclist,120L , "visibilityOfElementLocated");
            WebElement typselect = typlist.findElement(By.xpath(select));
            typselect.click();
            //========================================loop for execute single line 3 times.=========================================
            Thread.sleep(1000);
            action.click(driver, "xpath", rcrbutton, " RelatedContentRecirc button");
            action.inputText(driver, "xpath", titlercr, "Title of title the way", " field");
            action.inputText(driver, "xpath", urlrcr, "https://www.metlife.com", " field");
            action.inputText(driver, "xpath", timercr, "20 min", " field");

            //===========================================2nd title=================================================
//            action.click(driver, "xpath", rcrbutton, " RelatedContentRecirc button");
//            action.inputText(driver, "xpath", titlercr2, "Title of title the way", " field");
//            Thread.sleep(1000);
//            action.inputText(driver, "xpath", urlrcr2, "https://www.metlife.com/", " field");
//            action.inputText(driver, "xpath", timercr2, "20 min", " field");
//            Thread.sleep(5000);
//            //===========================================3rd title=================================================
//            action.click(driver, "xpath", rcrbutton, " RelatedContentRecirc button");
//            action.inputText(driver, "xpath", titlercr3, "Title of title the way", " field");
//            Thread.sleep(1000);
//            action.inputText(driver, "xpath", urlrcr3, "https://www.metlife.com/", " field");
//            action.inputText(driver, "xpath", timercr3, "20 min", " field");
//            Thread.sleep(5000);


        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//==============================================================================================================

}
