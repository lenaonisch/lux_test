/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onisch.luxofttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author ЛЕНА
 */
public class Page {
     WebDriver driver;
     
     public Page(WebDriver driver){
         this.driver = driver;
     }
     
    //@FindBy(linkText = "Сервисы") - так почему-то не находит
     @FindBy(css=".cl_services>a")
    private WebElement servicesMenuItem;
    
    @FindBy(linkText = "Повышение эффективности и совершенствование процессов разработки ПО")
    private WebElement effectivitySubMenu;
    
    public void openEffectivityPage(){
        new Actions(driver).
                moveToElement(servicesMenuItem).
                moveToElement(effectivitySubMenu).
                click().
                build().
                perform();
    }
}
