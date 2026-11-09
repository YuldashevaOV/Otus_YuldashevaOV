package org.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.exceptions.BrowserNotSupportException;
import org.factory.settings.BrowserChromeOptions;
import org.listeners.HighlightListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

/**
 * Создает драйвер
 */

public class WebDriverFactory {

    private String browserName = System.getProperty("browser.name");

    public WebDriver create() {
        switch (browserName) {
            case "chrome": {
                ChromeOptions browserOptions = (ChromeOptions) new BrowserChromeOptions().settings();
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver(browserOptions);
                WebDriverListener listener = new HighlightListener(driver);
                return new EventFiringDecorator(listener).decorate(driver);
            }
        }

        throw new BrowserNotSupportException(browserName);

    }

}
