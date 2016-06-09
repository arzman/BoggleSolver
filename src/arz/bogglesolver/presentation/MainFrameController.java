package arz.bogglesolver.presentation;

import arz.bogglesolver.application.BoggleManager;

public class MainFrameController {

	
	private static MainFrameController _instance;
	
	private Character[][] charTable;
	
	private MainFrameController(){
		
		charTable = new Character[getNbLine()][getNbCol()];
		
	}
	
	public static MainFrameController getInstance() {

		if (_instance == null) {

			_instance = new MainFrameController();

		}

		return _instance;
	}

	public void setCharAt(int line, int col, Character c) {
		charTable[line][col] = c;
		
	}

	public int getNbLine() {
		return BoggleManager.getInstance().getNbCol();
	}

	public int getNbCol() {
		return BoggleManager.getInstance().getNbCol();
	}
	
	
}
