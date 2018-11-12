package lone.wolf.lambda;

public interface MyInterface {
        public void saySometing(String str);
        default void say(){
            System.out.println("default say");
        }
}
