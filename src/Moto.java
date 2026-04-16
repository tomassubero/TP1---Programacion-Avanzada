public class Moto extends Vehiculo
{
    public Moto(String patente, String modelo, String marca)
    {
        super(patente, modelo, marca);
        this.setTarifaPorHora(Tarifario.getValorMoto());
        this.setEspacioQueOcupa(TamañoVehiculo.getTamañoMoto());
    }
}

