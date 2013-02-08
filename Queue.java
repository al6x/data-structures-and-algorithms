import static org.junit.Assert.assertEquals;

// [Queue](http://en.wikipedia.org/wiki/Queue_(abstract_data_type) is a collection of elements of
// type `T`, keeping [FIFO](http://en.wikipedia.org/wiki/FIFO) order and supporting `push`, `pop`
// and `isEmpty` operations.
public class Queue <T> {
  // Node - single element of queue, contains the value and reference to the next node.
  class Node <T> {
    T value;
    Node <T> next;
    Node(T value){this.value = value;}
  }

  // References to first and last elements of queue. Strictly speaking we don't need the
  // last element (it can be inferred by traversing `node.next`) but having it improves
  // performance of `push`.
  Node <T> first = null;
  Node <T> last = null;

  // Add value to queue.
  public void push(T value){
    Node <T> node = new Node(value);
    if(last != null) last.next = node;
    last = node;
    if(first == null) first = node;
  }

  // Add multiple values to queue.
  public void push(T... values){for(T value : values) push(value);}

  // Take value from queue.
  public T pop(){
    if(first == null) return null;
    T value = first.value;
    first = first.next;
    if(first == null) last = null;
    return value;
  }

  // Check if queue is empty.
  boolean isEmpty(){return first == null;}

  // # Example
  @org.junit.Test
  public void example(){
    // Queue containing messages.
    Queue <String> messages = new Queue<String>();

    // Queue is empty.
    assertEquals(messages.isEmpty(), true);
    assertEquals(messages.pop(), null);

    // Adding messages.
    messages.push("First");
    assertEquals(messages.isEmpty(), false);

    messages.push("Second", "Third");
    assertEquals(messages.isEmpty(), false);

    // Retrieving messages.
    assertEquals(messages.pop(), "First");
    assertEquals(messages.pop(), "Second");
    assertEquals(messages.pop(), "Third");
    assertEquals(messages.pop(), null);
    assertEquals(messages.isEmpty(), true);
  }
}