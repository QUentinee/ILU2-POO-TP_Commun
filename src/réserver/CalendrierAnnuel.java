package réserver;

public class CalendrierAnnuel {
	
	private class Mois {
		private String nom;
		private int nbJours;
		private boolean[] jours = new boolean[nbJours];
		
		private Mois(String nom, int nbJours) throws IllegalStateException {
			for(int i = 0; i < jours.length; i ++) {
				jours[i] = false;
			}
			this.nbJours = nbJours;
			this.nom = nom;
		}
		
		private boolean estLibre(int jour) {
			return !(jours[jour]);
		}
		
		private void reserver(int jour) {
			if(jours[jour]) {
				throw new IllegalStateException();
			}
			jours[jour] = true;
		}
	}
		
	private Mois[] calendrier = new Mois[12];
	
	public CalendrierAnnuel() {
		calendrier[0] = new Mois("Janvier", 31);
		calendrier[1] = new Mois("F�vrier", 28);
		calendrier[2] = new Mois("Mars", 31);
		calendrier[3] = new Mois("Avril", 30);
		calendrier[4] = new Mois("Mai", 31);
		calendrier[5] = new Mois("Juin", 30);
		calendrier[6] = new Mois("Juillet", 31);
		calendrier[7] = new Mois("Ao�t", 31);
		calendrier[8] = new Mois("Septembre", 30);
		calendrier[9] = new Mois("Octobre", 31);
		calendrier[10] = new Mois("Novembre", 30);
		calendrier[11] = new Mois("D�cembre", 31);
	}
	
	public boolean estLibre(int jour, int mois) {
		Mois lemois = calendrier[mois - 1]; 
		return lemois.estLibre(jour-1);
	}
	
	public boolean reserver(int jour, int mois) {
		Mois lemois = calendrier[mois -1];
		if(lemois.estLibre(jour -1)) {
			lemois.reserver(jour-1);
			return true;
		}
		else {
			return false;
		}
	}
	
	
}