package arz.bogglesolver.domain;

import java.util.ArrayList;
import java.util.List;

public class BoggleCase {

	private final ArrayList<BoggleCase> _nextCases;


	public BoggleCase() {

		_nextCases = new ArrayList<BoggleCase>();

	}
	
	
	
	public List<BoggleCase> getNextCases(){
		
		return _nextCases;
		
	}
	

}
