package dan.swetraining.leetcode;

public class LeetCodeStrings {

	public int reverse(int x) {
		
		int sign = x < 0 ? -1 : 1;
		
		x = Math.abs(x);
        
		char[] num = String.valueOf(x).toCharArray();
				
		for(int i = 0; i < num.length / 2; i++) {
			char t = num[i];
			num[i] = num[num.length - 1 - i];
			num[num.length - 1 - i] = t;
		}
		
		String max = String.valueOf(Integer.MAX_VALUE);
		
		String res = new String(num);
		
		if(res.length() >= max.length() && res.compareTo(max) > 0) {
			return 0;
		}
		
		int result = Integer.valueOf(new String(num));
		
		return result * sign;
    }
}
