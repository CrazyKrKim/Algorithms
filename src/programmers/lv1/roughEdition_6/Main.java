package programmers.lv1.roughEdition_6;

import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] keymap = {"ABACD", "BCEFD"};
		String[] targets = {"ABCD","AABB"};
		
		solution(keymap, targets);
	}

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<String, Integer> keyMapHash = new HashMap<String, Integer>();
        
        for(int i = 0; i < keymap.length; i++) {
        	for(int j = 0; j < keymap[i].length(); j++) {
        		String keymapStr = keymap[i].substring(j, j+1);
        		
        		if(keyMapHash.containsKey(keymapStr)) {
        			if(keyMapHash.get(keymapStr) > j+1) {
            			keyMapHash.put(keymapStr, j+1);        				
        			}
        		} else {
        			keyMapHash.put(keymapStr, j+1);
        		}
        	}
        }
        
        for(int i = 0; i < targets.length; i++) { 
        	int sum = 0;

        	for(int j = 0; j < targets[i].length(); j++) {
        		String targetsStr = targets[i].substring(j, j+1);
        		
        		if(!keyMapHash.containsKey(targetsStr)) {
        			sum = -1;
        			break;
        		} else {
        			sum += keyMapHash.get(targetsStr);
        		}
        	}
        	
        	answer[i] = sum;
        }
        
        return answer;
    }
}