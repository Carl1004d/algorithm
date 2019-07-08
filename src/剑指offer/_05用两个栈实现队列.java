package 剑指offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 */
public class _05用两个栈实现队列 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {

	}

	public int pop() {
		return 0;
	}
}
/**
 * 第一个栈临时保存插入的数据，当调用弹出函数的时候，如果stack2不为空则直接弹出；为空则把stack1中的数据全部弹出放到stack2中。
 * 
 * 这样不会存在冲突，而且由于stack2保存的是以前的老数据，弹出一定都符合队列的规律。
 */