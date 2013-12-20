/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onisch.luxoftPersonnel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author ЛЕНА
 */
public class Page {
    protected WebDriver driver;
    
    public Page(WebDriver driver){
        this.driver = driver;
    }
   
    @FindBy(className="f_footer_copyright")
    private WebElement copyRight;
    
    @FindBy(tagName="h1")
    protected WebElement title;
    
    public boolean isLuxoftPersonnelOpened(){
        return copyRight.getText().contains("Luxoft Personnel");
    }
    
    public String getTitle(){
        return title.getText();
    }
}
