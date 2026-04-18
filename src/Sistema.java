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

                System.out.println("\nIngrese el tipo de vehículo: \n1: Auto\n2: Moto\n3: Camión\n");
                tipo = Integer.parseInt(scanner.nextLine());

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

    public static void mostrarMenu()
    {
        System.out.println("\n---SISTEMA DE ESTACIONAMIENTO---");
        System.out.println("\n1. Ingresar vehiculo.\n2. egresar vehiculo.\n3. Consultar tarifas.\n4. Salir.\n");
    }
}
