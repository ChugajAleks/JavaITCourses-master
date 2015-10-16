package holding;

import java.util.ArrayList;
import java.util.Collections;

public class StackTest {
  public static void main(String[] args){
    Stack<String> stack = new Stack<String>();
    ArrayList<String> arStack = new ArrayList<String>();
    Collections.addAll(arStack, "q", "w", "e", "t");
    for(String s: "My dog has falos".split(" ")){
      stack.push(s);
    }
    while(!stack.empty()){
      System.out.print(stack.pop() + " ");
    }
    for(String s: arStack){
      stack.push(s);
    }
    while(!stack.empty()){
      System.out.print(stack.pop() + " ");
    }
  }
}
