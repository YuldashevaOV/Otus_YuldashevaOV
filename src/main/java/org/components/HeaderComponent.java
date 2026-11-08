package org.components;

import org.annotations.Component;
import org.openqa.selenium.WebDriver;

@Component("css:h2")
public class HeaderComponent extends AbsComponent {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public String getText() {
        return getComponentEntry().getText();
    }
}