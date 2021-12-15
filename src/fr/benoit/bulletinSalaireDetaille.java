package fr.benoit;

//@author Benoit

import java.util.Scanner;

public class bulletinSalaireDetaille {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Variables
        String nom = null;
        String prenom = null;
        String statut = null;
        int nbHeuresEffectuees = 0;
        double tauxHoraire = 0;
        int nbEnfant = 0;
        int primeEnfant = 0;
        double salaireBrut;
        double cotisationsSociales;
        double salaireNet = 0;

        // Mise en place du scanner
        Scanner sc = new Scanner(System.in);

        // Message d'accueil
        System.out.println("********************************************");
        System.out.println("*******    TP BULLETIN DE SALAIRE    *******");
        System.out.println("********************************************");

        // Afin d'éviter une saisie vide une boucle vérifie :
        // 1. Que le nom n'est pas null
        // 2. Que la saisie du nom, vidée des espaces (trim), n'est pas vide
        // (isEmpty)
        while (nom == null || nom.trim().isEmpty()) {
            System.out.println("Indiquez votre nom : ");
            nom = sc.nextLine();
        }
        // Afin d'éviter une saisie vide une boucle vérifie :
        // 1. Que le prénom n'est pas null
        // 2. Que la saisie du prénom, vidée des espaces (trim), n'est pas vide
        // (isEmpty)
        while (prenom == null || prenom.trim().isEmpty()) {
            System.out.println("Indiquez votre prénom : ");
            prenom = sc.nextLine();
        }
        // Afin d'éviter une saisie vide une boucle vérifie :
        // 1. Que le statut n'est pas null
        // 2. Que la saisie du statut, vidée des espaces (trim), n'est pas vide
        // (isEmpty)
        while (statut == null || statut.trim().isEmpty()) {
            System.out.println("Indiquez votre statut :");
            statut = sc.nextLine();
        }

        // Récupération du nombre d'heures
        System.out.println("Indiquez le nombre d'heures effectuées :");
        nbHeuresEffectuees = sc.nextInt();

        // Récupération du taux horaire qui ne peut ni être négatif, ni égal à 0
        while (tauxHoraire <= 0) {
            System.out.println("Indiquez le taux horaire :");
            tauxHoraire = sc.nextInt();
        }

        // Récupération du nombre d'enfants
        System.out.println("Indiquez le nombre d'enfant(s) :");
        nbEnfant = sc.nextInt();

        // Calcul du Salaire brut
        if (nbHeuresEffectuees <= 169) {
            // Sans heure sup' (inférieur ou égal à 169 heures)
            salaireBrut = tauxHoraire * nbHeuresEffectuees;
        } else if (nbHeuresEffectuees <= 180) {
            // Heures sup' comprises entre 169 et 180 heures majorées à 50%
            salaireBrut = 169 * tauxHoraire + (nbHeuresEffectuees - 169)
                    * tauxHoraire * 1.5;
        } else {
            // Heures sup' supérieures à 180 heures majorées à 60%
            salaireBrut = 169 * tauxHoraire + (180 - 169) * tauxHoraire * 1.5
                    + (nbHeuresEffectuees - 180) * tauxHoraire * 1.6;
        }

        // Calcul des cotisations sociales
        cotisationsSociales = (salaireBrut * 0.0349) + (salaireBrut * 0.0615)
                + (salaireBrut * 0.0095) + (salaireBrut * 0.0844)
                + (salaireBrut * 0.0305) + (salaireBrut * 0.0381)
                + (salaireBrut * 0.0102);
        /*
         * Cette opération est factorisable : cotisationsSociales = salaireBrut
         * * (0.0349 + 0.0615 + 0.0095 + 0.0844 + 0.0305 + 0.0102) ou
         * cotisationsSociales = salaireBrut * 0.2691
         */


        // Calcul de la prime pour enfants
        if (nbEnfant == 1) {
            primeEnfant = 20;
        } else if (nbEnfant == 2) {
            primeEnfant = 50;
        } else if (nbEnfant > 2) {
            primeEnfant = 70 + 20 * (nbEnfant - 2);
        }

        // Calcul du salaire net
        salaireNet = salaireBrut - cotisationsSociales + primeEnfant;

        // Affichage du bulletin de salaire
        System.out.println();
        System.out.println();
        System.out
                .println("*******************************************************************************");
        System.out.println();
        System.out.println("                            BULLETIN DE SALAIRE");
        System.out.println();
        System.out
                .println("*******************************************************************************");
        System.out.println();
        System.out.println("                                 ETAT CIVIL");
        System.out.println();
        // Le nom, le prénom et le statut sont passés en majuscules
        // (toUpperCase)
        System.out.println(" NOM : " + nom.toUpperCase());
        System.out.println(" PRENOM : " + prenom.toUpperCase());
        System.out.println();
        System.out.println(" STATUT : " + statut.toUpperCase());
        System.out.println();
        System.out
                .println("*******************************************************************************");
        System.out.println();
        System.out.println(" Nombre d'heures effectuées : "
                + nbHeuresEffectuees);
        System.out.println(" Taux horaire : " + tauxHoraire);
        System.out.println();
        if (nbHeuresEffectuees > 169 && nbHeuresEffectuees <= 180) {
            System.out.println(" Heures supplémentaires majorées à 50% : "
                    + (nbHeuresEffectuees - 169));
        } else if (nbHeuresEffectuees > 180) {
            System.out.println(" Heures supplémentaires majorées à 50% : "
                    + (180 - 169));
            System.out.println(" Heures supplémentaires majorées à 60% : "
                    + (nbHeuresEffectuees - 180));
        }
        System.out
                .println("*******************************************************************************");
        System.out.println();
        System.out.println(" SALAIRE BRUT : " + salaireBrut + " euros");
        System.out.println();
        System.out
                .println("*******************************************************************************");
        System.out
                .println("                              COTISATIONS SOCIALES");
        System.out.println();
        System.out.println(" LIBELLE      |  TAUX  |  MONTANT");
        System.out.println("--------------|--------|----------");
        System.out
                .println(" CRDS/CSG     |  3.49% | " + (salaireBrut * 0.0349));
        System.out
                .println(" CSG          |  6.15% | " + (salaireBrut * 0.0615));
        System.out
                .println(" Ass. Maladie |  0.95% | " + (salaireBrut * 0.0095));
        System.out
                .println(" Ass. Vieil.  |  8.44% | " + (salaireBrut * 0.0844));
        System.out
                .println(" Ass. Chômage |  3.05% | " + (salaireBrut * 0.0305));
        System.out
                .println(" IRCEM        |  3.81% | " + (salaireBrut * 0.0381));
        System.out
                .println(" Cot. AGFF    |  1.02% | " + (salaireBrut * 0.0102));
        System.out.println();
        System.out.println(" TOTAL DES COTISATIONS : " + cotisationsSociales);
        System.out.println();

        if (nbEnfant > 0) {
            System.out
                    .println("*******************************************************************************");
            System.out.println();
            System.out.println("                                 PRIME ENFANT");
            System.out.println();
            System.out
                    .println("*******************************************************************************");
            System.out.println();

            System.out.println(" Nombre d'enfant(s) : " + nbEnfant);
            System.out.println();
            System.out.println(" MONTANT DE LA PRIME : " + primeEnfant);
            System.out.println();
        }

        System.out
                .println("*******************************************************************************");
        System.out.println(" SALAIRE NET : * " + salaireNet + " euros ");
        System.out
                .println("*******************************************************************************");

        //Fermeture du Scanner
        sc.close();
    }
}

