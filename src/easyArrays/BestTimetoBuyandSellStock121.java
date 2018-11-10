package easyArrays;

import org.junit.Test;

public class BestTimetoBuyandSellStock121 {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2){
			return 0;
		}
		int profit = 0;
		int min = prices[0];
		int max = prices[0];
		for(int i = 0; i < prices.length; i++){
			// 判断买入价格,如果再次出现最小,就要从当前时日开始计算最大利润 将max的值归0(这里归到了当前最小值,这不影响的) 因为不能算之前的最大值
			if(min > prices[i]){
				min = prices[i];
				max = prices[i];
			}
			if(max < prices[i]){
				max = prices[i];
				// 因为之前在最小值更换以后最大值改变了 这里计算的 max - min不一定比之前的大
				int temp = max - min;
				if(temp > profit){
					profit = temp;
				}
			}
		}
		return profit;
	}
	@Test
	public void fun1(){
		int[] a = {7,3,6,4,1,5};
		System.out.println(maxProfit(a));
	}
}
