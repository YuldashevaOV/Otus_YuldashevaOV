package org.components;

import org.annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Component("css:h2")
public class HeaderComponent extends AbsComponent {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public String getText() {
        return getComponentEntry().getText();
    }

    public void waitForText(String expectedText) {
        waiters.waitForCondition(ExpectedConditions.textToBePresentInElementLocated(
                componentMetaDataAdapter(), expectedText
        ));
    }
}