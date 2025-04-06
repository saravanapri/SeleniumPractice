package srp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
{
    private WebDriver driver;
    By HeaderClass=By.className("vl-flyout-nav__container");
    By FooterId=By.id("s0-1-0-53-1-2-5-15-0[1]-10-@match-media-0-@ebay-carousel-list");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public FooterNav getFooterNav()
    {
        return new FooterNav(driver,FooterId);
    }

    public HeaderNav getHeaderNav()
    {
        return new HeaderNav(driver,HeaderClass);
    }


}
