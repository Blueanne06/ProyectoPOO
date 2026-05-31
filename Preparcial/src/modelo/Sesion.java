package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Sesion implements Serializable {
    private int codigo;
    private EquipoLaboratorio equipo;
    private Usuario usuario;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinalizacion;
    private float tiempoLimite;
    private float horasuso;
    private float penalizacion;
    private static int cont=0;

    public Sesion(EquipoLaboratorio equipo, Usuario usuario,
            float tiempoLimite) {
        cont++;
        this.codigo = cont;
        this.equipo = equipo;
        this.usuario = usuario;
        this.fechaHoraInicio = LocalDateTime.now();
        this.fechaHoraFinalizacion = null;
        this.tiempoLimite = tiempoLimite;
        this.horasuso=0;
        this.penalizacion = 0;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setHorasuso(float horasuso) {
        this.horasuso = horasuso;
    }

    public static void setCont(int cont) {
        Sesion.cont = cont;
    }

    public float getHorasuso() {
        return horasuso;
    }

    public static int getCont() {
        return cont;
    }

    public int getCodigo() {
        return codigo;
    }

    public EquipoLaboratorio getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoLaboratorio equipo) {
        this.equipo = equipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(LocalDateTime fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public float getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(float tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public float getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(float penalizacion) {
        this.penalizacion = penalizacion;
    }

}