package modelo;

public abstract class Usuario {

    protected String nombre;
    protected Rol rol; // numeraciones: 1. Estudiante, 2. Docente, 3. Personal de apoyo
    protected String codigo;
    protected int clave;

    protected Usuario(String nombre, Rol rol, String codigo, int clave) {

        this.nombre = nombre;
        this.rol = rol;
        this.codigo = codigo;
        this.clave = clave;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void mostrarmenu(){
        System.out.println("(0) Salir");
        System.out.println("(1) Mostrar inventario de equipos por laboratorio y estado");
        System.out.println("(2) Programar una sesion de uso de un equipo");
        System.out.println("(3) Cerrar una sesion de uso y calcular penalizacion");
        System.out.println("(4) Mostrar los equipos con mayor uso por laboratorio");
        System.out.println("(5) Mostrar usuarios con mayor indice de uso indebido");
        System.out.println("(6) Gestion de administradores");//crear/listar
    }
}