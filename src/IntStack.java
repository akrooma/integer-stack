import java.util.LinkedList;

public class IntStack {
	private LinkedList<Integer> integerStack;

   public static void main (String[] argum) {
//	   String s = "   \t \t356  \t \t";
//	   
//	   System.out.println("'" + s + "'");
//	   
//	   System.out.println();
//	   
//	   for (String token : s.split("\\s+")){
//		   System.out.println("--" + token + "--");
//	   }
//	   
//	   System.out.println();
//	   
//	   s = s.replaceAll("\\s+", " ").trim();
//	   System.out.println("'" + s + "'");
	   
//	   String pattern2 = "5 -";
//	   if (!(pattern2.matches("[\\s-+*/]+"))) {
//		   System.out.println("Operandid puuduvad.");
//	   }
   }

   IntStack() {
	   this.integerStack = new LinkedList<Integer>();
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
	   if (this.integerStack.size() == 0)
		   throw new RuntimeException("Nothing to clone.");
	   
	   IntStack clone = new IntStack();
	   
	   for (int i = 0; i < this.integerStack.size(); i++) {
		   clone.addLast(this.integerStack.get(i));
	   }
      return clone;
   }
   
   public void addLast (int a) {
	   this.integerStack.addLast(a);
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
	   if (o instanceof IntStack){
		   int thisLength = this.integerStack.size();
		   int inputLength = ((IntStack) o).size();
		   
		   if (thisLength == 0 && inputLength == 0)
			   return true;
		   
		   if (thisLength != inputLength)
			   return false;
		   
		   for (int i = 0; i < thisLength; i++) {
			   if (!(this.integerStack.get(i).equals(((IntStack) o).get(i))))
				   return false;
		   }
		   return true;
	   }
	   return false;
   }
   
   public int size(){
	   return this.integerStack.size();
   }
   
   public int get(int index){
	   return this.integerStack.get(index);
   }

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
   
   //Mingil m‰‰ral kasutasin siit saidilt saadud koodi: 
   //http://rosettacode.org/wiki/Parsing/RPN_calculator_algorithm
   public static int interpret (String pol) {
	   pol = pol.replaceAll("\\s+", " ").trim();
	   if (pol.length() == 0)
		   throw new RuntimeException("Empty string.");
	   
	   if (!(pol.matches("[\\s\\d-+*/]+")))
		   throw new RuntimeException("Contains illegal characters.");
	   
//	   if (pol.matches("[\\d\\s]+"))
//		   throw new RuntimeException("No operands found.");
	   
//	   if (pol.matches("[-+*/].*"))
//		   throw new RuntimeException("Starts with an operand.");
	   
	   IntStack stack = new IntStack();
	   
	   for (String token : pol.split("\\s+")) {
		   Integer tokenInt = null;
		   
		   try {
			   tokenInt = Integer.parseInt(token);
		   } catch (NumberFormatException e) {}
		   
		   if (tokenInt != null){
			   stack.push(tokenInt);
//		   } else if (token.equals("-") || token.equals("+") || token.equals("*") || token.equals("/")) {
//			   stack.op(token);
		   } else {
			   stack.op(token);
		   }
//		   } else {
//			   throw new RuntimeException("Something went wrong.");
//		   }
	   }
	   
	   int result = stack.pop();
	   
	   if (stack.stEmpty()) {
		   return result;
	   } else {
		   throw new RuntimeException("Excess elements found. " + stack.toString());
	   }
   }

}

