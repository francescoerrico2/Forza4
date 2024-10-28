package forza4game;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class deals with the grid. It is able to create it, print it, 
 * insert symbols, make various checks, and finally return the values.
 * Is an extension of the Forza4 class.
 * @param Grid is the grid made up of 6 rows and 7 columns
 * @param position would be the positions occupied in the column.
 */

public class Grid extends Forza4 {
	protected static String[][] Grid=new String[6][7];
	int[] position= {5,5,5,5,5,5,5};
	
	
	
	/**
	 * This method creates the grid by inserting blank spaces
	 * @return the Grid.
	 */
	public String[][] newGrid(){
		
		for(int i=0;i<6;i++) {
			
			for(int j=0;j<7;j++) {
				Grid[i][j]=" ";
			}
		}
		
		return Grid;
	}
	
	
	/**
	 * it is a function that prints the grid.
	 * @throws IOException
	 */
	
	public void printGrid() throws IOException{
		System.out.println();
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<7;j++) {
				if (j==6) {
					if (Grid[i][j]=="X")System.out.println(" |"+"X"+" |");
					
					else if(Grid[i][j]=="O")System.out.print(" |"+"O"+" |");
					else  System.out.print(" |"+Grid[i][j]+" |");
				}
				else {
					if (Grid[i][j]=="X")System.out.print(" |"+"X");
					else if(Grid[i][j]=="O")System.out.print(" |"+"O");
					else System.out.print(" |"+Grid[i][j]);
				}
			}
			System.out.println();
		}
		

	}
	
	
	/**
	 * Insert sibles into the grid and 
	 * check if the column is full.
	 * @param symbol user symbol
	 * @param f column where to insert the symbol
	 */
	
	public void insert(String symbol,int f) {
		f=f-1;
		int r=position[f];
		if (r>=0 && Grid[r][f]==" ") {
			Grid[r][f]=symbol;
			position[f]--;
		}
		else {
			System.out.println("Fila piena");
		}
		return;
	}
	
	
	/**
	 * Check if the row taken as input is a number and if it is covered between 1 and 7.
	 * If one of the two is false, it takes a new string as input and  performs the check again.
	 * @param st initial input string
	 * @return the correct number in case of corrections or the string transformed into a number.
	 */
	
	public int checkPosition(String st) {
		int f=1;
		String p;
		Scanner in=new Scanner(System.in);
		try {
			while(true) {
			 f=Integer.valueOf(st);
			 if (f>=0&&f<=7) {
					break;}
				else {
					System.out.println("Devi inserire una Fila tra 0 e 7 ");
					st=in.next();
					}}
		}
		catch(Exception e){
			System.out.println("Attenzione devi inserire un numero: ");
			while(true) {
			p=in.next();
			
			try {
				f=Integer.valueOf(p);
				if (f>=0&&f<=7) {
					
					break;}
				else {
					System.out.println("Devi inserire una Fila tra 0 e 7 ");
					f=in.nextInt();
					
				}
				}
			catch(Exception e1) {
				System.out.println("Attenzione devi inserire un numero: ");
			}
			
			}
			}
		
		
		return f;
		
	}
	
	
	/**
	 * Import a previously saved grid.
	 * @param Grid grid to import
	 */
	
	public void insertGrid(String[][] Grid) {
		this.Grid=Grid;
	}
	
	/**
	 * Imports previously saved column positions.
	 * @param Position position to import.
	 */
	
	public void insertPosition(int[] Position) {
		this.position=Position;
	}
	
	/**
	 * @return the grid returns
	 */
	
	public String[][] getGrid() {
		return Grid;
	}
	
	/**
	 * @return the positions returns
	 */
	
	public int[] getPosition() {
		return position;
	}
	

}