package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_FAQ;
import com.metlife.components.pageobjects.PO_VisualProductCard;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BL_VisualProductCard extends PO_VisualProductCard {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_VisualProductCard(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void VisualProductCard() throws Exception {
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
            action.inputText(driver, "xpath", browser_title, "Visualproductcardtest", "Enter Page title");
            action.inputText(driver, "xpath", page_title, "Visualproductcard", "Enter Page title");
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
            //===========================================2nd variation=================================================

            Rerun();
            action.click(driver, "xpath", click_comp2, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");

            WebElement imageicon = driver.findElement(By.xpath(drp1));
            imageicon.click();
            WebElement listimageicon= action.explicitWait(driver, droplist1,120L , "visibilityOfElementLocated");
            WebElement selectimageicon = listimageicon.findElement(By.xpath(dropselect));
            selectimageicon.click();

            WebElement colour = driver.findElement(By.xpath(drp2));
            colour.click();
            WebElement listcolour= action.explicitWait(driver, droplist2,120L , "visibilityOfElementLocated");
            WebElement selectigrey = listcolour.findElement(By.xpath(dropselect2));
            selectigrey.click();

            WebElement percent = driver.findElement(By.xpath(drp3));
            percent.click();
            WebElement listpercent= action.explicitWait(driver, droplist1,120L , "visibilityOfElementLocated");
            WebElement select55 = listpercent.findElement(By.xpath(dropselect3));
            select55.click();
            Rerun2();


            action.explicitWait(driver, menu, 160L, "visibilityOfElementLocated").click();
            WebElement pub =action.explicitWait(driver, publish, 160L, "visibilityOfElementLocated");
            pub.click();
            WebElement viewaspub =action.explicitWait(driver, viewaspublish, 120L, "visibilityOfElementLocated");
            viewaspub.click();


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
            action.inputText(driver, "xpath", enter_comp, "Visual product card", "Enter component name for search");
            action.click(driver, "xpath", select_comp, "Visual product card select");
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
            action.inputText(driver, "xpath", componentid, "12345", "compid field");
            action.inputText(driver, "xpath", eyebrow_vsc, "eyebrow", "title");
            WebElement buttadd= action.explicitWait(driver,Addcard, 120L , "visibilityOfElementLocated");
            buttadd.click();
            action.inputText(driver, "xpath", imagevpc, "/content/dam/Evolution-Mobile-Promo-Breaker.jpg", " field");
            action.inputText(driver, "xpath", titlevpc, "title All", " field");
            action.inputText(driver, "xpath", support, "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem", " field");
            Thread.sleep(5000);
            action.inputText(driver, "xpath", urlvpc, " metlife.com ", "copy field");
            action.inputText(driver, "xpath",ctavpc, "label", "copy field");
            action.explicitWait(driver, Done, 160L, "visibilityOfElementLocated").click();
            Thread.sleep(1000);

        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//=================

}
