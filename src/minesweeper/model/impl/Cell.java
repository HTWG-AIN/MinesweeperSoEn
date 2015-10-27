package minesweeper.model.impl;

import minesweeper.model.ICell;

public class Cell implements ICell {
	private final int col;
	private final int row;
	private int mines;
	private boolean opened;
	private boolean isMine;
	private boolean flag;

	public Cell(int col, int row) {
		this(col, row, 0, false, false, false);
	}

	public Cell(int col, int row, char type) {
		this.col = col;
		this.row = row;
		if (type == 'F') {
			setFlag(true);
			setIsMine(false);
			setOpened(false);
			setMines(0);
			return;
		}
		if (type == 'M') {
			setFlag(false);
			setIsMine(true);
			setOpened(true);
			setMines(0);
			return;
		}
		if (type == ' ') {
			setFlag(false);
			setIsMine(false);
			setOpened(false);
			setMines(0);
			return;
		}

		int mines = Character.getNumericValue(type);
		if (mines < 0 || mines > 9) {
			throw new IllegalArgumentException("Illegal Cell type");
		}
		setMines(mines);
		setFlag(false);
		setIsMine(false);
		setOpened(true);
	}

	public Cell(int col, int row, int mines, boolean opened, boolean isMine,
			boolean flag) {
		this.col = col;
		this.row = row;
		this.mines = mines;
		this.opened = opened;
		this.isMine = isMine;
		this.flag = flag;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public int getMines() {
		return mines;
	}

	public boolean isFlag() {
		return flag;
	}

	public boolean isMine() {
		return isMine;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setIsMine(boolean isMine) {
		this.isMine = isMine;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setMines(int mines) {
		this.mines = mines;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public String mkString() {
		if (flag)
			return "F";
		if (!opened)
			return " ";
		if (isMine) {
			return "M";
		}
		return String.valueOf(mines);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (col != other.col)
			return false;
		if (flag != other.flag)
			return false;
		if (isMine != other.isMine)
			return false;
		if (mines != other.mines)
			return false;
		if (opened != other.opened)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}
