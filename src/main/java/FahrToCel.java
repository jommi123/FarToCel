public class FahrToCel {
    public FahrToCel() {
    }

    public static double fahrToCel(double fahr) {
        return (fahr - 32) * 5 / 9;
    }

    public static double celToFahr(double cel) {
        return cel * 9 / 5 + 32;
    }

    public static double kelvinToCel(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahr(double kelvin) {
        return ((kelvin-273.15) * ((double)9/5) + 32);
    }

    public static void main(String[] args) {
        System.out.println("Fahrenheit to Celsius: " + fahrToCel(50));
        System.out.println("Celsius to Fahrenheit: " + celToFahr(10));
        System.out.println("Kelvin to Celsius: " + kelvinToCel(273.15));
        System.out.println("Kelvin to Fahrenheit: " + kelvinToFahr(65));
    }
}
