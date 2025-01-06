ages = [12, 25, 17, 18, 40, 15, 22]
adultes = filter(lambda age: age >= 18, ages)
print("Âges des adultes :", list(adultes))
ages_seniors = [45, 60, 70, 33, 80, 59, 65]
seniors = filter(lambda age: age >= 60, ages_seniors)
print("Âges des seniors :", list(seniors))
