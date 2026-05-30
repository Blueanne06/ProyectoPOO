package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Administrador;
import modelo.Estudiante;
import modelo.Monitor;
import modelo.Rol;
import modelo.Usuario;

public class CargarUsuarios {

    public static List<Usuario> cargarUsuariosDesdeArchivo(String ruta) {

        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length != 4) {
                    System.out.println("Línea inválida: " + linea);
                    continue;
                }

                String nombre = datos[0].trim();
                Rol rol = Rol.valueOf(datos[1].trim());
                String codigo = datos[2].trim();
                int clave = Integer.parseInt(datos[3].trim());

                Usuario usuario;

                switch (rol) {

                    case ESTUDIANTE:
                        usuario = new Estudiante(nombre, rol, codigo, clave);
                        break;

                    case MONITOR:
                        usuario = new Monitor(nombre, rol, codigo, clave);
                        break;

                    case ADMINISTRADOR:
                        usuario = new Administrador(nombre, rol, codigo, clave);
                        break;

                    default:
                        continue;
                }

                usuarios.add(usuario);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Rol inválido en el archivo: " + e.getMessage());
        }

        return usuarios;
    }
}
