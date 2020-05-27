package adt;

public class LinkedList<E> {

	private class Node{
		public E e;
		public Node next;
		
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this(e, null);
		}
		
		public Node() {
			this(null, null);
		}
		
		@Override
		public String toString() {
			return e.toString();
		}
	}
	
	private Node dummyHead;
	private int size;
	
	public LinkedList() {
		dummyHead = new Node();
		size = 0;
	}
	
	// ��ȡ������Ԫ�صĸ���
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	
	/**
	 *   null | 0 | 1 | 2 | 3 | 4 | 5 |
	 *     |        |       |
	 * dummyHead  prev     next
	 * 
	 */
	
	public void add(int index, E e) {
		
		if(index < 0 || index > size)
			throw new IllegalArgumentException("Add failed. Illegal index.");
		
			Node prev = dummyHead;
			for(int i = 0; i < index; i++)
				prev = prev.next;
//			Node node = new Node(e);
//			node.next = prev.next;
//			prev.next = node;
			prev.next = new Node(e, prev.next);
			size ++;
	}
	
	// ������ͷ�����µ�Ԫ��
	public void addFirst(E e) {
		add(0, e);
	}
	
	// ������ĩβ�����µ�Ԫ��e
	public void addLast(E e) {
		add(size, e);
	}
	
	// ��������ĵ�index(0-based)��λ�õ�Ԫ��
	public E get(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get failed. Illegal index.");
		
		Node cur = dummyHead.next;
		for(int i = 0; i < index; i ++)
			cur = cur.next;
		return cur.e;
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	public void set(int index, E e) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Update failed. Illegal index.");
		
		Node cur = dummyHead.next;
		for(int i = 0; i < index; i ++)
			cur = cur.next;
		cur.e = e;
	}
	
	// �����������Ƿ���Ԫ��e
	public boolean contains(E e) {
		Node cur = dummyHead.next;
		while(cur != null) {
			if(cur.e.equals(e))
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed. Index is illegal.");
		
		Node prev = dummyHead;
		for(int i = 0; i < index; i++)
			prev = prev.next;
		Node retNode = prev.next;
		prev.next = retNode.next;
		retNode.next = null;
		size --;
		
		return retNode.e;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size - 1); 
	}
	
	@Override
	public String toString() {
		
		StringBuilder res = new StringBuilder();
		
		Node cur = dummyHead.next;
		while(cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("NULL");
		
		return res.toString();
	}
	
	
	
}