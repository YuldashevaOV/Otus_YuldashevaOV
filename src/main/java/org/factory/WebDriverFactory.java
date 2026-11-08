package org.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.exceptions.BrowserNotSupportException;
import org.factory.settings.BrowserChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
                return new ChromeDriver(browserOptions);
            }
        }

        throw new BrowserNotSupportException(browserName);
    }

}
