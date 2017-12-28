package ds.list;

public class LinkedList<E> implements List<E> {
	private Link<E> head;
	private Link<E> tail;
	protected Link<E> curr;
	int length;
	
	public LinkedList(){	//I added this constructor. Must write it in the readme file.
		curr = tail = head = new Link<E>(null,null);
		length = 1;
	}
	public void setValue(int pos, E item) {	// I added this method just to change the value of the Link.element curr points to.
		if(pos<0||pos>length()-1) {
			return;
		}
		curr = head;
		for(int i=0;i<pos;i++)
			curr = curr.next();
		curr.setElement(item);
	}
	@Override
	public void clear() {
		curr = tail = head = new Link<E>(null,null);
		length = 1;
	}

	@Override
	public void insert(int pos, E item) {
		if(pos<0||pos>length()){
			return;
		}
		if(length==0) {
			curr = tail = head = new Link<E>(item,null);
			length++;
			return;
		}
		/*
		* moves curr to the location of pos-1
		*/
		curr = head;
		if(pos==length())
			curr = tail;
		else
			for(int i=0;i<pos-1;i++)
				curr = curr.next();
		curr.setNext(new Link<E>(item, curr.next()));
		if(tail == curr)
			tail = curr.next();
		length++;
	}

	@Override
	public E remove(int pos) {
		if(pos<0 || pos>length()-1)
			return null;
		curr = head;
		for(int i=0;i<pos-1;i++)
			curr = curr.next();
		if(curr.next()==null) {
			E it = curr.getElement();
			curr = head = tail = null;
			length--;
			return it;
		}
		E it = curr.next().getElement();
		if(tail == curr.next())
			tail = curr;
		curr.setNext(curr.next().next());
		length--;
		return it;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public E getValue(int pos) {
		if(pos<0||pos>length()-1)
			return null;
		curr = head;
		for(int i=0;i<pos;i++)
			curr = curr.next();
		return curr.getElement();
	}
}