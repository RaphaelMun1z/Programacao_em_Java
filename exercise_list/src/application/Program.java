package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantidade de linhas: ");
		Integer Lines = sc.nextInt();

		System.out.print("Quantidade de colunas: ");
		Integer Columns = sc.nextInt();

		int[][] array = new int[Lines][Columns];

		for (int l = 0; l < array.length; l++) {
			for (int c = 0; c < array[l].length; c++) {
				array[l][c] = sc.nextInt();
			}
		}

		System.out.println("-----------------------------");

		for (int l = 0; l < array.length; l++) {
			for (int c = 0; c < array[l].length; c++) {
				System.out.printf("%d ", array[l][c]);
			}
			System.out.println();
		}

		System.out.print("Escolha um número: ");
		Integer numberSelected = sc.nextInt();

		Integer nLine = 0;
		Integer nColumn = 0;

		for (int l = 0; l < array.length; l++) {
			for (int c = 0; c < array[l].length; c++) {
				if (array[l][c] == numberSelected) {
					nLine = l;
					nColumn = c;
				}
			}
		}

		System.out.printf("Posição: %d, %d %n", nLine, nColumn);
		if (nColumn > 0) {
			System.out.printf("Esquerda: %d %n", array[nLine][nColumn - 1]);
		}

		if (nColumn < Columns - 1) {
			System.out.printf("Direita: %d %n", array[nLine][nColumn + 1]);
		}

		if (nLine < Lines - 1) {
			System.out.printf("Embaixo: %d %n", array[nLine + 1][nColumn]);
		}

		if (nLine > 0) {
			System.out.printf("Em cima: %d %n", array[nLine - 1][nColumn]);
		}

		sc.close();
	}

}
