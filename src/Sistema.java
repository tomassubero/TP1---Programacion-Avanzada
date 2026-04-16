import java.util.Scanner;

public class Sistema
{
    private static String patente;
    private static String marca;
    private static String modelo;
    private static int tipo;
    private static boolean patenteRegistrada;

    public static Scanner scanner = new Scanner(System.in);

    public static void ingresarVehiculo()
    {
        do
        {
            System.out.println("\nIngrese la patente del vehiculo: ");
            patente = scanner.nextLine();
            patenteRegistrada = Estacionamiento.buscarPatente(patente);

            if(patenteRegistrada)
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
                tipo = Integer.parseInt(scanner.next());

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
        while(patenteRegistrada);
    }

    public static void mostrarMenu()
    {
        System.out.println("---SISTEMA DE ESTACIONAMIENTO---");
        System.out.println("\n1. Ingresar vehiculo.\n2. egresar vehiculo.\n3. Consultar tarifas.\n4. Salir.");
    }
}
