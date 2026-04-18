public class Ticket
{
    private Vehiculo vehiculo;
    private double tarifaFinal;

    public Ticket(Vehiculo vehiculo)
    {
        this.vehiculo = vehiculo;
        this.setTarifaFinal();
    }

    public void setTarifaFinal()
    {
        this.tarifaFinal = vehiculo.getTarifaPorHora() * vehiculo.getEstadia().getDuracion();
    }

    public double getTarifaFinal()
    {
        return tarifaFinal;
    }

    public void imprimirTicket()
    {
        System.out.printf("\n---%s %s---\nPatente: %s\nHora de ingreso: %s\nHora de egreso: %s\nTarifa: %f\n",
                    vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getPatente(), vehiculo.getEstadia().getHoraIngreso(), vehiculo.getEstadia().getHoraEgreso(), this.getTarifaFinal());
    }
}
