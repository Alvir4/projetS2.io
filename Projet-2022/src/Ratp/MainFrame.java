package Ratp;



import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

import org.json.JSONString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import Ratp.utilities.Alert;
import Ratp.utilities.Api;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class MainFrame  extends JFrame{


	
	private static final long serialVersionUID = 7828565325729935587L;
	public static final String ERR_GENERIQUE = "Aye voila une erreur";
	protected static String forecast;
	
	

    

	public MainFrame(String titre) {
		
		super(titre);
		
		
		
		
		
		String LineType = "bus";
		String LineId = "83";
		String StationSlug = "ponscarme";
		String lineWay = "A";
		
		
		
		
				
				
				
		

		
		
		//new ForecastWorker(forecastUrl).execute(); Methode syncrone
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(Api.getForecastUrl(LineType, LineId, StationSlug, lineWay))
				.build();
		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				
				System.out.println(Thread.currentThread().getName()); // affichage du thead actuel
				
				//System.out.println(response.body().string()); //on vas checker si on a notre clef ou quoi qui est valide
				
				if(response.isSuccessful()) {
					
					try {
					String jsonData = response.body().string();
				
					
					
					JSONObject forecast = (JSONObject) JSONValue.parseWithException(jsonData);
				
					
					JSONObject l = (JSONObject) forecast.get("result");
					
					System.out.println("apres le result :"+(forecast.get("result")));
					System.out.println("apres le _metadata :"+forecast.get("_metadata"));
					System.out.println("call :"+forecast.get("call"));
					System.out.println("Date :"+forecast.get("date"));
					System.out.println("Version :"+forecast.get("version"));
					
				
						
					} catch (org.json.simple.parser.ParseException e) {
						Alert.error(MainFrame.this, ERR_GENERIQUE);
					}
				}
				
				else {
					Alert.error(MainFrame.this,"Une erreur est survenue");
				
					
					
				}
				
//				if(response.code() >= 400) {
//					System.out.println("Erreur d'url "+response.body().string());
//				}
				
			}
			
			

			@Override
			public void onFailure(Call call, IOException e) {
				Alert.error(MainFrame.this,"Il faut verrifier sa connection internet");
				
				//System.out.println("req web : /0"+response.body().string()); //on vas checker si on a notre clef ou quoi qui est valide
				
				
				}
			
			
			});
						
		}
	
	
	

	/*class ForecastWorker extends SwingWorker<String,Void>{ //separation du travail   				 #######################
																									 ### methode syncrone ##
		private String forecastUrl;// on vas s'occuper de notre url pour notre requette				 #######################
		
		public ForecastWorker(String forecastUrl) {
			
			this.forecastUrl = forecastUrl;
		}

		@Override
		
		protected String doInBackground() throws Exception {
			OkHttpClient client = new OkHttpClient();
			
			Request request = new Request.Builder()
				.url(forecastUrl)
				.build();
			
			Call call = client.newCall(request);
			
			try {
				
				Response response =  call.execute();
				
				if(response.isSuccessful()) {
					
					return response.body().string();
					
				}
				
				
				
			} catch (IOException e) {
				
				System.err.println("il y a une erreur au niveau de la requette" + e);
				
			}
			
			return null;
		}
		
		@Override
		protected void done() {
			
			//System.out.println(Thread.currentThread().getName());
			try {
				
				System.out.println(get());
				
			} catch (InterruptedException | ExecutionException e) {
				
				System.err.println("il y a une erreur au niveau de la requette" + e);
			}
			
			super.done();
		}
	}
*/	
}

