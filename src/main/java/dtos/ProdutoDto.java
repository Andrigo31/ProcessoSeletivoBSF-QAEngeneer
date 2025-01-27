package dtos;

public class ProdutoDto {
    String nome;
    int preco;
    String descricao;
    int quantidade;

    private ProdutoDto(ProdutoDto.Builder builder) {
        this.nome = builder.nome;
        this.preco = builder.preco;
        this.descricao = builder.descricao;
        this.quantidade = builder.quantidade;
    }

    public static ProdutoDto.Builder builder() {
        return new ProdutoDto.Builder();
    }

    public static class Builder {
        String nome;
        int preco;
        String descricao;
        int quantidade;

        public ProdutoDto.Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ProdutoDto.Builder preco(int preco) {
            this.preco = preco;
            return this;
        }

        public ProdutoDto.Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public ProdutoDto.Builder quantidade(int quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ProdutoDto build() {
            return new ProdutoDto(this);
        }
    }
}
