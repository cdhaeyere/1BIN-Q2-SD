/**
 * @author Corentin D'haeyere
 */
public class TestBal2 {

    public static void main(String[] args) {

        Bal2 bal;

        Etudiant nico = new Etudiant("nico", 'M');
        Etudiant sam = new Etudiant("sam", 'M');
        Etudiant marie = new Etudiant("marie", 'F');
        Etudiant jeanne = new Etudiant("jeanne", 'F');
        Etudiant hugo = new Etudiant("hugo", 'M');
        Etudiant lea = new Etudiant("lea", 'F');

        String listeAttendue = " nico sam marie jeanne";
        String listeAttendue2 = " nico sam hugo marie jeanne lea";
        System.out.println();


        System.out.println("Test1: ordre des ajouts : nico sam marie jeanne");
        bal = new Bal2();

        System.out.println("ajout nico");
        bal.ajouterEtudiant(nico);
        System.out.println(bal);

        System.out.println("ajout sam");
        bal.ajouterEtudiant(sam);
        System.out.println(bal);

        System.out.println("ajout marie");
        bal.ajouterEtudiant(marie);
        System.out.println(bal);

        System.out.println("ajout jeanne");
        bal.ajouterEtudiant(jeanne);
        System.out.println(bal);

        if(bal.toString().equals(listeAttendue))
            System.out.println("Test 1 ok");
        else {
            System.out.println("Test 1 ko");
            System.out.println("Revoyez votre methode!");
            return;
        }
        System.out.println();


        System.out.println("Test2 : ordre des ajouts : marie jeanne nico sam");

        bal = new Bal2();

        System.out.println("ajout marie");
        bal.ajouterEtudiant(marie);
        System.out.println(bal);

        System.out.println("ajout jeanne");
        bal.ajouterEtudiant(jeanne);
        System.out.println(bal);

        System.out.println("ajout nico");
        bal.ajouterEtudiant(nico);
        System.out.println(bal);

        System.out.println("ajout sam");
        bal.ajouterEtudiant(sam);
        System.out.println(bal);

        if(bal.toString().equals(listeAttendue))
            System.out.println("Test 2 ok");
        else {
            System.out.println("Test 2 ko");
            System.out.println("Revoyez votre methode!");
            return;
        }
        System.out.println();



        System.out.println("Test3: ordre des ajouts : nico marie sam jeanne");

        bal = new Bal2();

        System.out.println("ajout nico");
        bal.ajouterEtudiant(nico);
        System.out.println(bal);

        System.out.println("ajout marie");
        bal.ajouterEtudiant(marie);
        System.out.println(bal);

        System.out.println("ajout sam");
        bal.ajouterEtudiant(sam);
        System.out.println(bal);

        System.out.println("ajout jeanne");
        bal.ajouterEtudiant(jeanne);
        System.out.println(bal);

        if(bal.toString().equals(listeAttendue))
            System.out.println("Test 3 ok");
        else {
            System.out.println("Test 3 ko");
            System.out.println("Revoyez votre methode!");
            return;
        }
        System.out.println();

        System.out.println("Test4: ordre des ajouts : marie nico jeanne sam");
        bal = new Bal2();

        System.out.println("ajout marie");
        bal.ajouterEtudiant(marie);
        System.out.println(bal);

        System.out.println("ajout nico");
        bal.ajouterEtudiant(nico);
        System.out.println(bal);

        System.out.println("ajout jeanne");
        bal.ajouterEtudiant(jeanne);
        System.out.println(bal);

        System.out.println("ajout sam");
        bal.ajouterEtudiant(sam);
        System.out.println(bal);
        if(bal.toString().equals(listeAttendue))
            System.out.println("Test 4 ok");
        else {
            System.out.println("Test 4 ko");
            System.out.println("Revoyez votre methode!");
            return;
        }
        System.out.println();

        System.out.println("Test5 : ordre des ajouts : marie nico jeanne sam hugo lea");
        bal = new Bal2();

        System.out.println("ajout marie");
        bal.ajouterEtudiant(marie);
        System.out.println(bal);

        System.out.println("ajout nico");
        bal.ajouterEtudiant(nico);
        System.out.println(bal);

        System.out.println("ajout jeanne");
        bal.ajouterEtudiant(jeanne);
        System.out.println(bal);

        System.out.println("ajout sam");
        bal.ajouterEtudiant(sam);
        System.out.println(bal);

        System.out.println("ajout hugo");
        bal.ajouterEtudiant(hugo);
        System.out.println(bal);

        System.out.println("ajout lea");
        bal.ajouterEtudiant(lea);
        System.out.println(bal);

        if(bal.toString().equals(listeAttendue2))
            System.out.println("Test 5 ok");
        else {
            System.out.println("Test 5 ko");
            System.out.println("Revoyez votre methode!");
            return;
        }
        System.out.println();
        System.out.println("Tous les tests ont reussi!");
    }



}
