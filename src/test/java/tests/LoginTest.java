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
    @Test
    public void  shoulNotLoginWhitInvalidEmail(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillEmail("mailasantos@gmail.com");
        loginPage.fillPassword("123490956");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertTrue(
                errorMessage.toLowerCase().contains("inválido") ||
                        errorMessage.toLowerCase().contains("incorreto"));
    }

    @Test
    public void shoulNotLoginWithWrongPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillEmail("mailasantos@gmail.com");
        loginPage.fillPassword("1jvnbvub");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertTrue(errorMessage.contains("senha"));
    }

    @Test
    public void shouldNotLoginWithValidEmailAndInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillEmail("mailasantos520@gmail.com");
        loginPage.fillPassword("senhafuhfewu");
        loginPage.clickLogin();

        String alertMessage = loginPage.getErrorMessage();

        Assertions.assertFalse(
                alertMessage.isEmpty(),
                "Menssagem de alerta não foi exibida para senha invalida"
        );
    }

}
