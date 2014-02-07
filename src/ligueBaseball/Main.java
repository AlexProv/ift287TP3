package ligueBaseball;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class Main {
	private static GestionLigueBaseball gestionLigue;
	private static boolean lectureAuClavier;
	public static BufferedReader cin = new BufferedReader(
			new InputStreamReader(System.in));
	public static void main(String[] args) {
		// validation du nombre de paramètres
				if (args.length < 3) {
					System.out.println("Usage: java ligueBaseball.Main <userId> <motDePasse> <baseDeDonnees> [<fichier-entree>]");
					System.out.println(Connexion.serveursSupportes());
					return;
				}

				try {
					lectureAuClavier = true;
					InputStream sourceTransaction = System.in;
					if (args.length > 3) {
						sourceTransaction = new FileInputStream(args[3]);
						lectureAuClavier = false;
					}
					BufferedReader reader = new BufferedReader(new InputStreamReader(
							sourceTransaction));

					gestionLigue = new GestionLigueBaseball("postgres", args[0], args[1], args[2]);
					traiterTransactions(reader);
				} catch (Exception e) {
					e.printStackTrace(System.out);
				} finally {
					try {
						gestionLigue.fermer();
					} catch (SQLException e) {
						e.printStackTrace(System.out);
					}
				}
	}
	/**
	 * Traitement des transactions de la bibliotheque
	 */
	static void traiterTransactions(BufferedReader reader) throws Exception {
		afficherAide();
		String transaction = lireTransaction(reader);
		while (!finTransaction(transaction)) {
			/* decoupage de la transaction en mots */
			StringTokenizer tokenizer = new StringTokenizer(transaction, " ");
			if (tokenizer.hasMoreTokens())
				executerTransaction(tokenizer);
			transaction = lireTransaction(reader);
		}
	}

	/**
	 * Lecture d'une transaction
	 */
	static String lireTransaction(BufferedReader reader) throws IOException {
		System.out.print("> ");
		String transaction = reader.readLine();
		/* echo si lecture dans un fichier */
		if (!lectureAuClavier)
			System.out.println(transaction);
		return transaction;
	}
	
	static void executerTransaction(StringTokenizer tokenizer){
		
	}

	/**
	 * La methode afficherAide sert a afficher l'aide pour les personnes qui ne seraient pas les options.
	 */
	static void afficherAide() {
	}
	

	static boolean finTransaction(String transaction) {
		/* fin de fichier atteinte */
		if (transaction == null)
			return true;

		StringTokenizer tokenizer = new StringTokenizer(transaction, " ");

		/* ligne ne contenant que des espaces */
		if (!tokenizer.hasMoreTokens())
			return false;

		/* commande "exit" */
		String commande = tokenizer.nextToken();
		if (commande.equals("exit"))
			return true;
		else
			return false;
	}

}
