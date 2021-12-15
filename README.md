# BulletinSalaire2Java

le programme permet de calculer et d’afficher le bulletin de salaire 
d’un employé.
Les nom, prénom et statut (cadre, agent de maîtrise, employé de bureau) sont des
informations obligatoirement mentionnées sur le bulletin de salaire d’un employé.
L’utilisateur doit saisir le nom, le prénom, le statut ainsi que le nombre d’heures effectuées
par un employé.
Calcul du salaire de base :
Le salaire de base dépend du nombre d’heures travaillées en tenant compte des critères
suivants :
- de 0 à 169 heures : le salaire mensuel est égal au nombre d’heures travaillées
multiplié par le taux horaire
- de 169 à 180 heures : le taux horaire est majoré de 50 %
- au-delà de 180 heures : le taux horaire est majoré de 60 %

Calcul du salaire à verser :
La prime est calculée en fonction du nombre d’enfants selon les règles suivantes :
- 0 enfant : pas de prime
- 1 enfant : 20€ de prime
- 2 enfants: 50€ de prime
- Plus de 2 enfants : 70€ + 20€ par enfants au-dessus de 2
Le calcul du montant net à payer s’effectue suivant la règle suivante :
Net à payer = Salaire de base – Total des cotisations salariales + Prime
