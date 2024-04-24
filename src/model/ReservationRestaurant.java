package model;

public class ReservationRestaurant extends Reservation {
	
	int nbLit;
	int nbLitDouble;
	int numChambre;
	
	
	
	public ReservationRestaurant(int nbLit, int nbLitDouble, int numChambre, int jour, int mois) {
		super(jour, mois);
		this.nbLit = nbLit;
		this.nbLitDouble = nbLitDouble;
		this.numChambre = numChambre;
		
		
	}
	
	
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("le " + jour + "/"+ mois +" : "+ nbLit + "Lit(s)"+ nbLitDouble + " LitDouble(s)  à la chambre n°" + numChambre + ".");
		System.out.println(chaine);
		return chaine.toString();
		
	}

}
