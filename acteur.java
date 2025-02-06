import java.util.ArrayList;
import java.util.List;

// Classe représentant un acteur
public class Acteur {
    private String nom;
    private String prenom;
    private List<Personnage> personnages;

    // Constructeur de la classe Acteur
    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.personnages = new ArrayList<>();
    }

    // Méthode pour ajouter un personnage à la liste des personnages incarnés
    public void ajouterPersonnage(Personnage personnage) {
        if (personnage != null) {
            this.personnages.add(personnage);
        }
    }

    // Méthode pour obtenir le nombre total de personnages joués par l'acteur
    public int getNombrePersonnages() {
        return this.personnages.size();
    }

    // Redéfinition de la méthode toString pour afficher les détails de l'acteur
    @Override
    public String toString() {
        return "Acteur { " +
                "Nom = '" + nom + "', " +
                "Prénom = '" + prenom + "', " +
                "Personnages = " + personnages +
                " }";
    }
}
