package br.com.alura.leilao;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginTest {

    @Autowired
    WebDriver webDriver = new ChromeDriver();

    @BeforeEach
    public void beforeEach(){
        webDriver.navigate().to("http://localhost:8080/login");
    }

    @AfterEach
    public void afterEach(){
        webDriver.quit();
    }

    @Test
    public void LoginComDadosValidos(){
        webDriver.findElement(By.id("input-username")).sendKeys("fulano");
        webDriver.findElement(By.id("input-password")).sendKeys("pass");
        webDriver.findElement(By.id("login-form")).submit();

        Assertions.assertNotEquals("http://localhost:8080/login", webDriver.getCurrentUrl());
        Assertions.assertEquals("fulano", webDriver.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    public void LoginCmDadosInvalidos(){
        webDriver.findElement(By.id("input-username")).sendKeys("fulano12");
        webDriver.findElement(By.id("input-password")).sendKeys("pass22");
        webDriver.findElement(By.id("login-form")).submit();

        Assertions.assertEquals("http://localhost:8080/login?error", webDriver.getCurrentUrl());
        Assertions.assertTrue(webDriver.getPageSource().contains("Usuário e senha inválidos."));
        Assert.assertThrows(NoSuchElementException.class, () -> webDriver.findElement(By.id("usuario-logado")));
    }
}
