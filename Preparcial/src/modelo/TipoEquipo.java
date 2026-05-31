package modelo;

import java.io.Serializable;

public enum TipoEquipo {

    COMPUTADORA(1), PROYECTOR(2), IMPRESORA(3);
    private int numero;
    TipoEquipo(int numero){
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static TipoEquipo crear(int numero){
        for(TipoEquipo tipo: TipoEquipo.values()){
            if(tipo.getNumero() == numero){
                return tipo;
            }
        }
        return null;
    }
}
