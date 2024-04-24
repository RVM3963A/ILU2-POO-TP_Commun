package model;

public abstract class Reservation {
	int jour;
	int mois;
	
	protected Reservation(int jour, int mois) {
		this.jour =jour;
		this.mois = mois;
	}
	
	@Override
	public String toString() {
		
		StringBuilder chaine = new StringBuilder();
		chaine.append("le" + jour + "/" + mois +": ");
		System.out.println(chaine);
		return chaine.toString();
		
		
	}
	

}
