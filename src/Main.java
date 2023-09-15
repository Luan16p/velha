import java.util.Scanner;
import java.io.IOException;



public class Main {
	public static char casas_tabuleiro[][] = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
	public static char response;
	public static int row, column;
	
	public static Scanner read = new Scanner(System.in);
	
	public static void resetTabuleiro() {
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            casas_tabuleiro[i][j] = ' ';
	        }
	    }
	}
	
	public static void criarTabuleiro(char context[][]) {
		System.out.printf("\t %c | %c | %c\n", context[0][0], context[0][1], context[0][2]);
		System.out.printf("\t-----------\n");
		System.out.printf("\t %c | %c | %c\n", context[1][0], context[1][1], context[1][2]);
		System.out.printf("\t-----------\n");
		System.out.printf("\t %c | %c | %c\n", context[2][0], context[2][1], context[2][2]);
	}
	
	public static void exibirTabuleiro(char args[][]) {
		clearConsole.clearConsole();
		
		criarTabuleiro(args);
	}
	
	private static void jogo() {
		do {
			resetTabuleiro();
			
			int jogadas = 0, jogador = 0;
			
			do {
				exibirTabuleiro(casas_tabuleiro);
				
				System.out.print("\nDigite sua casa na horizontal: (1-3) ");
				row = read.nextInt();
				
				System.out.print("\nDigite sua casa na vertical: (1-3) ");
				column = read.nextInt();
				
				if(row < 1 || row > 3 || column < 1 || column > 3) {
					row = 0;
					column = 0;
					System.out.println("Erro - Casa Inválida");	
				}
				
				else if(casas_tabuleiro[row-1][column-1] != ' ') {
					row = 0;
					column = 0;
					System.out.println("Erro - Casa Invalida");
				}
			
				else {
					
					if(jogador % 2 == 0) {
						System.out.printf("\t%s\n\n", "Jogada atual X");
						casas_tabuleiro[row-1][column-1] = 'X';
					}
					
					else {
						System.out.printf("\t%s\n\n", "Jogada atual O");
						casas_tabuleiro[row-1][column-1] = 'O';
					}
					
					jogador++;
					jogadas++;
				}	
				
				if(casas_tabuleiro[0][0] == 'X' && casas_tabuleiro[0][1] == 'X' && casas_tabuleiro[0][2] == 'X') jogadas=20;
				if(casas_tabuleiro[1][0] == 'X' && casas_tabuleiro[1][1] == 'X' && casas_tabuleiro[1][2] == 'X') jogadas=20;
				if(casas_tabuleiro[2][0] == 'X' && casas_tabuleiro[2][1] == 'X' && casas_tabuleiro[2][2] == 'X') jogadas=20;
				if(casas_tabuleiro[0][0] == 'X' && casas_tabuleiro[1][0] == 'X' && casas_tabuleiro[2][0] == 'X') jogadas=20;
				if(casas_tabuleiro[0][1] == 'X' && casas_tabuleiro[1][1] == 'X' && casas_tabuleiro[2][1] == 'X') jogadas=20;
				if(casas_tabuleiro[0][2] == 'X' && casas_tabuleiro[1][2] == 'X' && casas_tabuleiro[2][2] == 'X') jogadas=20;
				if(casas_tabuleiro[0][1] == 'X' && casas_tabuleiro[1][1] == 'X' && casas_tabuleiro[2][1] == 'X') jogadas=20;
				if(casas_tabuleiro[0][2] == 'X' && casas_tabuleiro[1][2] == 'X' && casas_tabuleiro[2][2] == 'X') jogadas=20;
				if(casas_tabuleiro[0][0] == 'X' && casas_tabuleiro[1][1] == 'X' && casas_tabuleiro[2][2] == 'X') jogadas=20;
				if(casas_tabuleiro[0][2] == 'X' && casas_tabuleiro[1][1] == 'X' && casas_tabuleiro[2][0] == 'X') jogadas=20;

				if(casas_tabuleiro[0][0] == 'O' && casas_tabuleiro[0][1] == 'O' && casas_tabuleiro[0][2] == 'O') jogadas=21;
				if(casas_tabuleiro[1][0] == 'O' && casas_tabuleiro[1][1] == 'O' && casas_tabuleiro[1][2] == 'O') jogadas=21;
				if(casas_tabuleiro[2][0] == 'O' && casas_tabuleiro[2][1] == 'O' && casas_tabuleiro[2][2] == 'O') jogadas=21;
				if(casas_tabuleiro[0][0] == 'O' && casas_tabuleiro[1][0] == 'O' && casas_tabuleiro[2][0] == 'O') jogadas=21;
				if(casas_tabuleiro[0][1] == 'O' && casas_tabuleiro[1][1] == 'O' && casas_tabuleiro[2][1] == 'O') jogadas=21;
				if(casas_tabuleiro[0][2] == 'O' && casas_tabuleiro[1][2] == 'O' && casas_tabuleiro[2][2] == 'O') jogadas=21;
				if(casas_tabuleiro[0][1] == 'O' && casas_tabuleiro[1][1] == 'O' && casas_tabuleiro[2][1] == 'O') jogadas=21;
				if(casas_tabuleiro[0][2] == 'O' && casas_tabuleiro[1][2] == 'O' && casas_tabuleiro[2][2] == 'O') jogadas=21;
				if(casas_tabuleiro[0][0] == 'O' && casas_tabuleiro[1][1] == 'O' && casas_tabuleiro[2][2] == 'O') jogadas=21;
				if(casas_tabuleiro[0][2] == 'O' && casas_tabuleiro[1][1] == 'O' && casas_tabuleiro[2][0] == 'O') jogadas=21;
				
			} while(jogadas < 9);

			exibirTabuleiro(casas_tabuleiro);
			
			if(jogadas == 10) {
				System.out.println("\n\tFIM DE JOGO\nResultado: Empate!");
			}
			else if(jogadas == 20) {
				System.out.println("\n\tFIM DE JOGO\nResultado: X Vencedor!");
			}
			else if(jogadas == 21) {
				System.out.println("\n\tFIM DE JOGO\nResultado: O Vencedor!");
			}
			
			
			
			System.out.print("\nJogar? [Y] > ");
			
		
			response = read.next().charAt(0);
			System.out.print('\n');
			
		} while (response == 'Y' || response == 'y');
	}
	
	public static void main(String[] args) throws IOException {
		jogo();
	}
}
