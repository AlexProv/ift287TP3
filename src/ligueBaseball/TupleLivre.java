package biblioJDBC;
import java.sql.*;

/**
 * Permet de représenter un tuple de la table livre.
 * 
 * <pre>
 * Marc Frappier - 83 427 378
 * Université de Sherbrooke
 * version 2.0 - 13 novembre 2004
 * ift287 - exploitation de bases de données
 *
 *</pre>
*/

public class TupleLivre {

  public int    idLivre;
  public String titre;
  public String auteur;
  public Date   dateAcquisition;
  public int    idMembre;
  public boolean idMembreNull;
  public Date   datePret;
}
