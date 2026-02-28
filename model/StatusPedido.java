package model;
public enum StatusPedido {

    ABERTO {
        public boolean podeAdicionarItem() { return true; }
        public boolean podeFinalizar() { return true; }
        public boolean podeCancelar() { return true; }
    },

    FINALIZADO {
        public boolean podeAdicionarItem() { return false; }
        public boolean podeFinalizar() { return false; }
        public boolean podeCancelar() { return false; }
    },

    CANCELADO {
        public boolean podeAdicionarItem() { return false; }
        public boolean podeFinalizar() { return false; }
        public boolean podeCancelar() { return false; }
    };

    public abstract boolean podeAdicionarItem();
    public abstract boolean podeFinalizar();
    public abstract boolean podeCancelar();
}
