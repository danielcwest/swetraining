package dan.swetraining.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {

	public List<String> dic; 
	
	public AutoComplete() {
		dic = new ArrayList<String>();
	}
	
	public void importDictionary(List<String> input) {
		this.dic = input;
	}
	
	public List<String> query(String search, int numItems){
		List<String> result = new ArrayList<String>();
		int count = 0;
		
		for(int i = 0; i < dic.size(); i++) {
			if(count == numItems) break;
			
			String word = dic.get(i);
			if(word.startsWith(search)) {
				result.add(word);
				count++;
			}
		}
		
		return result;
	}
}
