package funcionais;

import commons.BaseTestBack;
import dtos.ProdutoDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ProdutoServices;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ProdutoTest extends BaseTestBack {
    static ProdutoServices produtoServices;

    @BeforeEach
    void setup() {
        produtoServices = new ProdutoServices(requestSpecification);
    }

    @Test
    void cadastrarProdutoSucesso() {
        produtoServices = new ProdutoServices(requestSpecification);

        ProdutoDto produtoDto = ProdutoDto.builder()
                .descricao("Lego Classic Caixa De Festa Criativa")
                .nome("Lego Classic")
                .preco(519)
                .quantidade(1)
                .build();

        produtoServices.postProduto(produtoDto)
                .statusCode(SC_CREATED)
                .body("message", is("Cadastro realizado com sucesso"));

    }

    @Test
    void buscarProdutoPorNomeSucesso() {
        produtoServices = new ProdutoServices(requestSpecification);
        produtoServices.buscarProdutoPorNome("Lego Classic")
                .statusCode(SC_OK)
                .body("quantidade", notNullValue());
    }

    @AfterAll
    static void deletarProdutoSucesso() {
        produtoServices = new ProdutoServices(requestSpecification);

        String id = produtoServices.buscarProdutoPorNome("Lego Classic")
                .extract()
                .jsonPath()
                .get("produtos[0]._id");

        System.out.println(id);
        produtoServices.deleteProduto(id)
                .statusCode(SC_OK)
                .body("message", is("Registro excluído com sucesso"));
    }
}
