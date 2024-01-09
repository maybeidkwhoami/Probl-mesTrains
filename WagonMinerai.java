public class WagonMinerai extends Wagon{


    private final static float tonnageMax=22;
    private float tonnage;
    private static int nombreWagonsMinerai=0;

    public WagonMinerai(){
        super();
        nombreWagonsMinerai++;
    }
    public WagonMinerai(String c, String d, float t){
        super(c,d);
        this.tonnage=t;
        nombreWagonsMinerai++;
    }
    public static float getTonnageMax() {
        return tonnageMax;
    }
    public float getTonnage() {
        return tonnage;
    }
    public void setTonnage(float tonnage) {
        this.tonnage = tonnage;
    }
    public String toString(){
        return super.toString()+" TonnageMax="+tonnageMax+" TonnageActuel="+tonnage+" Nombre de wagon marchandise="+nombreWagonsMinerai+".";
    }
}
