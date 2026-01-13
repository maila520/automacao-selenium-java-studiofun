package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ForgotPasswordPage {

    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "email")
    WebElement campoEmail;

    @FindBy(css = "input[type='submit']")
    WebElement botaoEnviar;

    @FindBy(css = ".alert")
    WebElement mensagemSucessoOuErro;


    public  void  informarEmail(String email){
        campoEmail.sendKeys(email);
    }

    public void enviarSolicitacao(){
        botaoEnviar.click();
    }
    public String obterMensagem(){
        return mensagemSucessoOuErro.getText();
    }

    public void recuperarSenha(String email){
        informarEmail((email));
        enviarSolicitacao();
    }



}
