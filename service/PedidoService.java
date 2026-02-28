package service;

import model.*;
import repository.*;

public class PedidoService {

    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    private PedidoRepository pedidoRepository;

    public PedidoService() {
        this.clienteRepository = new ClienteRepository();
        this.produtoRepository = new ProdutoRepository();
        this.pedidoRepository = new PedidoRepository();
    }

    public Pedido criarPedido(Long clienteId) {

        Cliente cliente = clienteRepository.buscarPorId(clienteId);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        Pedido pedido = new Pedido(cliente);
        pedidoRepository.salvar(pedido);

        return pedido;
    }

    public void adicionarProduto(Long pedidoId, Long produtoId, int quantidade) {

        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

        Produto produto = produtoRepository.buscarPorId(produtoId);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        ItemPedido item = new ItemPedido(produto, quantidade);
        pedido.adicionarItem(item);
    }

    public void finalizarPedido(Long pedidoId) {

        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);

        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }

        pedido.finalizar();
    }
}
