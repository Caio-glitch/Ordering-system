package Entity;

public class Estoque {
    private String codigo;
    private int quantity;

    public Estoque(String codigo, int quantity){
        if(quantity < 0){
            throw new IllegalArgumentException("A quantidade não pode estar negativa");
        }

        if(codigo == null || codigo.isBlank()) {
                throw new IllegalArgumentException("O codigo não está preenchido de forma correta");
        }
        this.quantity = quantity;
        this.codigo = codigo;
    }

    private String getCodigo() {
        return codigo;
    }

    private int getQuantity() {
        return quantity;
    }

}
