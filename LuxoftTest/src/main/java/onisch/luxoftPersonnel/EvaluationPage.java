/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onisch.luxoftPersonnel;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author ЛЕНА
 */
public class EvaluationPage extends Page{
    @FindBy(xpath="//div[@id='h_nav_top_menu_usual']//li")
    List<WebElement> mainMenu;
    
    @FindBy(xpath="//div[@id='h_nav_secondary']//li")
    List<WebElement> subMenu;
    
    public EvaluationPage(WebDriver driver){
        super(driver);
    }
    
    @Override
    public String getTitle(){
        return title.findElement(By.tagName("b")).getText();
    }
    
    public String getCurrentMenuItem(){
        for(WebElement item:mainMenu){
            if (item.getAttribute("class").equals("current"))
                return item.findElement(By.tagName("a")).getText();
        }
        return null;
    }
    
    public String getCurrentSubMenuItem(){
        for(WebElement item:subMenu){
            WebElement link = item.findElement(By.tagName("a"));
            if (link.getAttribute("class").equals("current"))
                return link.getText();
        }
        return null;
    }
}
