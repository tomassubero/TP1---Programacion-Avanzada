public class Camion extends Vehiculo
{
    public Camion(String patente, String modelo, String marca)
    {
        super(patente, modelo, marca);
        this.setTarifaPorHora(Tarifario.getValorCamion());
        this.setEspacioQueOcupa(TamañoVehiculo.getTamañoCamion());

    }
}
