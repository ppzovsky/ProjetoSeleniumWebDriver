package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage {

    private static final String URL_NOVOLEILAO = "http://localhost:8080/leiloes/new";
    private WebDriver webDriver;

    public LeiloesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fechar() {
        this.webDriver.quit();
    }

    public CadastroLeilaoPage carregaFormulario() {
        this.webDriver.navigate().to(URL_NOVOLEILAO);
        return new CadastroLeilaoPage(webDriver);
    }
}
