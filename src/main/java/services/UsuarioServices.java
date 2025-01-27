package services;

import com.google.gson.Gson;
import dtos.UsuarioDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UsuarioServices {
    private final RequestSpecification requestSpecification;

    public UsuarioServices(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ValidatableResponse listarUsuarios() {
        return given().spec(requestSpecification)
                .get("/usuarios")
                .then();
    }

    public ValidatableResponse buscarUsuarioPorNome(String nome) {
        return given().spec(requestSpecification)
                .param("nome", nome)
                .get("/usuarios")
                .then();
    }

    public ValidatableResponse postUsuario(UsuarioDto usuario) {
        return given()
                .spec(requestSpecification)
                .basePath("/usuarios")
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(usuario))
                .post()
                .then()
                .log()
                .all();
    }

    public ValidatableResponse deleteUsuario(String id) {
        return given().spec(requestSpecification)
                .delete("/usuarios/{_id}", id)
                .then();
    }
}