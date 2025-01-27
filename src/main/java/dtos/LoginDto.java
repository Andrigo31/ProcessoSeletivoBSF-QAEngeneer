package dtos;

public class LoginDto {
    private String email;
    private String password;

    private LoginDto(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String password;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public LoginDto build() {
            return new LoginDto(this);
        }
    }
}
