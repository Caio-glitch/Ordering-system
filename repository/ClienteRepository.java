package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private List<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorId(Long id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> listarTodos() {
        return clientes;
    }
}
