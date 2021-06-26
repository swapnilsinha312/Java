package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head=new LLNode<E>();
		tail=new LLNode<E>();
		head.next=tail;
		tail.prev=head;
		size=0;
		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E el) 
	{
		// TODO: Implement this method
		if(el==null) throw new NullPointerException("Null element is not accepted");
		size++;
		LLNode<E> aa = new LLNode<E>(el);
		LLNode<E> aaa=tail.prev;
		aaa.next=aa;
		aa.prev=tail.prev;
		tail.prev=aa;
		aa.next=tail;
		aa.data=el;
			
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index>=size||size==0||index<0)
			throw new IndexOutOfBoundsException("Index greater than size"+size+index);
		int oo=-1;
		for(LLNode<E> aa=head;aa.next!=null && oo<size;aa=aa.next,oo++)
		{
			if(index==oo) 
				return aa.data;
			
		}
		return null;
	} 

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E el ) 
	{
		
		// TODO: Implement this method
		if(!(size==0 && index==0 && el!=null)){
		if(el==null) 	throw new NullPointerException("Null element is not accepted");
		if(index>size-1|index<0)	throw new IndexOutOfBoundsException("Index greater than size");
		
		}
		size++;
		int oo=-1;
		LLNode<E> aaa=new LLNode<E>(el);
		zz:for(LLNode<E> aa=head;aa.next!=null;aa=aa.next,oo++)
		{
			if(index-1==oo) 
			{
				aaa.next=aa.next;
				aa.next=aaa;
				aaa.prev=aa;
				aaa.next.prev=aaa;
				break zz;
			}
			
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
		
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index>=size||index<0)	throw new IndexOutOfBoundsException("Index greater than size");
		int oo=-1; size--;
		LLNode<E> aaa=new LLNode<E>();
		for(LLNode<E> aa=head;aa.next!=null && oo<size-1;aa=aa.next,oo++)
		{
			
			if(index==oo) 
			{
				aaa=aa.prev;
				aaa.next=aa.next;
				aa.next.prev=aaa;
				E ss=aa.data;
				aa.next=null;
				aa.prev=null;
				return ss;
			}
			
		}
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E el) 
	{
		// TODO: Implement this method
		if(el==null) 	throw new NullPointerException("Null element is not accepted");
		if(index>=size||index<0)	throw new IndexOutOfBoundsException("Index greater than size");
		int oo=-1;
		LLNode<E> aaa=new LLNode<E>(el);
		zz:for(LLNode<E> aa=head;aa.next!=null;aa=aa.next,oo++)
		{
			if(index==oo) 
			{
				E ss=aa.data;
				aa.data=el;
				return ss;
			}
			
		}
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode() 
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
