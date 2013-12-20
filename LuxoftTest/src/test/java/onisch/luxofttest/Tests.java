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
import onisch.luxoftPersonnel.EvaluationPage;
import onisch.luxoft.ru.SelectPersonalPage;
import onisch.luxoft.ru.Page;
import onisch.luxoft.ru.MetricsPage;
import onisch.luxoft.ru.EffectivityPage;

/**
 *
 * @author ЛЕНА
 */
public class Tests {
    WebDriver driver;
    
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://luxoft.ru/");
    }
    
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    
    @Test
    public void TC1_MetricsPageTest(){
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
    
    @Test
    public void TC2_CandidteEvaluationPageTest(){
        Page main = PageFactory.initElements(driver, Page.class);
        main.openSelectPersonalPage();
        SelectPersonalPage personalPage = PageFactory.initElements(driver, SelectPersonalPage.class);
        String actualStr =  personalPage.getTitle();
        Assert.assertEquals(actualStr, "Подбор IT персонала");
        Assert.assertEquals(personalPage.getSubTitlesCount(), 2);
        Assert.assertEquals(personalPage.getSubTitleText(0), "Luxoft Personnel: направления подбора");
        Assert.assertEquals(personalPage.getSubTitleText(1), "Luxoft Personnel: технологические специализации");
        //step 2
        Assert.assertTrue(personalPage.findLinkAndClick("Техническая оценка IT-кандидатов"));
        EvaluationPage evaluationPage = PageFactory.initElements(driver, EvaluationPage.class);
        Assert.assertTrue(evaluationPage.isLuxoftPersonnelOpened());
        //step 3
        actualStr = evaluationPage.getTitle();
        Assert.assertEquals(actualStr, "Техническая оценка IT-кандидатов");
        actualStr = evaluationPage.getCurrentMenuItem();
        Assert.assertEquals(actualStr, "УСЛУГИ");
        actualStr = evaluationPage.getCurrentSubMenuItem();
        Assert.assertEquals(actualStr, "Техническая оценка IT-кандидатов".toUpperCase());
    }
}
