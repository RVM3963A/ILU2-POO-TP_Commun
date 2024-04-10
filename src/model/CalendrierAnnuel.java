package model;

public class CalendrierAnnuel {
	Mois[] mois;
	
	
	public CalendrierAnnuel() {
		this.mois = new Mois[12];
		mois[0].nom = "janvier";
		mois[1].nom = "fevrier";
		mois[2].nom = "mars";
		mois[3].nom = "avril";
		mois[4].nom = "mai";
		mois[5].nom = "juin";
		mois[6].nom = "juillet";
		mois[7].nom = "aout";
		mois[8].nom = "septembre";
		mois[9].nom = "octobre";
		mois[10].nom = "novembre";
		mois[11].nom = "decembre";
		
	}
	
	public boolean estLibre(int jour, int mois) {
		return this.mois[mois].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) {
		try {
		this.mois[mois].reserver(jour);
		} catch (JourPrisException e) {
			e.printStackTrace();
		}
		return this.mois[mois].jours[jour];
		
	}
	
	private class Mois{
		private String nom;
		private boolean[] jours;
		
		private Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
			for( int i = 0; i<nbJours; i++) {
				jours[i] = false;
			}
		}
		
		private boolean estLibre(int jour) {
			return jours[jour];
		}
		
		private void reserver(int jour) throws JourPrisException {
			if (jours[jour]) {
				throw new JourPrisException("Le jour est déjà pris");
			}
			else jours[jour] = true;
			
		}
		
	}

}
