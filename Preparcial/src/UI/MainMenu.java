package UI;

import Excepciones.UsuarioInexistenteException;
import controladorServicio.sistema;
import modelo.Usuario;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        sistema sistema = new sistema();
        Scanner sc = new Scanner(System.in);
        int opp;
        Usuario login = null;
            do {
                System.out.println("LOGIN DE USUARIO");
                System.out.println("Ingrese su codigo de usuario:");
                String cod = sc.nextLine();
                System.out.println("Ingrese la clave:");
                int cl = sc.nextInt();
                sc.nextLine();
                try {
                    login = sistema.verificacion(cl,cod);
                } catch (UsuarioInexistenteException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }while(login ==null);

        do{
            login.mostrarmenu();
            System.out.println("Ingrese una opcion:");
            opp = sc.nextInt();
            sc.nextLine();
            switch(opp){
                case 1:
                    sistema.mostrarequipos();
                    break;
                case 2:

                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
            }
        }while(opp!= 0);
    }
}
