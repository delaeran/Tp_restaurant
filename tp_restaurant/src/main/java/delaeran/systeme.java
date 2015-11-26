import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class systeme {

	public carte carte;

	public List<table> listable = new ArrayList<table>();

	public void demandecarte() {
		this.carte.constructioncarte();
	}

	public void ajoutcarte(carte c) {
		this.carte = c;
	}

	public void affecteTable(int numtable, int nbClient) {

		if (this.listable.get(numtable - 1).nbClients == 0) {
			this.listable.get(numtable - 1).nbClients = nbClient;
			System.out.println(this.listable.get(numtable - 1).nbClients
					+ " client(s) ont �t� affect� la table " + numtable);
		} else if (nbClient == 0) {
			this.listable.get(numtable - 1).nbClients = nbClient;
			System.out.println("table lib�r�e");
		} else {
			System.out
					.println("Des clients sont d�j� pr�sent � cette table. Affectation annul�e.");
		}

	}

	// d�calez vers les autres fonctions de classes, qu'on n'ait pas un systeme
	// tout puissant.
	public void gestionCommande(table t, menu m) {
		if (t.commande == null) {
			t.creerCommande();
		}
		t.ajoutMenu(m);

	}

	public void gestionCommande(table t, plats p) {
		if (t.commande == null) {
			t.creerCommande();
		}
		t.ajoutPlat(p);
	}

	public void preparationCommande() {

	}

	public static void main(String[] args) {
		// proc�dure de cr�ation du systeme
		systeme S = new systeme();
		carte c = new carte();
		menu m1 = new menu("Etudiant", 6);

		// ajout de quelques plats � la carte
		c.ajoutplat(new plats(typePlat.Entree, "Salade", 3));
		c.ajoutplat(new plats(typePlat.PlatPrincipal, "steak-frite", 4));
		c.ajoutplat(new plats(typePlat.Dessert, "glace", 3));
		c.ajoutplat(new plats(typePlat.PlatPrincipal, "kebab", 3));
		c.ajoutplat(new plats(typePlat.Dessert, "gaufre", 5));
		c.ajoutplat(new plats(typePlat.Boisson, "ice tea", 2));
		c.ajoutplat(new plats(typePlat.Boisson, "coca", 2));

		// ajout des plats � un menu
		m1.ajoutplat(new plats(typePlat.Entree, "Salade", 3));
		m1.ajoutplat(new plats(typePlat.PlatPrincipal, "steak-frite", 4));
		m1.ajoutplat(new plats(typePlat.Dessert, "gaufre", 5));
		c.ajoutmenu(m1);

		// ajout de table aux systeme
		table table1 = new table(0, null);
		table table2 = new table(0, null);
		table table3 = new table(0, null);
		S.listable.add(table1);
		S.listable.add(table2);
		S.listable.add(table3);
		S.ajoutcarte(c);

		List<ticket> listeticketenvoy� = new ArrayList<ticket>(); // pile des
																	// ticket en
																	// attente
																	// dans la
																	// cuisine
		List<ticket> listeticketaservir = new ArrayList<ticket>(); // pile des
																	// ticket en
																	// attente
																	// de
																	// service
		System.out.println("\nInterface de gestion de commande 1.0");
		boolean fin = false;
		Scanner sc;
		sc = new Scanner(System.in);
		while (!fin) {
			
			System.out.println("s�lectionnez la commande que vous souhaitez ex�cuter");
			System.out.println("1) Afficher carte");
			System.out.println("2) Affecter table");
			System.out.println("3) Prendre la commande d'une table");
			System.out.println("4) Pr�parer les tickets d'une table");
			System.out.println("5) Envoyer le(s) ticket(s) d'une table");
			System.out.println("6) Cuisine: pr�paration les tickets envoy�");
			System.out.println("7) Service: Service des Ticket pr�par�");
			System.out
					.println("8) Consultation des tickets encore en attente d'une table");
			System.out.println("9) Paiement");
			System.out.println("10) d�connexion");

			System.out.println("Entrez votre choix");

			int choix = sc.nextInt();
			switch (choix) {

			case 1:
				S.demandecarte();
				System.out.println("\n");
				break;
			case 2:
				System.out.println(S.listable.size() + " tables enregistr�es");
				System.out
						.println("\nquelle table est � affecter/d�saffecter ?");
				int numtable = sc.nextInt();
				System.out.println("combien de clients ?");
				int nbclient = sc.nextInt();
				S.affecteTable(numtable, nbclient);
				break;

			case 3:
				System.out.println("entrez le numero de table � g�rer");
				int numtable2 = sc.nextInt();
				table temp = S.listable.get(numtable2 - 1);
				System.out
						.println("procedure d'ajout. entrez 0 pour finir, 1 pour ajouter un menu, et 2 pour ajouter un plat");
				int choixajout = sc.nextInt();
				while (choixajout != 0) {
					if (choixajout == 1) {
						S.carte.listemenu();
						System.out
								.println("Choisissez le num�ro du menu � ajouter � la commande");
						int select = sc.nextInt();
						menu majout = S.carte.m.get(select);
						S.gestionCommande(temp, majout);
					} else if (choixajout == 2) {
						S.carte.listeplats();
						;
						System.out
								.println("Choisissez le num�ro du plat � ajouter � la commande");
						int select2 = sc.nextInt();
						plats plajout = S.carte.p.get(select2);
						S.gestionCommande(temp, plajout);
					}
					System.out
							.println("choix ajout�. entrez 0 pour finir, 1 pour ajouter un menu, et 2 pour ajouter un plat");
					choixajout = sc.nextInt();
				}
				System.out.println("\n la commande est compos� de:");
				temp.commande.listemenu();
				temp.commande.listeplat();
				break;

			case 4:
				System.out.println("entrez le numero de table � g�rer");
				int numtabe2 = sc.nextInt();
				table tempp = S.listable.get(numtabe2 - 1);
				if (tempp.commande != null) {
					tempp.commande.PreparationTicket();
				} else {
					System.out.println("Aucune commande affect� � la table");
				}

				break;

			case 5:
				System.out
						.println("entrez le numero de table dont il faut envoyer les tickets");
				numtabe2 = sc.nextInt();
				tempp = S.listable.get(numtabe2 - 1);
				System.out
						.println("Affichage de le liste des tickets de la table");
				if (tempp.commande.getTicket().size() == 0
						|| tempp.commande == null) {

					System.out.println("La table n'a pas de ticket � envoyer");
				} else {

					for (int j = 0; j < tempp.commande.getTicket().size(); j++) {
						ticket tickettemp = tempp.commande.getTicket().get(j);
						String[] parts = tickettemp.getEtat().toString()
								.split("@");
						String etat = parts[0];
						if (etat.equals("EtatTicketAvecPlats")
								|| etat.equals("EtatAttentePrepation")) {
							System.out.println("\nticket n�" + j);
							tickettemp.descripticket();
						}
					}
					System.out
							.println("entrez le numero du ticket � envoyer\n");
					numtabe2 = sc.nextInt();
					tempp.commande.getTicket().get(numtabe2).getEtat()
							.EnvoyerTicket();
					listeticketenvoy�.add(tempp.commande.getTicket().get(
							numtabe2));
					System.out.println("\n ticket envoy�");
					tempp.commande.getEtat().CommandeEnCoursDeService();
				}
				break;

			case 6:
				if (listeticketenvoy�.size() == 0) {
					System.out.println("aucun ticket � emporter");
				} else {
					System.out.println("liste des tickets � faire en cuisine");
					for (int i = 0; i < listeticketenvoy�.size(); i++) {

						System.out.println("ticket n�" + i);
						listeticketenvoy�.get(i).descripticket();
						System.out.println("\n");
					}

					System.out
							.println("entrez le numero du ticket pris en charge");
					int numtic = sc.nextInt();
					listeticketenvoy�.get(numtic).getEtat().PreparationTicket();
					System.out
							.println("Preparation du ticket. Entrez \"ok\" une fois le ticket pr�t � �tre emport�\n");
					String attentefin = sc.next();
					listeticketenvoy�.get(numtic).getEtat()
							.FinPreparationTicket();
					listeticketaservir.add(listeticketenvoy�.get(numtic));
					listeticketenvoy�.remove(numtic);
				}
				break;

			case 7:
				if (listeticketaservir.size() == 0) {
					System.out.println("aucun ticket � emporter");
				} else {

					for (int i = 0; i < listeticketaservir.size(); i++) { // listing
																			// des
																			// ticket
																			// �
																			// servir
						System.out.println("ticket n�" + i);
						listeticketaservir.get(i).descripticket();
					}
					System.out.println("entrez le numero du ticket emport�");
					int numticc = sc.nextInt();
					listeticketaservir.get(numticc).getEtat().TicketEmporte();
					listeticketaservir.remove(numticc);
				}
				break;

			case 8:
				System.out.println("entrez le numero de table � consulter");
				numtabe2 = sc.nextInt();
				tempp = S.listable.get(numtabe2 - 1);
				tempp.commande.ConsultationTicket();
				break;

			case 9:

				System.out.println("entrez le numero de table � facturer");
				numtabe2 = sc.nextInt();
				tempp = S.listable.get(numtabe2 - 1);
				tempp.commande.getEtat().CommandeServie();
				tempp.commande.getEtat().PrixCommande();
				tempp.commande = null; // on lib�re la table de sa commande
										// pr�c�dente
				break;

			case 10:
				fin = true;
				break;
			}
		}
		sc.close();
	}
}
