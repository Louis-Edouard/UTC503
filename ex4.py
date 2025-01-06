from functools import reduce
notes = [12, 15, 9, 18, 6, 20, 14]
notes_sur_100 = list(map(lambda note: note * 5, notes))
print("Notes sur 100 :", notes_sur_100)
notes_sup_50 = list(filter(lambda note: note >= 50, notes_sur_100))
print("Notes supérieures ou égales à 50 :", notes_sup_50)

if len(notes_sup_50) > 0:
    moyenne_notes = reduce(lambda x, y: x + y, notes_sup_50) / len(notes_sup_50)
else:
    moyenne_notes = 0 
print("Moyenne des notes filtrées :", moyenne_notes)
