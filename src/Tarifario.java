public class Tarifario
{
    private static double valorAuto;
    private static double valorCamion;
    private static double valorMoto;

    private Tarifario()
    {
    }

    public static double getValorHora() {
        return valorAuto;
    }

    public static double getValorCamion() {
        return valorCamion;
    }

    public static double getValorMoto() {
        return valorMoto;
    }

    public static void setValorHora(double valorHora) {
        Tarifario.valorAuto = valorHora;
    }

    public static void setValorCamion(double valorCamion) {
        Tarifario.valorCamion = valorCamion;
    }

    public static void setValorMoto(double valorMoto) {
        Tarifario.valorMoto = valorMoto;
    }
}
