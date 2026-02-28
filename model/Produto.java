package model;

public class Produto {

    private static Long contadorId = 1L;

    private Long id;
    private String nome;
    private double preco;
    private String descricao;

    public Produto(String nome, double preco, String descricao) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }

        this.id = contadorId++;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}
