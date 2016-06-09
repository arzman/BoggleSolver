package arz.bogglesolver.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WordManager {

	public static final int RIEN = 0;
	
	public static final int DEBUT_MOT = 1;
	
	public static final int MOT = 2;
	
	public static final int MOT_ET_DEBUT_MOT = 3;
	
	

	private static WordManager _instance;

	private final String[] _wordList;
	
	private final HashMap<Character,Integer> _indexMap;

	private WordManager() {

		ArrayList<String> tmpList = new ArrayList<String>();

		// lecture du fichier texte
		InputStream in = getClass().getResourceAsStream(
				"/arz/bogglesolver/resources/dico_big_fr.txt");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String ligne;
			while ((ligne = br.readLine()) != null) {

				tmpList.add(ligne.trim());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.sort(tmpList);

		_indexMap = new HashMap<Character,Integer>();
		_wordList = new String [tmpList.size()];
		
		
		
		for(int i=0;i<_wordList.length;i++){
			
			
			_wordList[i] = tmpList.get(i);
			
			if( _indexMap.get(_wordList[i].charAt(0))==null){
				
				_indexMap.put(_wordList[i].charAt(0), i);
				
			}
			
			
			
			
		}
		

	}

	public static WordManager getInstance() {

		if (_instance == null) {

			_instance = new WordManager();

		}

		return _instance;

	}
	
	
	public int analyseWord(String word){
		
		int res = RIEN;
		
		if(word.length()==1){
			
			res = DEBUT_MOT;
			
		}else{
			
			char leChar = word.charAt(0);
			
			int index = _indexMap.get(leChar);
			
			
			boolean isFinish = false;
			
			while(!isFinish){
				
				if( _wordList[index].startsWith(word)){
					
					
					res = DEBUT_MOT;
					
					if(_wordList[index].equals(word)){
						
						res = MOT;
						
						if(_wordList[index+1].startsWith((word))){
							res = MOT_ET_DEBUT_MOT;
						}
						
					}
					isFinish = true;
					
				}else{
					index = index+1;
				}
			}

		}

		return res;
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println(WordManager.getInstance().analyseWord("mangera"));
		System.out.println(WordManager.getInstance().analyseWord("cocotiers"));
		
	}
	

}
