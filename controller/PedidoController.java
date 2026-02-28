package controller;

import service.PedidoService;

public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController() {
        this.pedidoService = new PedidoService();
    }

    public void iniciar(){
        System.out.println("Iniciando Pedido");
        this.pedidoService =  new PedidoService();
    }


    public void criarPedido(Long clienteId) {
        pedidoService.criarPedido(clienteId);
        System.out.println("Pedido criado com sucesso!");
    }

    public void finalizarPedido(Long pedidoId) {
        pedidoService.finalizarPedido(pedidoId);
        System.out.println("Pedido finalizado com sucesso!");
    }
}
