package Queues.LinkedQueues;
import Queues.Queue;
public class SingleLinkedQueue implements Queue{
    /*
        Private Node class, used to define elements of the Linked List and connect them.
    */
    private class Node{
        private Object item;
        private Node next;
        private Node(Object i,Node n){
            this.item=i;
            this.next=n;
        }
    }
    private Node first;
    private Node last;
    private int numItems;
    /*
        SingleLinkedQueue() - constructor that initializes local variables
     */
    public SingleLinkedQueue(){
        this.first=null;
        this.last=null;
        this.numItems=0;
    }
    /*
        insert(Object i) - wrapper method for insertItem()
     */
    public boolean insert(Object i){
        return this.insertItem(i);
    }
    /*
        insertItem(Object i) - inserts an item i in the Queue
     */
    private boolean insertItem(Object i){
        if(i==null){
            throw new IllegalArgumentException();
        }
        if(this.isFull()){
            return false;
        }
        Node newNode=new Node(i,null);
        if(this.first==null){
            this.first=newNode;
        }else{
            this.last.next=newNode;
        }
        this.last=newNode;
        this.numItems++;
        return true;
    }
    /*
        remove()- wrapper method for removeItem()
     */
    public Object remove(){
        return this.removeItem();
    }
    /*
        removeItem() - removes the first object in the Queue and returns it
     */
    private Object removeItem(){
        if(this.isEmpty()){
            return null;
        }
        Object removed=this.first.item;
        this.first=this.first.next;
        if(this.numItems==1){
            this.last=this.first;
        }
        this.numItems--;
        return removed;
    }
    /*
        peek()- wrapper method for peekItem()
     */
    public Object peek(){
        return this.peekItem();
    }
    /*
        peekItem()- returns the first object from the Queue
     */
    private Object peekItem(){
        if(this.isEmpty()){
            return null;
        }
        return this.first.item;
    }
    /*
        isEmpty() - return true if the Queue is empty, otherwise false
     */
    public boolean isEmpty(){
        return this.numItems==0;
    }
    /*
        isFull() - always returns false since SingleLinkedQueue can't be full
     */
    public boolean isFull(){
        return false;
    }
    /*
        length() - returns the length of the Queue
     */
    public int length(){
        return this.numItems;
    }
    /*
        toString() - overridden method from Object class that returns a string that represents SingleLinkedQueue object
     */
    public String toString(){
        String result="{";
        Node current=this.first;
        while(current!=null){
            result+=current.item;
            if(current.equals(this.last)){
                break;
            }
            result+=", ";
            current=current.next;
        }
        result+="}";
        return result;
    }

}
