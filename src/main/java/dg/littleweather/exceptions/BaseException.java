package dg.littleweather.exceptions;

public class BaseException extends RuntimeException{

    private String msg;

    public BaseException(){

    }

    public BaseException(String msg) {
        this.msg = msg;
    }

    public BaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }


    @Override
    public String getMessage() {
        return msg;
    }

}
