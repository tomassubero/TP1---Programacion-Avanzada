import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Sistema.setTarifas();
        int opcion;
        boolean sesion = true;

        Scanner scanner = new Scanner(System.in);

        while(sesion)
        {
            do
            {
                Sistema.mostrarMenu();
                try
                {
                    opcion = Integer.parseInt(scanner.nextLine());
                }
                catch(Exception e)
                {
                    System.out.printf("Ingrese un número dentro de los listados en el menú. (Error %s. )", e.getMessage());
                    opcion = 0;
                }

            }
            while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6);

            switch (opcion)
            {
                case 1:
                {
                    Sistema.ingresarVehiculo(scanner);
                    System.out.println("\nVehículo ingresado correctamente. ");
                    break;
                }
                case 2:
                {
                    Sistema.egresarVehiculo(scanner);
                    break;
                }
                case 3:
                {
                    System.out.printf(
                            "\nPrecio de hora para auto: %.2f\nPrecio de hora para moto: %.2f\nPrecio de hora para camión: %.2f\n",
                            Tarifario.getValorHora(), Tarifario.getValorMoto(), Tarifario.getValorCamion());
                    break;
                }

                case 4:
                {
                    Sistema.consultarEstado();
                    break;
                }

                case 5:
                {
                    Sistema.mostrarVehiculos();
                    break;
                }
                case 6:
                {
                    sesion = false;
                    System.out.println("\nAdios!");
                    break;
                }
            }
        }
    }
}

