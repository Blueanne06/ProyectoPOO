package modelo;

import java.io.Serializable;

public enum Estado {
    DISPONIBLE(1), OCUPADO(2), MANTENIMIENTO(3);
    private int numero;
    Estado(int numero){
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static Estado crear(int numero){
        for(Estado tipo: Estado.values()){
            if(tipo.getNumero() == numero){
                return tipo;
            }
        }
        return null;
    }
}
