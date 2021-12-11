
package br.com.senai.projetofinal.projetofinalds2.repository;

import br.com.senai.projetofinal.projetofinalds2.modelo.Pedido;
import br.com.senai.projetofinal.projetofinalds2.modelo.StatusPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    public List<Pedido> findByStatus(StatusPedido statusPedido);
    
}
