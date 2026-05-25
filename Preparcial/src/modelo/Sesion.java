package modelo;

import java.time.LocalDateTime;

public class Sesion {
    private String codigo;
    private EquipoLaboratorio equipo;
    private Usuario usuario;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinalizacion;
    private LocalDateTime tiempoLimite;
    private float penalizacion;

    public Sesion(String codigo, EquipoLaboratorio equipo, Usuario usuario,
            LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinalizacion,
            LocalDateTime tiempoLimite, float penalizacion) {
        this.codigo = codigo;
        this.equipo = equipo;
        this.usuario = usuario;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.tiempoLimite = tiempoLimite;
        this.penalizacion = penalizacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public LocalDateTime getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(LocalDateTime tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public float getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(float penalizacion) {
        this.penalizacion = penalizacion;
    }

}