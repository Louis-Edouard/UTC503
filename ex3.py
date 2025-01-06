from functools import reduce
ventes = [120, 50, 30, 20, 90, 100]
total_ventes = reduce(lambda x, y: x + y, ventes)
print("Total des ventes :", total_ventes)
produit_ventes = reduce(lambda x, y: x * y, ventes)
print("Produit des ventes :", produit_ventes)
