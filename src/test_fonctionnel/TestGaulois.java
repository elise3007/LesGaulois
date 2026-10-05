package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		Romain minus = new Romain("Minus", 6);
		
		asterix.parler("Bonjour Obélix.");
		obelix.parler("Bonjour Astérix. Ca te dirait d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée");
		System.out.println("Dans la forêt " + asterix.getNom() + " et " + obelix.getNom() + " tombent nez à nez sur le romain " + minus.getNom() + ".");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}
