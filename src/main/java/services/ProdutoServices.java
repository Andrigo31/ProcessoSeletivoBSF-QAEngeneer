package services;

import dtos.ProdutoDto;
import com.google.gson.Gson;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ProdutoServices {

    private final RequestSpecification requestSpecification;

    public ProdutoServices(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ValidatableResponse buscarProdutoPorNome(String nome) {
        return given().spec(requestSpecification)
                .param("nome", nome)
                .get("/produtos")
                .then();
    }

    public ValidatableResponse postProduto(ProdutoDto produtoDto) {
        LoginServices loginServices = new LoginServices(requestSpecification);

        String token = loginServices.efetuarLogin("andrigo@gmail.com", "654321")
                .extract()
                .jsonPath()
                .get("authorization");

        return given().spec(requestSpecification)
                .header("Authorization", token)
                .body(new Gson().toJson(produtoDto))
                .post("/produtos")
                .then();
    }

    public ValidatableResponse deleteProduto(String id) {
        LoginServices loginServices = new LoginServices(requestSpecification);

        String token = loginServices.efetuarLogin("andrigo@gmail.com", "654321")
                .extract()
                .jsonPath()
                .get("authorization");

        return given().spec(requestSpecification)
                .header("Authorization", token)
                .param("_id", id)
                .delete("/produtos/{_id}", id)
                .then();
    }
}