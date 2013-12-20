/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onisch.luxofttest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ЛЕНА
 */
public class Tests {
    WebDriver driver;
    
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://luxoft.ru/");
    }
    
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    
    @Test
    public void TC1(){
        Page main = PageFactory.initElements(driver, Page.class);
        main.openEffectivityPage();
        EffectivityPage effectivityPage = PageFactory.initElements(driver, EffectivityPage.class);
        String actualStr = effectivityPage.getTitle();
        Assert.assertEquals(actualStr, "Повышение эффективности и совершенствование процессов разработки ПО");
        int actualLinkCount = effectivityPage.getLinksCount();
        Assert.assertEquals(actualLinkCount, 9);
        Assert.assertTrue(effectivityPage.isPictureDisplayed());
        //step 2
        actualStr = effectivityPage.getLinkText(6);
        Assert.assertEquals(actualStr, "Внедрение системы сбора и анализа метрик");
        //step 3
        effectivityPage.clickLink(6);
        MetricsPage metricsPage = PageFactory.initElements(driver, MetricsPage.class);
        actualStr =  metricsPage.getTitle();
        Assert.assertEquals(actualStr, "Внедрение системы сбора и анализа метрик");
    }
}
