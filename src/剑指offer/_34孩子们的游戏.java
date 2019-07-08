package 剑指offer;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class _34孩子们的游戏 {
	public static void main(String[] args) {
		_34孩子们的游戏 o = new _34孩子们的游戏();
		System.out.println(o.LastRemaining_Solution(6, 3));
	}
	public int LastRemaining_Solution(int n, int m) {
		int[] children = new int[n];
		int count = 0;	// 轮的次数
		int temp = 0;	// 往后轮的children数组下标
		while(count != n-1){
			int times = 0;	// 往后轮的下数
			for(;times <= m-1;){
				if(children[temp] == 0) {	// 没有剔除
					if(times==m-1) {	// 轮到m-1
						children[temp] = 1;	// 剔除这个人
						break;
					}
					times++;
					temp = (temp+1) % n;
				} else {
					temp = (temp+1) % n;	// 继续往后轮
				}
			}
			count++;
		}
		for(int i = 0; i < n; i++){
			if(children[i] == 0) return i;
		}
		return -1;
	}
}
