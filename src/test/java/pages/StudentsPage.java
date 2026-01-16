package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StudentsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By btnNovoAluno = By.cssSelector("button[data-bs-target='#modalCadastro']");
    private By modalAluno = By.cssSelector(".modal-dialog");

    private By nomeCompleto = By.name("full_name");
    private By cpf = By.name("cpf");
    private By dataNascimento = By.name("birth_date");
    private By email = By.name("email");
    private By telefone = By.name("phone");
    private By cep = By.name("postal_code");
    private By cidade = By.name("city");
    private By logradouro = By.name("address");
    private By numero = By.name("address_number");
    private By plano = By.name("plan_id");
    private By sangue = By.name("blood_type");
    private By peso = By.name("weight");
    private By altura = By.name("height");
    private By contatoEmergencia = By.name("emergency_contact");
    private By telefoneEmergencia = By.name("emergency_phone");
    private By observacoesMedicas = By.name("medical_notes");

    private By btnSalvar = By.cssSelector("button[type='submit']");


    public StudentsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clicarNovoAluno() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNovoAluno)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalAluno));

    }

    public void preencherFormularioAluno(String nome, String cpfInformado) {
        driver.findElement(nomeCompleto).sendKeys("Maria Santos");
        driver.findElement(cpf).sendKeys("12345678900");
        driver.findElement(dataNascimento).sendKeys("01011995");
        driver.findElement(email).sendKeys("maria.santos@email.com");
        driver.findElement(telefone).sendKeys("11999999999");
        driver.findElement(cep).sendKeys("01001000");
        driver.findElement(cidade).sendKeys("São Paulo");
        driver.findElement(logradouro).sendKeys("Rua Teste");
        driver.findElement(numero).sendKeys("123");
        driver.findElement(plano).sendKeys("Plano Mensal (R$ 70.00)l");
        driver.findElement(sangue).sendKeys("O+");
        driver.findElement(peso).sendKeys("65");
        driver.findElement(altura).sendKeys("1.65");
        driver.findElement(contatoEmergencia).sendKeys("João Santos");
        driver.findElement(telefoneEmergencia).sendKeys("11988888888");
        driver.findElement(observacoesMedicas).sendKeys("Nenhuma observação");
        ;
    }

    public void salvarCadastro() {
        driver.findElement(btnSalvar).click();
    }

    public void clicarVerDetalhes(String nomeDoAluno) {
        String xpathBotao = "//tr[contains(., '" + nomeDoAluno + "')]//button[@title='Ver Detalhes']";
        WebElement btnOlhinho = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathBotao)));

        // FORÇA O SCROLL: Primeiro desce tudo, depois centraliza no botão
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); // Desce até o fim da página
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", btnOlhinho); // Centraliza no botão


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnOlhinho)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", btnOlhinho);
        }

    }

    public void clicarEditarAluno(String nomeDoAluno) {
        String xpathEditar = "//tr[contains(., '" + nomeDoAluno + "')]//button[@title='Editar']";
        WebElement btnEditar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathEditar)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btnEditar);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnEditar);

        wait.until(ExpectedConditions.visibilityOfElementLocated(modalAluno));
    }

    public void editarNome(String novoNome) {
        WebElement campoNome = wait.until(ExpectedConditions.elementToBeClickable(nomeCompleto));
        campoNome.clear();
        campoNome.sendKeys(novoNome);
    }

    public void excluirAluno(String nomeAluno) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");


        By linhaAluno = By.xpath("//tr[contains(., '" + nomeAluno + "')]");
        WebElement linha = wait.until(
                ExpectedConditions.visibilityOfElementLocated(linhaAluno)
        );


        js.executeScript("arguments[0].scrollIntoView(true);", linha);


        WebElement botaoExcluir = linha.findElement(
                By.xpath(".//button[@title='Excluir')]")
        );
        botaoExcluir.click();


        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}





