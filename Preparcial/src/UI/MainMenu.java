package UI;

import Excepciones.UsuarioInexistenteException;
import controladorServicio.sistema;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        sistema sistema = new sistema();

        int opp;
        do{
            Scanner sc = new Scanner(System.in);
            boolean IS = false;
            boolean ver;
            do {
                System.out.println("====Menu====");
                System.out.println("Login de usuario");
                int cl = sc.nextInt();
                sc.nextLine();
                try {
                    ver = sistema.verificacion(cl);
                    IS = true;
                } catch (UsuarioInexistenteException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }while(IS == false);


            if(ver)



            System.out.println("(2) Registrar un equipo de laboratorio");//administrador
            System.out.println("(3) Registrar un usuario");//admin
            System.out.println("(4) Cargar equipos desde archivo de texto");//admin
            System.out.println("(5) Cargar usuarios desde archivo de texto");//admin
            System.out.println("(6) Guardar el estado completo del sistema");//admin
            System.out.println("(7) Recuperar el estado del sistema desde archivo binario");//admin
            System.out.println("(8) Mostrar inventario de equipos por laboratorio y estado");
            System.out.println("(9) Programar una sesion de uso de un equipo");
            System.out.println("(10) Cerrar una sesion de uso y calcular penalizacion");
            System.out.println("(11) Mostrar los equipos con mayor uso por laboratorio");
            System.out.println("(12) Mostrar usuarios con mayor indice de uso indebido");
            System.out.println("(13) Gestion de administradores");//crear/listar
            System.out.println("(0) Salir");
            opp = sc.nextInt();
            sc.nextLine();
            switch(opp){
                case 1:
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
