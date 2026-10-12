package village_gaulois;

import personnages.Gaulois;

public class Village {
	
	private static int NB_VILLAGEOIS_MAX = 30;
	
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;
	
	public Village(String nom, Gaulois chef) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		chef.setVillage(this);		
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < NB_VILLAGEOIS_MAX) {
			villageois[nbVillageois] = gaulois;
			nbVillageois ++;
			gaulois.setVillage(this);
			
		} else {
			System.out.println("Le village est plein !");
		}
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if ( numVillageois < 1 || numVillageois > NB_VILLAGEOIS_MAX) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		} else {
			return villageois[numVillageois - 1];
		}
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village " + nom + " du chef " + chef.getNom() + " vivent les légendaires gaulois :\n");
		for (Gaulois gaulois : villageois) {
			System.out.println("- " + gaulois.getNom());
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix);
		abraracourcix.setVillage(village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);
		
		village.trouverVillageois(30);
		village.ajouterVillageois(asterix);
		village.ajouterVillageois(obelix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
		
	}
}
