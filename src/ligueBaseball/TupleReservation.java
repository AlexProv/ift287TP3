package biblioJDBC;
import java.sql.*;

/**
 * Permet de représenter un tuple de la table membre.
 * 
 * <pre>
 * Marc Frappier - 83 427 378
 * Université de Sherbrooke
 * version 2.0 - 13 novembre 2004
 * ift287 - exploitation de bases de données
 *
 *</pre>
*/

public class TupleReservation {

  public int    idReservation;
  public int    idLivre;
  public int    idMembre;
  public Date   dateReservation;
}
