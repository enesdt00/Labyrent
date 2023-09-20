import java.util.Scanner;

public class Oblig7 {
    public static void main(String[] args) {
        Scanner myobj=new Scanner(System.in);
      
        System.out.print("Hvilken labyrinten vil du ta !!!! Bare skriv tall: " );
        String filNavn = myobj.nextLine(); 
        String filNavnsist= filNavn+".in";
        Labyrint m=new Labyrint(filNavnsist);
        String forsette;
        do{
            System.out.println("Skriv inn koordinater <rad> <kolonne>");
            int rad=myobj.nextInt();
            int kol=myobj.nextInt();
            m.finnUtveiFra(rad, kol);
            System.out.println("Ska du forsette å skrive 'ja' eller 'nei' ");
            forsette=myobj.next();

    
    }while(!forsette.equals("nei"));
        
    }
    
}
