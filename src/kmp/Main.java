package kmp;

public class Main {
	public static void main(String[] args) {

		String s1 = "abdegababcabcababc";
		String s2 = "ababc";
		char[] A = s1.toCharArray();
		char[] B = s2.toCharArray();
		int[] F = getNext(s2);
		int m = B.length;
		int i = 0; // 上边s1字符串索引匹配到的位置(不是开始位置)
		int j = 0; // 下边s2索引
		while (i < s1.length()) {
			if (A[i] == B[j]) {
				i++;
				j++;
				if (j == m) {
					System.out.println(i - m + 1);// 注意,这里输出的位置是从1开始标号的,如果你要输出从0开始标号的位置,应该是是i-m.这份代码是我做一道题时写的,那道题要求输出的字符串位置从1开始标号.感谢@Draymonder指出了这个疏漏,更多内容请看评论区
					j = F[j - 1] + 1; // 继续向后遍历,寻找下一个匹配索引位置.其实就是最后一个匹配完了,再设定最后一个字符没有匹配,向前索引重新来,i也++了
				}
			} else {
				if (j == 0)
					i++;
				else
					j = F[j - 1] + 1;
			}
		}
	}

	// 获取next(F)数组,记录对应的某位置不匹配所需要的跳回到的位置.F元素还表示匹配之前F字符数量-1
	/**
	 * B="a  b  a a b b a b a a b" 
	 * F=-1 -1  0
	 */
	public static int[] getNext(String ps) {
		int m = ps.length();
		int[] F = new int[m];
		F[0] = -1;
		char[] B = ps.toCharArray();
		for (int i = 1; i < m; i++) {
			int j = F[i - 1];
			while ((B[j + 1] != B[i]) && (j >= 0))
				j = F[j];
			if (B[j + 1] == B[i])
				F[i] = j + 1;
			else
				F[i] = -1;
		}
		for (int c : F) {
			System.out.print(c + " ");
		}
		System.out.println();
		return F;
	}
	// 字符串从1开始标号
//	Nxt[0]=Nxt[1]=0;
//	for (int i=2,j=0;i<=m;i++){//构建 Next
//	    while (j&&T[j+1]!=T[i]) j=Nxt[j];
//	    if (T[j+1]==T[i]) ++j;Nxt[i]=j;
//	}
//	for (int i=1,j=0;i<=n;i++){//匹配
//	    while (j&&T[j+1]!=S[i]) j=Nxt[j];
//	    if (T[j+1]==S[i]) ++j;
//	    if (j==m) Mch[i]=1,j=Nxt[j];//匹配成功
//	}
}
