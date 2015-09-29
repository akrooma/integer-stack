import java.util.LinkedList;

public class IntStack {
	private LinkedList<Integer> integerStack;

   public static void main (String[] argum) {
	   
   }

   IntStack() {
	   this.integerStack = new LinkedList<Integer>();
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return this; // TODO!!! Your code here!
   }

   public boolean stEmpty() {
	   return (this.integerStack.size() == 0);
   }

   public void push (int a) {
	   this.integerStack.addFirst(a);
   }

   public int pop() {
	   if (this.stEmpty())
		   throw new RuntimeException("Stack is empty.");
	   return this.integerStack.removeFirst();
   }

   public void op (String s) {
      // TODO!!!
   }
  
   public int tos() {
	   if (this.stEmpty())
		   throw new RuntimeException("Stack is empty.");
      return this.integerStack.getFirst();
   }

   @Override
   public boolean equals (Object o) {
      return true; // TODO!!! Your code here!
   }
   
   public boolean equals (IntStack stack) {
	   if (this.integerStack.size() != stack.size())
		   return false;
      return true; // TODO!!! Your code here!
   }
   
   public int size(){
	   return this.integerStack.size();
   }

   @Override
   public String toString() {
      return null; // TODO!!! Your code here!
   }

   public static int interpret (String pol) {
      return 0; // TODO!!! Your code here!
   }

}

