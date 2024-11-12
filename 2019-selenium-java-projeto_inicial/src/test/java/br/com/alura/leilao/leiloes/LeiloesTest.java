package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {

    private LeiloesPage paginaLeiloes;
    private CadastroLeilaoPage paginaCadastroLeilao;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioLogin("fulano", "pass");
        this.paginaLeiloes = paginaDeLogin.enviaFormulario();
        this.paginaCadastroLeilao =  paginaLeiloes.carregaFormulario();
    }

    @AfterEach
    public void afterEach(){
        this.paginaLeiloes.fechar();
    }

    @Test
    public void deveriaCadastrarLeilao() {
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao dia " + hoje;
        String valor = "500.00";

        paginaCadastroLeilao.cadastrarLeilao(nome, valor, hoje);
        Assertions.assertTrue(paginaLeiloes.isLeilaoCadastrado(nome, valor, hoje));
    }

    @Test
    public void deveriaValidarCadastroDeLeilao(){
        paginaCadastroLeilao.cadastrarLeilao("", "", "");

        Assertions.assertTrue(this.paginaLeiloes.isPaginaAtual());
        Assertions.assertFalse(this.paginaCadastroLeilao.isPaginaAtual());
        Assertions.assertTrue(this.paginaCadastroLeilao.isMensagensVisiveis());
    }
}
