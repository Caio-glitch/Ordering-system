package model;

public class Cliente {

    private static Long contadorId = 1L;

    private Long id;
    private String nome;
    private String email;
    private String cep;

    public Cliente(String nome, String email, String cep) {
        this.id = contadorId++;
        this.nome = nome;
        setEmail(email);
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCep() {
        return cep;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        this.email = email;
    }

    public void setCep(String cep) {
        if(cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("O CEP não pode ser vazio");
        }
        this.cep = cep;
    }
}
