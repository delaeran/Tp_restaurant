
public class EtatTicketEnPreparation implements EtatsTicket {

	public EtatTicketEnPreparation(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	public void AjouterPlatTicket(plats p) {
		throw new IllegalStateException("Le ticket est en pr�paration, il n'y a rien � ajouter");

	}

	public void AjouterMenuTicket(menu m) {
		throw new IllegalStateException("Le ticket est en pr�paration, il n'y a rien � ajouter");
	}

	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket est en pr�paration, il n'y a rien � pas � le renvoyer");	
	}

	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est d�j� en pr�paration, il n'y a rien � pas � le re-pr�parer");	
		}

	public void FinPreparationTicket() {
		ticket.setEtat(new EtatTicketAEmporter(ticket));
			}

	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est en pr�paration, il ne peut pas �tre emport�");
	}

	
	private final ticket ticket;
}
