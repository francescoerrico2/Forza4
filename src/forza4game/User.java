package forza4game;
/**
 * Class that manages users,
 * Extended function from Forza4 class.
 * @param name contains the player's name
 * @param symbol contains the player's symbol
 * This class is implemented with the UserName interface
 * */

public class User extends Forza4 implements UserName {
	private String name;
	private String symbol;
	
	/**
	 * Constructor, assigns the data passed to the class.
	 * @param name
	 * @param symbol
	 */
	public User(String name, String symbol){
		this.name=name;
		this.symbol=symbol;
	}
	
	/**
	 * Check if the names of the two players are the same
	 * @param Name2 the name of the player2
	 * @return true if the two names are equal, false otherwise.
	 */
	public boolean checkName(String Name2) {
		return name.equals(Name2);
	}
	
	
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * @return the name
	 */
	public String toString() {
		return name;
		
	}
}
