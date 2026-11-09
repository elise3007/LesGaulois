package objets;

public class Chaudron {
	
	private int quantitePotion;
	private int forcePotion;
	
	public Chaudron() {
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public boolean resterPotion() {
		return quantitePotion != 0;
	}
	
	public int prendreLouche() {
		quantitePotion --;
		if (quantitePotion < 1) {
			forcePotion = 0;
		}
		return forcePotion;
	}

}
