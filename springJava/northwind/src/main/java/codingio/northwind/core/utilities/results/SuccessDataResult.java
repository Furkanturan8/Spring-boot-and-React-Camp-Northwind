package codingio.northwind.core.utilities.results;

public class SuccessDataResult <T> extends DataResult{

    public SuccessDataResult(Object data, String message) {
        super(data,true,message); // data verip mesaj gonderen bildirim
    }
    public SuccessDataResult(T data){
        super(data,true); //mesajsız fakat data gonderen bildirim
    }

    public SuccessDataResult(String message) {
        super(null,true,message); //datasız,mesajlı bildirim
    }

    public SuccessDataResult() {
        super(null,true); //mesajsız,datasız geri bildirim
    }

}
