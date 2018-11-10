package easyArraysWrong;

import org.junit.Test;
/*
	You're given strings J representing the types of stones that are jewels, 
	and S representing the stones you have.  Each character in S is a type of stone you have.  
	You want to know how many of the stones you have are also jewels.
	The letters in J are guaranteed distinct, and all characters in J and S are letters. 
	Letters are case sensitive, so "a" is considered a different type of stone from "A".
	Example 1:
	Input: J = "aA", S = "aAAbbbb"
	Output: 3
	Example 2:
	Input: J = "z", S = "ZZ"
	Output: 0
*/
/* 这个更简单:
 * public int numJewelsInStones(String J, String S) {
        boolean[] dictionary = new boolean[256];
        for(int i=0; i<J.length(); i++){
            dictionary[J.charAt(i)] = true;
        }
        int count = 0;
        for(int i=0; i<S.length(); i++){
            if(dictionary[S.charAt(i)]){
                count++;
            }
        }
        return count;
    }
 */
public class WrongJewelsandStones {
	
	public int numJewelsInStones(String J, String S) {
		char[] chsJ = J.toCharArray();
		char[] chsS = S.toCharArray();
		int sum = 0;
		for (char s : chsS) {
			for (char j : chsJ) {
				if(j == s){
					sum += 1;
					break;
				}
			}
		}
		
		return sum;
	}
	@Test
	public void testAp(){
		int jewels = numJewelsInStones("aA","aAAbbbb");
		System.out.println(jewels);
//		System.out.println('a'=='a');  // true
	}
}
