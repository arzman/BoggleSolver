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

	public boolean setCharAt(int line, int col, Character c) {
		
		boolean res = false;
		
		if(Character.getType(c) == Character.LOWERCASE_LETTER){
			charTable[line][col] = c;
			res = true;
		}
		
		charTable[line][col] = c;
		
		
		return res;
	}

	public int getNbLine() {
		return BoggleManager.getInstance().getNbCol();
	}

	public int getNbCol() {
		return BoggleManager.getInstance().getNbCol();
	}
	
	
}
