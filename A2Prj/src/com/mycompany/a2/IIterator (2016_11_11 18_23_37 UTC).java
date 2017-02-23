package com.mycompany.a2;

public interface IIterator {
	boolean hasNext();
	public Object getNext();
	public void remove();
	public int getIndex();
	public Object get(int i);
	public Object objectAt(int i);
	public int size();
}
