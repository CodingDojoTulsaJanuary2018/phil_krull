package singlyLinkedList;

public class SinglyLinkedList {
	private Node head;

	public SinglyLinkedList() {
	}
	
//	Create a add(int) method that will add a node to the end of your list with the value in the parameter
	public Node add(int val) {
		Node newNode = new Node(val);
		// empty list
		if(head == null) {
			head = newNode;
		} else {
			// not empty
			Node runner = this.head;
			while(runner.getNext() != null) {
				runner = runner.getNext();
			}
			runner.setNext(newNode);
		}
		return head;
	}
//	Create a remove() method that will remove a node from the end of your list
	public Node remove() {
		Node runner = this.head;
		// if empty list
		if(head == null) {
			return head;
		}
		// if 1 node in list
		else if(head.getNext() == null) {
			head = null;
			return runner;
		}
		// many nodes
		else {
			while(runner.getNext().getNext() != null) {
				runner = runner.getNext();
			}
			Node rNode = runner.getNext();
			runner.setNext(null);
			return rNode;
		}
	}

//	Create printValues() method that will print all the values of each node in the list in order
	public void printValues() {
		Node runner = this.head;
		System.out.println("===================================================");
		while(runner != null) {
			if(runner.getNext() != null) {				
				System.out.print(runner.getValue() + ", ");
			} else {
				System.out.println(runner.getValue());
			}
			runner = runner.getNext();
		}
		System.out.println("===================================================");
	}
	
//	 Implement a find(int) method that will return the first node with the value in the parameter
	public Node find(int val) {
		Node runner = head;
		while(runner != null && runner.getValue() != val) {
			runner = runner.getNext();
		}
		//  runner could be null or the correct node
		return runner;
	}
	
//   Implement a removeAt(int) method that will remove the node after n nodes, where n is the parameter. For example, if n is 0, remove the first node. If n is 1, remove the second node. Similar to Arrays.
	public Node removeAt(int position) {
		Node runner = head;
		Node rNode;
		// empty list
		if(head == null) {
			return head;
		}
		// position is 0 at head
		if(position == 0) {
			rNode = head;
			head = head.getNext();
			rNode.setNext(null);
			return rNode;
		}
		// somewhere else
		while(runner.getNext() != null && position > 1) {
			runner = runner.getNext();
			position --;
		}
		rNode = runner.getNext();
		// if node is the last node
		if(rNode.getNext() != null) {
			runner.setNext(rNode.getNext());
		} else {
			runner.setNext(null);
		}
		return rNode;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
}
