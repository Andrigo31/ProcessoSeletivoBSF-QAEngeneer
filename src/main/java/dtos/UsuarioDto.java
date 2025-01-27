package dtos;

public class UsuarioDto {
    private String nome;
    private String email;
    private String password;
    private String administrador;

    private UsuarioDto(UsuarioDto.Builder builder) {
        this.nome = builder.nome;
        this.email = builder.email;
        this.password = builder.password;
        this.administrador = builder.administrador;
    }

    public static UsuarioDto.Builder builder() {
        return new UsuarioDto.Builder();
    }

    public static class Builder {
        private String nome;
        private String email;
        private String password;
        private String administrador;

        public UsuarioDto.Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioDto.Builder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioDto.Builder password(String password) {
            this.password = password;
            return this;
        }

        public UsuarioDto.Builder administrador(String administrador) {
            this.administrador = administrador;
            return this;
        }

        public UsuarioDto build() {
            return new UsuarioDto(this);
        }
    }
}
