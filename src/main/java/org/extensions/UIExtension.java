package org.extensions;

import com.google.inject.Guice;
import org.factory.WebDriverFactory;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.modules.CommonModule;
import org.modules.GuicePageModule;
import org.openqa.selenium.WebDriver;

/**
 * Управление драйвером
 */

public class UIExtension implements BeforeEachCallback, AfterEachCallback {

    private WebDriver driver;

    // Создание драйвера через WebDriverFactory
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        driver = new WebDriverFactory().create();

        Guice.createInjector(new GuicePageModule(driver), new CommonModule()).injectMembers(context.getTestInstance().get());
    }

    // Закрытие браузера
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
