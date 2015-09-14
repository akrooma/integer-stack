
import static org.junit.Assert.*;
import org.junit.Test;

/** Testklass.
 * @author jaanus
 */
public class IntStackTest {

   @Test (timeout=1000)
   public void testNewStack() { 
      IntStack m = new IntStack();
      assertTrue ("new stack must be empty;", m.stEmpty());
      m.push (1);
      m.pop();
      assertTrue ("stack must be empty after one push and one pop; ", m.stEmpty());
   }

   @Test (timeout=1000)
   public void testLIFO() {
      IntStack m = new IntStack();
      m.push (6);
      m.push (-3);
      int i1 = m.pop();
      int i2 = m.pop();
      assertTrue ("After two pushes and two pops stack must be empty;",
         m.stEmpty());
      assertTrue ("LIFO order must hold: 6 -3 returns -3 first;",
         (i1 == -3) && (i2 == 6));
   }

   @Test (timeout=1000)
   public void testOp() {
      int tt = 0;
      IntStack m = new IntStack();
      m.push (5);
      m.push (3);
      m.op ("+");
      tt = m.pop();
      assertTrue ("5 + 3 must be 8; ", tt==8);
      assertTrue ("push push op pop must not grow the stack; ", m.stEmpty());
      m.push (5);
      m.push (3);
      m.op ("-");
      tt = m.pop();
      assertTrue ("5 - 3 must be 2; ", tt==2);
      assertTrue ("push push op pop must not grow the stack; ", m.stEmpty());
      m.push (5);
      m.push (3);
      m.op ("*");
      tt = m.pop();
      assertTrue ("5 * 3 must be 15; ", tt==15);
      assertTrue ("push push op pop must not grow the stack; ", m.stEmpty());
      m.push (51);
      m.push (3);
      m.op ("/");
      tt = m.pop();
      assertTrue ("51 / 3 must be 17; ", tt==17);
      assertTrue ("push push op pop must not grow the stack; ", m.stEmpty());
   } 

   @Test (timeout=1000)
   public void testTos() {
      IntStack m = new IntStack();
      m.push (2);
      m.push (5);
      int k = m.tos();
      int k2 = m.pop();
      assertEquals ("5 must be on top ", 5, k);
      assertEquals ("tos must not change the top;", 5, k2);
      int k3 = m.pop();
      assertEquals ("tos must not change the stack;", 2, k3);
      assertTrue ("tos must not pop;", m.stEmpty());
   }

   @Test (timeout=1000)
   public void testEquals() {
      IntStack m1 = new IntStack();
      IntStack m2 = new IntStack();
      assertTrue ("two empty stacks must be equal;", m1.equals(m2));
      m1.push (1);
      m2.push (1);
      assertTrue ("1 in both stacks - stacks must be equal; ", m1.equals(m2));
      m1.push (0);
      assertFalse ("1 0 and just 1 must not be equal;", m1.equals(m2));
      m2.push (3);
      assertFalse ("1 0 and 1 3 must not be equal;", m1.equals(m2));
      m1.pop();
      m2.pop();
      assertTrue ("1 in stacks with different history, stacks must be equal;", 
         m1.equals(m2));
      m1.pop();
      assertFalse ("first empty, second contains 1, must not be equal;", 
         m1.equals(m2));
   }

   @Test (expected=RuntimeException.class)
   public void testPopEmpty() {
      IntStack m = new IntStack();
      m.pop();
   }

   @Test (expected=RuntimeException.class)
   public void testOpUnderflow() {
      IntStack m = new IntStack();
      m.push (4);
      m.op ("+");
   }

   @Test (timeout=1000)
   public void testClone() {
      IntStack m1 = new IntStack();
      m1.push (5);
      m1.push (4);
      IntStack m2 = null;
      try {
         m2 = (IntStack)m1.clone();
      } catch (CloneNotSupportedException e) {};
      assertNotSame ("clone must differ from original;", m2, m1);
      assertEquals ("clone must be equal to original;", m2, m1);
      m1.pop();
      m1.push (6);
      assertFalse ("clone must be independent;", m1.equals(m2));
   }

   @Test (timeout=1000)
   public void testToString() {
      IntStack m = new IntStack();
      assertNotNull ("empty stack must be ok;", m.toString());
      m.push (-8);
      m.push (7);
      String s1 = m.toString().substring (0, 3);
      m.push (2);
      String s2 = m.toString().substring (0, 3);
      assertEquals (
   "top must be the last element; toString from bottom must start with -8 7  ", 
         s1, s2);
   } 

   @Test (expected=RuntimeException.class)
   public void testTosUnderflow() {
      IntStack m = new IntStack();
      m.tos();
   }

   @Test (timeout=1000)
   public void testInterpret() {
      String s = "1";
      assertEquals ("expression: " + s, 1, IntStack.interpret (s));
      s = "2 5 -";
      assertEquals ("expression: " + s, -3, IntStack.interpret (s));
      s = "35 10 -3 + /";
      assertEquals ("expression: " + s, 5, IntStack.interpret (s));
   }

   @Test (expected=RuntimeException.class)
   public void testInterpretStackbalance() {
      String s = "35 10 -3 + / 2";
      IntStack.interpret (s);
   }

   @Test (expected=RuntimeException.class)
   public void testInterpretIllegalArg1() {
      String s = "35 10 -3 + x 2";
      IntStack.interpret (s);
   }

   @Test (expected=RuntimeException.class)
   public void testInterpretIllegalArg2() {
      String s = "35 y 10 -3 + - +";
      IntStack.interpret (s);
   }

   @Test (expected=RuntimeException.class)
   public void testInterpretUnderflow() {
      String s = "35 10 + -";
      IntStack.interpret (s);
   }

   @Test (expected=RuntimeException.class)
   public void testInterpretNull() {
      String s = null;
      IntStack.interpret (s);
   }

   @Test (expected=RuntimeException.class)
   public void testInterpretEmpty() {
      String s = "";
      IntStack.interpret (s);
   }

   @Test (expected=RuntimeException.class)
   public void testInterpretOpfirst() {
      String s = "- 3 2";
      IntStack.interpret (s);
   }

   @Test (timeout=1000)
   public void testInterpretLong() {
      String s = "1 -10 4 8 3 - + * +";
      assertEquals ("expression: " + Aout.toString (s), -89,
         IntStack.interpret (s));
      s = "156 154 152 - 3 + -";
      assertEquals ("expression: " + Aout.toString (s), 151,
         IntStack.interpret (s));
   }

   @Test (timeout=1000)
   public void testInterpretTokenizer() {
      String s = "1  2    +";
      assertEquals ("expression: " + Aout.toString (s), 3, 
         IntStack.interpret (s));
      s = "   \t \t356  \t \t";
      assertEquals ("expression: " + Aout.toString (s), 356,
         IntStack.interpret (s));
      s = "\t2 \t5 +   \t";
      assertEquals ("expression: " + Aout.toString (s), 7, 
         IntStack.interpret (s));
   }
}

