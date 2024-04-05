package exerc3.src.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exerc3.src.entities.enums.StatusPedido;

public class Pedido {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private Date momento;
    private StatusPedido status;

    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<ItemPedido>();

    public Pedido(){
    }

    public Pedido(Date momento, StatusPedido status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(ItemPedido item){
        itens.add(item);
    }

    public void removeItem(ItemPedido item){
        itens.remove(item);
    }

    public Double total(){
        Double sum = 0.0;
        for(ItemPedido item : itens){
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(sdf.format(momento) + "\n");
        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Itens do pedido:\n");
        for(ItemPedido item : itens){
            sb.append(item + "\n");
        }
        sb.append("Preço total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }

}
