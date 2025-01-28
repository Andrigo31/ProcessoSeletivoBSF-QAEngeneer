package funcionais;

import commons.CaptchaSolver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CorreiosPage;

import java.io.IOException;
import java.time.Duration;

public class CorreiosTest {

    public WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    void consultarCepComSucesso() throws IOException {

        new CorreiosPage(driver).acessaPagina()
         .pesquisa();

        WebElement captchaImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("captcha_image")));
        String captchaImageUrl = captchaImage.getAttribute("src");

        CaptchaSolver solver = new CaptchaSolver();
        String captchaSolution = solver.getCaptchaSolution(captchaImageUrl);

        if (captchaSolution != null) {
            WebElement captchaInput = driver.findElement(By.id("captcha"));
            captchaInput.sendKeys(captchaSolution);

            WebElement submitButton = driver.findElement(By.id("btn_pesquisar"));
            submitButton.click();

            WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")));
            Assertions.assertEquals("Rua Miranda Leão", resultado.getText());
        } else {
            Assertions.fail("Não foi possível resolver o CAPTCHA.");
        }
    }
}
