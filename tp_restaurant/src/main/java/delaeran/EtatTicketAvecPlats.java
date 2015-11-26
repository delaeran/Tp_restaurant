
public class EtatTicketAvecPlats implements EtatsTicket {
	
	public EtatTicketAvecPlats(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	public void AjouterPlatTicket(plats p) {
			ticket.getPlats().add(p);
	}

	public void EnvoyerTicket() {
		ticket.setEtat(new EtatTicketAttentePreparation(ticket));
		
	}
	
	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est n'a pas �t� envoy�, il n'y a rien � pr�parer");
	}
	
	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est n'a pas �t� envoy�, il n'y a rien � finir de pr�parer");
	}
	
	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est n'a pas �t� envoy�, il n'y a rien � emporter");
	}
	
	private final ticket ticket;
}
