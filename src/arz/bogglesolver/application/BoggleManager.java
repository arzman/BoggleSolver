package arz.bogglesolver.application;

import java.util.ArrayList;
import java.util.List;

import arz.bogglesolver.domain.BoggleCase;

public class BoggleManager {

	private static BoggleManager _instance;

	private List<BoggleCase> _boggleCases;

	private BoggleManager() {

	}

	public static BoggleManager getInstance() {

		if (_instance == null) {

			_instance = new BoggleManager();

		}

		return _instance;
	}

	public void init(int heigth, int width) {

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
				
				//ligne du dessus
				if(i-1>-1){
					
					if(j-1>-1){
						cible.getNextCases().add(tmpTable[i-1][j-1]);
					}
					
					cible.getNextCases().add(tmpTable[i-1][j]);
					
					if(j+1<width){
						cible.getNextCases().add(tmpTable[i-1][j+1]);
					}
					
				}
				// ligne courante
				if(j-1>-1){
					cible.getNextCases().add(tmpTable[i][j-1]);
				}
				
				
				if(j+1<width){
					cible.getNextCases().add(tmpTable[i][j+1]);
				}
				
				//ligne du dessous
				if(i+1<heigth){
					if(j-1>-1){
						cible.getNextCases().add(tmpTable[i+1][j-1]);
					}
					
					cible.getNextCases().add(tmpTable[i+1][j]);
					
					if(j+1<width){
						cible.getNextCases().add(tmpTable[i+1][j+1]);
					}
				}
			
				
			}
		}

	}

}
