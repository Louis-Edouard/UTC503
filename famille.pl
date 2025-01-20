homme(pierre).
homme(marc).
homme(paul).
femme(marie).
femme(sophie).

parent(pierre, paul).
parent(marie, paul).
parent(marc, sophie).

pere(X,Y) - homme(x), parent(X, Y).
mere(X, Y) :- femme(X), parent(X, Y).

homme(jacques).
parent(jacques, marc).

Ex:1
Le père de Marc est jacques
Marc est le père de Paul et Sophie


Ex2:
grand_parents(X, Y) :- parent(X, Y).

Jacques est le grand père de Paul

oui

Ex3 :
frere_soeur(X, Y) :- parent(P, X), parent(P, Y), X \= Y.

Paul n'a pas de frère ou soeur

Ex4 :
oncle_tante(X, Y) :- parent(P, Y), frere_soeur(X, P).

?- homme(X).
X = jacques ;
X = marc ;
X = jean ;
X = paul ;
X = pierre.

?- parent(X, sophie).
X = marc ;
X = marie.

Ex5 :


Ex6 :

Ex7 : 
membre(X, [X|_]).
membre(X, [_|Queue]) :- membre(X, Queue).

?- ma_liste(L), membre(marie, L).

Ex8:
Marc n'est pas l'oncle de Paul

Julie est la tante de Paul