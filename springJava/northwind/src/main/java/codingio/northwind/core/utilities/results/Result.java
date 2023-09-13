package codingio.northwind.core.utilities.results;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success){
        this.success=success;
    }
    public Result(boolean success,String message){
        this(success); // this.success=success; ile aynı ama constructor kullanıp clean kod yazalım
        this.message=message;
    }

    public boolean isSuccess(){
        return this.success;
    }
    public String getMessage(){
        return this.message;
    }
}

