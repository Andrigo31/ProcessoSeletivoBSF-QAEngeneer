package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CorreiosPage {

    private WebDriver driver;
    private By endereco = By.id("endereco");
    private By pesquisar = By.id("btn_pesquisar");

    public CorreiosPage(WebDriver driver){
        this.driver = driver;
    }
    public CorreiosPage acessaPagina(){
        driver.get("http://www.buscacep.correios.com.br");
        driver.manage().deleteAllCookies();
        return this;
    }
    public CorreiosPage pesquisa(){
        driver.findElement(endereco).sendKeys("69005-040");
        driver.findElement(pesquisar).click();
        return this;
    }
}