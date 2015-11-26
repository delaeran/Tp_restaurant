
public class EtatTicketAEmporter implements EtatsTicket {

	public EtatTicketAEmporter(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	
	public void AjouterPlatTicket(plats p) {
		throw new IllegalStateException("Le ticket est � emporter, il n'y a rien � ajouter");

	}

	public void AjouterMenuTicket(menu m) {
		throw new IllegalStateException("Le ticket est � emporter, il n'y a rien � ajouter");
	}

	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket est � emporter, il n'y a rien � pas � le renvoyer");	
	}

	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est � emporter, il n'y a rien � pas � le re-pr�parer");	
		}

	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est d�j� � emporter, il n'y a rien � pas � le relancer");	
		}

	public void TicketEmporte() {
		ticket.setEtat(new EtatTicketEmporte(ticket));
	}


	private final ticket ticket;
}
