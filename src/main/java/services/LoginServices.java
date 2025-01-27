package services;

import dtos.LoginDto;
import com.google.gson.Gson;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class LoginServices {
    private final RequestSpecification requestSpecification;

    public LoginServices(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ValidatableResponse login(String email, String senha) {

        LoginDto loginDto = LoginDto.builder()
                .email(email)
                .password(senha)
                .build();

        return given().spec(requestSpecification)
                .body(new Gson().toJson(loginDto))
                .post("/login")
                .then();
    }
}