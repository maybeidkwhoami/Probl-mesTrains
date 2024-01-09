public abstract class Wagon {
    private String code;
    private String description;
    public Wagon(){

    }
    public Wagon(String c, String d){
        this.code = c ;
        this.description = d;
    }
    public void setCode(String c){
        this.code = c;
    }
    public void setDescription(String d){
        this.description=d;
    }
    public String getCode(){
        return this.code;
    }
    public String getDescription(){
        return this.description;
    }
    @Override
    public String toString(){
        return "Wagon[ Code"+code+" Description: "+description+" ]";
    }
}
