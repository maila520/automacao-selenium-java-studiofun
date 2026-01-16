package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    // Locators
    private By menuToggle = By.cssSelector("button.navbar-toggler");
    private By menuAlunos = By.cssSelector("a[href='/students']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirMenuLateralSeNecessario() {

        List<WebElement> menuButtons = driver.findElements(menuToggle);

        if (!menuButtons.isEmpty()) {
            WebElement menuButton = menuButtons.get(0);

            if (menuButton.isDisplayed() && menuButton.isEnabled()) {
                menuButton.click();
            }
        }
    }

    public void clickMenuAlunos() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(menuAlunos))
                .click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void criarNovoAluno(){

    }
}

