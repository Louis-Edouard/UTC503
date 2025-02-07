from functools import reduce
import time

# Exercice 1: Utilisation d'Expressions Lambda

# Question 1.1 : Carré d'un nombre
carre = lambda x: x ** 2

# Question 1.2 : Mapper une liste de nombres en leurs carrés
nombres = [1, 2, 3, 4, 5]
carres = list(map(carre, nombres))

# Question 1.3 : Somme de deux nombres
somme = lambda a, b: a + b

# Question 1.4 : Réduction de la liste en somme totale
somme_totale = reduce(somme, nombres)

# Exercice 2: Utilisation de Clôtures

# Question 2.1 : Fonction créant un multiplicateur
def create_multiplier(n):
    return lambda x: x * n

# Question 2.2 : Création des fonctions double et triple
double = create_multiplier(2)
triple = create_multiplier(3)

# Question 2.3 : Test des fonctions
result_double = double(4)
result_triple = triple(4)

# Exercice 3: Application Pratique

# Question 3.1 : Liste de mots
mots = ["apple", "banane", "avocat", "orange", "abricot", "kiwi"]

# Question 3.2 : Filtrer les mots commençant par 'a'
mots_a = list(filter(lambda mot: mot.startswith("a"), mots))

# Question 3.3 : Clôture pour compter les mots de plus de 5 caractères
def compteur_mots(longueur):
    return lambda liste: len([mot for mot in liste if len(mot) > longueur])

compteur = compteur_mots(5)
mots_longueur_sup5 = compteur(mots)

# Exercice 5 : Composition de Fonctions

# Question 1 : Fonction compose
def compose(f, g):
    return lambda x: f(g(x))

# Question 2 : Test avec deux lambdas
f = lambda x: x * 2
g = lambda x: x + 3
h = compose(f, g)
resultat_composition = h(5)

# Exercice 6 : Utilisation Avancée d'Expressions Lambda

# Question 1 : Fonction filterMap
def filterMap(filtre, transformation, liste):
    return list(map(transformation, filter(filtre, liste)))

# Question 2 : Test avec suppression des chaînes vides et conversion en majuscules
chaines = ["hello", "", "world", "python", ""]
resultat_filterMap = filterMap(lambda x: x != "", lambda x: x.upper(), chaines)

# Exercice 7: Utilisation Avancée de Clôtures

# Question 1 : Fonction de mémorisation
def memoize(f):
    cache = {}
    def memorized_func(x):
        if x not in cache:
            cache[x] = f(x)
        return cache[x]
    return memorized_func

# Question 2 : Mémoisation de Factorielle et Fibonacci
@memoize
def factorielle(n):
    return 1 if n == 0 else n * factorielle(n - 1)

@memoize
def fibonacci(n):
    return n if n < 2 else fibonacci(n - 1) + fibonacci(n - 2)

# Test de performance
start = time.time()
fact_10 = factorielle(10)
fib_30 = fibonacci(30)
end = time.time()
temps_execution = end - start

# Exercice 8: Application Pratique

# Question 3 : Calcul du prix après réduction
def calculateDiscount(produits, reduction):
    return sum(map(lambda p: p * (1 - reduction / 100), produits))

# Question 4 : Test avec réduction de 20%
produits = [100, 200, 50, 75]
montant_apres_reduction = calculateDiscount(produits, 20)

# Affichage des résultats
print("Carrés des nombres :", carres)
print("Somme totale :", somme_totale)
print("Résultat du double :", result_double)
print("Résultat du triple :", result_triple)
print("Mots commençant par 'a' :", mots_a)
print("Nombre de mots > 5 caractères :", mots_longueur_sup5)
print("Résultat de la composition de fonctions :", resultat_composition)
print("Résultat de filterMap :", resultat_filterMap)
print("Factorielle de 10 :", fact_10)
print("Fibonacci de 30 :", fib_30)
print("Temps d'exécution :", temps_execution, "secondes")
print("Montant après réduction de 20% :", montant_apres_reduction)
