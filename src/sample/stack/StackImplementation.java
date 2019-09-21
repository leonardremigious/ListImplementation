import java.util.EmptyStackException;

public class StackImplementation {
    Stack root=null;
//    public void Stack() {
//        Stack();
//    }
    private   Integer size(){
        Integer size=0;
        Stack node=root;
        while (node!=null){
            size++;
            node=node.next;
        }
        return size;
    }

    public Integer elementAt(int i) {
        Stack node=root;
        if(node==null){
            return -1;
        }
        if(i>= size()){
            return  -1;
        }

        for (int j=0;j<=i;j++){
           if (j==i){
               return node.value;
           }
           node=node.next;
        }
        return -1;
    }

    private  Integer lastIndexOf(Object o){
        Integer index=1;
        Integer val=(Integer)o;
        Stack node= root;
        if(node==null){
            return  -1;
        }
        while (node!=null){
            if(node.value==val){
                return index;
            }
            node=node.next;
            index+=1;
        }
        return index;
    }
    public Integer push(Integer item) {
        Stack node=root;
        if(root==null){
            root=new Stack(item);
        }
        else{
            while (node.next!=null){
                node=node.next;
            }
            node.next=new Stack(item);
        }
        return item;
    }
    public synchronized Integer peek() {
        int     len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    public synchronized Integer pop() {
        Integer       obj;
        int     len = size();
        Stack node=root;

        obj = peek();
//       for (int i=0;i<len;i++){
//           if(len==1){
//               root=null;
//           }
//           else if(i+1==len){
//                node.next=null;
//           }
//           node=node.next;
//       }

        root=node.next;
        return obj;
    }
    public boolean empty() {
        return size() == 0;
    }
    public synchronized int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }
}
