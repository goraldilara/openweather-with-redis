package dg.littleweather.exceptions;

public class OpenWeatherServiceException extends BaseException {

    public OpenWeatherServiceException(String message) {
        super(message);
    }

    public OpenWeatherServiceException(String message, Throwable cause) {
        super(message,cause);
    }

    public OpenWeatherServiceException(Throwable cause) {}
}
