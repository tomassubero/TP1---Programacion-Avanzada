import java.util.ArrayList;
import java.util.Scanner;

public class Sistema
{
    private static String patente;
    private static String marca;
    private static String modelo;
    private static int tipo;
    private static int patenteRegistrada;

    public static void ingresarVehiculo(Scanner scanner)
    {
        do
        {
            System.out.println("\nIngrese la patente del vehiculo: ");
            patente = scanner.nextLine();
            patenteRegistrada = Estacionamiento.buscarPatente(patente);

            if(patenteRegistrada >= 0)
            {
                System.out.printf("\nLa patente: %s ya está registrada en sistema. Intente con una distinta. ", patente);
            }
            else
            {
                System.out.println("\nIngrese la marca del vehículo: ");
                marca = scanner.nextLine();

                System.out.println("\nIngrese el modelo: ");
                modelo = scanner.nextLine();
                do
                {
                    try
                    {
                        System.out.println("\nIngrese el tipo de vehículo: \n1: Auto\n2: Moto\n3: Camión\n");
                        tipo = Integer.parseInt(scanner.nextLine());
                        ValidarTipoVehiculo(tipo);
                    }
                    catch (NumberFormatException e)
                    {
                        System.err.println("Error: Debes ingresar un número válido (1, 2 o 3).");
                        tipo = 0;
                    }
                    catch (TipoInvalidoException e)
                    {
                        System.err.printf("Error: %s", e.getMessage());
                    }
                }
                while(tipo != 1 && tipo !=2 && tipo != 3);


                switch (tipo)
                {
                    case 1:
                    {
                        Vehiculo vehiculo = new Auto(patente, marca, modelo);
                        Estacionamiento.ocuparEspacio(vehiculo);
                        break;
                    }
                    case 2:
                    {
                        Vehiculo vehiculo = new Moto(patente, marca, modelo);
                        Estacionamiento.ocuparEspacio(vehiculo);
                        break;
                    }
                    case 3:
                    {
                        Vehiculo vehiculo = new Camion(patente, marca, modelo);
                        Estacionamiento.ocuparEspacio(vehiculo);
                        break;
                    }
                }
            }
        }
        while(patenteRegistrada >= 0);
    }

    public static void egresarVehiculo(Scanner scanner)
    {
        if(Estacionamiento.getListaVehiculos().isEmpty())
        {
            System.out.println("\nEl estacionamiento está vacío. Estacioná donde quieras pa.\n");
        }
        else
        {
            try
            {
                System.out.println("\nIngrese la patente del auto a retirar: \n");
                patente = scanner.nextLine();
                int indicePatente = Estacionamiento.buscarPatente(patente);

                if( indicePatente >= 0)
                {
                    Estacionamiento.liberarEspacio(Estacionamiento.getListaVehiculos().get(indicePatente));
                }
                else
                {
                    System.out.printf("El vehículo de patente %s no se encuentra en el estacionamiento. ", patente);
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void mostrarMenu()
    {
        System.out.println("\n---SISTEMA DE ESTACIONAMIENTO---");
        System.out.println("\n1. Ingresar vehiculo." + "\n2. egresar vehiculo.\n3. Consultar tarifas.\n" +
                           "4. Consultar espacio disponible\n5. Ver vehículos\n6. Salir.\n");
    }

    public static void consultarEspacios()
    {
        System.out.println("\n---STATUS DEL ESTACIONAMIENTO---");

        System.out.printf("- Capacidad máxima: %d\n- Espacio disponible: %d\n- Espacio ocupado: %d\n", Estacionamiento.getEspacio_total(), Estacionamiento.getEspacio_disponible(), Estacionamiento.getEspacio_ocupado());
    }

    public static void mostrarVehiculos()
    {
        ArrayList<Vehiculo> listaVehiculos = Estacionamiento.getListaVehiculos();
        int cantidad = listaVehiculos.size();

        System.out.println("---LISTA DE VEHICULOS INGRESADOS---");
        for(int i = 0; i < cantidad; i++)
        {
            System.out.printf("---VEHICULO N°: %d---\n", i+1);
            listaVehiculos.get(i).mostrarDatos();
            System.out.printf(" | Plaza n°: %d\n", i+1);
        }
    }

    public static void ValidarTipoVehiculo(int tipo) throws TipoInvalidoException
    {
        if (tipo != 1 && tipo != 2 && tipo != 3)
        {
            throw new TipoInvalidoException("Debes elegir una de las opciones en pantalla (1, 2 o 3).");
        }
    }
}

