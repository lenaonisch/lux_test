/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onisch.luxoft.ru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author ЛЕНА
 */
public class Page {
     private WebDriver driver;
     
     public Page(WebDriver driver){
         this.driver = driver;
     }
     
     @FindBy(xpath="//div[@id='title']/h1")
    private WebElement title;
     
    //@FindBy(linkText = "Сервисы") - так почему-то не находит
     @FindBy(css=".cl_services>a")
    private WebElement servicesMenuItem;
    
    @FindBy(linkText = "Повышение эффективности и совершенствование процессов разработки ПО")
    private WebElement effectivitySubMenu;
    
    @FindBy(linkText="Подбор IT-персонала")
    private WebElement hrLink;
    
    public String getTitle(){
        return title.getText();
    }
    
    private void openSubMenuPage(WebElement menuItem){
       new Actions(driver).
                moveToElement(servicesMenuItem).
                moveToElement(menuItem).
                click().
                build().
                perform(); 
    }
    
    public void openEffectivityPage(){
        openSubMenuPage(effectivitySubMenu);
    }
    
    public void openSelectPersonalPage(){
        openSubMenuPage(hrLink);
    }
}
