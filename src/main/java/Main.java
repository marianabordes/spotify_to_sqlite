import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        System.out.println("Artistas Disponibles: ");
        System.out.println(controller.getArtistsString());

        System.out.println("¿Desea añadir algún artista? [s] si [n] no");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String respuesta = scanner.next();

        if (respuesta.equals("s")){
            System.out.println("Introduzca el nombre del artista: ");
            String artista = scanner.next();

            System.out.println("Introduzca el id del artista: ");
            String id = scanner2.next();

            controller.setArtists(artista, id);

        }

        System.out.println("Iniciando extracción de datos de artistas");

        controller.controller();
    }

}
