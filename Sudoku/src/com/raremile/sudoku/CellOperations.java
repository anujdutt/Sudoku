package com.raremile.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to perform the operations of row, column and grid scanning.
 * 
 * @author AnujD
 *
 */
public class CellOperations {
	public Cell cells[][];

	/**
	 * Pass the cell array.
	 * 
	 * @param inputCell
	 */
	public CellOperations(Cell inputCell[][]) {
		cells = inputCell;
	}

	/**
	 * Pass the indices of the cell to be checked. If any cell in the same row
	 * as this cell has a valid value, then remove that number from the list of
	 * possible numbers that this cell can take.
	 * @param rowIndex
	 * @param columnIndex
	 */
	public void checkTheRow(int rowIndex, int columnIndex) {
		for (int j = 0; j < 9; j++) {
			if (j == columnIndex)
				continue; 
			if (cells[rowIndex][j].value != 0) {
				cells[rowIndex][columnIndex].possibleValues
						.remove((Integer) (cells[rowIndex][j].value));
			}
		}
	}

	/**
	 * Pass the indices of the cell to be checked. If any cell in the same column
	 * as this cell has a valid value, then remove that number from the list of
	 * possible numbers that this cell can take.
	 * @param rowIndex
	 * @param columnIndex
	 */
	public void checkTheColumn(int rowIndex, int columnIndex) {
		for (int i = 0; i < 9; i++) {
			if (i == rowIndex)
				continue;
			if (cells[i][columnIndex].value != 0) {
				cells[rowIndex][columnIndex].possibleValues
						.remove((Integer) (cells[i][columnIndex].value));
			}
		}
	}

	/**
	 * Pass the indices of the cell to be checked. If any cell in the same 3x3 grid
	 * as this cell has a valid value, then remove that number from the list of
	 * possible numbers that this cell can take.
	 * @param rowIndex
	 * @param columnIndex
	 */
	public void checkTheGrid(int rowIndex, int columnIndex) {
		int startRowIndex = 0;
		int startColumnIndex = 0;
		if (rowIndex < 3)
			startRowIndex = 0;
		else if (rowIndex >= 3 && rowIndex < 6)
			startRowIndex = 3;
		else if (rowIndex >= 6 && rowIndex < 9)
			startRowIndex = 6;
		if (columnIndex < 3)
			startColumnIndex = 0;
		else if (columnIndex >= 3 && columnIndex < 6)
			startColumnIndex = 3;
		else if (columnIndex >= 6 && columnIndex < 9)
			startColumnIndex = 6;
		for (int i = startRowIndex; i < startRowIndex + 3; i++) {
			for (int j = startColumnIndex; j < startColumnIndex + 3; j++) {
				if (i == rowIndex && j == columnIndex)
					continue;
				if (cells[i][j].value != 0) {
					cells[rowIndex][columnIndex].possibleValues
							.remove((Integer) (cells[i][j].value));
				}
			}
		}
	}
}
