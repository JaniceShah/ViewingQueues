package initialQueue;

import java.util.NoSuchElementException;

import viewers_info.ViewingRequest;

class DoublyLinkedList {
    private Node first;
    private Node last;
    private int size;
    
    /**
     * Constructs an empty doubly linked list.
     */
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    public void addFirst(ViewingRequest viewer) {
        Node newNode = new Node(viewer, first, null);
        if (first != null) {
        	first.previous = newNode;
        }
        first = newNode;
        if (last == null) {
            last = newNode;
        }
        size++;
    }

    
    public void insert(ViewingRequest viewer, Node node) {
        Node newNode = new Node(viewer, node.next, node);
        node.next = newNode;
        if (newNode.next != null) {
            newNode.next.previous = newNode;
        } else {
            last = newNode;
        }
        size++;
    }
    
	    public ViewingRequest pop() {
		  if (first == null) {
	          throw new NoSuchElementException();
	      }
	      ViewingRequest viewer = first.viewer;
	      first = first.next;
	      if (first != null) {
	          first.previous = null;
	      } else {
	          last = null;
	      }
	      size--;
	      return viewer;
	  }

    public Node getFirstNode() {
        return first;
    }

    public Node getLastNode() {
        return last;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    
}
