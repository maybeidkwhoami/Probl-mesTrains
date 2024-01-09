public class WagonMarchandise extends Wagon {

    private final static float VOLUME_MAX = 72;
    private float volume;
    private static int nombreWagonMarchandise = 0;

    public WagonMarchandise() {
        super();
        nombreWagonMarchandise++;
    }

    public WagonMarchandise(String c, String d, float v) {
        super(c, d);
        this.volume = v;
        nombreWagonMarchandise++;
    }

    public float getVolumeMax() {
        return VOLUME_MAX;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        // You can add validation logic here if needed
        this.volume = volume;
    }

    public int getNombreWagonMarchandise() {
        return nombreWagonMarchandise;
    }

    @Override
    public String toString() {
        return super.toString() + " volumeMax=" + VOLUME_MAX + " volume=" + volume + '}';
    }
}