package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage extends PageObject {

    private static final String URL_NOVOLEILAO = "http://localhost:8080/leiloes/new";
    private static final String URL_LEILAO = "http://localhost:8080/leiloes";

    public LeiloesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CadastroLeilaoPage carregaFormulario() {
        this.webDriver.navigate().to(URL_NOVOLEILAO);
        return new CadastroLeilaoPage(webDriver);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement ultimaLinha = this.webDriver.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = ultimaLinha.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaData = ultimaLinha.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValor = ultimaLinha.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome) && colunaData.getText().equals(data) && colunaValor.getText().equals(valor);
    }

    public boolean isPaginaAtual() {
        return webDriver.getCurrentUrl().equals(URL_LEILAO);
    }
}
