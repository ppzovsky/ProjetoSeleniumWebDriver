package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

    protected WebDriver webDriver;

    public PageObject(WebDriver webDriver) {
        if (webDriver == null) {
            this.webDriver = new ChromeDriver();
        } else {
            this.webDriver = webDriver;
        }
    }

    public void fechar() {
        this.webDriver.quit();
    }
}
