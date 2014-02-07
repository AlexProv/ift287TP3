package ligueBaseball;
import java.sql.*;

/**
 * La classe GestionLigueBaseball
 * @author Mathieu Lavoie, Alex Provencher et Vincent Gagnon
 *
 */
public class GestionLigueBaseball
{
public Connexion cx;
public Livre livre;
public Membre membre;
public Reservation reservation;
public GestionLivre gestionLivre;
public GestionMembre gestionMembre;
public GestionPret gestionPret;
public GestionReservation gestionReservation;
public GestionInterrogation gestionInterrogation;

/**
  * Ouvre une connexion avec la BD relationnelle et
  * alloue les gestionnaires de transactions et de tables.
  * <pre>
  * 
  * @param serveur SQL
  * @param bd nom de la bade de donn�es
  * @param user user id pour �tablir une connexion avec le serveur SQL
  * @param password mot de passe pour le user id
  *</pre>
  */
public GestionLigueBaseball(String serveur, String bd, String user, String password)
  throws BiblioException, SQLException
{
// allocation des objets pour le traitement des transactions
cx = new Connexion(serveur, bd, user, password);
livre = new Livre(cx);
membre = new Membre(cx);
reservation = new Reservation(cx);
gestionLivre = new GestionLivre(livre,reservation);
gestionMembre = new GestionMembre(membre,reservation);
gestionPret = new GestionPret(livre, membre, reservation);
gestionReservation = new GestionReservation(livre, membre, reservation);
gestionInterrogation = new GestionInterrogation(cx);
}

public void fermer()
  throws SQLException
{
// fermeture de la connexion
cx.fermer();
}
}
