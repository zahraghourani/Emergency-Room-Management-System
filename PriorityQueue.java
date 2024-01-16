package erms;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue extends LinkedList{
    public static final int CRITICAL_LEVEL = 5;
    public PriorityQueue() {
		super();
	}

	public void enqueue(Patient a, int p) {
		priorityEnqueue(a, p);
	}

	public void enqueueNormal(Patient a, int p) {
		insertAtBack(a, p);
	}

	public Node dequeue() {
		return deleteFromFront();
	}
    
    public boolean isEmpty(){
        return super.isEmpty();
    }
    
}