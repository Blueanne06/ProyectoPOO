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

}