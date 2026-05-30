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

    public Usuario verificacion(int clave,String  cod ) throws UsuarioInexistenteException {
        for(Usuario u:usuarios){
            if(u.getCodigo().equals(cod)) {
                if (u.getClave() == clave) {
                    if (u instanceof Administrador) {
                        System.out.println("Accediendo al sistema como administrador");
                        return u;
                    } else {
                        System.out.println("Bienvenido estudiante/monitor.Accediendo con funciones limitadas");
                        return u;
                    }
                }
            }
        }
        throw new UsuarioInexistenteException("No existe un usuario con este Codigo");
    }

    public void mostrarequipos(){
        for(EquipoLaboratorio e:equipos){
            System.out.println("Equipo: "+e.getNombreEquipo()+"("+e.getCodigo()+")\nLaboratorio: "+e.getLaboratorio()+
                    "\nEstado:"+e.getEstado());
        }
    }


}
