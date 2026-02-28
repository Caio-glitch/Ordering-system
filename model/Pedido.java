package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static Long contadorId = 1L;

    private Long id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser null");
        }

        this.id = contadorId++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.ABERTO;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return List.copyOf(itens);
    }

    public void adicionarItem(ItemPedido item) {

        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser null");
        }

        if (status != StatusPedido.ABERTO) {
            throw new IllegalStateException("Só é possível adicionar itens em pedidos ABERTOS");
        }

        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void finalizar() {

        if (status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("Não é possível finalizar pedido cancelado");
        }

        if (status == StatusPedido.FINALIZADO) {
            throw new IllegalStateException("Pedido já está finalizado");
        }

        if (itens.isEmpty()) {
            throw new IllegalStateException("Não é possível finalizar pedido vazio");
        }

        this.status = StatusPedido.FINALIZADO;
    }

    public void cancelar() {

        if (status == StatusPedido.FINALIZADO) {
            throw new IllegalStateException("Não é possível cancelar pedido finalizado");
        }

        if (status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("Pedido já está cancelado");
        }

        this.status = StatusPedido.CANCELADO;
    }
}
