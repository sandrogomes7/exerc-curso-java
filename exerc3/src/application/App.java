package exerc3.src.application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import exerc3.src.entities.Cliente;
import exerc3.src.entities.ItemPedido;
import exerc3.src.entities.Pedido;
import exerc3.src.entities.Produto;
import exerc3.src.entities.enums.StatusPedido;

public class App {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Digite os dados do cliente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date dataNascimento = sdf.parse(sc.nextLine());

        Cliente cliente = new Cliente(nome, email, dataNascimento);

        System.out.println("Digite os dados do pedido:");
        System.out.print("Status: ");
        StatusPedido status = StatusPedido.valueOf(sc.next());
        System.out.print("Quantos itens tem o pedido? ");
        int N = sc.nextInt();
        
        Pedido pedido = new Pedido(new Date(), status, cliente);

        System.out.println("Digite os dados do pedido:");
        for (int i = 0; i < N; i++) {
            System.out.println("Digite os dados do #" + (i+1) + " item:");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Preço do produto: ");
            double precoProduto = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(nomeProduto, precoProduto);
            ItemPedido it = new ItemPedido(quantidade, precoProduto, produto);
            pedido.addItem(it);
        }
        System.out.println();

        System.out.println("RESUMO DO PEDIDO:");
        System.out.println(pedido);

        sc.close();
    }
}
