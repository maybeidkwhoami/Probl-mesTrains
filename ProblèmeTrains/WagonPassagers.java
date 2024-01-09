public class WagonPassagers extends Wagon {

    private final static int NOMBRE_PASSAGERS_MAX = 50;
    private int nombrePassagers;
    private static int nombreWagonsPassagers = 0;

    // Constructors
    public WagonPassagers() {
        super();
        nombreWagonsPassagers++;
    }

    public WagonPassagers(String c, String d, int np) {
        super(c, d);
        this.nombrePassagers = np;
        nombreWagonsPassagers++;
    }

    // Getters
    public int getNombrePassagersMax() {
        return NOMBRE_PASSAGERS_MAX;
    }

    public int getNombrePassagers() {
        return nombrePassagers;
    }

    public static int getNombreWagonsPassagers() {
        return nombreWagonsPassagers;
    }

    // Setters
    public void setNombrePassagers(int nombrePassagers) {
        // You can add validation logic here if needed
        this.nombrePassagers = nombrePassagers;
    }

    @Override
    public String toString() {
        return super.toString() + " nombrePassagersMax=" + NOMBRE_PASSAGERS_MAX + " nombrePassagers=" + nombrePassagers + '}';
    }
}
