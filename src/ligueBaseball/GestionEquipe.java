package ligueBaseball;
import java.sql.*;
import java.util.List;

/**
 * 
 * @author Mathieu Lavoie, Alex Provencher et Vincent Gagnon
 *
 */
public class GestionEquipe {

private Equipe equipe;
private Connexion cx;

/**
  * Creation d'une instance
  */
public GestionEquipe(Equipe equipe) throws LigueBaseballException
{
this.cx = equipe.getConnexion();
this.equipe = equipe;
}

/**
  * Ajout d'une nouvelle equipe dans la base de donnees.
  * S'il existe deja, une exception est levee.
  */
public void ajout(int equipeId, int terrainId, String equipeNom)
  throws SQLException, LigueBaseballException, Exception
{
try {
    if (equipe.existe(equipeNom))
        throw new LigueBaseballException("Equipe existe deja: " + equipeId);
    
    equipe.ajoutEquipe(equipeId, terrainId, equipeNom);
    cx.commit();
    }
catch (Exception e)
    {
//        System.out.println(e);
    cx.rollback();
    throw e;
    }
}

/**
  * Vente d'un livre.
  */
public void supprimer(String equipeNom)
  throws SQLException, LigueBaseballException, Exception
{
try {
    boolean exister = equipe.existe(equipeNom);
    if (exister == false)
        throw new LigueBaseballException("Equipe inexistante: " + equipeNom);
    
    /* Suppression du livre. */
    int nb = equipe.suppressionEquipe(equipeNom);
    if (nb == 0)
        throw new LigueBaseballException
        ("Livre " + equipeNom + " inexistant");
    cx.commit();
    }
catch (Exception e)
    {
    cx.rollback();
    throw e;
    }
}

public void getEquipes(){
	try {
		List<TupleEquipe> listEquipes = equipe.getEquipes();
		for (TupleEquipe tupleEquipe : listEquipes) {
			System.out.println(tupleEquipe.equipeid + "\t" + tupleEquipe.equipenom);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
