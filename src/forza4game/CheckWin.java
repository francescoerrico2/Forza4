package forza4game;

import java.io.IOException;

/**
 * Class that controls the win or draw of the match
 * Extended function from Grid class.
 */

public class CheckWin extends Grid {
	
	/**
	 * This function checks if there is a win in the game
	 * @return a boolean value dependent on the result
	 */
	public boolean win(){
	    String temp;
	    boolean flag=false;
		for(int j=0;j<6;j++)
		{   if(flag)break;
			for (int i=0;i<7;i++)
			{temp=Grid[j][i];
				if (temp != " ")
				//Control horizontally
				{	
				if (i<4)
					{
					if(temp==Grid[j][i+1] && temp==Grid[j][i+2] && temp==Grid[j][i+3])
						{
							flag=true;
							break;
						}	
				}else if (i>=4){
						if(temp==Grid[j][i-1] && temp==Grid[j][i-2] &&temp==Grid[j][i-3])
						{
								flag=true;
								break;
						}
					}
				//Vertical Control
				if(j<=2 && flag==false){
					
						if (temp==Grid[j+1][i] && temp==Grid[j+2][i] && temp==Grid[j+3][i]){
							flag=true;
						
						}
					}
					
					//diagonal control from bottom to left
				if (j>2 && i<=3){
						if(temp==Grid[j-1][i+1] && 
						   temp==Grid[j-2][i+2] &&
						   temp==Grid[j-3][i+3]){
							flag=true;
							break;
						}
					}//diagonal control from top to left
					else if(j<=2 && i<=3){
						if (temp==Grid[j+1][i+1] &&
							temp==Grid[j+2][i+2] &&
							temp==Grid[j+3][i+3]){
							flag=true;
							break;
						}
					}//diagonal control from top to right
					else if(j<=2 && i>=3){
						if (temp==Grid[j+1][i-1] && 
							temp==Grid[j+2][i-2] &&
							temp==Grid[j+3][i-3]){
							flag=true;
							break;
						}
					}//diagonal control from bottom to right
					else if(j>2 && i>=3){
						if (temp==Grid[j-1][i-1] &&
							temp==Grid[j-2][i-2] &&
							temp==Grid[j-3][i-3]){
							flag=true;
							break;
						}
					}
				}
			}
		}
		return flag;
	}
	
	/**
	 * Function that checks if there is parity
	 * @return to the menu
	 * @throws IOException 
	 */
	
	public boolean equal() throws IOException {
		boolean flag=false;
		for(int i=0;i<6;i++) {
			
			for(int j=0;j<7;j++) {
				if(Grid[i][j]!=" ")flag=true;
				else return false;
			}
		}
		 if(flag) {
			 System.out.println("La Partita si è conclusa con un pareggio");
			 Menu menu=new Menu();
			 menu.getpostGame();
			 
		 }
		 return flag;
	}
}