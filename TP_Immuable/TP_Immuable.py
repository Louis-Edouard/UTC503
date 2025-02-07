from typing import List, NamedTuple
import asyncio
import random

# Exercice 1: Programmation Immuable

def addToEach(n: int, lst: List[int]) -> List[int]:
    return [x + n for x in lst]

def removeDuplicates(lst: List[int]) -> List[int]:
    return list(set(lst))

# Exercice 2: Objets Persistants et Promesses

class Personne(NamedTuple):
    nom: str
    age: int

def anniversaire(personnes: List[Personne]) -> List[Personne]:
    return [Personne(p.nom, p.age + 1) for p in personnes]

async def getRandomNumber() -> int:
    await asyncio.sleep(1)
    return random.randint(1, 100)

async def afficherDeuxNombres():
    num1, num2 = await asyncio.gather(getRandomNumber(), getRandomNumber())
    print(f"Nombre 1: {num1}, Nombre 2: {num2}")

# Exercice 3: Gestion d'un inventaire

class Article(NamedTuple):
    nom: str
    prix: float
    quantite: int

def ajouterArticle(inventaire: List[Article], article: Article) -> List[Article]:
    return inventaire + [article]

def mettreAJourQuantite(inventaire: List[Article], nom: str, nouvelle_quantite: int) -> List[Article]:
    return [Article(a.nom, a.prix, nouvelle_quantite) if a.nom == nom else a for a in inventaire]

def supprimerArticle(inventaire: List[Article], nom: str) -> List[Article]:
    return [a for a in inventaire if a.nom != nom]

class Commande(NamedTuple):
    articles: List[Article]

def calculerTotal(commande: Commande) -> float:
    return sum(a.prix * a.quantite for a in commande.articles)

class Promotion(NamedTuple):
    nom: str
    condition: float  # Montant minimum pour appliquer la promo
    reduction: float  # Réduction en %

def appliquerPromotions(commande: Commande, promotions: List[Promotion]) -> float:
    total = calculerTotal(commande)
    for promo in promotions:
        if total >= promo.condition:
            total -= total * (promo.reduction / 100)
    return total

def miseAJourStock(inventaire: List[Article], commandes: List[Commande]) -> List[Article]:
    new_inventory = {a.nom: a for a in inventaire}
    for commande in commandes:
        for article in commande.articles:
            if article.nom in new_inventory:
                quantite_restante = max(0, new_inventory[article.nom].quantite - article.quantite)
                new_inventory[article.nom] = Article(article.nom, article.prix, quantite_restante)
    return list(new_inventory.values())

# Exécution de l'affichage des nombres aléatoires
if __name__ == "__main__":
    asyncio.run(afficherDeuxNombres())
