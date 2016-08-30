package il.co.ArrayListNew;

import java.io.IOException;
import java.util.*;
import java.util.Iterator;

import il.co.ArrayListNewExceptions.IllegalIndexException;
import il.co.ArrayListNewExceptions.InitializationException;

public class ArrayListNew<E> implements List<E> {
	
	
	private E[] mass;
	private int index;
		
	public ArrayListNew(){
		mass = (E[])new Object[10];
	}
	
	public ArrayListNew(int capacity) throws InitializationException{
		
			if (capacity <0){
				throw new InitializationException();
			}
			mass = (E[]) new Object[capacity];
	}
	
	public E get(int index){
		checkIndex(index);
		return mass[index];
	}
	
	private void checkIndex(int index) {
		if (index<0 || index>=this.index){
			throw new IllegalIndexException();
		}
    }
	
	public E set(int index, E value){
		checkIndex(index);
		mass[index]=value;
		return null;
	}

	public boolean add(E value){
		if(index == mass.length){
			growArray();
		}
			mass[index]=value;
			index++;
			return true;
		}
	
	public void add(int indexx, E value){
		checkIndex(indexx);
		if (index == mass.length)
			growArray();
		System.arraycopy(mass, indexx, mass, indexx+1, index-indexx);
		mass[indexx]=value;
		index++;
	}
	
	public E remove(int indexx){
		checkIndex(indexx);
		
		System.arraycopy(mass, indexx+1, mass, indexx, index - indexx-1);
		mass[index-1]=null;
		index--;
		return null;
	}
	
	
	
	@Override
	public boolean remove(Object object) {
		//object=(E)object;
		for(int i=0;i<index;i++){
			if (mass[i].equals((E)object)){
				System.arraycopy(mass, i+1, mass, i, index-i-1);
				mass[index-1]=null;
				index--;
			    return true;				
			}
		} 
		return false;		
	}
	
	@Override
	public void clear() {
		E[] mass1 = (E[]) new Object[10];
		mass = mass1;
		index=0;
		
	}
	
	public void growArray(){
		E[] newArray = (E[]) new Object[mass.length * 2];
		System.arraycopy(mass, 0, newArray, 0, index );
		mass = newArray;
	}
	
	public int size(){
		return index;
	}
	
	public int lenght(){
		int length = mass.length;
		return length;
	}
	
	
	public Iterator<E> getIterator() {
		 return new NameIterator();
	}
	
 //TODO
	public int hashCode(){
		int code = 0;
		Iterator<E> it = iterator();
		while(it.hasNext()){
			E e = it.next();
			if (e != null){
				code = 7*e.hashCode();
			}
		}
		return code;
	}	
	
	public boolean equals (Object o){
		if(this.getClass().equals(o.getClass())){
			ArrayListNew<E> that = (ArrayListNew<E>)o;
			if (this.index != that.index){
				return false;
			} else {
				for (int i=0;i<index;i++){
					if(mass[i]==null){
						if(that.mass[i]==null){
							continue;
						} else {
							return false;
						}
					} else {
						if(!mass[i].equals(that.mass[i])){
							return false;
						}
					}
				}
			}			
		}
		return false;
	}
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new NameIterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	private class NameIterator<E> implements Iterator<E> {

	      int index;

	      @Override
	      public boolean hasNext() {
	      
	         if(index < mass.length){
	            return true;
	         }
	         else return false;
	      }

	      @Override
		public void remove() {
	    	  Iterator.super.remove();
		}

		@Override
	      public E next() {
	      
	         if(this.hasNext()){
	            return  (E) mass[index++];
	         }
	         else return null;
	      }		
	   }


}
