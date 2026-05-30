package persistence;

import modelo.EquipoLaboratorio;
import modelo.Estado;
import modelo.TipoEquipo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;//import java.util.ArrayList y compañia.

public class CargarEquipos {

    public static List<EquipoLaboratorio> cargarEquiposDesdeArchivo(String ruta){
        List<EquipoLaboratorio> equipos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] datos = linea.split(",");

                String codigo = datos[0];
                String nombreEquipo = datos[1];
                TipoEquipo tipoEquipo = TipoEquipo.valueOf(datos[2]);
                Estado estado = Estado.valueOf(datos[3]);
                String laboratorio = datos[4];
                float valor = Float.parseFloat(datos[5]);
                int contador = Integer.parseInt(datos[6]);

                EquipoLaboratorio equipo = new EquipoLaboratorio(codigo, nombreEquipo, tipoEquipo, estado, laboratorio,valor,contador);
                equipos.add(equipo);

            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo: "+ e.getMessage());
        }
        return equipos;
    }

}
