package registro;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import rest.httpHandler;

import com.cipolat.slidenavigation.R;


import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroInicial extends Activity {
	EditText Nombre;
	EditText Edad;
	Button registro_Aceptar;
	GoogleCloudMessaging gcm;
	String regid;	
	Context context;
	private static final String PROPERTY_REG_ID = "registration_id";
	private static final String PROPERTY_APP_VERSION = "appVersion";
	private static final String PROPERTY_EXPIRATION_TIME = "onServerExpirationTimeMs";
	private static final String PROPERTY_USER = "user";
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro_inicial);
		Nombre= (EditText) findViewById(R.id.txt_registro_Nombre);
		Edad=(EditText) findViewById(R.id.txt_registro_Edad);
		registro_Aceptar=(Button) findViewById(R.id.btn_registro_Aceptar);
		registro_Aceptar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 TareaRegistroGCM tarea = new TareaRegistroGCM();
                 tarea.execute(Nombre.getText().toString());
				 finish();
				 
			}
		});		
	}
	private static int getAppVersion(Context context)
    {
        try
        {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
     
            return packageInfo.versionCode;
        }
        catch (NameNotFoundException e)
        {
            throw new RuntimeException("Error al obtener versión: " + e);
        }
    }
    
    
    
    private class TareaRegistroGCM extends AsyncTask<String,Integer,String>
    {
        private static final String SENDER_ID = "530033326682";
		private static final long EXPIRATION_TIME_MS = 1000 * 3600 * 24 * 7;
		private static final String TAG = "Registro";

		@Override
            protected String doInBackground(String... params)
        {
                String msg = "";
     
                try
                {
                    if (gcm == null)
                    {
                        gcm = GoogleCloudMessaging.getInstance(context);
                    }
     
                    
                    regid = gcm.register(SENDER_ID);
                    Log.d(TAG, "Registrado en GCM: registration_id=" + regid);     
                    boolean registrado = registroServidor(params[0], regid);     
                    if(registrado)
                    {
                        setRegistrationId(context, params[0], regid);
                    }
                }
                catch (IOException ex)
                {
                    Log.d(TAG, "Error registro en GCM:" + ex.toString());
                }     
                return msg;
            }
		
		
		private void setRegistrationId(Context context, String user, String regId)
		{
		    SharedPreferences prefs = getSharedPreferences("Registro",
		        Context.MODE_PRIVATE);		 
		    //int appVersion = getAppVersion(context);
		    SharedPreferences.Editor editor = prefs.edit();
		    editor.putString(PROPERTY_USER, user);
		    editor.putString(PROPERTY_REG_ID, regId);
		    editor.putInt(PROPERTY_APP_VERSION, 4);
		    editor.putLong(PROPERTY_EXPIRATION_TIME,
		    System.currentTimeMillis() + EXPIRATION_TIME_MS);
		 
		    editor.commit();
		}
		   private class ejecutarRestTask extends AsyncTask <String, Void, String> {      

		        
		        protected String doInBackground(String... urls) {
					// TODO Auto-generated method stub
					/*httpHandler mijin=new httpHandler();
					httpPost ejecutar=new 
					String mijitrin=mijin.post(urls[0]);
		            return mijitrin;*/
		        	HttpResponse response = null ;
		        	String resp = null;
		        	HttpClient client = new DefaultHttpClient();
		        	HttpPost post = new HttpPost(urls[0]);
		        	List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		        	pairs.add(new BasicNameValuePair("nombre", urls[1]));
		        	pairs.add(new BasicNameValuePair("gcm", urls[2]));
		        	pairs.add(new BasicNameValuePair("seccion", urls[3]));
		        	pairs.add(new BasicNameValuePair("pass", "mijin"));
		        	try {
						post.setEntity(new UrlEncodedFormEntity(pairs));
						response = client.execute(post);
						resp= EntityUtils.toString(response.getEntity());
						
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
					return resp;

					
				}
		        protected void onPostExecute(String result) {
		        	
		        	Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
		        }
				}
		
		private boolean registroServidor(String usuario, String regId)
		{
			String [] url={"http://rest.intinnover.com/v1/registrogcm"
					,Nombre.getText().toString(),regId,Edad.getText().toString()};
		    new ejecutarRestTask().execute(url);
						
			return true;
		}
		
    }
	
}
