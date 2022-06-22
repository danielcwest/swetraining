package dan.swetraining.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeArrays {

	//Arrays
    public int removeDuplicates(int[] nums) {
                
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            nums[j] = nums[i];
            while(i + 1 < nums.length && nums[i+1] == nums[i]){
                i++;
            }
            j++;
        }
        
        return j;
    }
    
    public void rotateArray(int[] nums, int k) {
    	
    	for(int n = 0; n < k; n++) {
    		int prev = nums[0];
    		for(int i = 0; i < nums.length; i++) {
    			int currentPrev;
    			if(i + 1 >= nums.length) {
    				currentPrev = nums[i + 1 - nums.length];
    				nums[i + 1 - nums.length] = prev;
    			}else {
    				currentPrev = nums[i + 1];
    				nums[i + 1] = prev;  				
    			}
    			prev = currentPrev;
    		}
    	}
    	System.out.println("");
    }
    
    public void rotateArray2(int[] nums, int k) {
    	
    	k = k % nums.length;
    	
    	for(int n = 0; n < k; n++) {		
    		//Swap the ith with the last
    		for(int i = 0; i < nums.length; i++) {
    			int prev = nums[i];
    			nums[i] = nums[nums.length - 1];
    			nums[nums.length - 1] = prev;
    		}
    	}
    	System.out.println("");
    }
    
    public void rotate3(int[] nums, int k) {
    	
    	//reverse array
    	nums = reverse(nums, 0, nums.length);
    	
    	//reverse first 3 elements
    	nums = reverse(nums, 0, k);
    	
    	nums = reverse(nums, k, nums.length);
    	
    	System.out.println("");

    }
    
    public int[] reverse(int[] nums, int start, int end) {  	
		for(int i = 0; i < (end - start) / 2; i++) {
			int prev = nums[i + start];
			nums[i + start] = nums[end - i - 1];
			nums[end - i - 1] = prev;
		}
		return nums;
    }
    
    
    public boolean containsDuplicate(int[] nums) {
    	boolean result = false;
    	
    	Map<Integer, Integer> keys = new HashMap<Integer,Integer>();
    	
    	for(int num : nums) {
    		if(keys.containsKey(num)) {
    			result = true;
    			break;
    		}else {
    			keys.put(num, null);
    		}
    	}
    	
    	return result;
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
    	List<Integer> resultList = new ArrayList<Integer>();
    	
    	Map<Integer, Integer> keys = new HashMap<Integer,Integer>();

    	for(int num : nums1) {
    		keys.put(num, keys.containsKey(num) ? keys.get(num) + 1 : 1);
    	}
    	
    	for(int num : nums2) {
    		if(keys.containsKey(num)) {
    			int count = keys.get(num);
    			
    			if(count > 0)
    				resultList.add(num);
    			
    			keys.put(num, --count);
    		}
    	}
    	
    	int[] result = new int[resultList.size()];
    	
    	for(int i = 0; i < resultList.size(); i++) {
    		result[i] = resultList.get(i);
    	}
    	
    	return result;
    }
    
    
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
    // Write your code here
    	List<Integer> result = new ArrayList<Integer>();
    	
    	Collections.sort(arr);

    	for(int i = arr.size() - 1; i > 0; i--) {
    		for(int j = i - 1; j >= 0; j--) {
        		List<Integer> b = arr.subList(0, j);
        		List<Integer> a = arr.subList(j, i + 1);

        		if(a.stream().reduce(0, Integer::sum) > b.stream().reduce(0, Integer::sum)) {
        			result = a;
        			break;
        		}
    		}
    		if(result.size() > 0) {
    			break;
    		}
    	}
    	
    	return result;
    }
    
    public static List<Integer> minimalHeaviestSet2(List<Integer> arr) {
    // Write your code here
    	List<Integer> result = new ArrayList<Integer>();
    	

    	
    	return result;
    }
    
    public static int countGroups(List<String> related) {
        // Write your code here
    	List<List<Integer>> groups = new ArrayList<List<Integer>>();
    	int count = 0;
    	int[][] matrix = new int[related.get(0).length()][related.size()];
    	
    	for(int i = 0; i < related.size(); i++) {
    		String r = related.get(i);
    		for(int j = 0; j < r.length(); j++) {
    			String val = String.valueOf(r.charAt(j));
    			matrix[i][j] = Integer.valueOf(val);
    		}
    	}
    	
    	for(int i = 0; i < matrix[0].length; i++) {
    		for(int j = 0; j < matrix.length; j++) {
    			boolean isG = isGroup(matrix, i, j);
    			if(isG) {
    				count++;
    			}
    		}
    	}

    	return count;
     }
    
    //recursively check above and below and switch value to zero
    public static boolean isGroup(int[][] matrix, int i, int j) {
    	if(i < 0 || j < 0 || i >= matrix[0].length || j >= matrix.length || matrix[i][j] == 0) {
    		return false;
    	}else{
    		matrix[i][j] = 0;
    		isGroup(matrix, i + 1, j);
    		isGroup(matrix, i - 1, j);
    		isGroup(matrix, i, j + 1);
    		isGroup(matrix, i, j - 1);
    		
    		return true;
    	}
    }

    
    public int[] plusOne(int[] digits) {
        
    	int[] result;
    	
    	boolean increaseArray = true;
    	
    	for(int i = 0; i < digits.length; i++) {
    		if(digits[i] != 9) {
    			increaseArray = false;
    		}
    	}
    	
    	if(increaseArray) {
    		result = new int[digits.length + 1];   		
    	}else {
    		result = new int[digits.length];
    	}    
    	
		for(int i = 0; i < digits.length; i++) {
			result[result.length - 1 - i] = digits[digits.length - 1 - i];
		}

		boolean remainder = true; //start with remainder flag because we are adding 1
		
		for(int i = result.length - 1; i >= 0; i--) {
			
			if(result[i] == 9 && remainder) {
				result[i] = 0;
			}else if(remainder) {
				result[i] = result[i] + 1;
				remainder = false;
			}
		}
    	return result;
    }
    
    public void moveZeroes(int[] nums) {   	
    	int endIndx = nums.length - 1; 
    	int startIndx = 0;
    	for(int i = 0; i < nums.length; i++) {  		
    		if(nums[startIndx] == 0) {//Rotate
    			reverse(nums, startIndx, endIndx + 1);
    			reverse(nums, startIndx, endIndx);
    			endIndx--;
    		}else {
    			startIndx++;
    		}
    	}
    }
    
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
    	
    	Map<Integer, Integer> map = new HashMap<Integer,Integer> ();
    	
    	for(int i = 0; i < nums.length; i++) {
    		map.put(nums[i], i);
    	}
    	
    	for(int i = 0; i < nums.length; i++) {
    		int x = nums[i];
    		
    		if(map.containsKey(target - x)) {
    			int yIndx = map.get(target - x);
    			
    			if(yIndx == i) continue;
    			
    			result[0] = i;
    			result[1] = yIndx;
    			break;
    		}
    	}
    	
        return result;
    }
}
