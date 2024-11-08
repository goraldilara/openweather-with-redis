package dg.littleweather.domain.constants;

public class LittleWeatherConstants {

    //constant values for api addresses and api key
    public static final String CITY_INFO_URL = "https://api.openweathermap.org/data/2.5/weather";
    public static final String HOURLY_WEATHER_URL = "https://api.openweathermap.org/data/2.5/onecall";
    public static final String OPEN_WEATHER_API_KEY = "47f06c26dcd2450582b41991bc72b209";

    public static final int HTTP_500 = 500;
    public static final int HTTP_400 = 400;
    public static final int HTTP_200 = 200;
    public static final int HTTP_100 = 100;
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

    private static final String REDIS_KEY = "User";

}
