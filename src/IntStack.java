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
	   if (this.integerStack.size() == 0)
		   throw new RuntimeException("Nothing to clone.");
	   
	   LinkedList<Integer> clone = new LinkedList<Integer>();
	   
	   for (int i = 0; i < this.integerStack.size(); i++) {
		   clone.addLast(this.integerStack.get(i));
	   }
      return clone; // TODO!!! Your code here!
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
	   if (this.integerStack.size() == 0)
		   throw new RuntimeException("Stack is empty.");
	   
	   int x2 = this.integerStack.pop();
	   int x1 = this.integerStack.pop();
	   
	   if (s.equals("-")) push(x1 - x2);
	   if (s.equals("+")) push(x1 + x2);
	   if (s.equals("*")) push(x1 * x2);
	   if (s.equals("/")) push(x1 / x2);
   }
  
   public int tos() {
	   if (this.stEmpty())
		   throw new RuntimeException("Stack is empty.");
      return this.integerStack.getFirst();
   }

   @Override
   public boolean equals (Object o) {
//	   if (!(o instanceof LinkedList<?>))
//		   return false;
	   int a = this.integerStack.size();
	   int b = ((LinkedList<Integer>) o).size();
	   
	   if (a != b)
		   return false;
	   
	   for (int i = 0; i < a; i++) {
		   if (this.integerStack.get(i) != ((LinkedList<Integer>) o).get(i)) {
			   return false;
		   }
	   }
	   return true; // TODO!!! Your code here!
   }
   
//   public boolean equals (IntStack stack) {
//	   if (this.integerStack.size() != stack.size())
//		   return false;
//      return true;
//   }
//   
//   public int size(){
//	   return this.integerStack.size();
//   }

   @Override
   public String toString() {
	   if (this.integerStack.size() == 0)
		   return "Stack is empty.";
	   
	   StringBuffer sb = new StringBuffer();
	   
	   for (int i = this.integerStack.size()-1; i >= 0; i--) {
		   sb.append(String.valueOf(this.integerStack.get(i) + " "));
	   }
	   
       return sb.toString();
   }

   public static int interpret (String pol) {
      return 0; // TODO!!! Your code here!
   }

}

