package repository;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> produtos;

    public ProdutoRepository() {
        this.produtos = new ArrayList<>();
    }

    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    public Produto buscarPorId(Long id) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Produto> listarTodos() {
        return produtos;
    }
}
