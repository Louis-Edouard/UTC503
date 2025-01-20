#Version impérative


recettes = {"Pâtes Carbonara": ["pâtes", "lardons", "crème", "parmesan", "œuf"],
    "Salade César": ["laitue", "poulet", "croutons", "parmesan", "sauce César"],
    "Omelette": ["œuf", "lait", "beurre", "sel"],
    "Soupe de légumes": ["carotte", "poireau", "pomme de terre", "oignon", "eau"],
    "Pizza Margherita": ["pâte à pizza", "sauce tomate", "mozzarella", "basilic"],}

def recettes_realisables(ingredients_disponibles):
    recettes_possibles = []
    for recette, ingredients in recettes.items():
        if all(ingredient in ingredients_disponibles for ingredient in ingredients):
            recettes_possibles.append(recette)
    return recettes_possibles

#Version fonctionnel 
recettes_f = {}

def recette_realisables_f():

