package para.neun.smarthome;

/**
 *  Clase que representa la casa inteligente y como atributos tiene a los elementos de la casa que se pueden controlar
 */
public class Home implements java.io.Serializable{
    private Boolean[] focos = {false, false, false, false, false, false, false, false, false, false};
    private Boolean puertaPrincipal;
    private Boolean puertaPatio;
    private Boolean garage;
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
        garage = false;
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
     * @return Estado del garage
     */
    public Boolean getGarage() {
        return garage;
    }

    /**
     *
     * @param garage Nuevo estado del garage
     */
    public void setGarage(Boolean garage) {
        this.garage= garage;
    }

    /**
     *
     * @return Temperatura actual de la sala
     */
    public float getTemperaturaSala() {
        return temperaturaSala;
    }

    /**
     *
     * @param temperaturaSala Nueva temperatura de la sala
     */
    public void setTemperaturaSala(float temperaturaSala) {
        this.temperaturaSala = temperaturaSala;
    }

    /**
     *
     * @return Humedad de la sala
     */
    public float getHumedadSala() {
        return humedadSala;
    }

    /**
     *
     * @param humedadSala Nueva humedad de la sala
     */
    public void setHumedadSala(float humedadSala) {
        this.humedadSala = humedadSala;
    }

    /**
     *
     * @return Temperatura del cuarto
     */
    public float getTemperaturaCuarto() {
        return temperaturaCuarto;
    }

    /**
     *
     * @param temperaturaCuarto Nueva temperatura del cuarto
     */
    public void setTemperaturaCuarto(float temperaturaCuarto) {
        this.temperaturaCuarto = temperaturaCuarto;
    }

    /**
     *
     * @return Humedad del cuarto
     */
    public float getHumedadCuarto() {
        return humedadCuarto;
    }

    /**
     *
     * @param humedadCuarto Nueva humedad del cuarto
     */
    public void setHumedadCuarto(float humedadCuarto) {
        this.humedadCuarto = humedadCuarto;
    }

    /**
     *
     * @return Estado de la alerta de fuego
     */
    public Boolean getFuego() {
        return fuego;
    }

    /**
     *
     * @param fuego Nuevo estado de la alerta de fuego
     */
    public void setFuego(Boolean fuego) {
        this.fuego = fuego;
    }

    /**
     *
     * @return Estado de la alerta de gas
     */
    public Boolean getGas() {
        return gas;
    }

    /**
     *
     * @param gas Nuevo estado de la alerta de gas
     */
    public void setGas(Boolean gas) {
        this.gas = gas;
    }

    /**
     *
     * @return Estado de la ventana
     */
    public Boolean getVentana() {
        return ventana;
    }

    /**
     *
     * @param ventana Nuevo estado de la ventana
     */
    public void setVentana(Boolean ventana) {
        this.ventana = ventana;
    }
}
