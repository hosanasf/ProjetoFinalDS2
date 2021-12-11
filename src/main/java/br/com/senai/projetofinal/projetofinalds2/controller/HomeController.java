package br.com.senai.projetofinal.projetofinalds2.controller;

import br.com.senai.projetofinal.projetofinalds2.modelo.Pedido;
import br.com.senai.projetofinal.projetofinalds2.modelo.StatusPedido;
import br.com.senai.projetofinal.projetofinalds2.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping
    public String home(Model model){
       List<Pedido> pedidos = pedidoRepository.findAll();
       model.addAttribute("pedidos", pedidos);
       return "home";
    }
    
    @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model){
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }    
}