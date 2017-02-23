package com.mycompany.a2;

import java.util.Vector;

public class GameObjectIterator implements IIterator{
	private int index;
	private Vector collection;
	public GameObjectIterator(Vector c){
		index= -1;
		collection= c;
	}
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(collection.size() <= 0) {
			return false;
		}
		if(index == collection.size() - 1) {
			return false;
		}
		return true;
	}

	public Object getNext() {
		// TODO Auto-generated method stub
		index++;
		return(collection.elementAt(index));
	}

	public void remove() {
		// TODO Auto-generated method stub
		collection.remove(index);
	}

	public int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	public Object objectAt(int i) {
		// TODO Auto-generated method stub
		return collection.get(i);
	}
	public Object get(int i){
		return(collection.elementAt(i));
	}
	public int size(){
		return collection.size();
	}

}
