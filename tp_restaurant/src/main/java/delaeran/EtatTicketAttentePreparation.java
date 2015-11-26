
public class EtatTicketAttentePreparation implements EtatsTicket {

	public EtatTicketAttentePreparation(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	public void AjouterPlatTicket(plats p) {
		throw new IllegalStateException("Le ticket a �t� envoy�, il n'y a rien � ajouter");

	}

	public void AjouterMenuTicket(menu m) {
		throw new IllegalStateException("Le ticket a �t� envoy�, il n'y a rien � ajouter");
	}

	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket a d�j� �t� envoy�, il n'y a rien � pas � le renvoyer");	
	}

	public void PreparationTicket() {
		ticket.setEtat(new EtatTicketEnPreparation(ticket));
	}

	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est n'est pas en pr�paration, il vient juste d'�tre envoy�");
	}

	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est n'est pas � emporter, il vient juste d'�tre envoy�");
	}

	private final ticket ticket;
}
