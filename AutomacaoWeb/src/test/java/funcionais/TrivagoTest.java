package funcionais;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TrivagoPage;

import java.time.Duration;

public class TrivagoTest {
    public WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.edgedriver()
                .setup();
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    void TrivagoTestSucesso() {
        TrivagoPage trivagoPages = new TrivagoPage(driver).acessarSite()
                .escolherDestino("Manaus")
                .realizarPesquisa()
                .ordenarResultado();

        Assertions.assertEquals("Rede Andrade Amazônia", trivagoPages.obterPrimeiroHotel());
        Assertions.assertEquals("7.5", trivagoPages.obterPrimeiraAvalicao());
        Assertions.assertEquals("R$78", trivagoPages.obterPrimeiroValor());
    }
}