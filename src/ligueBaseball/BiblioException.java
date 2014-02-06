package ligueBaseball;

/**
 * L'exception BiblioException est lev�e lorsqu'une transaction est inad�quate.
 * Par exemple -- livre inexistant
 */

public final class BiblioException extends Exception
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public BiblioException(String message)
{
super(message);
}
}