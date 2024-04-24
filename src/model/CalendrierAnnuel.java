package model;

public class CalendrierAnnuel {
	Mois[] mois;

	public CalendrierAnnuel() {
		this.mois = new Mois[12];
		mois[0] = new Mois("janvier", 31);
		mois[1] = new Mois("fevrier", 28);
		mois[2] = new Mois("mars", 31);
		mois[3] = new Mois("avril", 30);
		mois[4] = new Mois("mai", 31);
		mois[5] = new Mois("juin", 30);
		mois[6] = new Mois("juillet", 31);
		mois[7] = new Mois("aout", 31);
		mois[8] = new Mois("septembre", 30);
		mois[9] = new Mois("octobre", 31);
		mois[10] = new Mois("novembre", 30);
		mois[11] = new Mois("decembre", 31);

	}

	public boolean estLibre(int jour, int mois) {
		return this.mois[mois].estLibre(jour);
	}

	public boolean reserver(int jour, int mois) {
		try {
			this.mois[mois].reserver(jour);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return false;
		}
		return this.mois[mois].jours[jour];

	}

	private static class Mois {
		private String nom;
		private boolean[] jours;

		private Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
			for (int i = 0; i < nbJours; i++) {
				jours[i] = false;
			}
		}

		private boolean estLibre(int jour) {
			return jours[jour];
		}

		private void reserver(int jour) {
			if (jours[jour]) {
				throw new IllegalStateException("Le jour est déjà pris");
			} else
				jours[jour] = true;

		}

	}

}
