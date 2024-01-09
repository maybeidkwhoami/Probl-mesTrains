import java.util.ArrayList;

public class Train{
    private String code;
    private Personnel conducteur;
    private TypeTrain type;
    private int longueur;
    private ArrayList<Wagon> wagons;
    

    public Train(String code, Personnel conducteur, TypeTrain type){
        this.code=code;
        this.conducteur=conducteur;
        this.type=type;
    }
    
    public Train(String code, Personnel conducteur, TypeTrain type, ArrayList<Wagon> w){
        this.code=code;
        this.conducteur=conducteur;
        this.type=type;
        this.wagons = new ArrayList<>(w);
    }
    public void setLongueur(int l){
        this.longueur=l;
    }
    public int getLongueur(){
        return this.longueur;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    public void setConducteur(Personnel conducteur) {
        this.conducteur = conducteur;
    }
    public Personnel getConducteur() {
        return conducteur;
    }
    public void setType(TypeTrain type) {
        this.type = type;
    }
    public TypeTrain getType() {
        return type;
    }
    public void setWagons(ArrayList<Wagon> wagons) {
        this.wagons = new ArrayList<>(wagons);
        this.longueur=wagons.size();
    }
    public ArrayList<Wagon> getWagons(){
        return this.wagons;
    }
    public void ajouterWagonMinerai(String c, String d, float t) throws TrainWagonIncompatiblesException{
        if(this.type!=TypeTrain.Minerai){
            throw new TrainWagonIncompatiblesException("Type non compatible");
        }
        else{
            wagons.add(new WagonMinerai(c,d,t));
            this.longueur++;
        }
    }
    public void ajouterWagonPassagers(String c, String d, int n) throws TrainWagonIncompatiblesException{
        if(this.type!=TypeTrain.Passagers || this.type!=TypeTrain.Marchandise){
            throw new TrainWagonIncompatiblesException("Type de train incompatible");
        }
        else{
            wagons.add(new WagonPassagers(c,d,n));
            this.longueur++;
        }
    }
    public void ajouterWagonMarchandise(String code, String description, float volume) throws TrainWagonIncompatiblesException {
        if ((this.type == TypeTrain.Minerai) || (this.type == TypeTrain.Passagers)) {
            throw new TrainWagonIncompatiblesException("Type wagon non autorisé pour ce type de train");
        }
        wagons.add(new WagonMarchandise(code, description, volume));
        this.longueur++;
    }
    public void ajouterWagon(Wagon wagon) throws TrainWagonIncompatiblesException{
        if(((this.type == TypeTrain.Minerai) && (wagon instanceof WagonMinerai)) || ((this.type==TypeTrain.Marchandise)&&(wagon instanceof WagonMarchandise)) || ((this.type==TypeTrain.Passagers || this.type== TypeTrain.Marchandise)&&(wagon instanceof WagonPassagers || wagon instanceof WagonMarchandise))){
            wagons.add(wagon);
            this.longueur++;
        }
        else{
            throw new TrainWagonIncompatiblesException("Type wagon non compatible avec le train actuel");
        }
    }
    public boolean supprimerWagon(String code){
        boolean c = false;
        for (Wagon i: wagons){
            if(i.getCode().equals(code)){
                wagons.remove(i);
                c = true;
                this.longueur --;
                break;
            }
        }
        return c;
    }
    @Override
    public String toString() {
        return "Train{" + "code=" + code + ", conducteur=" + conducteur + ", type=" + type + ", longueur=" + longueur + ", wagons=" + wagons + '}';
    }
    public void AfficherCharge() {
        float volumeTotal = 0;
        float tonnageTotal = 0;
        int nombreTotal = 0;
        switch (type) {
            case Minerai:
                for (Wagon w : wagons) {
                    tonnageTotal += ((WagonMinerai) w).getTonnage();
                }
                System.out.println("le tonnage total est " + tonnageTotal);
                break;
            case Marchandise:
                for (Wagon w : wagons) {
                    volumeTotal += ((WagonMarchandise) w).getVolume();
                }
                System.out.println("le volume total est " + volumeTotal);
                break;
            case Passagers:
                for (Wagon w : wagons) {
                    nombreTotal += ((WagonPassagers) w).getNombrePassagers();
                }
                System.out.println("le nombre total est " + nombreTotal);
                break;
            case PassagersMarchandise:
                for (Wagon w : wagons) {
                    if (w instanceof WagonPassagers) {
                        nombreTotal += ((WagonPassagers) w).getNombrePassagers();
                    } else {
                        volumeTotal += ((WagonMarchandise) w).getVolume();
                    }
                }
                System.out.println("le nombre total est " + nombreTotal + " le volume total est" + volumeTotal);
                break;
        }

    }
}