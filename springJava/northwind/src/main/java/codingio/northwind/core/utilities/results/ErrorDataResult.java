package codingio.northwind.core.utilities.results;

public class ErrorDataResult <T> extends DataResult{

    public ErrorDataResult(Object data, String message) {
        super(data,false,message); // data verip mesaj gonderen bildirim
    }
    public ErrorDataResult(T data){
        super(data,false); //mesajsız fakat data gonderen bildirim
    }

    public ErrorDataResult(String message) {
        super(null,false,message); //datasız,mesajlı bildirim
    }

    public ErrorDataResult() {
        super(null,false); //mesajsız,datasız geri bildirim
    }

}

