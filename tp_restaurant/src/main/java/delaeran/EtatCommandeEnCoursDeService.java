
public class EtatCommandeEnCoursDeService implements EtatsCommande {

	public EtatCommandeEnCoursDeService(commande C) {
		if(null == C)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe a la banque qu'il represente");
		}
		this.commande=C;
	}
	
	
	@Override
	public void AjouterPlatCommande(plats P) {
		throw new IllegalStateException("La commande est en service, on ne peut lui ajouter de plats");
	}

	@Override
	public void AjouterMenuCommande(menu M) {
			throw new IllegalStateException("La commande est en service, on ne peut lui ajouter de menus");
		
	}

	@Override
	public void PrixCommande() {
		int prixtotal=0;
		for (int i = 0; i<commande.getMenus().size();i++)
		{
			System.out.println("menu "+ commande.getMenus().get(i).nom +" à "+commande.getMenus().get(i).prix +"€");
			prixtotal = prixtotal + commande.getMenus().get(i).prix;
		}
		for (int j = 0; j<commande.getPlats().size();j++)
		{
			System.out.println("plat "+ commande.getPlats().get(j).nom +" à "+commande.getPlats().get(j).prix +"€");
			prixtotal = prixtotal + commande.getPlats().get(j).prix;
		}
		System.out.println("prix total " + prixtotal + "€");
	}


	@Override
	public void CommandeEnRemplissage() {
		throw new IllegalStateException("La commande est en service, on ne peut lui ajouter de menus ou de plats");
		
	}

	@Override
	public void CommandePrête() {
		throw new IllegalStateException("La commande est en service");
		
	}

	@Override
	public void CommandeEnCoursDeService() {		
	}

	@Override
	public void CommandeServie() {
		commande.setEtat(new EtatCommandeFacturée(commande));
		
	}

	public void PréparationTicket() {
		throw new IllegalStateException("La commande est en service, on ne peut la repréparer");
		
	}

	public void ConsultationTicketAServir() {
		System.out.println("Ticket En attente de préparation sur la table\n");
		for (int i = 0;i<this.commande.getTicket().size(); i++ ){
			
			ticket temp = this.commande.getTicket().get(i);
			String[] parts = temp.getEtat().toString().split("@");
			String etat = parts[0];
			if (etat.equals("EtatTicketAvecPlats") || etat.equals("EtatAttentePrepation")){
				temp.descripticket();
			}
		}		
	}
	
	private final commande commande;
		
	}


