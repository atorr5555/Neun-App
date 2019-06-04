package para.neun.smarthome;

/**
 *  Clase que representa la casa inteligente y como atributos tiene a los elementos de la casa que se pueden controlar
 */
public class Home {
    private Boolean[] focos = new Boolean[8];
    private Boolean puertaPrincipal;
    private Boolean puertaPatio;
    private Boolean puertaCuarto;
    private float temperatura;
    private float humedad;

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
     * @return
     */
    public Boolean getPuertaPatio() {
        return puertaPatio;
    }

    /**
     *
     * @param puertaPatio
     */
    public void setPuertaPatio(Boolean puertaPatio) {
        this.puertaPatio = puertaPatio;
    }

    /**
     *
     * @return
     */
    public Boolean getPuertaCuarto() {
        return puertaCuarto;
    }

    /**
     *
     * @param puertaCuarto
     */
    public void setPuertaCuarto(Boolean puertaCuarto) {
        this.puertaCuarto = puertaCuarto;
    }

    /**
     *
     * @return
     */
    public float getTemperatura() {
        return temperatura;
    }

    /**
     *
     * @param temperatura
     */
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    /**
     *
     * @return
     */
    public float getHumedad() {
        return humedad;
    }

    /**
     *
     * @param humedad
     */
    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }
}
