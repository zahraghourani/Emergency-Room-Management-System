package erms;

public class Node {
    public Patient data;
    public Node next;
    public int priority;
    
    public Node(Patient data){
        this.data = data;
        next = null;
    }
    
    public Node(Patient data, int priority){
        this.data = data;
        this.priority = priority;
        next = null;
    }
}