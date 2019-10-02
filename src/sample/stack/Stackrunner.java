public class Stackrunner {
    public static void main(String args[]){
        StackImplementation run=new StackImplementation();
        run.push(3);
        run.push(4);
        run.push(5);
        System.out.println(run.elementAt(2));

        run.pop();
        System.out.println(run.elementAt(0));
        System.out.println(run.elementAt(2));
    }

}
