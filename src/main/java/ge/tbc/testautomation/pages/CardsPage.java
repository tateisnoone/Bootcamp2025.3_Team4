package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CardsPage {

    public Locator cardDetailsButton;

    public CardsPage(Page page){
        this.cardDetailsButton = page.locator("button:has-text('დეტალურად')");

    }
}
