package srp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponent {

    public WebDriver driver;
    public WebElement sectionElement;

    public AbstractComponent(WebDriver driver,By sectionElement)
    {
        this.sectionElement=driver.findElement(sectionElement);
    }
    public WebElement findElement(By findElementBy)
    {
        return sectionElement.findElement(findElementBy);
    }
    public List<WebElement> findElements(By findElementBy)
    {
        return sectionElement.findElements(findElementBy);
    }
}
