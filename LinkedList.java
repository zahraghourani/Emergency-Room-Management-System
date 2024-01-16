package erms;

public class LinkedList{
        private Node first;
	private Patient pat;

	public LinkedList() {
		first = null;
		pat = null;
	}

	public LinkedList(Patient pat) {
		first = null;
		this.pat = pat;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertAtBack(Patient v, int p) {
		Node n = new Node(v, p);
		if (isEmpty()) {
			first = n;
		} else {
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = n;
			n.next = null;
		}
	}
        
        public void priorityEnqueue(Patient a, int priority) {
		Node n = new Node(a, priority);
		boolean flag = false;
		if (isEmpty()) {
			first = n;
		} else if (first.priority > priority) {
			Node current = first;
			if (first.next != null)
				while (current.next.priority > priority) {
					current = current.next;
					if (current.next == null)
						break;
				}
			n.next = current.next;
			current.next = n;
		} else {
			n.next = first;
			first = n;
		}
	}


	public Node deleteFromFront() {
		Node temp = first;
		if (!isEmpty()) {
			first = first.next;
		}
		return temp;
	}

	public void display() {
		Node current = first;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}