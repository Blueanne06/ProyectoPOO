package persistence;

import modelo.EquipoLaboratorio;
import modelo.Estado;
import modelo.TipoEquipo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;//import java.util.ArrayList y compañia.

public class CargarEquipos {

    public static List<EquipoLaboratotio> cargarEquiposDesdeArchivo(string ruta){
        List<EquipoLaboratorio> equipos = new ArratList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] datos = linea.split(",");


                

            }
        }
    }

}
