package org.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class HighlightListener implements WebDriverListener {

    private WebDriver driver;

    public HighlightListener(WebDriver driver) {
        this.driver = driver;
    }

    // Подсвечиваем объект
    @Override
    public void beforeClick(WebElement element) {
        System.out.println("=== THE LISTENER HAS WORKED ===");
        String className = element.getAttribute("class");
        System.out.println("Element class: " + className);
        if (className != null && className.contains("btn-primary")) {
            System.out.println("=== CONDITION FULFILLED, HIGHLIGHTING ===");
            WebElement card = element.findElement(By.xpath("./ancestor::div[contains(@class, 'card')]"));
            higlightFrame(card, "green");
        }
    }

    public void higlightFrame(WebElement element, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid " + color + "'; arguments[0].style.background='yellow';", element);
    }

    @Override
    public void afterClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', '');", element);
    }
}
