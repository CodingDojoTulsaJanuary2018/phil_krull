package singlyLinkedList;

public class ListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList myList = new SinglyLinkedList();
		System.out.println("the list head is: " + myList.getHead());
		myList.add(88);
		System.out.println("the list head is: " + myList.getHead());
		myList.add(5);
		System.out.println("the list head is: " + myList.getHead());
		myList.add(41);
		myList.add(78);
		myList.add(12);
		myList.add(57);
		myList.printValues();
		Node nodeRemoved = myList.remove();
		System.out.println("the node removed is: " + nodeRemoved);
		myList.printValues();
		Node nodeFound = myList.find(88);
		Node nodeNotFound = myList.find(40);
		System.out.println("node found is: " + nodeFound);
		System.out.println("node not found is: " + nodeNotFound);
		myList.removeAt(0);
		myList.printValues();
		myList.removeAt(2);
		myList.printValues();
		myList.removeAt(2);
		myList.printValues();
	}

}
