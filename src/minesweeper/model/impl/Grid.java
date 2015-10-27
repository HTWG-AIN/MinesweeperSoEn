package minesweeper.model.impl;

import java.util.LinkedList;
import java.util.List;

public class Grid {
	private Cell[][] cells;
	private int height = 0;
	private int width = 0;

	protected Grid(Cell[][] cells) {
		setCells(cells);
	}

	protected void setCells(Cell[][] cells) {
		if (cells == null || cells.length < 1 || cells[0] == null
				|| cells[0].length < 1) {
			throw new IllegalArgumentException("Cells input array illegal");
		}
		this.cells = cells;
		height = cells.length;
		width = cells[0].length;
	}

	public Cell getCell(int height, int width) {
		checkBounds(height, width);
		return cells[height][width];
	}

	public int getMines(int height, int width) {
		checkBounds(height, width);
		return getCell(height, width).getMines();
	}
	
	public boolean isFlag(int height, int width) {
		checkBounds(height, width);
		return getCell(height, width).isFlag();
	}
	
	public boolean isMine(int height, int width) {
		checkBounds(height, width);
		return getCell(height, width).isMine();
	}
	
	public boolean isOpened(int height, int width) {
		checkBounds(height, width);
		return getCell(height, width).isOpened();
	}

	public List<Cell> getList() {
		List<Cell> cellList = new LinkedList<>();
		for (Cell[] rows : cells) {
			for (Cell cell : rows) {
				cellList.add(cell);
			}
		}
		return cellList;
	}

	public String mkString() {
		StringBuilder sb = new StringBuilder();
		for (Cell[] rows : cells) {
			for (Cell cell : rows) {
				sb.append(cell.mkString()).append('|');
			}
			// Delete the last '|' in the line
			sb.deleteCharAt(sb.length()-1);
			sb.append('\n');
		}
		return sb.toString();
	}
	
	private void checkBounds(int height, int width) {
		if (height < 0 || width < 0  || height >= this.height || width >= this.width);
	}

}
