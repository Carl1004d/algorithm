package dynamicProgrammingMedium;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again). After you sell your stock, you cannot
 * buy stock on next day. (ie, cooldown 1 day) Example:
 * 
 * Input: [1,2,3,0,2] Output: 3 Explanation: transactions = [buy, sell,
 * cooldown, buy, sell]
 */
// 可以用状态机,s0代表没买,s1代表买了,s2代表冷却. s0不操作到自己,购买到s1,s1不操作到自己,卖出到s2,s2不操作到s0
// s0[i] = Math.max(s2[i - 1], s0[i - 1]);
// s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
// s2[i] = s1[i - 1] + prices[i];
public class _309BestTimeBuySellStock {
//	public int maxProfit(int[] prices) {
//		if (prices.length <= 1)
//			return 0;
//		int[] s0 = new int[prices.length];
//		int[] s1 = new int[prices.length];
//		int[] s2 = new int[prices.length];
//		s1[0] = -prices[0];
//		for (int i = 1; i < prices.length; i++) {
//			s0[i] = Math.max(s2[i - 1], s0[i - 1]);
//			s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
//			s2[i] = s1[i - 1] + prices[i];
//		}
//		return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
//	}
	public int maxProfit(int[] prices) {
	    int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
	    for (int price : prices) {
	        prev_buy = buy;
	        buy = Math.max(prev_sell - price, prev_buy);
	        prev_sell = sell;
	        sell = Math.max(prev_buy + price, prev_sell);
	    }
	    return sell;
	}
	public static void main(String[] args) {
		_309BestTimeBuySellStock o = new _309BestTimeBuySellStock();
		int[] a = {3,4,4,1,2};
		System.out.println(o.maxProfit(a));
	}
}
