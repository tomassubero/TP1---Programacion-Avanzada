import java.time.LocalTime;
import java.util.ArrayList;

public class Estacionamiento
{
    private static final int espacio_total = 100;
    private static int espacio_ocupado;
    private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private static ArrayList<Ticket> listaTickets = new ArrayList<>();

    public static void ocuparEspacio(Vehiculo vehiculo)
    {
        if((espacio_ocupado + vehiculo.getEspacioQueOcupa()) > espacio_total)
        {
            System.out.println("El estacionamiento está lleno, no es posible estacionar. ");
        }
        else
        {
            espacio_ocupado += vehiculo.getEspacioQueOcupa();
            listaVehiculos.add(vehiculo);
            crearEstadia(vehiculo);
        }
    }

    public static void liberarEspacio(Vehiculo vehiculo)
    {
        espacio_ocupado -= vehiculo.getEspacioQueOcupa();
        vehiculo.getEstadia().setHoraEgreso(LocalTime.now());
        vehiculo.getEstadia().calcularDuracion();

        Ticket ticket = new Ticket(vehiculo);
        listaTickets.add(ticket);

        System.out.println("\nVehículo retirado del estacionamiento. Imprimiendo ticket...\n");
        ticket.mostrarDatos();
        listaVehiculos.remove(vehiculo);

    }

    public static void crearEstadia(Vehiculo vehiculo)
    {
        LocalTime horaIngreso = LocalTime.now();
        Estadia estadia = new Estadia(horaIngreso);
        vehiculo.setEstadia(estadia);
    }

    public static int buscarPatente(String patente)
    {
        int longitud = listaVehiculos.toArray().length;
        int i;
        for(i = 0; i < longitud; i++)
        {
            if(listaVehiculos.get(i).getPatente().equals(patente))
            {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Vehiculo> getListaVehiculos()
    {
        return listaVehiculos;
    }

    public static int getEspacio_total()
    {
        return espacio_total;
    }

    public static int getEspacio_ocupado()
    {
        return espacio_ocupado;
    }

    public static int getEspacio_disponible()
    {
        return espacio_total - espacio_ocupado;
    }

    public static ArrayList<Integer> cantidadPorTipoVehiculo()
    {
        int cantidad_auto = 0, cantidad_moto = 0, cantidad_camion = 0;
        int total_vehiculos = listaVehiculos.size();

        ArrayList<Integer> lista_cantidad_por_tipo = new ArrayList<>();

        for(int i = 0; i < total_vehiculos; i++)
        {
            if(listaVehiculos.get(i).getClass().getName().equals("Auto"))
            {
                cantidad_auto += 1;
            }
            else if (listaVehiculos.get(i).getClass().getName().equals("Moto"))
            {
                cantidad_moto += 1;
            }
            else
            {
                cantidad_camion += 1;
            }
        }
        lista_cantidad_por_tipo.add(cantidad_auto);
        lista_cantidad_por_tipo.add(cantidad_moto);
        lista_cantidad_por_tipo.add(cantidad_camion);

        return lista_cantidad_por_tipo;
    }

}
