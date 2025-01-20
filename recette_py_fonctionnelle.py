# Définition des recettes
recettes = {
    "Omelette": {
        "ingredients": ["oeufs", "sel", "poivre", "beurre"],
        "temps": 10,
        "difficulte": "facile"
    },
    "Pâtes Carbonara": {
        "ingredients": ["pates", "lardons", "oeufs", "parmesan", "poivre"],
        "temps": 20,
        "difficulte": "moyen"
    },
    "Salade César": {
        "ingredients": ["laitue", "poulet", "parmesan", "croûtons", "sauce césar"],
        "temps": 15,
        "difficulte": "facile"
    }
}

def ingredients_disponibles(ingredients_recette, ingredients_utilisateur):
    """Vérifie si tous les ingrédients de la recette sont disponibles"""
    return all(ingredient in ingredients_utilisateur for ingredient in ingredients_recette)

def filtrer_recettes(recettes, ingredients_disponibles):
    """Filtre les recettes réalisables avec les ingrédients disponibles"""
    return dict(filter(
        lambda item: ingredients_disponibles(item[1]["ingredients"], ingredients_disponibles),
        recettes.items()
    ))

def formater_recette(nom_recette, details):
    """Formate une recette pour l'affichage"""
    return {
        "nom": nom_recette,
        "ingredients": ", ".join(details["ingredients"]),
        "temps": f"{details['temps']} minutes",
        "difficulte": details["difficulte"]
    }

def obtenir_recettes_possibles(ingredients_utilisateur):
    """Retourne les recettes possibles formatées"""
    recettes_possibles = filtrer_recettes(recettes, ingredients_utilisateur)
    return list(map(
        lambda x: formater_recette(x[0], x[1]),
        recettes_possibles.items()
    ))

# Exemple d'utilisation
if __name__ == "__main__":
    # Ingrédients disponibles
    mes_ingredients = ["oeufs", "sel", "poivre", "beurre", "laitue", "parmesan", "croûtons"]
    
    # Obtenir les recettes possibles
    recettes_possibles = obtenir_recettes_possibles(mes_ingredients)
    
    # Afficher les résultats
    print("Recettes réalisables avec vos ingrédients:")
    for recette in recettes_possibles:
        print(f"\nNom: {recette['nom']}")
        print(f"Ingrédients nécessaires: {recette['ingredients']}")
        print(f"Temps de préparation: {recette['temps']}")
        print(f"Difficulté: {recette['difficulte']}")