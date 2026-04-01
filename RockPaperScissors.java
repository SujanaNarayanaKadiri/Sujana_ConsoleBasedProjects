//package com.projects;
//
//import java.util.Scanner;
//
//public class RockPaperScissors {
//	static void display(int choice) {
//		switch (choice) {
//		case 1 -> System.out.println("Rock 🪨");
//		case 2 -> System.out.println("Paper 📄");
//		case 3 -> System.out.println("Scissors ✂️");
//		default -> System.out.println("Invalid choice!");
//		}
//	}
//
//	static int checkWinner(int p1, int p2) {
//		if (p1 == 1 && p2 == 2) {
//			return p2;
//		} else if (p1 == 1 && p2 == 3) {
//			return p1;
//		} else if (p1 == 2 && p2 == 1) {
//			return p1;
//		} else if (p1 == 2 && p2 == 3) {
//			return p2;
//		} else if (p1 == 3 && p2 == 1) {
//			return p2;
//		} else if (p1 == 3 && p2 == 2) {
//			return p1;
//		} else {
//			return 0;
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("----------Player1's turn ------------");
//		System.out.println("Enter your choice : ");
//		System.out.println("1.Rock 2.paper 3.scissor");
//		int p1choice = sc.nextInt();
//		display(p1choice);
//		for (int i = 0; i <= 25; i++) {
//			// for empty lines cause other player2 could not able to see player 1 choice
//			System.out.println(" ");
//		}
//		System.out.println("----------Player233's turn ------------");
//		System.out.println("Enter your choice : ");
//		System.out.println("1.Rock 2.paper 3.scissor");
//		int p2choice = sc.nextInt();
//		display(p2choice);
//		if (p1choice == p2choice) {
//			System.out.println("Game is Draw ");
//			System.out.println("Both Selected Same choice");
//		} else {
//			int winner = checkWinner(p1choice, p2choice);
//			if (winner == p1choice)
//				System.out.println("Player 1 is Winner ");
//			else
//				System.out.println("Player 2 is Winner ");
//		}
//
//		sc.close();
//	}
//
//}
//
//
//

package com.projects;

import java.util.Scanner;

public class RockPaperScissors {
    
    // Constants for better readability
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    
    static void display(int choice) {
        switch (choice) {
            case ROCK -> System.out.println("Rock 🪨");
            case PAPER -> System.out.println("Paper 📄");
            case SCISSORS -> System.out.println("Scissors ✂️");
            default -> System.out.println("Invalid choice!");
        }
    }
    
    static int checkWinner(int p1, int p2) {
        if (p1 == p2) {
            return 0; // Draw
        }
        
        // Using modular arithmetic for cleaner logic
        // If the difference is 1 or -2, player 1 wins in certain cases
        // (p1 - p2 + 3) % 3 gives:
        // 1: player 1 wins, 2: player 2 wins
        int result = (p1 - p2 + 3) % 3;
        return result == 1 ? p1 : p2;
        
        // Alternative simple logic:
        // if ((p1 == ROCK && p2 == SCISSORS) ||
        //     (p1 == PAPER && p2 == ROCK) ||
        //     (p1 == SCISSORS && p2 == PAPER)) {
        //     return p1;
        // } else {
        //     return p2;
        // }
    }
    
    static int getValidChoice(Scanner sc, String playerName) {
        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("\n---------- " + playerName + "'s turn ------------");
            System.out.println("Enter your choice:");
            System.out.println("1. Rock 🪨");
            System.out.println("2. Paper 📄");
            System.out.println("3. Scissors ✂️");
            System.out.print("Choice (1-3): ");
            
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // Clear invalid input
            }
        }
        return choice;
    }
    
    static void clearScreen() {
        // Simple screen clearing by printing empty lines
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain;
        
        do {
            // Player 1's turn
            int p1choice = getValidChoice(sc, "Player 1");
            System.out.print("\nPlayer 1 chose: ");
            display(p1choice);
            
            // Clear screen for player 2
            System.out.println("\nClearing screen for Player 2...");
            try {
                Thread.sleep(1500); // Brief pause
            } catch (InterruptedException e) {
                // Continue if sleep is interrupted
            }
            clearScreen();
            
            // Player 2's turn
            int p2choice = getValidChoice(sc, "Player 2");
            System.out.print("\nPlayer 2 chose: ");
            display(p2choice);
            // Show both choices
            System.out.println("\n=====================");
            System.out.print("Player 1: ");
            display(p1choice);
            System.out.print("Player 2: ");
            display(p2choice);
            System.out.println("=====================");
            
            // Determine winner
            if (p1choice == p2choice) {
                System.out.println("Game is a Draw!");
                System.out.println("Both players selected the same choice.");
            } else {
                int winner = checkWinner(p1choice, p2choice);
                if (winner == p1choice) {
                    System.out.println("🎉 Player 1 is the Winner! 🎉");
                } else {
                    System.out.println("🎉 Player 2 is the Winner! 🎉");
                }
            }
            
            // Ask to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = sc.next().toLowerCase();
            
        } while (playAgain.equals("yes") || playAgain.equals("y"));
        
        System.out.println("\nThanks for playing! 👋");
        sc.close();
    }
}
