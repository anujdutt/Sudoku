package com.raremile.sudoku;

import java.util.ArrayList;
import java.util.List;
/**
 * Class for each cell.
 * @author AnujD
 *
 */
public class Cell {
	public List<Integer> possibleValues;
	public int value;
	/**
	 * Initialize the list of possible values that this cell can take.
	 */
	public Cell(){
		possibleValues=new ArrayList<Integer>();
		for(int i=1;i<=9;i++)
			possibleValues.add(i);
	}
 }
