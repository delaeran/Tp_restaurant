public class EtatTicketCree implements EtatsTicket {

	public EtatTicketCree(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	public void AjouterPlatTicket(plats p) {
		ticket.getPlats().add(p);
		ticket.setEtat(new EtatTicketAvecPlats(ticket));
	}

	
	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket est vide, il n'y a rien � envoyer");
	}
	
	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est vide, il n'y a rien � pr�parer");
	}
	
	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est vide, il n'y a rien � finir de pr�parer");
	}
	
	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est vide, il n'y a rien � emporter");
	}
	
	private final ticket ticket;
}
