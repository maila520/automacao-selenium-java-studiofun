package tests;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {
    @Test
    void deveRealizarLoginSucesso(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.realizarLogin("mailasantos520@gmail.com","Brastemp1*");
        String urlAtual = driver.getCurrentUrl();
        Assertions.assertTrue(
                urlAtual.contains("dashboard"),
                "Login falhou: usúario não foi redirecionado"
        );
    }
}
