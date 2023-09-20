import java.util.ArrayList;

public class Aapning extends HvitRute  {
    

    public Aapning(int radNum,int kolNum,Labyrint lab){
        super(radNum, kolNum, lab);
    }
    @Override
    public char Tegn(){
        return '.';
    }
    @Override
    public void finn(Rute fra){
        
            
          this.lab.opningene.add(this);
        // System.out.println("hey hey jeg har add:");
        
            return;
        }
     
    }
    

