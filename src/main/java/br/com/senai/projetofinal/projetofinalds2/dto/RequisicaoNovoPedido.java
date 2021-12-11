
package br.com.senai.projetofinal.projetofinalds2.dto;

import br.com.senai.projetofinal.projetofinalds2.modelo.Pedido;
import br.com.senai.projetofinal.projetofinalds2.modelo.StatusPedido;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import static org.springframework.http.ResponseEntity.status;

public class RequisicaoNovoPedido {
    
    @NotBlank
    private String txtProduto;
    
    @NotBlank
    private String txtUrlProduto;
   
    @NotBlank
    private String txtUrlImagem;
    
    private String txtDescricao;

    private String txtId;
    
    
    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }
    
    public String getTxtProduto() {
        return txtProduto;
    }

    public void setTxtProduto(String txtProduto) {
        this.txtProduto = txtProduto;
    }

    public String getTxtUrlProduto() {
        return txtUrlProduto;
    }

    public void setTxtUrlProduto(String txtUrlProduto) {
        this.txtUrlProduto = txtUrlProduto;
    }

    public String getTxtUrlImagem() {
        return txtUrlImagem;
    }

    public void setTxtUrlImagem(String txtUrlImagem) {
        this.txtUrlImagem = txtUrlImagem;
    }

    public String getTxtDescricao() {
        return txtDescricao;
    }

    public void setTxtDescricao(String txtDescricao) {
        this.txtDescricao = txtDescricao;
    }
    
    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(txtProduto);
        pedido.setUrlProduto(txtUrlProduto);
        pedido.setUrlImagem(txtUrlImagem);
        pedido.setDescricao(txtDescricao);
        pedido.setDataDaEntrega(LocalDate.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
    
    public Pedido toUpdateStatusPedido(String status){
        Pedido pedido = new Pedido();
        pedido.setId(Long.parseLong(txtId));
        pedido.setNomeProduto(txtProduto);
        pedido.setUrlProduto(txtUrlProduto);
        pedido.setUrlImagem(txtUrlImagem);
        pedido.setDescricao(txtDescricao);
        pedido.setDataDaEntrega(LocalDate.now());
        
        if(status.equals("aprovado")){
           pedido.setStatus(StatusPedido.APROVADO);
        }else{
            pedido.setStatus(StatusPedido.ENTREGUE);
        }
        return pedido;
    }   
}
