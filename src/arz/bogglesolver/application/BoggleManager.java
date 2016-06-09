package arz.bogglesolver.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import arz.bogglesolver.domain.BoggleCase;

public class BoggleManager {

	private static BoggleManager _instance;

	private List<BoggleCase> _boggleCases;
	
	private int _nbLine;
	
	private int _nbCol;

	private BoggleManager() {

	}

	public static BoggleManager getInstance() {

		if (_instance == null) {

			_instance = new BoggleManager();

		}

		return _instance;
	}

	public void init(int heigth, int width) {

		
		_nbLine = heigth;
		_nbCol = width;
		
		// création de la liste finale
		_boggleCases = new ArrayList<BoggleCase>();

		// création d'un tableau temporaire 2D
		BoggleCase[][] tmpTable = new BoggleCase[heigth][width];

		// création des cases
		for (int i = 0; i < heigth; i++) {

			for (int j = 0; j < width; j++) {

				BoggleCase boggleCase = new BoggleCase();
				tmpTable[i][j] = boggleCase;
				_boggleCases.add(boggleCase);

			}
		}

		// création des liens entre les cases
		for (int i = 0; i < heigth; i++) {

			for (int j = 0; j < width; j++) {

				BoggleCase cible = tmpTable[i][j];

				// ligne du dessus
				if (i - 1 > -1) {

					if (j - 1 > -1) {
						cible.getNextCases().add(tmpTable[i - 1][j - 1]);
					}

					cible.getNextCases().add(tmpTable[i - 1][j]);

					if (j + 1 < width) {
						cible.getNextCases().add(tmpTable[i - 1][j + 1]);
					}

				}
				// ligne courante
				if (j - 1 > -1) {
					cible.getNextCases().add(tmpTable[i][j - 1]);
				}

				if (j + 1 < width) {
					cible.getNextCases().add(tmpTable[i][j + 1]);
				}

				// ligne du dessous
				if (i + 1 < heigth) {
					if (j - 1 > -1) {
						cible.getNextCases().add(tmpTable[i + 1][j - 1]);
					}

					cible.getNextCases().add(tmpTable[i + 1][j]);

					if (j + 1 < width) {
						cible.getNextCases().add(tmpTable[i + 1][j + 1]);
					}
				}

			}
		}

	}

	public List<String> resolveBoggle(Character[][] table) {

		ArrayList<String> res = new ArrayList<>();

		// remplissage de la structure du boggle
		int k = 0;
		for (int i = 0; i < table.length; i++) {

			for (int j = 0; j < table[i].length; j++) {

				_boggleCases.get(k).setChar(table[i][j]);
				k = k + 1;
			}
		}

		Stack<List<BoggleCase>> zeStack = new Stack<List<BoggleCase>>();

		for (BoggleCase bCase : _boggleCases) {

			ArrayList<BoggleCase> list = new ArrayList<BoggleCase>();
			list.add(bCase);
			zeStack.push(list);

		}
		
		
		while(!zeStack.isEmpty()){
			
			String st = convertToString(zeStack.pop());
			int resword = WordManager.getInstance().analyseWord(st);
			
			if(resword == WordManager.MOT){
				System.out.println(st);
			}
			
			
		}
		

		return res;
	}

	private String convertToString(List<BoggleCase> listCase) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNbLine() {

		return _nbLine;
	}

	public int getNbCol() {

		return _nbCol;
	}

}
