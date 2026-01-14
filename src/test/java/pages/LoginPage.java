package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "email")
    WebElement campoUsuario;

    @FindBy(name = "password")
    WebElement campoSenha;

    @FindBy(css = "button[type='submit']")
    WebElement botaoEntrar;

    @FindBy(linkText = "Esqueci a senha")
    WebElement linkEsqueciSenha;


    public void realizarLogin(String usuario, String senha){
        campoUsuario.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        botaoEntrar.click();
    }

    public void clicarEsqueciSenha() {
        linkEsqueciSenha.click();
    }

    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".alert-danger");

    public  void fillEmail (String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }
    public void fillPassword (String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }


}


