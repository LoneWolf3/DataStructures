import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
	public void reverse(Queue q)
	{
	    Stack s = new Stack();  //create a stack

	    //while the queue is not empty
	    while(!q.isEmpty())
	    {  //add the elements of the queue onto a stack
	       s.push(q.poll());
	    } 

	    //while the stack is not empty
	    while(!s.isEmpty())
	    { //add the elements in the stack back to the queue
	      q.offer(s.pop());
	    }

	}
}
