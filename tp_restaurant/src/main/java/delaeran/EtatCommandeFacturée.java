
public class EtatCommandeFactur�e implements EtatsCommande  {

	public EtatCommandeFactur�e(commande C) {
		if(null == C)
		{
            throw new IllegalArgumentException("L'etat d'une commande est necessairement associe a la commande qu'il represente");
		}
		this.commande=C;
	}
	
	
	@Override
	public void AjouterPlatCommande(plats P) {
		throw new IllegalArgumentException("La commande a �t� factur�e");
		
	}

	@Override
	public void AjouterMenuCommande(menu M) {
		throw new IllegalArgumentException("La commande a �t� factur�e");	}

	@Override
	public void PrixCommande() {
		int prixtotal=0;
		for (int i = 0; i<this.commande.getMenus().size();i++)
		{
			System.out.println("menu "+ this.commande.getMenus().get(i).nom +" � "+this.commande.getMenus().get(i).prix +"�");
			prixtotal = prixtotal + this.commande.getMenus().get(i).prix;
		}
		for (int j = 0; j<commande.getPlats().size();j++)
		{
			System.out.println("plat "+ this.commande.getPlats().get(j).nom +" � "+this.commande.getPlats().get(j).prix +"�");
			prixtotal = prixtotal + this.commande.getPlats().get(j).prix;
		}
		System.out.println("prix total " + prixtotal + "�");
	}

	public void CommandeEnRemplissage() {
		throw new IllegalArgumentException("La commande a �t� factur�e");		
	}

	public void CommandePr�te() {
		throw new IllegalArgumentException("La commande a �t� factur�e");		
	}

	public void CommandeEnCoursDeService() {
		throw new IllegalArgumentException("La commande a �t� factur�e");		
	}


	public void CommandeServie() {
		throw new IllegalArgumentException("La commande a �t� factur�e");
	}
	

	public void Pr�parationTicket() {
		throw new IllegalArgumentException("La commande a �t� factur�e");	
	}


	public void ConsultationTicketAServir() {
		System.out.println("Ticket En attente de pr�paration sur la table\n");
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
