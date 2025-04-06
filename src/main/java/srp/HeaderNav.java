package srp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeaderNav extends AbstractComponent{

    private WebDriver driver;

    public HeaderNav(WebDriver driver,By sectionElement)
    {
        super(driver,sectionElement);
        this.driver=driver;

    }

    public List<String> getElements() {
        List<WebElement> HeaderElements=findElements(By.tagName("li"));
        List<String> elements=new ArrayList<>();
        for(WebElement HeaderElement : HeaderElements)
        {
            if(!HeaderElement.getText().isEmpty())
                elements.add(HeaderElement.getText());
        }
        return elements;
    }

    public int linkCount()
    {

        List<WebElement> linkNames=findElements(By.cssSelector("a"));
        return linkNames.size();
    }

}
