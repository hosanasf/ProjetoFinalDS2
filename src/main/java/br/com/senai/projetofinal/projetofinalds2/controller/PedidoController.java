
package br.com.senai.projetofinal.projetofinalds2.controller;

import br.com.senai.projetofinal.projetofinalds2.dto.RequisicaoNovoPedido;
import br.com.senai.projetofinal.projetofinalds2.modelo.Pedido;
import br.com.senai.projetofinal.projetofinalds2.modelo.StatusPedido;
import br.com.senai.projetofinal.projetofinalds2.repository.PedidoRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("pedido")
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
        return "pedido/formulario";
    }
    
    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result){
        if(result.hasErrors()){
            return "pedido/formulario";
        }else{
            Pedido pedido = requisicao.toPedido();
            pedidoRepository.save(pedido);
            return "redirect:/home";
        }
    }
      
    @GetMapping("/{status}")
    public String porStatus(RequisicaoNovoPedido requisicao,@PathVariable("status") String status, Model model){
            
            Pedido pedido = requisicao.toUpdateStatusPedido(status);
            pedidoRepository.save(pedido);
            
            return "redirect:/home/"+status;
    }
}

