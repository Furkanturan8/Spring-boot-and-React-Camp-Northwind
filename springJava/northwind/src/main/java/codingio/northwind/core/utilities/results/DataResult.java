package codingio.northwind.core.utilities.results;

public class DataResult<T> extends Result{

    private T data; // T generic bir yapı tum veri tipleri olabilir
    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data=data;
    }
    public DataResult(T data, boolean success) {
        super(success);
        this.data=data;
    }

    public T getData(){
        return this.data;
    }


}
