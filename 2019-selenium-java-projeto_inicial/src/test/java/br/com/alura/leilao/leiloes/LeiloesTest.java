package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {

    private LeiloesPage paginaLeiloes;

    @AfterEach
    public void afterEach(){
        this.paginaLeiloes.fechar();
    }

    @Test
    public void deveriaCadastrarLeilao() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioLogin("fulano", "pass");
        this.paginaLeiloes = paginaDeLogin.enviaFormulario();
        CadastroLeilaoPage paginaCadastroLeilao =  paginaLeiloes.carregaFormulario();

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao dia" + hoje;
        String valor = "500,00";

        paginaCadastroLeilao.cadastrarLeilao(nome, valor, hoje);
    }

}
