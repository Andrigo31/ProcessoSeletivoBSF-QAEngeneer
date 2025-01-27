package commons;

import org.junit.jupiter.api.BeforeEach;
import io.restassured.specification.RequestSpecification;
import specifications.ServeRestSpecification;

public class BaseTestBack {
    protected static RequestSpecification requestSpecification;

    @BeforeEach
    public void setUp() {
        try {
            requestSpecification = new ServeRestSpecification().getRequestSpecification();
        } catch (Exception e) {
            throw new RuntimeException("Erro, requisição não pode ser configurada: " + e.getMessage(), e);
        }
    }
}