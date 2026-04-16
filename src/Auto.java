public class Auto extends Vehiculo
{
    public Auto(String patente, String modelo, String marca)
    {
        super(patente, modelo, marca);
        this.setTarifaPorHora(Tarifario.getValorHora());
        this.setEspacioQueOcupa(TamañoVehiculo.getTamañoAuto());
    }
}
