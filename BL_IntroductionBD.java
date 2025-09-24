package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_IntroductionBD;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BL_IntroductionBD extends PO_IntroductionBD {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_IntroductionBD(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     **************************************************************************************************************/

    public void IntroductionBD() throws Exception {
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
            action.inputText(driver,"xpath",browser_title,"IntroductionBDTest","Enter Page title");
            action.inputText(driver,"xpath",page_title,"IntroductionBDTest","Enter Page title");
            action.click(driver,"xpath",btn_create2,"click create ");
            action.click(driver,"xpath",btn_open,"open page ");
            //=========================================switch to another page =========================================
            action.switchToWindowUsingTitle(driver, "stage");
            Thread.sleep(2000);
            Rerun();
//            //===================================== select compt from search==========================================
//            action.click(driver,"xpath",comp_holder,"click on the overlay");
//            action.click(driver,"xpath",add_comp,"click on adding comp icon");
//            action.inputText(driver,"xpath",enter_comp,"Introduction","Enter component name");
//            action.click(driver,"xpath",select_comp ,"select introduction banner d");
            Thread.sleep(2000);
           driver.navigate().refresh();
            //=========================================configure the component===========================================
            action.click(driver, "xpath", click_comp, "click the component");
            action.click(driver, "xpath", btn_configure, "click configure icon");
            action.inputText(driver, "xpath", bgImg_field, "/content/dam/metlifecom/us/ris/insights/heroes/circle-design-thumbnail.jpg", "select image");
            action.inputText(driver, "xpath", tabimag, "/content/dam/Evolution-Mobile-Promo-Breaker.jpg", "select image");
            action.inputText(driver, "xpath", mobimg, "/content/dam/Evolution-Mobile-Promo-Breaker.jpg", "select image");
            action.inputText(driver, "xpath", titlefield, "2025 Personal Injury Settlement Study", "select image");
            action.inputText(driver, "xpath", subtitle, "2025 Personal Injury Settlement Study 2025 Personal Injury Settlement Study 2025 Personal Injury Settlement Study 2025 Personal Injury Settlement Study", "select image");
            action.click(driver, "xpath", Done, "save the author page");

            //========================================variation 2 dropdown ====================================================
             Rerun();
          //  Thread.sleep(2000);
            driver.navigate().refresh();
            action.click(driver, "xpath", click_comp2, "click the component");
            action.click(driver, "xpath", configicon2, "click configure icon");
            action.inputText(driver, "xpath", bgImg_field, "/content/dam/metlifecom/us/ris/insights/heroes/circle-design-thumbnail.jpg", "select image");
            action.inputText(driver, "xpath", tabimag, "/content/dam/Evolution-Mobile-Promo-Breaker.jpg", "select image");
            action.inputText(driver, "xpath", mobimg, "/content/dam/Evolution-Mobile-Promo-Breaker.jpg", "select image");
        //======================================dropdown===================================================================
            WebElement postion = driver.findElement(By.xpath(positioncta));
            postion.click();
            WebElement postionli= action.explicitWait(driver, positionlist,120L , "visibilityOfElementLocated");
            WebElement postionsele = postionli.findElement(By.xpath(positionselect));
            postionsele.click();

//            Select sel = new Select(driver.findElement(By.xpath(positionlist)));
//            List<WebElement> list = sel.getOptions();
//            for (WebElement li : list)
//            {
//                System.out.println(li.getText());
//                sel.selectByIndex(1);
//            }

            action.inputText(driver, "xpath", titlefield, "2025 Personal Injury Settlement Study", "select image");
            action.inputText(driver, "xpath", subtitle, "2025 Personal Injury Settlement Study 2025 Personal Injury Settlement Study 2025 Personal Injury Settlement Study 2025 Personal Injury Settlement Study", "select image");
            action.click(driver, "xpath", Done, "save the author page");





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
            action.inputText(driver, "xpath", enter_comp, "Introduction", "Enter component name");
            action.click(driver, "xpath", select_comp, "select introduction banner d");



        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }

    }
}
