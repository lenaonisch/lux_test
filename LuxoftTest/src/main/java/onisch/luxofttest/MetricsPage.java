/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onisch.luxofttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author ЛЕНА
 */
public class MetricsPage extends Page{
    @FindBy(xpath="//div[@id='title']/h1")
    private WebElement title;
    
    public MetricsPage(WebDriver driver){
        super(driver);
    }
    
    public String getTitle(){
        return title.getText();
    }
}
