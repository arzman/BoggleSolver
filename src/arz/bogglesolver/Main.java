package arz.bogglesolver;

import arz.bogglesolver.application.BoggleManager;
import arz.bogglesolver.application.WordManager;
import arz.bogglesolver.presentation.ConfigFrame;
import arz.bogglesolver.presentation.MainFrame;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		ConfigFrame cf = new ConfigFrame();
		cf.setVisible(true);
		
		BoggleManager.getInstance().init(cf.getNbLine(),cf.getNbCol());
		
		
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		
		WordManager.getInstance();

	}

}
