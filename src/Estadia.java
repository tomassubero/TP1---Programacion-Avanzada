import java.time.LocalTime;

public class Estadia
{
    private LocalTime horaIngreso;
    private LocalTime horaEgreso;
    private int duracion;;

    public Estadia(LocalTime horaIngreso)
    {
        this.horaIngreso = horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public void setHoraEgreso(LocalTime horaEgreso) {
        this.horaEgreso = horaEgreso;
    }

    public void setDuracion(int duracion)
    {
        this.duracion = duracion;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public LocalTime getHoraEgreso() {
        return horaEgreso;
    }

    public int getDuracion() {
        return duracion;
    }

    public void calcularDuracion()
    {
        // Lo mínimo que cobra es 1 hora, por más que hayas estado 1 minuto en el estacionamiento
        // Si pasó más de una hora, se evalúan los minutos. Si son más de 30, se cobra como 1 hora
        // caso contrario, no se tienen en cuenta.
        int hora = horaEgreso.minusHours(horaIngreso.getHour()).getHour();
        int minuto = horaEgreso.getMinute() - horaIngreso.getMinute();
        if(minuto > 30 || (hora == 0 && minuto < 30))
        {
            hora += 1;
        }
        this.setDuracion(hora);
    }
}


