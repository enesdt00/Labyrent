import java.util.ArrayList;

public abstract class Rute {
    private int radNum, kolNum;
    protected Labyrint lab;
    private Rute nord,syd,vest,oest;
    public Rute(int radNum,int kolNum, Labyrint lab){
        this.radNum=radNum;
        this.kolNum=kolNum;
        this.lab=lab;
        
    }
    public Labyrint hentLabyrint(){
        return lab;
    }
    
   /*  public void settNabo(){
        if(nord!=null) nord=new Rute(radNum-1,kolNum,lab);
        if(syd !=null) syd= new  Rute(radNum+1, kolNum,lab);
        if(vest!=null) vest=new Rute(radNum,kolNum+1,lab);
        if(oest!=null) oest=new Rute(radNum,kolNum-1,lab);

    }*/
   
    public void finn(){
        this.finn(this);
    }
    
    public void finn(Rute fra) {
        if (fra.Tegn() == 'A') {
            //System.out.println(fra);
            return;
        }
    
        
        if (fra.Tegn() == '#') {
            return;
        }
    
       
        if (hentNord() != null && fra.hentNord().Tegn() == '.') {
            hentNord().finn(this);
        }
    
        if (hentSyd() != null && fra.hentSyd().Tegn() == '.') {
            hentSyd().finn(this);
        }
    
        if (hentVest() != null && fra.hentVest().Tegn() == '.') {
            hentVest().finn(this);
        }
    
        if (hentOest() != null && fra.hentOest().Tegn() == '.') {
          hentOest().finn(this);
        }
    }

    
   
        
    public  abstract char Tegn();
    
    public void settNord(Rute nord){
        this.nord=nord;
    }
    public void settSyd(Rute syd){
        this.syd=syd;
    }
    public void settVest(Rute vest){
        this.vest=vest;
    }
    public void settOest(Rute oest){
        this.oest=oest;
    }
    public Rute hentNord(){
        return nord;

    }
    public Rute hentSyd(){
        return syd;
    }
    public Rute hentOest(){
        return oest;
    }
    public Rute hentVest(){
        return vest;
    }
    @Override
    public String toString(){
        return String.valueOf(radNum) +","+ String.valueOf(kolNum) ;
    }
    
     
     
    
}
