package forza4game;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
*Main class capable of starting the game, 
*playing, saving and loading a game
*/

public class Forza4 {
	/**
	 * Main class that starts the game
	 * @throws IOException in case it does not find the Force 4 function
	 */
	public static void main(String[] args) throws IOException {
		Forza4();
	}


	/**
	 * function that opens the main menu, creates users, 
	 * grids and starts the game;
	 * @throws IOException
	 */
	public static void Forza4()  throws IOException {
		//creation of the menu and start
		Menu menu=new Menu();
		menu.getMenu();
		//user and grid creation
		Scanner in=new Scanner(System.in);
		Scanner in2=new Scanner(System.in);
		System.out.println("Inserisci il Nome del primo Giocatore: ");
		String name=in.nextLine();
		System.out.println("Inserisci il Simbolo di "+name+" è: X ");
		User user1=new User(name,"X");
		System.out.println();
		boolean checkname=false;
		System.out.println("Inserisci il Nome del secondo Giocatore: ");
		String name1=in2.nextLine();
		while(!checkname) {
		if(user1.checkName(name1) ) {
			System.out.println("Il nome inserito è gia in uso, inserisci uno nuovo: ");
			 name1=in2.nextLine();}
		else checkname=true;
		}
		System.out.println("Il Simbolo di "+name1+" è: O ");
		User user2=new User(name1,"O");
		System.out.flush();
		Grid grid=new Grid();
		grid.newGrid();
		// start the game
		System.out.println();
		game(grid,user1,user2,menu);
		System.out.println();
		// end game menu
	    menu.getpostGame();
	}
	
	
	/**
	 * game function, takes the number of the row as input and manages
	 * the players by alternating them, inserting the symbols in the appropriate grid. 
	 * Also check if it is a draw or a win and you can reset the break.
	 * @param Grid would be the grill
	 * @param user1 user number 1
	 * @param user2 user number 3
	 * @param menu would be the menu
	 */
	public static void game(Grid grid,User user1,User user2,Menu menu) throws IOException {
		String st;
		int fi;
		Scanner in=new Scanner(System.in);
		CheckWin check= new CheckWin();
		//cycle until someone wins or there is a tie
		while(!check.win()&&!check.equal()) 
		{ 
	    	System.out.flush();
	    	grid.printGrid();
	    	//insertion of user 1 symbol in the row
	    	System.out.println("E' il turno di "+user1.toString()+" inserisci numero fila (premi 0 per mettere in pausa): ");
	    	st=in.next();
	    	//row number check inserted
	    	fi=grid.checkPosition(st);
	    	while(fi==0) {
	    	    if(menu.getPause()==2) Save(grid,user1,user2);
	    		System.out.flush();
	    		System.out.println("E' il turno di "+user1.toString()+" inserisci numero fila (premi 0 per mettere in pausa): ");
		    	st=in.next();
		    	fi=grid.checkPosition(st);
	    	}
	    	//inserts the symbol into the grid
	    	grid.insert(user1.getSymbol(),fi);
	    	grid.printGrid();
	    	//check if there is a win or a tie
	    	if(check.win()||check.equal()) {
	    		System.out.println(user1.toString()+" HA VINTO!!!");
	    		break;
	    		}
	    	//insertion of user 1 symbol in the row
	    	System.out.println("E' il turno di "+user2.toString()+" inserisci numero fila (premi 0 per mettere in pausa): ");
	    	st=in.next();
	    	//row number check inserted
	    	fi=grid.checkPosition(st);
	    	while(fi==0) {
	    		if(menu.getPause()==2) Save(grid,user1,user2);
	    		System.out.flush();
	    		System.out.println("E' il turno di "+user2.toString()+" inserisci numero fila (premi 0 per mettere in pausa): ");
	    		st=in.next();
		    	fi=grid.checkPosition(st);
	    	}
	    	//inserts the symbol into the grid
	    	grid.insert(user2.getSymbol(),fi);
	    	//check if there is a win or a tie
	    	if(check.win()||check.equal()) {
	    		System.out.println(user2.toString()+" HA VINTO!!!");
	    		break;
	    	}
	    	
	    }
	    
	}
	
	
	
	
	/**
	 * function that saves the game data to a file
	 * with the F4G extension in the same directory as the program.
	 * @param grid
	 * @param user1 
	 * @param user2
	 * @throws IOException
	 */
	public static void Save(Grid grid,User user1,User user2) throws IOException {
		String[][] sgrid;
		int[] sp;
		String name1,name2;
		sgrid=grid.getGrid();
		sp=grid.getPosition();
		name1=user1.toString();
		name2=user2.toString();
		Scanner in= new Scanner(System.in);
		System.out.println("Con che nome vuoi salvare la partita? ");
		String sname=in.nextLine()+".f4g";
		//creates file with name taken in input and extension f4g
		File file = new File(sname);
		if (file.exists())
		System.out.println("Il file " + sname + " esiste, verra sovrascritto! ");
		file.createNewFile();
		
		FileWriter bw = new FileWriter(file);
		BufferedWriter fw= new BufferedWriter (bw);
		//inserts the data into the file
		for(int i=0;i<6;i++) {
			
			for(int j=0;j<7;j++) {
				fw.write(sgrid[i][j]);
			}
			fw.write("\n");
		}
		for(int i=0;i<7;i++) {
			
			String b=String.valueOf((sp[i]));
			fw.write(b);
		}
		fw.write("\n");
		fw.write(name1);
		fw.write("\n");
		fw.write(name2);
		fw.close();		
		System.out.flush();
		System.out.println("Il file "+sname+" è stato salvato!");
		//exits the game
		Forza4();
		
	}
	

	/**
	 * function that reads the data saved on F4G file, 
	 * able to restart the previously saved game.
	 * @throws IOException
	 */
	public static void Load() throws IOException {
		//load the file data into the game
		Grid grid=new Grid();
		String[][] ngrid = grid.newGrid();
		int[] p=new int[7];
		String name1="",name2="";
		int next,j=0,i=0,n=0;
		File folder=new File(System.getProperty("user.dir"));
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()&& file.getName().substring(file.getName().length()-4).equals(".f4g")) 
			{
				System.out.println(file.getName().substring(0,file.getName().length()-4));
			}
		}
		Scanner in=new Scanner(System.in);
		System.out.println("Inserisci il nome della partita da caricare: ");
		String namef=in.nextLine()+".f4g";
		File log=new File(namef);
		try (BufferedReader reader = new BufferedReader(new FileReader(log))){
			int count=0;
			 do {
	                next = reader.read(); 
	                char nextc = (char) next;
	                
	                if (i<6) {
	                	if(j<7) {
	                    if (nextc!=' '){
	                    	if(nextc=='X')ngrid[i][j]="X";
	                    	else ngrid[i][j]="O";
	                    }
	                    
	                    j++;
	                	}
	                	else {
	                		j=0;
	                		i++;
	                	}
	                }
	                else if (i>=6 && count<7&&nextc!=10) {
	                	
	                	p[count]=Character.getNumericValue(nextc);
	                	count++;
	                }
	                if (count>=7) {
	                	if (nextc==10)n++;
	                	if (n<2) name1+=nextc;
	                	else name2+=nextc;
	                }
	                
	                

	            } while (next != -1);
			 reader.close();			
			 //delete the file of the player's choice and start the loaded game
			 System.out.println("Partita Caricata, Premi 1 per Eliminare il File: ");
			 Scanner in2=new Scanner(System.in);
			 try{
				 int r=in2.nextInt();
			 
			 if(r==1) {
			 String path = log.getCanonicalPath();
			 File filePath = new File(path);
			 if(filePath.delete()) System.out.println("Eliminato!");
			 }
			 }
			 catch(Exception e) {
				 System.out.println("Il File non è stato eliminato!");
			 }
			 grid.insertGrid(ngrid);
			 grid.insertPosition(p);
			 name1=name1.substring(1,name1.length());
			 name1=name1.replace("\n","");
			 name2=name2.substring(1,name2.length()-1);
			 name2=name2.replace("\n","");
			 User user1= new User(name1,"X");
			 User user2= new User(name2,"O");
			 Menu menu=new Menu();
			 game(grid,user1,user2,menu);
			 System.out.flush();
			 menu.getpostGame();
		} catch (FileNotFoundException e) {
			System.out.println("File non trovato!");
			
		}
	}
	
	
}