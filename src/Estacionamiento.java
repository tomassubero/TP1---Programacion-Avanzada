import java.util.ArrayList;

public class Estacionamiento
{
    private final int espacio_total = 100;
    private static int espacio_ocupado;
    private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    public static void ocuparEspacio(Vehiculo vehiculo)
    {
        if((espacio_ocupado += vehiculo.getEspacioQueOcupa()) > espacio_ocupado)
        {
            System.out.println("El estacionamiento está lleno, no es posible estacionar. ");
        }
        else
        {
            espacio_ocupado += vehiculo.getEspacioQueOcupa();
            listaVehiculos.add(vehiculo);
        }
    }

    public static void liberarEspacio(Vehiculo vehiculo)
    {
        espacio_ocupado -= vehiculo.getEspacioQueOcupa();
        listaVehiculos.remove(vehiculo);
    }

    public static boolean buscarPatente(String patente)
    {
        int longitud = listaVehiculos.toArray().length;
        for(int i = 0; i < longitud; i++)
        {
            if(listaVehiculos.get(i).equals(patente))
            {
                return true;
            }
        }
        return false;
    }
}
