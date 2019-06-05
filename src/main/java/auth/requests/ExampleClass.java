package auth.requests;

public class ExampleClass {

    private void Hello(){
        System.out.println("Good!");
    }

    private void BadCode(int a, int b, int c){
        if(a > b){
            if(a > c){
                System.out.println("Yeah!");
            }
        }
        if(c > a){
            if(c > b){
                System.out.println("No!");
            }
        }
        if(b> c){
            if(b>a){
                System.out.println("Dab!");
            }
        }
    }
}
