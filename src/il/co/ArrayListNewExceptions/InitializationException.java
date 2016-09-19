package il.co.ArrayListNewExceptions;

public class InitializationException extends RuntimeException {

    public InitializationException() {
        System.out.println("Capacity <0, Enter capacity >0;");
    }

    public InitializationException(String message) {
        System.out.println(message);
    }

    public InitializationException(int noumberOfExeption) {
        System.out.println(noumberOfExeption);
    }

    public void InitializationExeption() {
        System.out.println("Capacity <0, Enter capacity >0;");
    }
}
