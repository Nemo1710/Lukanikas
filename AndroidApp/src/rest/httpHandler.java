package rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;

import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class httpHandler {

  public String post(String posturl){

	  try {

		  HttpClient httpclient = new DefaultHttpClient();
		  /*Creamos el objeto de HttpClient que nos permitira conectarnos mediante peticiones http*/
		  HttpPost httppost = new HttpPost(posturl);
		  /*El objeto HttpPost permite que enviemos una peticion de tipo POST a una URL especificada*/
		  //AÑADIR PARAMETROS
		  List<NameValuePair> params = new ArrayList<NameValuePair>();
		  params.add(new BasicNameValuePair("name","Leslia"));
		  params.add(new BasicNameValuePair("email","Otromensaje1"));
		  params.add(new BasicNameValuePair("password","Otromensaje1"));
		/*Una vez añadidos los parametros actualizamos la entidad de httppost, esto quiere decir en pocas palabras anexamos los parametros al objeto para que al enviarse al servidor envien los datos que hemos añadido*/
  httppost.setEntity(new UrlEncodedFormEntity(params));

                  /*Finalmente ejecutamos enviando la info al server*/
		  HttpResponse resp = httpclient.execute(httppost);
		  HttpEntity ent = resp.getEntity();/*y obtenemos una respuesta*/

		  String text = EntityUtils.toString(ent);

		  return text;

	  }
	  catch(Exception e) { return "error" +e;
	  //Log.i("que paso",e.toString());
	  }
	  }
  public ArrayList<String []> get(String posturl){
	  ArrayList<String []> mijo=new ArrayList<String []>();
	  try {

		  HttpClient httpclient = new DefaultHttpClient();
		  /*Creamos el objeto de HttpClient que nos permitira conectarnos mediante peticiones http*/
		  HttpGet httppost = new HttpGet(posturl);
		  /*El objeto HttpPost permite que enviemos una peticion de tipo POST a una URL especificada*/
		 
		  HttpResponse resp = httpclient.execute(httppost);
		  HttpEntity ent = resp.getEntity();/*y obtenemos una respuesta*/

		  String text = EntityUtils.toString(ent);
		  
		  mijo=this.tratamientoJson1(text);
		  return mijo;

	  }
	  catch(Exception e) { 
		  return mijo;
	      
	  }
	  }
	  public String [] palabra(String id){
		  String [] men=null;
		  try {
			  StringBuilder builder = new StringBuilder();
			  String posturl="http://rest.intinnover.com/v1/palabra";
			  HttpClient httpclient = new DefaultHttpClient();
			  String line="";
			  
			  HttpPost httppost = new HttpPost(posturl);
			  /*El objeto HttpPost permite que enviemos una peticion de tipo POST a una URL especificada*/
			  //AÑADIR PARAMETROS
			  List<NameValuePair> params = new ArrayList<NameValuePair>();
			  params.add(new BasicNameValuePair("identifi",id));
			
			/*Una vez añadidos los parametros actualizamos la entidad de httppost, esto quiere decir en pocas palabras anexamos los parametros al objeto para que al enviarse al servidor envien los datos que hemos añadido*/
			  httppost.setEntity(new UrlEncodedFormEntity(params));

	                  /*Finalmente ejecutamos enviando la info al server*/
			  HttpResponse resp = httpclient.execute(httppost);
			  HttpEntity ent = resp.getEntity();/*y obtenemos una respuesta*/
			  
			  
			  InputStream content = ent.getContent();
		      BufferedReader reader = new BufferedReader(
		        new InputStreamReader(content));
		      while ((line = reader.readLine()) != null) {
		        builder.append(line);
		      }
		      men=tratamientoJson(builder.toString());
			  
			  //String text = EntityUtils.toString(ent);
			  //JSONArray jsonArray = new JSONArray(text);
			  
			  

		  }
		  catch(Exception e) { 
			  
		  //Log.i("que paso",e.toString());
		  
		  }
		return men;

	}
	  public String secuencia(String id){
		  String men=null;
		  try {
			  StringBuilder builder = new StringBuilder();
			  String posturl="http://rest.intinnover.com/v1/secuencia";
			  HttpClient httpclient = new DefaultHttpClient();
			  String line="";
			  
			  HttpPost httppost = new HttpPost(posturl);
			  /*El objeto HttpPost permite que enviemos una peticion de tipo POST a una URL especificada*/
			  //AÑADIR PARAMETROS
			  List<NameValuePair> params = new ArrayList<NameValuePair>();
			  params.add(new BasicNameValuePair("identifi",id));
			
			/*Una vez añadidos los parametros actualizamos la entidad de httppost, esto quiere decir en pocas palabras anexamos los parametros al objeto para que al enviarse al servidor envien los datos que hemos añadido*/
			  httppost.setEntity(new UrlEncodedFormEntity(params));

	                  /*Finalmente ejecutamos enviando la info al server*/
			  HttpResponse resp = httpclient.execute(httppost);
			  HttpEntity ent = resp.getEntity();/*y obtenemos una respuesta*/
			  
			  
			  InputStream content = ent.getContent();
		      BufferedReader reader = new BufferedReader(
		        new InputStreamReader(content));
		      while ((line = reader.readLine()) != null) {
		        builder.append(line);
		      }
		      men=tratamientoJson2(builder.toString());
			  
			  //String text = EntityUtils.toString(ent);
			  //JSONArray jsonArray = new JSONArray(text);
			  
			  

		  }
		  catch(Exception e) { 
			  
		  //Log.i("que paso",e.toString());
		  
		  }
		return men;

	}
	  private String[] tratamientoJson(String string) throws JSONException {
		   JSONObject jsonArray = new JSONObject(string);
		   String resp="";
		   /*for (int i = 0; i < jsonArray.length(); i++) {
		     JSONObject jsonObject = jsonArray.getJSONObject(i);
		     /*this.salida.append("\n name=" + jsonObject.getString("name")
		       + " version=" + jsonObject.getString("version")
		       + " private=" + jsonObject.getBoolean("private") ); }*/
		   //JSONObject jsonObject = jsonArray.getJSONObject(0  );
		     resp=jsonArray.getString("message");
		     JSONObject jsonArray1 = new JSONObject(resp);
		     resp=jsonArray1.getString("palabra1");
		     String [] respuesta={
		    		 jsonArray1.getString("palabra1"),
		    		 jsonArray1.getString("palabra2"),
		    		 jsonArray1.getString("palabra3"),
		    		 jsonArray1.getString("silaba1"),
		    		 jsonArray1.getString("silaba2"),
		    		 jsonArray1.getString("silaba3"),
		    		 jsonArray1.getString("silaba4")
		    		 
		     };

	  	
		   return respuesta;
	  }
	  private String tratamientoJson2(String string) throws JSONException {
		   JSONObject jsonArray = new JSONObject(string);
		   String resp="";
		   /*for (int i = 0; i < jsonArray.length(); i++) {
		     JSONObject jsonObject = jsonArray.getJSONObject(i);
		     /*this.salida.append("\n name=" + jsonObject.getString("name")
		       + " version=" + jsonObject.getString("version")
		       + " private=" + jsonObject.getBoolean("private") ); }*/
		   //JSONObject jsonObject = jsonArray.getJSONObject(0  );
		     resp=jsonArray.getString("message");
		     
		    		 
		     

	  	
		   return resp;
	  }
	  private ArrayList <String []> tratamientoJson1(String string) throws JSONException {
		   JSONArray jsonArray = new JSONArray(string);
		   String resp="";
		   ArrayList <String []> parser=new ArrayList <String []>();
		   String [] datos = new String[8];
		   for (int i = 0; i < jsonArray.length(); i++) {
			   JSONObject jsonObject = jsonArray.getJSONObject(i);
			   String[] toppings = {""+jsonObject.getInt("id"), 
					   						jsonObject.getString("palabra1"), 
					   						jsonObject.getString("palabra2"),
					   						jsonObject.getString("palabra3"),
					   						jsonObject.getString("silaba1"),
					   						jsonObject.getString("silaba2"),
					   						jsonObject.getString("silaba3"),
					   						jsonObject.getString("silaba4"), 
					   						};

			   parser.add(toppings);
		}

	       

		   Log.d("dsad", ""+jsonArray.length());
		   
		   return parser;
	  }

}