package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;

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
		return "Le gaulois" + nom + " : ";
		
	}
	
	public void frapper(Romain romain) {
		String nomRomain = romain.getNom();
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + nomRomain);
		int forceCoup = force * effetPotion/ 3;
		romain.recevoirCoup(forceCoup);
		if (effetPotion > 1) {
			effetPotion = effetPotion - 1;
		}
	}
	

	@Override
	public String toString() {
		return nom;
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
	
	
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

}
