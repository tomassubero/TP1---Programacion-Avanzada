public class Tarifario
{
    //Estoy haciendo básicamente una clase estática, no quiero instanciar un tarifario
    // y quiero que todos los vehículos puedan acceder a consultar las tarifas.
    private static double valorHora;
    private static double valorCamion;
    private static double valorMoto;

    private Tarifario()
    {
    }

    public static double getValorHora() {
        return valorHora;
    }

    public static double getValorCamion() {
        return valorCamion;
    }

    public static double getValorMoto() {
        return valorMoto;
    }

    public static void setValorHora(double valorHora) {
        Tarifario.valorHora = valorHora;
    }

    public static void setValorCamion(double valorCamion) {
        Tarifario.valorCamion = valorCamion;
    }

    public static void setValorMoto(double valorMoto) {
        Tarifario.valorMoto = valorMoto;
    }
}
