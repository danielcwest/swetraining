package dan.swetraining.leetcode;

import java.util.ArrayList;
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
}
