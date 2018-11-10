package easyArrays;

import org.junit.Test;

public class CanPlaceFlowers605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0
					&& (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
			}
		}

		return count >= n;
	}
	@Test
	public void fun1(){
		int[] a = {1,0,0,0,1,0,0};
		System.out.println(canPlaceFlowers(a,2));
	}
}
