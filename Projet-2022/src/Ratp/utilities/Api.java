package Ratp.utilities;

public class Api {

	public static final String FORECAST_API_URL = "https://api-ratp.pierre-grimaud.fr/v3/schedules" ;
//	public static final String FORECAST_API_KEY = "https://api-ratp.pierre-grimaud.fr/v3" ;
	
	public static String getForecastUrl(String LineType ,String LineId , String StationSlug ,String lineWay) {
//		return FORECAST_API_URL + "/" + LineType + "/" + LineId + "/" + StationSlug + "/" + lineWay ; // avoir les horaires
//		return "https://api-ratp.pierre-grimaud.fr/v3/traffic"; // avoir les probleme de ligne
		return "https://api-ratp.pierre-grimaud.fr/v3/lines";
	}
			
}
