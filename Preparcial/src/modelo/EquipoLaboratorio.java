package modelo;

public class EquipoLaboratorio {

    private String codigo;
    private String nombreEquipo;
    private TipoEquipo tipoEquipo;
    private Estado estado;
    private String laboratorio;
    private float valor;
    private int contador;

    public EquipoLaboratorio(String codigo, String nombreEquipo, TipoEquipo tipoEquipo, Estado estado,
            String laboratorio, float valor, int contador) {
        this.codigo = codigo;
        this.nombreEquipo = nombreEquipo;
        this.tipoEquipo = tipoEquipo;
        this.estado = estado;
        this.laboratorio = laboratorio;
        this.valor = valor;
        this.contador = contador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
