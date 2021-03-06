package dynamicProgrammingEasy;

import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * @author 84135
 *
 */
public class _139WordBreak {
	  public boolean wordBreak(String s, Set<String> dict) {
	        
	        boolean[] f = new boolean[s.length() + 1];
	        
	        f[0] = true;
	        
	        
	        /* First DP
	        for(int i = 1; i <= s.length(); i++){
	            for(String str: dict){
	                if(str.length() <= i){
	                    if(f[i - str.length()]){
	                        if(s.substring(i-str.length(), i).equals(str)){
	                            f[i] = true;
	                            break;
	                        }
	                    }
	                }
	            }
	        }*/


	        // 这个是当i截取abcdef时候,j=0,看"a"之前是不是被拼成功过,再截取a后面的bcdef,看有没有匹配.有了就修改当前f[i]为true.没有就跳过,用下一个ab和cdef判断
	        //Second DP
	        for(int i=1; i <= s.length(); i++){
	            for(int j=0; j < i; j++){
	                if(f[j] && dict.contains(s.substring(j, i))){
	                    f[i] = true;
	                    break;
	                }
	            }
	        }
	        
	        return f[s.length()];
	    }
}
