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
public class SelectPersonalPage extends Page{
    @FindBy(xpath="//div[@id='mainpart']//h2")
    private List<WebElement> subTitles;
    
    @FindBy(xpath="//div[@id='mainpart']//a")
    private List<WebElement> linksOfMainPart;
    
    public SelectPersonalPage(WebDriver driver){
        super(driver);
    }
    
    public int getSubTitlesCount(){
        return subTitles.size();
    }
    
    public String getSubTitleText(int index){
        return subTitles.get(index).getText();
    }
    
    public boolean findLinkAndClick(String text){
        for(WebElement item : linksOfMainPart){
            if (item.getText().contains(text)){
                item.click();
                return true;
            }
        }
        return false;
    }
    
}
