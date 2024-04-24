package model;

public class ReservationHotel extends Reservation {

	int numService;
	int numTableReserve;
	
	
	public ReservationHotel(int numService, int numTableReserve,int jour, int mois) {
		super(jour,mois);
		this.numService = numService;
		this.numTableReserve = numTableReserve;
		
	}
	
	
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append(super.toString()+" Table n°"+numTableReserve + "pour le " + numService + " service.");
		return chaine.toString(); 
		//héritage tostring
		
	}
	
	
	
	
}
