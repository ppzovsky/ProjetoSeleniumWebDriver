package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    private static final String URL_NOVOLEILAO = "http://localhost:8080/leiloes/new";
    private WebDriver webDriver;

    public CadastroLeilaoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fechar() {
        this.webDriver.quit();
    }

    public void cadastrarLeilao(String nome, String valor, String hoje) {
        this.webDriver.findElement(By.id("nome")).sendKeys(nome);
        this.webDriver.findElement(By.id("valorInicial")).sendKeys(valor);
        this.webDriver.findElement(By.id("dataAbertura")).sendKeys(hoje);
        this.webDriver.findElement(By.id("button-submit")).submit();
    }
}
