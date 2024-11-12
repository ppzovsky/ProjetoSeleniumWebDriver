package br.com.alura.leilao.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LoginTest {

    private LoginPage paginaLogin;

    @BeforeEach
    public void beforeEach(){
        this.paginaLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        paginaLogin.fechar();
    }

    @Test
    public void LoginComDadosValidos(){
        paginaLogin.preencheFormularioLogin("fulano", "pass");
        paginaLogin.enviaFormulario();

        Assertions.assertFalse(paginaLogin.isPaginaLogin());
        Assertions.assertEquals("fulano", paginaLogin.getUsuarioLogado());
    }

    @Test
    public void LoginCmDadosInvalidos(){
        paginaLogin.preencheFormularioLogin("fulano2", "pass2");
        paginaLogin.enviaFormulario();

        Assertions.assertFalse(paginaLogin.isPaginaLogin());
        Assertions.assertTrue(paginaLogin.contemTexto("Usuário e senha inválidos."));
        Assertions.assertNull(paginaLogin.getUsuarioLogado());
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        paginaLogin.navegaParaPaginaDeLances();
        Assertions.assertTrue(paginaLogin.isPaginaLogin());
        Assertions.assertFalse(paginaLogin.contemTexto("Dados do Leilão"));
    }
}
