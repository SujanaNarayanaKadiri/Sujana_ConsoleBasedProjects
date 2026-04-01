package com.projects;

import java.util.Scanner;

public class TicTacToe {
	static char[][] arr = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
//	static char curr = 'x';

	static void board() {
		for (int row = 0; row < 3; row++) {
			System.out.println("--------------");
			for (int col = 0; col < 3; col++) {
				System.out.print("| " + arr[row][col] + " ");
			}
			System.out.println("|");
		}
		System.out.println("--------------");
	}

	static boolean isValid(int r, int c) {
		if (r > 2 || c > 2 || r < 0 || c < 0 || arr[r][c] != ' ') {
			return false;
		}
		return true;
	}

	static boolean isWinner(char curr) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ((arr[0][i] == curr && arr[1][i] == curr && arr[2][i] == curr)
						|| (arr[i][0] == curr && arr[i][1] == curr && arr[i][2] == curr)
						|| (arr[0][0] == curr && arr[1][1] == curr && arr[2][2] == curr)
						|| (arr[0][2] == curr && arr[1][1] == curr && arr[2][0] == curr)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isDraw() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice either x or o ");
		char curr=sc.next().charAt(0);
		if(curr=='x'||curr=='o') {
		while (true) {
			board();
			System.out.println(curr + "----> choice ");
			System.out.println("Enter the row :");
			int r = sc.nextInt();
			System.out.println("Enter the Column :");
			int c = sc.nextInt();
			if (isValid(r, c)) {
				arr[r][c] = curr;
				if (isWinner(curr)) {
					System.out.println(curr + " is Winner of the game");
					board();
					break;
				}
				if (isDraw()) {
					System.out.println("Game is draw...............");
					board();
					break;
				}
				curr = curr == 'x' ? 'o' : 'x';
			} else {
				System.err.println("Invalid positions........!try Again");
				continue;
			}
		}
		}else {
			System.err.println("Enter correct choice ");
		}
		sc.close();
	}

}
