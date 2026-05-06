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
        int hora = horaEgreso.minusHours(horaIngreso.getHour()).getHour();
        int minuto = horaEgreso.getMinute() - horaIngreso.getMinute();
        if(minuto > 30 || (hora == 0 && minuto < 30))
        {
            hora += 1;
        }
        this.setDuracion(hora);
    }
}


