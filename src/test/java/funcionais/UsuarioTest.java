package funcionais;

import dtos.UsuarioDto;
import commons.BaseTestBack;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import services.UsuarioServices;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.greaterThan;

public class UsuarioTest extends BaseTestBack {
    static UsuarioServices usuarioServices;

    @Test
    void listarUsuarioSucesso() {
        usuarioServices = new UsuarioServices(requestSpecification);
        usuarioServices.listarUsuarios()
                .statusCode(SC_OK)
                .body("quantidade", notNullValue());
    }

    @Test
    void validarCadastroUsuarioSucesso() {
        usuarioServices = new UsuarioServices(requestSpecification);

        UsuarioDto usuarioDto = UsuarioDto.builder()
                .nome("AndreaFA")
                .email("andrea@gmail.com")
                .password("123456")
                .administrador("true")
                .build();

        usuarioServices.postUsuario(usuarioDto)
                .statusCode(SC_CREATED)
                .body("message", is("Cadastro realizado com sucesso"));

        usuarioServices.buscarUsuarioPorNome("AndreaFA")
                .statusCode(SC_OK)
                .body("quantidade", allOf(notNullValue(), greaterThan(0)));
    }

    @AfterAll
    static void deletarUsuarioSucesso() {
        usuarioServices = new UsuarioServices(requestSpecification);

        String id = usuarioServices.buscarUsuarioPorNome("AndreaFA").log().all()
                .extract()
                .jsonPath()
                .get("usuarios[0]._id");

        usuarioServices.deleteUsuario(id)
                .statusCode(SC_OK)
                .body("message", is("Registro excluído com sucesso"));
    }
}