package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

    @Test
    void shouldAccessStudentsPageFromSidebarMenu(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.realizarLogin("mailasantos520@gmail.com","Brastemp1*");

        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.abrirMenuLateralSeNecessario();
        dashboardPage.clickMenuAlunos();

        String currentUrl = dashboardPage.getCurrentUrl();
        Assertions.assertTrue(
                currentUrl.contains("students"),
                "A página de Alunos não oi acessada corretamente"
        );

    }

}
