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
}
