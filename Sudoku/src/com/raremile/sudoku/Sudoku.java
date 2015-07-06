package com.raremile.sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class to run the program.
 * @author AnujD
 *
 */

public class Sudoku {
	public Cell cells[][];
	File file;
	BufferedReader bufferedReader;
	String rowValues;
/**
 * Initialize the cells to their default values.
 */
	public Sudoku() {
		cells = new Cell[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				cells[i][j]=new Cell();
		}
		try {
			bufferedReader = new BufferedReader(new FileReader(
					"files\\Cellvalues.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/**
		 * For loop to read each line from the file and insert into the cells.
		 */
		for (int i = 0; i < 9; i++) {
			try {
				rowValues = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < 9; j++) {
				int intValue;
				intValue = rowValues.charAt(j) - 48;
				cells[i][j].value = intValue;
			}
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public static void main(String[] args) {
		Sudoku game = new Sudoku();
		int countOfFinishedCells=0;
		System.out.println("The input is: ");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++){
				System.out.print(game.cells[i][j].value + " ");
				if(game.cells[i][j].value!=0)
					countOfFinishedCells++;
			}
			System.out.println();
		}
		
		while(true){
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++){
					CellOperations cellOperations = new CellOperations(game.cells);
					if(game.cells[i][j].value==0){
						cellOperations.checkTheRow(i, j);
						cellOperations.checkTheColumn(i, j);
						cellOperations.checkTheGrid(i, j);
					}
					if(game.cells[i][j].value != 0) {
						game.cells[i][j].possibleValues.clear();
					}
					if ((game.cells[i][j].possibleValues.size()==1)){
						game.cells[i][j].value=game.cells[i][j].possibleValues.get(0);
						countOfFinishedCells++;
						game.cells[i][j].possibleValues.clear();
					}
				}
			}
			if(countOfFinishedCells>=81)
				break;
		}
		System.out.println("The output is:");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++){
				System.out.print(game.cells[i][j].value + " ");
				if(game.cells[i][j].value!=0) 
					countOfFinishedCells++;
			}
			System.out.println();
		}
	}
}