package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection {
	private Vector<Object> collection;
	
	GameObjectCollection(){
		collection = new Vector();
	}
	
	public IIterator getIterator() {
		// TODO Auto-generated method stub
		return new GameObjectIterator(collection);
	}

	public void add(Object o) {
		// TODO Auto-generated method stub
		collection.addElement(o);
	}
	
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
