package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage extends PageObject {

    private static final String URL_NOVOLEILAO = "http://localhost:8080/leiloes/new";

    public CadastroLeilaoPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void cadastrarLeilao(String nome, String valor, String hoje) {
        this.webDriver.findElement(By.id("nome")).sendKeys(nome);
        this.webDriver.findElement(By.id("valorInicial")).sendKeys(valor);
        this.webDriver.findElement(By.id("dataAbertura")).sendKeys(hoje);
        this.webDriver.findElement(By.id("button-submit")).submit();
    }

    public boolean isPaginaAtual() {
        return webDriver.getCurrentUrl().equals(URL_NOVOLEILAO);
    }

    public boolean isMensagensVisiveis() {
        String pageSource = webDriver.getPageSource();
        return pageSource.contains("minimo 3 caracteres") &&
                pageSource.contains("não deve estar em branco") &&
                pageSource.contains("deve ser um valor maior de 0.1") &&
                pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
