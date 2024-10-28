package forza4game;
import java.io.IOException;
import java.util.Scanner;
/**
 * This class manages the various menus and menu options.
 * Extended function from Forza4 class.
 */
public class Menu extends Forza4 {
	
	/*
	 * Main menu function, it would be the start menu
	 */
	
	public void getMenu() throws IOException {
		String input;
		Scanner in=new Scanner(System.in);
		System.out.println("###########FORZA4###########");
		System.out.println("Premi 1 per iniziare una nuova partita");
		System.out.println("Premi 2 per avviare una partita gia iniziata");
		System.out.println("Premi 3 per uscire");
		System.out.println();
		input=in.next();
		int choice=CheckNumber(input);
		if(choice==1) {
			return;
		}
		else if(choice==2) {
			super.Load();
		}
		else {
			System.out.println("Arrivederci!");
			System. exit(0);
		}
		
	}
	
	
	/**
	 * End of game menu function
	 * @throws IOException
	 */
	
	public void getpostGame() throws IOException {
		String input;
		Scanner in=new Scanner(System.in);
		System.out.println("###########FORZA4###########");
		System.out.println("Premi 1 per andare al menu principale");
		System.out.println("Premi 2 per uscire");
		System.out.println();
		input=in.next();
		int choice=CheckNumber(input);
		if(choice==1) {
			super.Forza4();
		}
		
			System.out.println("Arrivederci!");
			System. exit(0);
	
	}
	

	
	
	/*
	 * Pause menu function.
	 */
	public int getPause() throws IOException {
		String input;
		Scanner in=new Scanner(System.in);
		System.out.println("###########PAUSA###########");
		System.out.println("Premi 1 riprendere");
		System.out.println("Premi 2 salvare");
		System.out.println("Premi 3 per andare al menu principale");
		System.out.println("Premi 4 per uscire");
		System.out.println();
		input=in.next();
		int choice=CheckNumber(input);
		if(choice==1) {
			return 0;
		}
		else if(choice==2) {
			return 2;
		}
		else if(choice==3) {
			super.Forza4();
		}
		System.out.println("Arrivederci!"); 
		System. exit(0);
		return 0;

	}
	
	/**
	 * Checks if the string taken as input is a number and belongs to the menu list
	 * @param s input string
	 * @return the correct number
	 */
	
	
	public int CheckNumber(String s) {
		int f;
		String p;
		Scanner in= new Scanner(System.in);
		try {
			while(true) {
			 f=Integer.valueOf(s);
			 if (f>0&&f<=4) {
					break;}
				else {
					System.out.println("Devi inserire un numero tra quelli elencati: ");
					s=in.next();
					}}
		}
		catch(Exception e){
			System.out.println("Attenzione devi inserire un numero: ");
			while(true) {
			p=in.next();
			
			try {
				f=Integer.valueOf(p);
				if (f>=0&&f<=4) {
					
					break;}
				else {
					System.out.println("Devi inserire un numero tra quelli elencati: ");
					f=in.nextInt();
					
				}
				}
			catch(Exception e1) {
				System.out.println("Attenzione devi inserire un numero: ");}
			
			}
		}
		return f;
	}
	
	
	

}
