package modelo;

import java.io.Serializable;

public enum Rol {
    ESTUDIANTE(1), MONITOR(2), ADMINISTRADOR(3);
    private int numero;
    Rol(int numero){
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static Rol crear(int numero){
        for(Rol tipo: Rol.values()){
            if(tipo.getNumero() == numero){
                return tipo;
            }
        }
        return null;
    }
}
