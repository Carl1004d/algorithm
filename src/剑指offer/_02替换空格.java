package 剑指offer;
 
/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are
 * Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 */
public class _02替换空格 {
	 public String replaceSpace(StringBuffer str) {
	    	return "";
	    }
}
/**
 * Step1.先遍历一次字符串，这样就能统计出字符串中空格的总数，并可以由此计算出替换之后的字符串的总长度。
 * 以前面的字符串"We arehappy."为例，"We are
 * happy."这个字符串的长度是14（包括结尾符号'\0'），里面有两个空格，因此替换之后字符串的长度是18。
 * Step2.从字符串的后面开始复制和替换。
 * 准备两个指针，P1和P2。P1指向原始字符串的末尾，而P2指向替换之后的字符串的末尾。接下来向前移动指针P1，逐个把它指向的字符复制到P2指向的位置，
 * 直到碰到第一个空格为止。接着向前复制，直到碰到第二、三或第n个空格。
 */