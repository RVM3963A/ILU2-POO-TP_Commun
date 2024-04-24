package model;

public class ReservationSpectacle extends Reservation {

	int numZone;
	int numChaise;
	
	public ReservationSpectacle(int numZone, int numChaise, int jour, int mois) {
		super(jour, mois);
		this.numZone=numZone;
		this.numChaise = numChaise;
		
		
	}
	
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("le " + jour + "/"+ mois +" : "+ "Secteur "+numZone + "à la chaise " + numChaise + ".");
		System.out.println(chaine);
		return chaine.toString();
		
	}
	
	
}
