package arenaGame;

import java.util.Random;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayGame {

	public static class Player {
		int health;
		int strength;
		int attack;

		Player(int health, int strength, int attack) {
			this.health = health;
			this.strength = strength;
			this.attack = attack;
		}

		Player() {

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
	
	// Junits for test cases
	public class PlayerTest {

	    @Test
	    void testPlayerConstructor() {
	    	// Test for Player constructor 
	        Player player = new Player(100, 10, 5);
	        assertEquals(100, player.health);
	        assertEquals(10, player.strength);
	        assertEquals(5, player.attack);
	    }
	}
	    @Test
	    public void testRoll() {
	        // Test if roll() returns a value between 1 and 6
	        int result = PlayGame.roll();
	        assertTrue(result >= 1 && result <= 6, "Roll value should be between 1 and 6");
	    }

	    @Test
	    public void testGameLogic() {
	        // Test the game logic by simulating a game with predefined player attributes
	        Player player1 = new Player(50, 5, 10);
	        Player player2 = new Player(100, 10, 5);

	        // Simulate game until one player's health reaches 0
	        while (player1.health > 0 && player2.health > 0) {
	            // Simulate a round of attack and defense
	            // You may need to mock the roll() method for predictable test results
	            int attackRoll1 = PlayGame.roll();
	            int defenseRoll2 = PlayGame.roll();
	            int attackValue1 = attackRoll1 * player1.attack;
	            int defenseValue2 = defenseRoll2 * player2.strength;
	            int attackPower1 = Math.max(0, attackValue1 - defenseValue2);
	            player2.health -= attackPower1;

	            int attackRoll2 = PlayGame.roll();
	            int defenseRoll1 = PlayGame.roll();
	            int attackValue2 = attackRoll2 * player2.attack;
	            int defenseValue1 = defenseRoll1 * player1.strength;
	            int attackPower2 = Math.max(0, attackValue2 - defenseValue1);
	            player1.health -= attackPower2;
	        }

	        // Check if one player's health reaches 0
	        assertTrue(player1.health <= 0 || player2.health <= 0, "Game should end when one player's health reaches 0");

	        // Check if the winner is determined correctly
	        if (player1.health <= 0) {
	            assertEquals("Player2", "Player2", "Player2 should win when Player1's health reaches 0");
	        } else {
	            assertEquals("Player1", "Player1", "Player1 should win when Player2's health reaches 0");
	        }
	    }

	
	// Main execution starts from here.
		
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

			// Player-1 Details
			Player player1 = new Player();
			System.out.println("Enter Player-1 Details: ");
			System.out.print("Health: ");
			player1.health = scn.nextInt();
			System.out.print("Strength: ");
			player1.strength = scn.nextInt();
			System.out.print("Attack: ");
			player1.attack = scn.nextInt();
			System.out.println();

			// Player-2 Details
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
			// Always player-1 has lowest value;
			if (player2.health < player1.health) {
				flag = true;
			}

			// false turn for player-1 and true for player-2
			boolean turn = flag;
			while (player1.health > 0 && player2.health > 0) {
				if (!turn) {
					int attackRoll = roll();
					System.out.println("Roll for attack by Player-1: " + attackRoll);
					int defenceRoll = roll();
					System.out.println("Roll for defence by Player-2: " + defenceRoll);
					int attackValue = attackRoll * player1.attack;
					int defenceValue = defenceRoll * player2.strength;

					int attackPower = (defenceValue >= attackValue) ? 0 : attackValue - defenceValue;

					player2.health -= attackPower;
					turn = true;
				} else {
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

			if (turn) {
				System.out.println("Congratulations!! Player-1 Wins the Game:)");
			} else {
				System.out.println("Congratulations!! Player-2 Wins the Game:)");
			}

			System.out.println("\nDo you want to play another round? (Y/N)");

			ch = scn.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

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
