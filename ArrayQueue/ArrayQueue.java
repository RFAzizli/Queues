package Queues.ArrayQueue;
import Queues.Queue;

public class ArrayQueue implements Queue{
    private Object[] items;
    private int front;
    private int rear;
    private int numItems;
    public ArrayQueue(int maxSize){
        if(maxSize<0){
            throw new IllegalArgumentException();
        }
        this.items=new Object[maxSize];
        this.numItems=0;
        this.front=0;
        this.rear=-1;
    }
    /*
        length() - returns the length of the queue
     */
    public int length(){
        return this.numItems;
    }
    /*
        isEmpty() - checks if the queue is empty
     */
    public boolean isEmpty(){
        return this.numItems==0;
    }
    /*
        isFull() - checks if the queue is full
     */
    public boolean isFull(){
        return this.numItems==this.items.length;
    }
    /*
        insert(Object o) - wrapper method for insertItem()
     */
    public boolean insert(Object o){
        return this.insertItem(o);
    }
    /*
        insertItem(Object item) - inserts an Object item in the queue
     */
    private boolean insertItem(Object item){
        if(item==null){
            throw new IllegalArgumentException();
        }
        if(this.isFull()){
            return false;
        }
        this.rear=(this.rear+1)%this.items.length;
        this.items[this.rear]=item;
        this.numItems++;
        return true;
    }
    /*
        remove() - wrapper method for removeItem()
     */
    public Object remove(){
        return this.removeItem();
    }
    /*
        removeItem() - removes an Object from the front of the queue
     */
    private Object removeItem(){
        if(this.isEmpty()){
            return null;
        }
        Object removed=this.items[this.front];
        this.items[this.front]=null;
        this.front=(this.front+1)%this.items.length;
        this.numItems--;
        return removed;
    }
    /*
        peek() - wrapper method for peekItem()
     */
    public Object peek(){
        return this.peekItem();
    }
    /*
        peekItem() - returns an Object from the queue that is at the front of it
     */
    private Object peekItem(){
        if(this.isEmpty()){
            return null;
        }
        return this.items[this.front];
    }

    /*
        toString() - overridden method from Object class that returns a string that represents ArrayQueue object
     */
    public String toString(){
        String result="{";
        Object[] copy=new Object[this.numItems];
        int lastIndex=0;
        for(int i=this.front,j=0;i<this.items.length && j<copy.length;i++,j++){
            copy[j]=this.items[i];
            lastIndex=j;
        }
        lastIndex++;
        for(int i=0,j=lastIndex;i<this.front&& j<copy.length;i++,j++){
            if(this.items[i]==null){
                continue;
            }
            copy[j]=this.items[i];
        }
        for(int i=0;i<copy.length;i++){
            result+=copy[i];
            if(i==this.numItems-1){
                break;
            }
            result+=", ";
        }
        result+="}";
        return result;
    }

}
