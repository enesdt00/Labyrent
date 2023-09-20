import java.util.ArrayList;

public class HvitRute extends Rute {
   public static  ArrayList<Rute> erBesoktFra = null;
   

    public HvitRute(int radNum, int kolNum, Labyrint lab) {
        super(radNum, kolNum, lab);
        erBesoktFra = new ArrayList<Rute>();
    }

    @Override
    public char Tegn() {
        return '.';
    }
   @Override
    public void finn(){
        this.finn(this);
    }
    @Override
public void finn(Rute fra) {
    if (!erBesoktFra.contains(this)) {
        erBesoktFra.add(this);
    } else {
        return; }

  //nSystem.out.println(erBesoktFra.toString());

    
    
    if (hentNord() != null /*&& fra.hentNord().Tegn() == '.'*/) {
       // System.out.println(fra.Tegn()+fra.toString());
     //System.out.println(fra.hentNord().Tegn()+ fra.hentNord().toString()); 
     hentNord().finn(this);
        
    }
   if (hentOest() != null ) {
        //System.out.println(fra.Tegn()+fra.toString());
       // System.out.println(fra.hentOest().Tegn()+ fra.hentOest().toString());
       hentOest().finn(this);
        

    }
    if (hentSyd() != null ) {
        //System.out.println(fra.Tegn()+fra.toString());
        //System.out.println(fra.hentSyd().Tegn()+ fra.hentSyd().toString());
        hentSyd().finn(this);
      
    }
    if (hentVest() != null ) {
        //System.out.println(fra.Tegn()+fra.toString());
        //System.out.println(fra.hentVest().Tegn()+ fra.hentVest().toString());
      hentVest().finn(this);
    }
}


}

