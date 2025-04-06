package srp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FooterNav extends AbstractComponent{

    WebDriver driver;

    public FooterNav(WebDriver driver,By sectionElement) {
        super(driver,sectionElement);
        this.driver = driver;
    }

    public List<String> getElements() {
        List<WebElement> footerElements = findElements(By.tagName("li"));
        List<String> elements = new ArrayList<>();
        for (WebElement footerElement : footerElements) {
            elements.add(footerElement.getText());
        }
        return elements;
    }

    public int linkCount()
    {
        List<WebElement> linkNames=findElements(By.cssSelector("a"));
        return linkNames.size();
    }

    public WebElement getElement(String str)
    {
        Map<String,WebElement> hoverElements=new HashMap<>();
        List<WebElement> linkNames=findElements(By.cssSelector("a"));
        for(WebElement linkName : linkNames)
            hoverElements.put(linkName.getText(),linkName);
        return hoverElements.get(str);
    }


}
