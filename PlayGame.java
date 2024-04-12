package arenaGame;
import java.util.Random;
import java.util.Scanner;
public class PlayGame {
		
		public static class Player{
			int health;
			int strength;
			int attack;
			
			Player(int health, int strength, int attack){
				this.health = health;
				this.strength = strength;
				this.attack = attack;
			}
			
			Player(){
				
			}
		}
		
		
		private static final Random random = new Random();

	    // Function to simulate rolling a six-sided die
	    public static int roll() {
	    	System.out.println("Rolling dice......");
	    	try {
	            // Sleep for 2000 milliseconds(2 seconds)
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            // Handle any exceptions
	            e.printStackTrace();
	        }
	        // Generate a random number between 1 and 6 (inclusive)
	        return random.nextInt(6) + 1;
	    }

		public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        
	        
	        char ch = 'Y';
	        do {
	        	System.out.println("\n\t***Game Starting*\n\n");
	        	
	        	try {
	                // Sleep for 2000 milliseconds(2 seconds)
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	                // Handle any exceptions
	                e.printStackTrace();
	            }
	        	
	        	//Player-1 Details
	            Player player1 = new Player();
	            System.out.println("Enter Player-1 Details: ");
	            System.out.print("Health: ");
	            player1.health = scn.nextInt();
	            System.out.print("Strength: ");
	            player1.strength = scn.nextInt();
	            System.out.print("Attack: ");
	            player1.attack = scn.nextInt();
	            System.out.println();
	            
	            //Player-2 Details
	            Player player2 = new Player();
	            System.out.println("Enter Player-2 Details: ");
	            System.out.print("Health: ");
	            player2.health = scn.nextInt();
	            System.out.print("Strength: ");
	            player2.strength = scn.nextInt();
	            System.out.print("Attack: ");
	            player2.attack = scn.nextInt();
	            System.out.println();
	            
	            
	            boolean flag = false;
	            //Always player-1 has lowest value;
	            if(player2.health < player1.health) {
	            	flag = true;
	            }
	            
	            //false turn for player-1 and true for player-2
	            boolean turn = flag;
	            while(player1.health > 0 && player2.health > 0) {
	            	if(!turn) {
	            		int attackRoll = roll();
	            		System.out.println("Roll for attack by Player-1: " + attackRoll);
	            		int defenceRoll = roll();
	            		System.out.println("Roll for defence by Player-2: " + defenceRoll);
	            		int attackValue = attackRoll * player1.attack;
	            		int defenceValue = defenceRoll * player2.strength;
	            		
	            		int attackPower = (defenceValue >= attackValue) ? 0 : attackValue - defenceValue;
	            		
	            		player2.health -= attackPower;
	            		turn = true;
	            	}else {
	            		int attackRoll = roll();
	            		System.out.println("Roll for attack by Player-2: " + attackRoll);
	            		int defenceRoll = roll();
	            		System.out.println("Roll for defence by Player-1: " + defenceRoll);
	            		int attackValue = attackRoll * player2.attack;
	            		int defenceValue = defenceRoll * player1.strength;
	            		
	            		int attackPower = (defenceValue >= attackValue) ? 0 : attackValue - defenceValue;
	            		
	            		player1.health -= attackPower;
	            		turn = false;
	            	}
	            	
		player1.health = (player1.health < 0) ? 0 : player1.health;
	            	player2.health = (player2.health < 0) ? 0 : player2.health;
	            	
	        		System.out.println("\nPlayer-1 remaining health: " + player1.health);
	        		System.out.println("Player-2 remaining health: " + player2.health);
	            	
	            	System.out.println();
	            }
	            
	            if(turn) {
	        		System.out.println("Congratulations!! Player-1 Wins the Game:)");
	            }else {
	        		System.out.println("Congratulations!! Player-2 Wins the Game:)");
	            }
	            
	            System.out.println("\nDo you want to play another round? (Y/N)");
	            
	            ch = scn.next().charAt(0);
	            
	        }while(ch == 'Y' || ch == 'y');
	        
	        
	        System.out.println("Thank You for playing the Game");
	        
	        System.out.println("\n\t***Game CLosing*");
	        
	        try {
	            // Sleep for 2000 milliseconds(2 seconds)
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            // Handle any exceptions
	            e.printStackTrace();
	        }
	        
	        scn.close();
	    }
	    
		
		
	    
		
}

