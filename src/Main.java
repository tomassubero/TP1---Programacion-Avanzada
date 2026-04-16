import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Tarifario.setValorCamion(1500);
        Tarifario.setValorMoto(700);
        Tarifario.setValorHora(1000);

        int opcion;
        boolean sesion = true;

        Scanner scanner = new Scanner(System.in);

        //Bucle principal del Menú de estacionamiento: egresar vehículo, ingresar vehículo, consultar tarifas
        while(sesion)
        {
            do
            {
                Sistema.mostrarMenu();
                opcion = Integer.parseInt(scanner.nextLine());
            }
            while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);

            switch (opcion)
            {
                case 1:
                {
                    //Ingreso de vehiculo
                    Sistema.ingresarVehiculo();
                    break;
                }
                case 2:
                {
                    //TODO: egreso de vehículo
                    break;
                }

                case 3:
                {
                    //TODO: mostrar tarifario
                    System.out.printf(
                            "Precio de hora para auto: %.2f\nPrecio de hora para moto: %.2f\nPrecio de hora para camión: %.2f\n",
                            Tarifario.getValorHora(), Tarifario.getValorMoto(), Tarifario.getValorCamion());
                    break;
                }
                case 4:
                {
                    sesion = false;
                    System.out.println("\nAdios!");
                    break;
                }
            }
        }
    }

}

