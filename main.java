import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Création d'un premier film avec des valeurs fixes
        Film film1 = new Film("Star Wars: Un nouvel espoir", "IV", 1977, 11000000.0, 775000000.0);
        
        // Création d'un acteur et ajout de personnages
        Acteur harrisonFord = new Acteur("Harrison", "Ford");
        harrisonFord.ajouterPersonnage(new Personnage("Han Solo", "La Force"));
        harrisonFord.ajouterPersonnage(new Personnage("Indiana Jones", "Héros"));
        
        // Affichage des informations de l'acteur
        System.out.println(harrisonFord);
        
        // Saisie interactive pour un deuxième film
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez les informations pour le deuxième film :");
        System.out.print("Titre : ");
        String titre = scanner.nextLine();
        
        System.out.print("Numéro d'épisode : ");
        int numero = scanner.nextInt();
        
        System.out.print("Année de sortie : ");
        int annee = scanner.nextInt();
        
        System.out.print("Coût de production : ");
        double cout = scanner.nextDouble();
        
        System.out.print("Recette : ");
        double recette = scanner.nextDouble();
        
        Film film2 = new Film(titre, numero, annee, cout, recette);
        
        // Affichage des films
        System.out.println("\nFilm 1 : " + film1);
        System.out.println("\nFilm 2 : " + film2);
        
        // Création et affichage de personnages
        Personnage darthVader = new Personnage("Dark Vador", true);
        Personnage luke = new Personnage("Luke Skywalker", false);
        
        System.out.println("\nPersonnages créés :");
        System.out.println(darthVader);
        System.out.println(luke);
        
        // Création d'une collection contenant les objets créés
        List<Object> starWarsCollection = new ArrayList<>();
        starWarsCollection.add(film1);
        starWarsCollection.add(film2);
        starWarsCollection.add(darthVader);
        starWarsCollection.add(luke);
        
        // Affichage de la collection
        System.out.println("\nContenu de la collection Star Wars :");
        for (Object obj : starWarsCollection) {
            System.out.println(obj);
        }
        
        scanner.close();
    }
}
