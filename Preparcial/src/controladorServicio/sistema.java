package controladorServicio;

import Excepciones.EquipoException;
import Excepciones.SesionException;
import Excepciones.UsuarioException;
import modelo.*;


import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.time.*;
import java.util.*;

public class sistema implements Serializable{
    private List<EquipoLaboratorio> equipos;
    private List<Usuario> usuarios;
    private List<Sesion> sesiones;

    public sistema(){
        equipos = new ArrayList<>();
        usuarios = new ArrayList<>();
        sesiones = new ArrayList<>();
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

    transient Scanner sc = new Scanner(System.in);

    public EquipoLaboratorio buscarEquipo(String cod){
        for( EquipoLaboratorio e: equipos){
            if(cod.equals(e.getCodigo())){
                return e;
            }
        }
        return null;
    }

    public Usuario verificacion(int clave,String  cod ) throws UsuarioException {
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
        throw new UsuarioException("No existe un usuario con este Codigo");
    }

    public void mostrarequipos(){
        for(EquipoLaboratorio e:equipos){
            System.out.println("Equipo: "+e.getNombreEquipo()+"("+e.getCodigo()+")\nLaboratorio: "+e.getLaboratorio()+
                    "\nEstado:"+e.getEstado());
        }
    }

    public void nuevasesion(Usuario u) throws EquipoException {

        System.out.println("Codigo del equipo que desea solicitar:");
        String cod = sc.nextLine();
        EquipoLaboratorio e = buscarEquipo(cod);
        if(e==null){
            throw new EquipoException("El equipo buscado no existe");
        }
        if(e.getEstado() != Estado.DISPONIBLE){
            throw new EquipoException("El equipo buscado no esta disponible");
        }
        for(EquipoLaboratorio eq: equipos){
            if(eq.equals(e)){
                eq.setEstado(Estado.OCUPADO);
                eq.setContador(eq.getContador()+1);
            }
        }
        System.out.println("Tiempo limite de la sesion:");
        int h = sc.nextInt();
        sc.nextLine();
        Sesion s = new Sesion(e,u,h);
        System.out.println("Sesion creada exitosamente");
        System.out.println("Codigo de sesion asignado:"+s.getCodigo());
        sesiones.add(s);
    }

    public void cerrarsesion(int cod) throws SesionException {
        for(Sesion s:sesiones){
            if(cod == s.getCodigo()){
                for(EquipoLaboratorio e: equipos){
                    if(e.equals(s.getEquipo())){
                        e.setEstado(Estado.DISPONIBLE);
                    }
                }
                s.setFechaHoraFinalizacion(LocalDateTime.now());
                Duration duracion = Duration.between(s.getFechaHoraInicio(), s.getFechaHoraFinalizacion());
                float horas = (float) duracion.toHours();
                s.setHorasuso(horas);
                if(horas>s.getTiempoLimite()){
                    float p = (s.getEquipo().getValor()*0.01f)*(horas-s.getTiempoLimite());
                    s.setPenalizacion(p);
                    for(Usuario u:usuarios){
                        if(u.equals(s.getUsuario())){
                            u.setBadboy(u.getBadboy()+1);
                        }
                    }
                }
                else{
                    System.out.println("No se excedio el tiempo limite establecido");
                }
                return;
            }
        }
        throw new SesionException("La sesion buscada no existe");
    }

    public void rankingequipos(String lab){
        List<Map.Entry<Integer, Float>> ranking = new ArrayList<>();
        for(int i=0;i<equipos.size();i++){
            float sum=0f;
            for(Sesion s: sesiones){
                if(s.getEquipo().equals(equipos.get(i))){
                    if(s.getEquipo().getLaboratorio().equals(lab)) {
                        sum += s.getHorasuso();
                    }
                }
            }
            ranking.add(new AbstractMap.SimpleEntry<>(i, sum));
        }
        ranking.sort(Map.Entry.<Integer, Float>comparingByValue().reversed());
        for(int j=0;j<3;j++){
            int e = ranking.get(j).getKey();
            System.out.println("("+j+1+") Equipo: "+ equipos.get(e).getNombreEquipo()+"("+equipos.get(e).getCodigo()+") con "+ranking.get(j).getValue()+" horas de uso.");
        }
    }

    public void rankingusuarios(){
        usuarios.sort(Comparator.comparingInt(Usuario::getBadboy).reversed());
        for(int j=0;j<3;j++) {
            System.out.println("("+j+1+") Usuario: "+usuarios.get(j).getNombre()+"("+usuarios.get(j).getCodigo()+") con indice de sesiones sobrepasadas de:"+usuarios.get(j).getBadboy());
        }
    }

    public void listaadmins(){
        System.out.println("===ADMINISTRADORES===");
        for(Usuario u: usuarios){
            if( u instanceof Administrador){
                System.out.println(u.getNombre()+"("+u.getCodigo()+")");
            }
        }
    }

    public void registrarequipo() throws EquipoException{
        System.out.println("Codigo del equipo:(formato: C000)");
        String cod = sc.nextLine();
        cod.toUpperCase();
        EquipoLaboratorio e=buscarEquipo(cod);
        if(e!= null){
            throw new EquipoException("Equipo existente");
        }
        System.out.println("Nombre del equipo:");
        String nom = sc.nextLine();
        System.out.println("Tipo de equipo:(1) COMPUTADORA, (2) PROYECTOR, (3) IMPRESORA");
        int te = sc.nextInt();
        TipoEquipo tipo= TipoEquipo.crear(te);
        System.out.println("Estado:(1) DISPONIBLE, (2) OCUPADO, (3) MANTENIMIENTO");
        int es = sc.nextInt();
        sc.nextLine();
        Estado MIGUELANGELLOMAMAMIA= Estado.crear(es);
        System.out.println("Laboratorio: ");
        String lab = sc.nextLine();
        System.out.println("Costo del equipo: ");
        float c = sc.nextFloat();
        sc.nextLine();
        e = new EquipoLaboratorio(cod, nom,tipo,MIGUELANGELLOMAMAMIA,lab,c);
       equipos.add(e);
        System.out.println("El equipo se ha registrado exitosamente");
    }

    public void registrarusuario() throws UsuarioException{
        System.out.println("Ingrese el codigo: ");
        String cod = sc.nextLine();
        Usuario u=null;
        for( Usuario us: usuarios) {
            if (cod.equals(us.getCodigo())) {
                u = us;
            }
        }
        if(u != null){
            throw new UsuarioException("Usuario existente");
        }
        System.out.println("Ingrese el nombre: ");
        String nom = sc.nextLine();
        System.out.println("Clave:");
        int cl= sc.nextInt();
        sc.nextLine();
        System.out.println("Rol del usuario:(1) ESTUDIANTE, (2) MONNITOR, (3) ADMINISTRADOR");
        int r = sc.nextInt();
        Rol rol= Rol.crear(r);
        switch (rol) {

            case ESTUDIANTE:
                u  = new Estudiante(nom, rol, cod, cl);
                break;

            case MONITOR:
                u = new Monitor(nom, rol, cod, cl);
                break;

            case ADMINISTRADOR:
                u = new Administrador(nom, rol, cod, cl);
                break;
        }
        usuarios.add(u);
    }

    public void Serializar(sistema sis){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sistema.dat"))) {
            out.writeObject(sis);
            System.out.println("Sistema guardado exitosamente");
        }catch(IOException e){
            System.out.println("Error al serializar"+e.getMessage());
        }
    }

    public void deserializar(sistema sis){
        try(ObjectInputStream in= new ObjectInputStream(new FileInputStream("sistema.dat"))) {
            sis = (sistema) in.readObject();
        }catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
