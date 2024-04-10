package interface_noyau_fonctionnel;

import java.time.LocalDate;

public class InterfaceNoyauFonctionnel {
    
    
    public String[] trouverHoraireDisponible(LocalDate date) {
    
        String[] heurelist = { "12:00", "13:00", "14:00", "15:00"};
        return heurelist;
        
    }

    public String[] trouverNbPersonnes() {
        String[] perList = {"1", "2", "3", "4", "5", "6", "7", "8"} ;
        return perList;
    
    }
    
    
    public String[] trouverTableDisponible(int jour, int mois, int nombrePersonnes, String time) {
        if(nombrePersonnes >=3 && nombrePersonnes<5) {
            return new String[]{"Table 2","Table 3","Table 4","Table 5","Table 6",};
        }
        if(nombrePersonnes >=5) {
            return new String[]{"Table 6"};
        }
        return new String[]{"Table1","Table 2","Table 3","Table 4","Table 5","Table 6",};
        
    }

}
