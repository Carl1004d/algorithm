package 剑指offer;
/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class _07斐波那契数列 {
	public static void main(String[] args) {
		_07斐波那契数列 o = new _07斐波那契数列();
		System.out.println(o.Fibonacci(40));
	}
	public int Fibonacci(int n) {
		if(n==0 ) return 0;
		if(n==1 ) return 1;
		return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
