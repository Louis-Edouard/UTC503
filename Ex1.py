
prix_euros = [50, 20, 35, 100, 80]
taux_conversion = 1.10
prix_dollars = map(lambda prix: prix * taux_conversion, prix_euros)
prix_dollars_format = map(lambda prix: f"{prix:.2f}$", prix_dollars)
prix_final = list(prix_dollars_format)
print("Prix convertis en dollars :", prix_final)
