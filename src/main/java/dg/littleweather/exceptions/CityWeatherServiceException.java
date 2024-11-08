package dg.littleweather.exceptions;

public class CityWeatherServiceException extends BaseException{

    protected String msg;

    public CityWeatherServiceException(String msg) {
        this.msg = msg;
    }

}
