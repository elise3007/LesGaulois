package personnages;

import objets.Equipement;
import village_gaulois.Musee;
import village_gaulois.Village;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion = 1;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}
	

	
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}
	
	

	
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
		+ romain.getNom());
		Equipement[] tropheesEjectes = romain.recevoirCoup((force / 2) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
		effetPotion = 1;
		}
		for (int i = 0; tropheesEjectes != null && i < tropheesEjectes.length; i++, nbTrophees++) {
		this.trophees[nbTrophees] = tropheesEjectes[i];
		}
	}
	
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
	
	
	public void setVillage(Village village) {
		this.village = village;
	}
	
	
	public void sePresenter() {
		if (this.village == null) {
			this.parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		} else if (this.village.getChef() == this) {
			this.parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village : " + village.getNom() + ".");
		} else {
			this.parler("Bonjour, je m'appelle " + nom + ". J'habite le village : " + village.getNom() + ".");
		}
	}
	
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			String message = "Je donne au musée tous mes trophées :";
			for (int i = 0 ; i < nbTrophees ; i++) {
				message += "\n- " + trophees[i];
				musee.donnerTrophees(this, trophees[i]);
				trophees[i] = null;
			}
			
			parler(message);
			nbTrophees = 0;
		}
	}
	
	
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

}
