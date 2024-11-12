package br.com.alura.leilao.login;

import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private final WebDriver webDriver = new ChromeDriver();

    public LoginPage(){
        this.webDriver.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.webDriver.quit();
    }

    public void preencheFormularioLogin(String username, String password) {
        webDriver.findElement(By.id("input-username")).sendKeys(username);
        webDriver.findElement(By.id("input-password")).sendKeys(password);
    }

    public LeiloesPage enviaFormulario(){
        webDriver.findElement(By.id("login-form")).submit();
        return new LeiloesPage(webDriver);
    }

    public boolean isPaginaLogin() {
        return webDriver.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getUsuarioLogado() {
        try {
            return webDriver.findElement(By.id("usuario-logado")).getText();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        this.webDriver.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        return webDriver.getPageSource().contains(texto);
    }
}
