
public interface EtatsCommande  {

	public void AjouterPlatCommande(plats P);
	
	public void AjouterMenuCommande(menu M);

	public void PrixCommande();
	
	public void Pr�parationTicket();
	
	public void ConsultationTicketAServir();

	public void CommandeEnRemplissage();
	
	public void CommandePr�te();

	public void CommandeEnCoursDeService();
	
	public void CommandeServie();
	
}
