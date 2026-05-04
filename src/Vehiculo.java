public class Vehiculo implements Mostrable
{
    private String patente;
    private String modelo;
    private String marca;
    private int espacioQueOcupa;
    private double tarifaPorHora;
    private Estadia estadia;

    public Vehiculo(String patente, String marca, String modelo)
    {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
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

    public void setEstadia(Estadia estadia)
    {
        this.estadia = estadia;
    }

    public Estadia getEstadia()
    {
        return estadia;
    }

    public void mostrarDatos()
    {
        System.out.printf("\nMarca: %s | Modelo: %s | Patente: %s", this.marca, this.modelo, this.patente);
    }

}
