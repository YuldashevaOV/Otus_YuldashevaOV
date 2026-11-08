package org.factory.settings;

import org.openqa.selenium.remote.AbstractDriverOptions;

/**
 * Интерфейс для настроек браузера
 */

public interface IBrowserSettings {
    AbstractDriverOptions settings();
}
