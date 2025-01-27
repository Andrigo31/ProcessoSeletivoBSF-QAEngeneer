package dtos;

public class LoginDto {

    private LoginDto(Builder builder) {
        String email = builder.email;
        String password = builder.password;
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
