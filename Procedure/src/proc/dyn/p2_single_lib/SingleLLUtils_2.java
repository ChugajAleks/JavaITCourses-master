package proc.dyn.p2_single_lib;

import proc.dyn.Node;
import proc.dyn.p1_single_lib.SingleLLUtils_1;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 23.01.13
 * Time: 23:44
 * To change this template use File | Settings | File Templates.
 */
public class SingleLLUtils_2 {
   public static Node add(Node tail, int elem) {
        return add(tail, SingleLLUtils_1.length(tail), elem);
   }

    /*
     *  Удаляет голову списка (на сайте не описано, что нужно удалять)
     */
   public static Node remove(Node tail) {
       if(tail != null){
           if(tail.next == null)return null;
           Node baseNode = tail;
           while(tail.next != null && tail.next.next != null)
           {
               tail = tail.next;
           }
           tail.next = null;
           return baseNode;
       } else {
           throw new IllegalArgumentException("Provided node is null");
       }
   }

    public static Node add(Node tail, int index, int elem) {
        if(tail != null)
        {
            if(index < 0)
            {
                throw new IndexOutOfBoundsException("Can't add element at index < 0");
            }
            if(index == 0)
            {
                return new Node(elem, tail);
            }
            Node baseNode = tail;
            Node node = tail;
            while(index > 1)
            {
                if(node.next == null)
                {
                    throw new IndexOutOfBoundsException("Can't add element at index > list length");
                }
                node = node.next;
                index--;
            }
            node.next = new Node(elem, (node == null)? null : node.next);
            return baseNode;
        }
        return new Node(elem, null);
    }

    /*
     * Я так понял, можно найти смысл возвращать и удаленный элемент и tail, поэтому напишу с возвратом tail'a,
     * потому что мне так удобней будет печатать
     */
    public static Node remove(Node tail, int index) {
        if(tail != null)
        {
            Node baseNode = tail;
            if(index < 0)
            {
                throw new IndexOutOfBoundsException("Can't add element at index < 0");
            }

            Node prevNode = null;
            while(index-- > 0)
            {
                prevNode = tail;
                if(prevNode == null)
                {
                    throw new IndexOutOfBoundsException("Provided index is out of list's length");
                }
                tail = tail.next;
            }

            if(prevNode != null){
                prevNode.next = tail.next;
            } else {
                return baseNode.next;
            }

            return baseNode;
        }
        throw new IllegalArgumentException("Provided node is null");
    }
}
