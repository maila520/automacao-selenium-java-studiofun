package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.StudentsPage;

public class StudentsTeste extends BaseTest{
    @Test
    void deveCriarNovoAlunoComSucesso(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.realizarLogin("mailasantos520@gmail.com","Brastemp1*");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.abrirMenuLateralSeNecessario();
        dashboardPage.clickMenuAlunos();

        Assertions.assertTrue(
                driver.getCurrentUrl().contains("students"),
                "Não acessou a página de Alunos"
        );


        StudentsPage studentsPage = new StudentsPage(driver);

        String nomeCadastrado = "Maria Santos";

            studentsPage.clicarNovoAluno();
            studentsPage.preencherFormularioAluno(nomeCadastrado,"12345678900" );
            studentsPage.salvarCadastro();



            studentsPage.clicarVerDetalhes(nomeCadastrado);

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("students"));

        Assertions.assertTrue(driver.getCurrentUrl().contains("/students"),
                "O teste falhou pois a URL atual é: " + driver.getCurrentUrl());



    }

    @Test
    void deveEditarNomeDeAlunoComSucesso() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.realizarLogin("mailasantos520@gmail.com", "Brastemp1*");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuAlunos();

        StudentsPage studentsPage = new StudentsPage(driver);
        String nomeAtual = "Maria Santos";
        String nomeNovo = "Maria Souza";

        studentsPage.clicarEditarAluno(nomeAtual);
        studentsPage.editarNome(nomeNovo);
        studentsPage.salvarCadastro();

        studentsPage.clicarVerDetalhes(nomeNovo);

        Assertions.assertTrue(driver.getCurrentUrl().contains("/students"),
                "Não abriu os detalhes do nome editado");
    }

    @Test
    void deveExcluirAlunoComSucesso() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.realizarLogin("mailasantos520@gmail.com", "Brastemp1*");

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuAlunos();

        StudentsPage studentsPage = new StudentsPage(driver);
        String nomeParaExcluir = "Maria Souza";

        studentsPage.excluirAluno(nomeParaExcluir);

        boolean alunoAindaExiste = driver.findElements(By.xpath("//tr[contains(., '" + nomeParaExcluir + "')]")).size() > 0;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//tr[contains(., '" + nomeParaExcluir + "')]")
        ));

        Assertions.assertTrue(
                driver.findElements(By.xpath("//tr[contains(., '" + nomeParaExcluir + "')]")).isEmpty(),
                "O aluno ainda aparece na lista após a exclusão!"
        );

    }


}
