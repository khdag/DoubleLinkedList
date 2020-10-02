/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DoubleLinkedList <A> {

    //change, moe was here
    private static class Node<A>{
        Node next;
        private A Input;
        private Node<A> nextNode;
        private Node<A> prevNode;

        public Node(A Input, Node<A> nextNode, Node<A> prevNode) {
            this.Input = Input;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
        public A getInput(){
            return Input;
        }

        public void setNext(Node<A> nextNode){
            this.nextNode = nextNode;
        }
        public Node<A> getNext(){
            return nextNode;
        }

        public void setprev(Node<A> prevNode){
            this.prevNode = prevNode;
        }
        public Node<A> getprev(){
            return prevNode;
        }
    }

    int size = 0;
    private Node<A> head;
    private Node<A> tail;


    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(A element){
        Node<A> newNode = new Node<>(element, head , null); // 

        if(isEmpty()) tail = newNode;
        if(size != 0) head.setprev(newNode);
        head = newNode;
        size++;
    }

    public void addLast(A element){
        Node<A> newNode = new Node<>(element, null, tail);

        if(isEmpty()) head = newNode;
        else {
            tail.setNext(newNode);
        }

        tail = newNode;
        size++;
    }

    public A remove(Node<A> node){
        Node<A> predecessor = node.getprev();
        Node<A> succesor = node.getNext();
        predecessor.setNext(succesor);
        succesor.setprev(predecessor);
        size--;
        return node.getInput();
    }

    public A removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(head.getNext());
    }

    public A removeLast(){
        if (isEmpty()){
            return null;
        }
        return remove(tail.getprev());
    }


    public void printAll()
    {
        Node<A> currentNode = head;
        while(currentNode != null)
        {
            System.out.println(currentNode.getInput());
            currentNode = currentNode.getNext();
        }
    }
    public void printReverse(){
        Node<A> currentNode = tail;
        while(currentNode != null)
        {
            System.out.println(currentNode.getInput());
            currentNode = currentNode.getprev();
        }
    }
}
//doesnt work
  /*  public Node<A> deleteFirst()
	    {
	        Node temp = head;

	        if(head.next==null)
	            tail = null;
	        else
	            {head.prevNode = null;
	            head = head.next;}

	        return temp;
	    }
	// needs to be fixed
    public Node<A> deletetLast() 
	    {if(head == null) {  
            System.out.println("List is empty");  
            return null;  
        }  
        else {  
		 if(head != tail) {  
                head = head.next;  
            }  
		 else {  
                head = tail = null;  
            }
                }

	        Node secondLast = head; 
	        while (secondLast.next.next != null) 
	            secondLast = secondLast.next; 

	        secondLast.next = null; 

	        return head; 
	    }
	    void deleteNode(struct Node **head_ref, int key) 
{ 
    // Store head node 
    struct Node* temp = *head_ref, *prev; 
  
    // If head node itself holds the key to be deleted 
    if (temp != NULL && temp->data == key) 
    { 
        *head_ref = temp->next;   // Changed head 
        free(temp);               // free old head 
        return; 
    }*/

