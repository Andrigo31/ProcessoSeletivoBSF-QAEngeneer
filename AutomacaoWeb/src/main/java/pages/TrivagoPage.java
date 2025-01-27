package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TrivagoPage extends BasePage  {

    private static final Logger logger = LoggerFactory.getLogger(TrivagoPage.class);
    protected WebDriverWait wait;

    public static final By busca = By.xpath("//*[@id='__next']/div[1]/div[2]/section[1]/div[2]/div/button");
    public static final By autoComplete = By.id("input-auto-complete");
    public static final By destino = By.xpath("//*[text()='Cidade · Amazonas, Brasil']");
    public static final By botaoPesquisar = By.xpath("//*[text()='Pesquisar']");
    public static final By comboOrdenarPor = By.xpath("//*[text()='Ordenar por']");
    public static final By itemAvaliacaoESugestoes = By.xpath("//*[text()='Avaliação e sugestões']");
    public static final By botaoConfirmar = By.xpath("//*[text()='Confirmar']");
    public static final By hotelPrimeiroResultado = By.xpath("//*[@id=\"__next\"]/div[1]/main/div[3]/section/div/div/ol/li[1]/div/article/div[2]/div[1]/section/h2/button/span");
    public static final By avaliacaoPrimeiroResultado = By.xpath("//*[@id=\"__next\"]/div[1]/main/div[3]/section/div/div/ol/li[1]/div/article/div[2]/div[1]/button[3]/span/span/span[1]");
    public static final By valorPrimeiroResultado = By.xpath("//*[@id='__next']/div[1]/main/div[3]/section[2]/div/div/ol/li[1]/div/article/div[2]/div[2]/div/div/div[1]");
    public static final By cookie = By.xpath("//*[text()='OK']");

    public TrivagoPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public TrivagoPage acessarSite() {
        logger.info("Acessando o site do Trivago");
        driver.get("http://www.trivago.com.br");
        driver.manage().deleteAllCookies();
        return this;
    }


    public TrivagoPage escolherDestino(String destinoEscolhido) {
        try {
            logger.info("Iniciando seleção do destino: {}", destinoEscolhido);
            clicarElemento(busca);
            WebElement autoCompleteElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(autoComplete));
            autoCompleteElemento.sendKeys(destinoEscolhido);
            clicarElemento(destino);
            logger.info("Destino selecionado com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao selecionar o destino: {}", e.getMessage());
        }
        return this;
    }

    public TrivagoPage realizarPesquisa() {
        clicarElemento(botaoPesquisar);
        logger.info("Pesquisa realizada com sucesso!");
        return this;
    }

    public TrivagoPage ordenarResultado() {
        logger.info("Iniciando ordenação por avaliação e sugestões");
        clicarElemento(comboOrdenarPor);
        clicarElemento(itemAvaliacaoESugestoes);
        clicarElemento(botaoConfirmar);
        logger.info("Ordenação concluída");
        return this;
    }

    public String obterTextoDeElemento(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void clicarElemento(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String obterPrimeiroHotel() {
        return obterTextoDeElemento(hotelPrimeiroResultado);
    }

    public String obterPrimeiraAvalicao() {
        return obterTextoDeElemento(avaliacaoPrimeiroResultado);
    }

    public String obterPrimeiroValor() {
        try {
            WebElement priceElement = driver.findElement(valorPrimeiroResultado);
            return priceElement.getText()
                    .split("\\n")[1]
                    .trim();
        } catch (Exception e) {
            logger.error("Preço não encontrado: " + e.getMessage());
            return null;
        }
    }

}