import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Création des films
        Film film1 = new Film("Un nouvel espoir", 1977, 4, 11000000, 775398007, "George Lucas");
        Film film2 = new Film("Le Réveil de la Force", 2015, 7, 245000000, 2068223624.0, "J.J. Abrams");

        // Création des acteurs
        Acteur harrison = new Acteur("Ford", "Harrison");
        Acteur carrie = new Acteur("Fisher", "Carrie");
        Acteur markHamill = new Acteur("Hamill", "Mark");

        // Création des personnages
        Personnage lukeSkywalker = new Gentil("Skywalker", "Luke");
        Personnage princesseLeia = new Gentil("Organa", "Leia");
        Personnage darthVader = new Mechant("Vader", "Dark");

        // Attribution des personnages aux acteurs
        harrison.ajouterPersonnage(new Gentil("Solo", "Han"));
        carrie.ajouterPersonnage(princesseLeia);
        markHamill.ajouterPersonnage(lukeSkywalker);
        harrison.ajouterPersonnage(darthVader);

        // Ajout des acteurs et personnages au film1
        film1.ajouterActeurs(List.of(harrison, carrie, markHamill));
        film1.ajouterPersonnages(List.of(lukeSkywalker, princesseLeia, darthVader));

        // Affichage des informations
        System.out.println("Nombre d'acteurs dans film1: " + film1.nbActeurs());
        System.out.println("Nombre de personnages dans film1: " + film1.nbPersonnages());

        Film.Pair<Double, Boolean> benefice = film1.calculBenefice();
        System.out.println("Bénéfice de film1: " + benefice.getFirst() + ", Est bénéficiaire: " + benefice.getSecond());

        System.out.println("Film1 est-il avant 1980? " + film1.isBefore(1980));

        // Création d'une map des films et sauvegarde
        Map<Integer, Film> filmMap = new HashMap<>();
        filmMap.put(film1.getAnnee(), film1);
        filmMap.put(film2.getAnnee(), film2);
        sauvegarderFilms(filmMap);
    }

    public static void sauvegarderFilms(Map<Integer, Film> films) {
        films.forEach((annee, film) -> System.out.println(annee + " – " + film.getTitre() + " – " + film.calculBenefice().getFirst()));
    }
}
