package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HorasContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Digite o nome do departamento: ");
        String departamentoNome = sc.nextLine();

        System.out.println("Digite os dados do trabalhador: ");
        System.out.print("Nome: ");
        String nomeTrabalhador = sc.nextLine();
        System.out.print("Nível: ");
        String nivelTrabalhador = sc.nextLine();
        System.out.print("Salário base: ");
        double salarioBase = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador),
                salarioBase, new Departamento(departamentoNome)); // Instanciando um objeto do tipo Trabalhador e
                                                                  // outro do tipo Departamento

        System.out.print("Quantos contratos para esse trabalhador? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Digite os dados do contrato #" + i + " data:");
            System.out.print("Data (DD/MM/YYYY): ");
            Date contratoData = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();
            System.out.print("Duração (horas): ");
            int horas = sc.nextInt();

            HorasContrato contrato = new HorasContrato(contratoData, valorPorHora, horas); // Instanciando um objeto do
                                                                                           // tipo HorasContrato
                                                                                        
            trabalhador.addContrato(contrato); // Adicionando o contrato ao trabalhador
        }
        System.out.println();

        System.out.print("Digite o mês e o ano para calcular a renda (MM/YYYY): ");
        String mesEAno = sc.next();

        int mes = Integer.parseInt(mesEAno.substring(0, 2));
        int ano = Integer.parseInt(mesEAno.substring(3));

        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.println("Renda para " + mesEAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));

        


        sc.close();
    }
}
