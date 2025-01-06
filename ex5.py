import csv
from functools import reduce

def lire_donnees_csv(nom_fichier):
    with open(nom_fichier, mode='r', newline='', encoding='utf-8') as fichier:
        lecteur = csv.DictReader(fichier)
        return [ligne for ligne in lecteur]

def ecrire_donnees_csv(nom_fichier, donnees):
    with open(nom_fichier, mode='w', newline='', encoding='utf-8') as fichier:
        ecrivain = csv.DictWriter(fichier, fieldnames=donnees[0].keys())
        ecrivain.writeheader()
        ecrivain.writerows(donnees)

def main():
    fichier_csv = "employes.csv"
    donnees = lire_donnees_csv(fichier_csv)

    for employe in donnees:
        employe["nom"] = employe["nom"].upper()

    employes_senior = list(filter(lambda e: float(e["salaire"]) > 50000, donnees))

    salaire_total = reduce(lambda x, y: x + float(y["salaire"]), employes_senior, 0)

    for employe in donnees:
        salaire = float(employe["salaire"])
        if salaire < 30000:
            employe["statut"] = "junior"
        elif 30000 <= salaire <= 50000:
            employe["statut"] = "intermédiaire"
        else:
            employe["statut"] = "senior"

    fichier_csv_modifie = "employes_modifies.csv"
    ecrire_donnees_csv(fichier_csv_modifie, donnees)

    print("Employés seniors :", employes_senior)
    print("Salaire total des employés seniors :", salaire_total)

if __name__ == "__main__":
    main()
