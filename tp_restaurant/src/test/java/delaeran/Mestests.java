package delaeran;

import org.junit.Assert;
import org.junit.Test;

public class Mestests {

@Test
public void WhenCommandeCreatedCommandFromTableNotNull () throws Exception{
	systeme S = new systeme();
	carte c = new carte();
	table table = new table(0, null);
	S.gestionCommande(table,new plats(typePlat.Entree, "Salade", 3))
	Assert.assertTrue(table.commande!=null);
	}


@Test
public void ClientFromTableNot0WhenClientAreAffectedToTable() throws Exception{
		systeme S = new systeme();
	carte c = new carte();
	table table = new table(0, null);
	S.affecteTable(table, 1);
	Assert.assertTrue(table.nbClients!=0);
	}

}