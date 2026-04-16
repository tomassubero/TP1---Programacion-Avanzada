public class Vehiculo
{
    private String patente;
    private String modelo;
    private String marca;
    private int espacioQueOcupa;
    private double tarifaPorHora;

    public Vehiculo(String patente, String modelo, String marca)
    {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
    }

    public void setTarifaPorHora(double tarifa)
    {
        this.tarifaPorHora = tarifa;
    }

    public double getTarifaPorHora()
    {
        return tarifaPorHora;
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setEspacioQueOcupa(int espacioQueOcupa)
    {
        this.espacioQueOcupa = espacioQueOcupa;
    }

    public int getEspacioQueOcupa()
    {
        return espacioQueOcupa;
    }
}
