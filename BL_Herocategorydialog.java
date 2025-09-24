package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Herocategorydialog;
import com.metlife.components.pageobjects.PO_VisualProductCard;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BL_Herocategorydialog extends PO_Herocategorydialog {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_Herocategorydialog(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void Herocategorydialog() throws Exception {
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
            action.inputText(driver, "xpath", browser_title, "Herocategorytest", "Enter Page title");
            action.inputText(driver, "xpath", page_title, "herocategorydialog", "Enter Page title");
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
            action.explicitWait(driver, Done, 160L, "visibilityOfElementLocated").click();
            Thread.sleep(1000);
            //===========================================2nd variation=================================================

            Rerun();
            action.click(driver, "xpath", click_comp2, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            Rerun2();
            WebElement vari1 = driver.findElement(By.xpath(addcontent));
            vari1.click();
            WebElement varilist= action.explicitWait(driver, addcontentlist,180L , "visibilityOfElementLocated");
            WebElement variselect = varilist.findElement(By.xpath(addcontentselect));
            variselect.click();
            Thread.sleep(1000);
            action.inputText(driver, "xpath", ctatext, "Read More", "Enter Page title");
            action.inputText(driver, "xpath", ctapath, "https://www.metlife.com/health/", "Enter Page title");
            action.inputText(driver, "xpath", contacttext, "Contact us", "Enter Page title");
            action.inputText(driver, "xpath", contactpath, "https://www.metlife.com/health/", "Enter Page title");

            action.explicitWait(driver, Done, 160L, "visibilityOfElementLocated").click();
            Thread.sleep(1000);

//            action.explicitWait(driver, menu, 160L, "visibilityOfElementLocated").click();
//            WebElement pub =action.explicitWait(driver, publish, 160L, "visibilityOfElementLocated");
//            pub.click();
//            WebElement viewaspub =action.explicitWait(driver, viewaspublish, 120L, "visibilityOfElementLocated");
//            viewaspub.click();


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
            action.inputText(driver, "xpath", enter_comp, "category hero", "Enter component name for search");
            action.click(driver, "xpath", select_comp, "Hero category dialog select");
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
            action.inputText(driver, "xpath",desktopimg, "/content/dam/metlifecom/us/Promo/promo_employee_benefits.jpg", "compid field");
            action.inputText(driver, "xpath", mobileimg, "/content/dam/metlifecom/us/Promo/promo_employee_benefits.jpg", "title");
            WebElement postion = driver.findElement(By.xpath(positioncta));
            postion.click();
            WebElement postionli= action.explicitWait(driver, positionlist,120L , "visibilityOfElementLocated");
            WebElement postionsele = postionli.findElement(By.xpath(positionselect));
            postionsele.click();
            action.inputText(driver, "xpath", headlinetitle, "Health", " field");
            //========================================h1 tag dropdown====================================================================
            WebElement tag1 = driver.findElement(By.xpath(h1tag));
            tag1.click();
            WebElement h1taglist= action.explicitWait(driver, htaglist,120L , "visibilityOfElementLocated");
            WebElement h1select = h1taglist.findElement(By.xpath(htagselect));
            h1select.click();
            //=============================================================================================================================

            action.inputText(driver, "xpath", headlinecopy, "We understand the emotional and financial stress that can arise from uncertainty over your medical coverage", " field");
            action.inputText(driver, "xpath", supporttitle, "Your partner in health every step of the way", " field");
            action.inputText(driver, "xpath", supportcopy, "We offer insurance products and services to help ease the high cost of healthcare — and offer broad protection from unexpected medical bills", " field");
            Thread.sleep(5000);


        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//==============================================================================================================

}
