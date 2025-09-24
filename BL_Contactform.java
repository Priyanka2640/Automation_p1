package com.metlife.components.businesslogic;

import com.metlife.components.pageobjects.PO_Contactform;
import com.metlife.components.pageobjects.PO_Gatedoverlay;
import com.metlife.components.reporting.Extent_Reporting;
import com.metlife.components.utilities.Common_Functions;
import com.metlife.components.utilities.ElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BL_Contactform extends PO_Contactform {
    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_Contactform(WebDriver driver, String TC_ID) {

        this.driver = driver;
        this.TC_ID = TC_ID;
    }

    /**************************************************************************************************************
     * @throws Throwable
     * @author Priyanka
     *********************************************Form*****************************************************************/

    public void Contactform() throws Exception {
        try {

            Thread.sleep(2000);
            WebElement ifrm = driver.findElement(By.tagName("Iframe"));
            action.switchToIFrameByFrameElement(driver,ifrm,120L);
            action.inputText(driver, "xpath", Namef, "priyanka", "field");
            action.inputText(driver, "xpath", middlen, "Mddle", "field");
            action.inputText(driver, "xpath", lastn, "Chaudhary", "field");
            action.inputText(driver, "xpath", emailn, "priya@gmail.com", "field");
            action.inputText(driver, "xpath", mobilen, "09099898989", "field");
           // action.explicitWait(driver, dateofbirth, 160L, "visibilityOfElementLocated").click();
            action.inputText(driver, "xpath", dob, "02/06/2014", "birthday month");
            Thread.sleep(2000);
            // Select Male gender option
            WebElement maleOption = driver.findElement(By.xpath(male));
          if ( maleOption.isSelected())
               {
                 System.out.println("male selected");
               }
               else
               {
                   maleOption.click();
                   System.out.println("female selected");
               }


            //==========================================dropdown for form============================================

            WebElement h1 = driver.findElement(By.xpath(highest));
            h1.click();
            WebElement h1li = action.explicitWait(driver,highlestlist, 120L,"visibilityOfElementLocated");
            WebElement h1select = h1li.findElement(By.xpath(highlestselect));
            h1select.click();
            // Get all <li> elements (options)
//            List<WebElement>  hlist = driver.findElements(By.xpath(highlestlist));
//            System.out.println("list" + hlist.size());
//            for (int i=0; i<hlist.size(); i++);
//            hlist.get(i).click();

            WebElement butt = action.explicitWait(driver, submitb, 160L, "visibilityOfElementLocated");
            butt.click();
            Thread.sleep(8000);


        } catch (Exception t) {
            t.printStackTrace();
            Extent_Reporting.Log_Fail("Function  Feature content promo is FAILED due to error" + t.getMessage());
            throw new Exception(t.getMessage());
        }



    }
//==============================================================================================================

}
