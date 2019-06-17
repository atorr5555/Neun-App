package para.neun.smarthome;

/**
 *  Clase que representa la casa inteligente y como atributos tiene a los elementos de la casa que se pueden controlar
 */
public class Home implements java.io.Serializable{
    private Boolean[] focos = {false, false, false, false, false, false, false, false};
    private Boolean puertaPrincipal;
    private Boolean puertaPatio;
    private Boolean puertaCuarto;
    private float temperaturaSala;
    private float humedadSala;
    private float temperaturaCuarto;
    private float humedadCuarto;
    private Boolean fuego;
    private Boolean gas;
    private Boolean ventana;

    public Home() {
        puertaPrincipal = false;
        puertaPatio = false;
        puertaCuarto = false;
        fuego = false;
        ventana = false;
        gas = false;
    }

    /**
     *
     * @return Arreglo con el estado(encendido/apagado) de todos los focos de la casa
     */
    public Boolean[] getFocos() {
        return focos;
    }

    /**
     *
     * @param focos Arreglo con el estado(encendido/apagado) de todos los focos de la casa
     */
    public void setFocos(Boolean[] focos) {
        this.focos = focos;
    }

    /**
     *
     * @param n Número de foco del que se desea conocer el estado
     * @return Estado del foco seleccionado
     */
    public Boolean getFoco(int n) {
        return focos[n-1];
    }

    /**
     *
     * @param estado Nuevo estado del foco seleccionado
     * @param n Número de foco del que se desea cambiar el estado
     */
    public void setFoco(Boolean estado, int n) {
        focos[n-1] = estado;
    }

    /**
     *
     * @return Estado de la puerta principal (abierta/cerrada)
     */
    public Boolean getPuertaPrincipal() {
        return puertaPrincipal;
    }

    /**
     *
     * @param puertaPrincipal Nuevo estado de la puerta principal
     */
    public void setPuertaPrincipal(Boolean puertaPrincipal) {
        this.puertaPrincipal = puertaPrincipal;
    }

    /**
     *
     * @return Estado de la puerta del patio
     */
    public Boolean getPuertaPatio() {
        return puertaPatio;
    }

    /**
     *
     * @param puertaPatio Nuevo estado de la puerta del patio
     */
    public void setPuertaPatio(Boolean puertaPatio) {
        this.puertaPatio = puertaPatio;
    }

    /**
     *
     * @return Estado de la puerta del cuarto
     */
    public Boolean getPuertaCuarto() {
        return puertaCuarto;
    }

    /**
     *
     * @param puertaCuarto Nuevo estado de la puerta del cuarto
     */
    public void setPuertaCuarto(Boolean puertaCuarto) {
        this.puertaCuarto = puertaCuarto;
    }

    public float getTemperaturaSala() {
        return temperaturaSala;
    }

    public void setTemperaturaSala(float temperaturaSala) {
        this.temperaturaSala = temperaturaSala;
    }
    public float getHumedadSala() {
        return humedadSala;
    }

    public void setHumedadSala(float humedadSala) {
        this.humedadSala = humedadSala;
    }

    public float getTemperaturaCuarto() {
        return temperaturaCuarto;
    }

    public void setTemperaturaCuarto(float temperaturaCuarto) {
        this.temperaturaCuarto = temperaturaCuarto;
    }

    public float getHumedadCuarto() {
        return humedadCuarto;
    }

    public void setHumedadCuarto(float humedadCuarto) {
        this.humedadCuarto = humedadCuarto;
    }

    public Boolean getFuego() {
        return fuego;
    }

    public void setFuego(Boolean fuego) {
        this.fuego = fuego;
    }

    public Boolean getGas() {
        return gas;
    }

    public void setGas(Boolean gas) {
        this.gas = gas;
    }

    public Boolean getVentana() {
        return ventana;
    }

    public void setVentana(Boolean ventana) {
        this.ventana = ventana;
    }
}
