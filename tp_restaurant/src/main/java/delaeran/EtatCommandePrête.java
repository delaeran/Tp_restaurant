
public class EtatCommandePr�te implements EtatsCommande  {

	public EtatCommandePr�te(commande C) {
		if(null == C)
		{
            throw new IllegalArgumentException("L'etat d'une commande est necessairement associe a la commande qu'il represente");
		}
		this.commande=C;
	}
	
	
	@Override
	public void AjouterPlatCommande(plats P) {
		throw new IllegalArgumentException("La commande est pr�te, on n'a plus de plats � y ajouter");
	}

	@Override
	public void AjouterMenuCommande(menu M) {		
		throw new IllegalArgumentException("La commande est pr�te, on n'a plus de menus � y ajouter");
	}

	@Override
	public void PrixCommande() {
		int prixtotal=0;
		for (int i = 0; i<commande.getMenus().size();i++)
		{
			prixtotal = prixtotal + commande.getMenus().get(i).prix;
		}
		for (int j = 0; j<commande.getPlats().size();j++)
		{
			prixtotal = prixtotal + commande.getPlats().get(j).prix;
		}
	}

	@Override
	public void CommandeEnRemplissage() {
		throw new IllegalArgumentException("La commande est pr�te, elle est d�j� remplie");
		
	}

	@Override
	public void CommandePr�te() {
			throw new IllegalArgumentException("La commande est d�j� pr�te");
		
	}

	@Override
	public void CommandeEnCoursDeService() {
		commande.setEtat(new EtatCommandeEnCoursDeService(commande));
		
	}

	@Override
	public void CommandeServie() {
		throw new IllegalArgumentException("La commande est d�j� pr�te, mais elle n'est pas encore servie");
		
	}

	@Override
	public void Pr�parationTicket() {
		throw new IllegalArgumentException("La commande est d�j� pr�te, elle a d�j� �t� pr�par�e");
		
	}


	@Override
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
