package ds.stack;

import ds.list.LinkedList;

public class LinkedStack<E> implements Stack<E> {
	public LinkedList<E> stack;
	int pushCount = 0;
	@Override
	public void clear() {
		stack.clear();
	}

	@Override
	public void push(E item) {
		if(pushCount == 0) {
			stack = new LinkedList<E>();
			stack.setValue(0, item);
			pushCount++;
			return;
		}
		stack.insert(stack.length(),item);
	}

	@Override
	public E pop() {
		if(stack.length()==0) {
			pushCount = 0;
			return null;
		}
		return stack.remove(stack.length()-1); //-1 is right
	}

	@Override
	public int length() {
		return stack.length();
	}

	@Override
	public boolean isEmpty() {
		if(stack.length()==0)
			return true;
		return false;
	}
}
