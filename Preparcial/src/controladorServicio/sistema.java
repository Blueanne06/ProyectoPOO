package controladorServicio;

import Excepciones.UsuarioInexistenteException;
import modelo.Administrador;
import modelo.EquipoLaboratorio;
import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class sistema {
    private List<EquipoLaboratorio> equipos;
    private List<Usuario> usuarios;

    public sistema(){
        equipos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public List<EquipoLaboratorio> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<EquipoLaboratorio> equipos) {
        this.equipos = equipos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean verificacion(int clave) throws UsuarioInexistenteException {
        for(Usuario u:usuarios){
            if(u.getClave() == clave) {
                if(u instanceof Administrador){
                    System.out.println("Accediendo al sistema como administrador");
                    return true;
                }
                else{
                    System.out.println(" Clave de usuario no corresponde a un administrador. Accediendo con funciones limitadas");
                    return false;
                }
            }
        }
        throw new UsuarioInexistenteException("No existe un usuario con la clave ingresada");
    }
}
