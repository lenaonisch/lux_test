/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onisch.luxoft.ru;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author ЛЕНА
 */
public class EffectivityPage extends Page{
    @FindBy(xpath="//blockquote//a")
    private List<WebElement> linksToServices;
    
    @FindBy(xpath="//div[@class='headline_image']/img")
    private WebElement headPicture;
    
    public EffectivityPage(WebDriver driver){
        super(driver);
    } 
    
    public boolean isPictureDisplayed(){
        return headPicture.isDisplayed();
    }
    
    public int getLinksCount(){
        return linksToServices.size();
    }
    
    public void clickLink(int index){
        linksToServices.get(index).click();
    }
    
    public String getLinkText(int index){
        return linksToServices.get(index).getText();
    }
}
