import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Labyrint{
    ArrayList<Aapning> opningene= new ArrayList<>();
    private int rader, kolonner;
    private Rute lab[][];
    public Labyrint(String filnavn){
        try{
            File fil=new File(filnavn);
            Scanner myleser=new Scanner(fil);

            rader=myleser.nextInt();
            kolonner=myleser.nextInt();

            lab=new Rute[rader][kolonner];

            for(int rad=0; rad<rader; rad++){
                String linje=myleser.next();
               for(int kol=0; kol<kolonner; kol++){
                char tegn=linje.charAt(kol);
                if(tegn == '#') {lab[rad][kol]= new SortRute(rad, kol, this);}
                else{
                    if(rad==0 || rad== rader-1|| kol==0 || kol==kolonner-1 ){
                        lab[rad][kol]=new Aapning(rad, kol, this);
                        
                    }
                    else{
                        lab[rad][kol]=new HvitRute(rad, kol, this);
                    }
                }

               } 
            }
            myleser.close();

            for(int rad=0; rad<rader; rad++){
                for(int kol=0; kol<kolonner; kol++){
                    Rute nyRute=lab[rad][kol];
                    if(kol>0){
                        nyRute.settVest(lab[rad][kol-1]);
                    }if(kol<kolonner-1){
                        nyRute.settOest(lab[rad][kol+1]);
                    }if(rad>0){
                        nyRute.settNord(lab[rad-1][kol]);
                    }if(rad<rader-1){
                        nyRute.settSyd(lab[rad+1][kol]);
                    }
                }
            }
            System.out.println(this);
            

        }catch( FileNotFoundException e){
            System.out.println(" finner det ikke filen"+ filnavn);
        }
       // this.rader=rader;
        //this.kolonner=kolonner;
        //lab[rader][kolonner];
        
    }
    public void finnUtveiFra(int rad, int kol) {
        if (rad < 0 || kol < 0 || rad >= lab.length || kol >= lab[0].length) {
            return;
        }  
        try {
            Rute rute = lab[rad][kol];
            HvitRute hvitRute = (HvitRute) rute;
            hvitRute.finn(); 
            System.out.println("Aapningene:");
            if(opningene.size()==0){
                System.out.println("Dessverre det ikke finnes noen opnigene!!");
            }else{

            for(Aapning r: opningene){
            System.out.println(r.toString());

            }}
        } catch (ClassCastException e) {
            System.out.println("Du kan ikke starte med StortRute!!");
        }
               
               
           
            
    }
  
    
    @Override
    public String toString(){
        StringBuilder labyrent=new StringBuilder();
        for(int rad=0; rad< rader; rad++){
            for(int kol=0; kol<kolonner; kol++){
                labyrent.append(lab[rad][kol].Tegn());
            }
            labyrent.append("\n");
        }
        return labyrent.toString();
    }
}