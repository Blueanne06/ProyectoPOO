package UI;

import Excepciones.EquipoException;
import Excepciones.SesionException;
import Excepciones.UsuarioException;
import controladorServicio.sistema;
import modelo.Usuario;
import persistence.CargarEquipos;
import persistence.CargarUsuarios;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

        sistema sistema = new sistema();

        sistema.deserializar(sistema);

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
                } catch (UsuarioException e) {
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
                    try {
                        sistema.nuevasesion(login);
                    } catch (EquipoException e) {
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        System.out.println("Codigo de la sesion:");
                        int cod= sc.nextInt();
                        sc.nextLine();
                        sistema.cerrarsesion(cod);
                    }catch(SesionException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("De que laboratorio desea el ranking:");
                    String lab = sc.nextLine();
                    sistema.rankingequipos(lab);
                    break;
                case 5:
                    sistema.rankingusuarios();
                    break;
                case 6:
                    sistema.listaadmins();
                    break;
                case 7:
                    try {
                        sistema.registrarequipo();
                    } catch (EquipoException e) {
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 8:
                    try{
                        sistema.registrarusuario();
                    }catch(UsuarioException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 9:
                        sistema.setEquipos(CargarEquipos.cargarEquiposDesdeArchivo("equipos.txt"));
                    break;
                case 10:
                        sistema.setUsuarios(CargarUsuarios.cargarUsuariosDesdeArchivo("usuarios.txt"));
                    break;
                case 11:
                    sistema.Serializar(sistema);
                    break;
                case 12:
                    sistema.deserializar(sistema);
                    break;
            }
        }while(opp!= 0);
    }
}
