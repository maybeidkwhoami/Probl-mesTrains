public class Personnel {

    private String matricule;
    private String nom;
    private String prenom;

    public Personnel(){

    }
    public Personnel(String m, String n, String p){
        this.nom=n;
        this.prenom=p;
        this.matricule=m;
    }
    public Personnel(Personnel p){
        this.nom=p.nom;
        this.prenom=p.prenom;
        this.matricule=p.matricule;
    }

    public String getMatricule(){
        return this.matricule;
    }
    public String getNom(){
        return this.nom;
    }
    public  String getPrenom(){
        return this.prenom;
    }
    
    public void setMatricule(String m){
        this.matricule=m;
    }
    public void setNom(String n){
        this.nom=n;
    }
    public void setPrenom(String p){
        this.prenom=p;
    }
}