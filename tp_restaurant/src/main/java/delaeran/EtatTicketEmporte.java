
public class EtatTicketEmporte implements EtatsTicket {

	public EtatTicketEmporte(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	
	public void AjouterPlatTicket(plats p) {
		throw new IllegalStateException("Le ticket est emport�, il n'y a rien � ajouter");

	}

	public void AjouterMenuTicket(menu m) {
		throw new IllegalStateException("Le ticket est emport�, il n'y a rien � ajouter");
	}

	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket est emport�, il n'y a rien � pas � le renvoyer");	
	}

	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est emport�, il n'y a rien � pas � le re-pr�parer");	
		}

	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est emport�, il n'y a rien � pas � le relancer");	
		}

	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est d�j� emport�, il n'y a rien � pas � l'emporter de nouveau");	
		}


	@SuppressWarnings("unused")
	private final ticket ticket;
}
