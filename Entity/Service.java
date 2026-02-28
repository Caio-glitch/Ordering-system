package Entity;

public class Service {
    public String endereco;
    public String cidade;
    public String estado;
    private String cep;

    public Service(String endereco, String cidade, String estado, String cep) {
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    private String getEndereco(String endereco){
        return endereco;
    }

    private String getCep(String cep){
        return cep;
    }

}
