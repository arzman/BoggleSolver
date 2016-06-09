package arz.bogglesolver.domain;

import java.util.ArrayList;
import java.util.List;

public class BoggleCase {

	private final ArrayList<BoggleCase> _nextCases;
	
	private char _character;


	public BoggleCase() {

		_nextCases = new ArrayList<BoggleCase>();
		

	}
	
	
	
	public List<BoggleCase> getNextCases(){
		
		return _nextCases;
		
	}



	public void setChar(Character character) {
		
		_character = character;
		
	}
	
	
	public char getChar(){
		return _character;
	}
	
	

}
