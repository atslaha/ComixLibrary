package il.co.ArrayListNewExceptions;

public class IllegalIndexException extends IllegalArgumentException {

    public IllegalIndexException() {
        System.out.println("Illegal index. There isn't element in array with that index!");
    }

    public IllegalIndexException(String message) {
        System.out.println(message);
    }

    public IllegalIndexException(int nomberOfException) {
        System.out.println(nomberOfException);
    }

}
