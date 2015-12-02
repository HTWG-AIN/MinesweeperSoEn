package minesweeper;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import minesweeper.aview.tui.TextUI;
import minesweeper.controller.IMinesweeperController;
import minesweeper.controller.impl.ControllerWrapper;
import minesweeper.model.IGridFactory;
import minesweeper.model.impl.GridFactory;

public class Minesweeper {
	private Minesweeper() {
	}

	public static void main() {
		// Set up logging through log4j
		PropertyConfigurator.configure("log4j.properties");

		IGridFactory gFact = new GridFactory();
		IMinesweeperController controller = new ControllerWrapper(gFact);
		TextUI tui = new TextUI(controller);
		controller.changeSettings(10, 20, 10);

		boolean cont = true;
		Scanner scanner = new Scanner(System.in);
		while (cont) {
			cont = tui.processLine(scanner.nextLine());
		}
		scanner.close();
	}
}
