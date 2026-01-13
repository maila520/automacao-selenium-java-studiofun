package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;

public class ForgotPasswordTest extends BaseTest {

    @Test
    void deveEnviarSolicitacaoDeRecuperacaoDeSenhaComSucesso(){

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clicarEsqueciSenha();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        forgotPasswordPage.recuperarSenha("mailasantos520@gmail.com");

        String mensagem = forgotPasswordPage.obterMensagem();

        Assertions.assertTrue(
                mensagem.toLowerCase().contains("envi"),
                "Mensagem de sucesso não exibida"
        );

    }
}
