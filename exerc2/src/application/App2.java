package exerc2.src.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import exerc2.src.entities.Comentario;
import exerc2.src.entities.Postagem;

public class App2 {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comentario c1 = new Comentario("Boa viagem!");
        Comentario c2 = new Comentario("Aproveite!");
        Postagem p1 = new Postagem(sdf.parse("21/06/2018 13:05:44"),
                "Viagem a Nova Zelândia",
                "Estou indo visitar esse país maravilhoso!", 12); // Instanciando um objeto do tipo Postagem

        p1.addComentario(c1);
        p1.addComentario(c2);

        Comentario c3 = new Comentario("Boa noite!");
        Comentario c4 = new Comentario("Que a força esteja com você!");

        Postagem p2 = new Postagem(sdf.parse("28/07/2018 23:14:19"),
                "Bom dia galera!",
                "Acordei feliz hoje!", 5);

        p2.addComentario(c3);
        p2.addComentario(c4);

        System.out.println(p1);
        System.out.println(p2);

    }
}
