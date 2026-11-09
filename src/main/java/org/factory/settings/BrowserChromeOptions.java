package org.factory.settings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

/**
 * Реализация настроек для браузера
 */

public class BrowserChromeOptions implements IBrowserSettings {

    @Override
    public AbstractDriverOptions settings() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        options.addArguments("--remote-allow-origins=*");

        return options;
    }
}
