package modelo;

public class Administrador extends Usuario {

    public Administrador(String nombre, Rol rol, String codigo, int clave) {
        super(nombre, rol, codigo, clave);
    }

    @Override
    public void mostrarmenu(){
        super.mostrarmenu();
        System.out.println("(7) Registrar un equipo de laboratorio");//administrador
        System.out.println("(8) Registrar un usuario");//admin
        System.out.println("(9) Cargar equipos desde archivo de texto");//admin
        System.out.println("(10) Cargar usuarios desde archivo de texto");//admin
        System.out.println("(11) Guardar el estado completo del sistema");//admin
        System.out.println("(12) Recuperar el estado del sistema desde archivo binario");
    }
}
