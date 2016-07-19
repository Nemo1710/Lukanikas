package com.cipolat.slidenavigation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import registro.RegistroInicial;
import rest.httpHandler;

import com.cipolat.slidenavigation.juegos.Tablero1;

import com.google.android.gms.gcm.GoogleCloudMessaging;



import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	    private String[] titulos;
	    private DrawerLayout NavDrawerLayout;
	    private ListView NavList;
        private ArrayList<Item_objct> NavItms;
        private TypedArray NavIcons;
	    private ActionBarDrawerToggle mDrawerToggle;
	    private CharSequence mDrawerTitle;
	    private CharSequence mTitle;
	    NavigationAdapter NavAdapter;  
	    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 0;
		private static final String TAG = "MessagesCLoud";
		
		
		private static final String PROPERTY_REG_ID = "registration_id";
		private static final String PROPERTY_APP_VERSION = "appVersion";
		private static final String PROPERTY_EXPIRATION_TIME = "onServerExpirationTimeMs";
		private static final String PROPERTY_USER = "user";
		Button registro;
		Context context;
		GoogleCloudMessaging gcm;
		String regid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);		
			context = getApplicationContext();
			 gcm = GoogleCloudMessaging.getInstance(MainActivity.this);
             //Obtenemos el Registration ID guardado
            regid = getRegistrationId(context);
            if(regid.equals("noexiste")){
            	Intent nuevo = new Intent(context,RegistroInicial.class);
            	startActivity(nuevo);
            	
            	
            	
            }
            SharedPreferences prefs = getSharedPreferences("Registro",
    		        Context.MODE_PRIVATE);		 

            
            
            
            
            
            
			//Creo un drawer LAyout
			//NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			NavDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
			
			//creo una lista
			
	        //NavList = (ListView) findViewById(R.id.lista);
			NavList = (ListView) findViewById(R.id.lista);
			NavList.setBackgroundColor(0xCCff402b);
			//NavList.invalidate();
	        //Declaramos el header el cual sera el layout de header.xml
	        //View header = getLayoutInflater().inflate(R.layout.header, null);
	        //View header= getLayoutInflater().inflate(R.layout.header,null);
	        //Establecemos header
	        //NavList.addHeaderView(header);
			//Tomamos listado  de imgs desde drawable
	        NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);			
			//Tomamos listado  de titulos desde el string-array de los recursos @string/nav_options
	        titulos = getResources().getStringArray(R.array.nav_options);
	        //Listado de titulos de barra de navegacion
	        NavItms = new ArrayList<Item_objct>();
	        //Agregamos objetos Item_objct al array
	        //Perfil	      
	        NavItms.add(new Item_objct(titulos[0], NavIcons.getResourceId(0, -1)));
	        //Favoritos
	        NavItms.add(new Item_objct(titulos[1], NavIcons.getResourceId(1, -1)));
	        //Eventos
	        NavItms.add(new Item_objct(titulos[2], NavIcons.getResourceId(2, -1)));
	        //Lugares
	        NavItms.add(new Item_objct(titulos[3], NavIcons.getResourceId(3, -1)));
	        //Etiquetas
	        NavItms.add(new Item_objct(titulos[4], NavIcons.getResourceId(4, -1)));
	        //Configuracion
	        NavItms.add(new Item_objct(titulos[5], NavIcons.getResourceId(5, -1)));
	        //Share
	        NavItms.add(new Item_objct(titulos[6], NavIcons.getResourceId(6, -1)));
	      
	        //Declaramos y seteamos nuestro adaptador al cual le pasamos el array con los titulos	       
	        NavAdapter= new NavigationAdapter(this,NavItms);
	        NavList.setAdapter(NavAdapter);	
	        //Siempre vamos a mostrar el mismo titulo
	        mTitle = mDrawerTitle = getTitle();
	        
	        //Declaramos el mDrawerToggle y las imgs a utilizar
	        mDrawerToggle = new ActionBarDrawerToggle(
	                this,                  /* host Activity */
	                NavDrawerLayout,         /* DrawerLayout object */
	                R.drawable.ic_drawer,  /* Icono de navegacion*/
	                R.string.app_name,  /* "open drawer" description */
	                R.string.hello_world  /* "close drawer" description */
	                ) {

	            /** Called when a drawer has settled in a completely closed state. */
	            public void onDrawerClosed(View view) {
	            	Log.e("Cerrado completo", "!!");
	            }

	            /** Called when a drawer has settled in a completely open state. */
	            public void onDrawerOpened(View drawerView) {
	                Log.e("Apertura completa", "!!");
	            }
	        };	        
	        
	        // Establecemos que mDrawerToggle declarado anteriormente sea el DrawerListener
	        NavDrawerLayout.setDrawerListener(mDrawerToggle);
	        //Establecemos que el ActionBar muestre el Boton Home
	        getActionBar().setDisplayHomeAsUpEnabled(true);

	        //Establecemos la accion al clickear sobre cualquier item del menu.
	        //De la misma forma que hariamos en una app comun con un listview.
	        NavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
	            	MostrarFragment(position);
	            }
	        });
	        
	        //Cuando la aplicacion cargue por defecto mostrar la opcion Home
	        MostrarFragment(1);
	}
	
	/*Pasando la posicion de la opcion en el menu nos mostrara el Fragment correspondiente*/
    private void MostrarFragment(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
        case 1:
            fragment = new HomeFragment();
            break;
        case 2:
            fragment = new Login();
            break;
     
 
        default:
        	//si no esta la opcion mostrara un toast y nos mandara a Home
        	Toast.makeText(getApplicationContext(),"Opcion "+titulos[position]+"no disponible!", Toast.LENGTH_SHORT).show();
            fragment = new HomeFragment();
            position=1;
            break;
        }
        //Validamos si el fragment no es nulo
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
 
            // Actualizamos el contenido segun la opcion elegida
            NavList.setItemChecked(position, true);
            NavList.setSelection(position);
            //Cambiamos el titulo en donde decia "
            setTitle(titulos[position-1]);
            //Cerramos el menu deslizable
            NavDrawerLayout.closeDrawer(NavList);
        } else {
            //Si el fragment es nulo mostramos un mensaje de error.
            Log.e("Error  ", "MostrarFragment"+position);
        }
    }
	  
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
    private String getRegistrationId(Context context)
    {
        SharedPreferences prefs = getSharedPreferences(
        "Registro",
            Context.MODE_PRIVATE);
     
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        Log.e("datos",registrationId);
        if (registrationId.length() == 0)
        {
            Log.d(TAG, "Registro GCM no encontrado.");
            return "noexiste";
        }
     
       return "existe";
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            Log.e("mDrawerToggle pushed", "x");
          return true;
        }
        // Handle your other action bar items...
        switch (item.getItemId()) {
        case R.id.tablero1:
            //Toast.makeText(getApplicationContext(), "Que Fueef", Toast.LENGTH_LONG).show();
        	Intent Tablero1 = new Intent(this, Tablero1.class);
            this.startActivity(Tablero1);
            
            return true;
            
        default:
        	return super.onOptionsItemSelected(item);  
    }
    	
    	
    	
    	
        /*
    	// Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        
    	if (mDrawerToggle.onOptionsItemSelected(item)) {
    		switch (item.getItemId()) {
            case R.id.tablero1:
                Toast.makeText(getApplicationContext(), "Que Fueef", Toast.LENGTH_LONG).show();
            	//Intent Tablero1 = new Intent(this, Tablero1.class);
                //this.startActivity(Tablero1);
                
                return true;
                
            default:
            	return super.onOptionsItemSelected(item);  
        }
    		
    		
    		/*Log.e("mDrawerToggle pushed", "x");
          return true;*/
        
        // Handle your other action bar items...
        
    	
    	/*
    	switch (item.getItemId()) {
        case R.id.tablero1:
            
        	Intent Tablero1 = new Intent(this, Tablero1.class);
            this.startActivity(Tablero1);
            return true;
    }
		return false;*/
        
    }

    
    private class TareaRegistroGCM extends AsyncTask<String,Integer,String>
    {
        private static final String SENDER_ID = "530033326682";
		private static final long EXPIRATION_TIME_MS = 1000 * 3600 * 24 * 7;

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
     
                    //Nos registramos en los servidores de GCM
                    regid = gcm.register(SENDER_ID);
     
                    Log.d(TAG, "Registrado en GCM: registration_id=" + regid);
     
                    //Nos registramos en nuestro servidor
                    boolean registrado = registroServidor(params[0], regid);
     
                    //Guardamos los datos del registro
                    if(registrado)
                    {
                        setRegistrationId(context, params[0], regid);
                    }
                }
                catch (IOException ex)
                {
                    Log.d(TAG, "Error registro en GCM:" + ex.getMessage());
                }
     
                return msg;
            }
		
		
		private void setRegistrationId(Context context, String user, String regId)
		{
		    SharedPreferences prefs = getSharedPreferences(
		    MainActivity.class.getSimpleName(),
		        Context.MODE_PRIVATE);
		 
		    int appVersion = getAppVersion(context);
		 
		    SharedPreferences.Editor editor = prefs.edit();
		    editor.putString(PROPERTY_USER, user);
		    editor.putString(PROPERTY_REG_ID, regId);
		    editor.putInt(PROPERTY_APP_VERSION, appVersion);
		    editor.putLong(PROPERTY_EXPIRATION_TIME,
		    System.currentTimeMillis() + EXPIRATION_TIME_MS);
		 
		    editor.commit();
		}
		
		private boolean registroServidor(String usuario, String regId)
		{
			
			
			return true;
		}
	    private class ejecutarRestTask extends AsyncTask <String, Void, String> {      

	        
	        protected String doInBackground(String... urls) {
				// TODO Auto-generated method stub
				/*httpHandler mijin=new httpHandler();
				
				String mijitrin=mijin.post(urls[0]);
	            return mijitrin;*/
	        	String responseText = null;
	        	HttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost(urls[0]);
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("nombre", urls[1]));
				pairs.add(new BasicNameValuePair("gcm", urls[2]));
				pairs.add(new BasicNameValuePair("seccion", urls[3]));
				pairs.add(new BasicNameValuePair("pass", "mijin"));
				try {
					post.setEntity(new UrlEncodedFormEntity(pairs));
					HttpResponse response = client.execute(post);
					responseText = EntityUtils.toString(response.getEntity());
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
				return responseText;
				
			}
	        protected void onPostExecute(String result) {
	        	
	        	Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
	        }
			
		
			
			
			
		

			

			
	    
	    }
    }

    
}
