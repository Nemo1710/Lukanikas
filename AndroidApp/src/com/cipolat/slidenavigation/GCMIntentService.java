package com.cipolat.slidenavigation;

import java.util.ArrayList;

import registro.DataBaseManager;
import rest.httpHandler;

import com.cipolat.slidenavigation.R;
import com.google.android.gms.gcm.GoogleCloudMessaging;



import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class GCMIntentService extends IntentService
{
    private static final int NOTIF_ALERTA_ID = 1;
    private Uri soundURI = Uri
			.parse("android.resource://com.cipolat.slidenavigation/"
					+ R.raw.alarm_rooster);
	private long[] mVibratePattern = { 200, 200, 200, 300 };
	
	DataBaseManager manager;
    public GCMIntentService() {
            super("GCMIntentService");
        }
 
    @Override
        protected void onHandleIntent(Intent intent)
    {
            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
            
            String messageType = gcm.getMessageType(intent);
            Bundle extras = intent.getExtras();
            String titulo;
            String id;
            String update;
            if (!extras.isEmpty())
            {
                    if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType))
                    {
                        if(extras.getString("tipo").equals("palabra")){
                        	
                            NotificationManager mNotificationManager =
                                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                            titulo=extras.getString("tipo");
                            id=extras.getString("id");

                            
                            Intent Palabra =  new Intent(this, Ejemplo1Web.class);
                            
                            Palabra.putExtra("extra",id);
                          //Toast.makeText(getApplicationContext(),"entro" ,Toast.LENGTH_SHORT).show();
                           
                            /*PendingIntent contIntent = PendingIntent.getActivity(
                                    this, 0, Palabra, 0);*/
                            PendingIntent contIntent = PendingIntent.getActivity
                            		(this, 0, Palabra, PendingIntent.FLAG_CANCEL_CURRENT);
                                    
                            NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(this)
                                    .setSmallIcon(android.R.drawable.stat_sys_speakerphone)
                                    .setAutoCancel(true)
                                    
                                    .setContentTitle("Lukanikas")
                                    .setContentText(id)
                                    .setContentIntent(contIntent).setSound(soundURI)
                    				.setVibrate(mVibratePattern);
                        			
                     
                           
                     
                            mBuilder.setContentIntent(contIntent);
                     
                            mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());
                        	
                        	
                        	
                        }else if(extras.getString("tipo").equals("updatedb")){
                        	NotificationManager mNotificationManager =
                                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                            
                            //id=extras.getString("id");
                        	manager=new DataBaseManager(this);
                        	manager.eliminar();
                        	ejecutarRestTask tarea=new ejecutarRestTask();
                        	tarea.execute("http://rest.intinnover.com/v1/palabras");
                            
                            Intent Palabra =  new Intent(this, MainActivity.class);
                            
                          ;
                          //Toast.makeText(getApplicationContext(),"entro" ,Toast.LENGTH_SHORT).show();
                           
                            /*PendingIntent contIntent = PendingIntent.getActivity(
                                    this, 0, Palabra, 0);*/
                            PendingIntent contIntent = PendingIntent.getActivity
                            		(this, 0, Palabra, PendingIntent.FLAG_CANCEL_CURRENT);
                                    
                            NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(this)
                                    .setSmallIcon(android.R.drawable.stat_sys_speakerphone)
                                    .setAutoCancel(true)
                                    
                                    .setContentTitle("Lukanikas")
                                    .setContentText("Actualizar Palabras")
                                    .setContentIntent(contIntent).setSound(soundURI)
                    				.setVibrate(mVibratePattern);
                        			
                     
                           
                     
                            mBuilder.setContentIntent(contIntent);
                     
                            mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());
                        	
                        	
                        }else if(extras.getString("tipo").equals("secuencia")){
                        	
                            NotificationManager mNotificationManager =
                                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                            titulo=extras.getString("tipo");
                            id=extras.getString("id");

                            
                            Intent Palabra =  new Intent(this, ejem3web.class);
                            
                            Palabra.putExtra("extra",id);
                          //Toast.makeText(getApplicationContext(),"entro" ,Toast.LENGTH_SHORT).show();
                           
                            /*PendingIntent contIntent = PendingIntent.getActivity(
                                    this, 0, Palabra, 0);*/
                            PendingIntent contIntent = PendingIntent.getActivity
                            		(this, 0, Palabra, PendingIntent.FLAG_CANCEL_CURRENT);
                                    
                            NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(this)
                                    .setSmallIcon(android.R.drawable.stat_sys_speakerphone)
                                    .setAutoCancel(true)
                                    
                                    .setContentTitle("Lukanikas")
                                    .setContentText(id)
                                    .setContentIntent(contIntent).setSound(soundURI)
                    				.setVibrate(mVibratePattern);
                        			
                     
                           
                     
                            mBuilder.setContentIntent(contIntent);
                     
                            mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());
                        	
                        	
                        	
                        }
                        else{
                        	mostrarNotification(extras.getString("message"));
                        }
                    }
            }
 
            GCMBroadcastReceiver.completeWakefulIntent(intent);
        }
 
    private void mostrarNotification(String msg)
    {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
 
        Intent notIntent =  new Intent(this, MainActivity.class);
        PendingIntent contIntent = PendingIntent.getActivity(
                this, 0, notIntent, 0);
        NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.stat_sys_speakerphone)
                .setContentTitle(msg)
                .setContentText("Se concluye nueva vía")
                .setContentIntent(contIntent).setSound(soundURI)
				.setVibrate(mVibratePattern);
    			
 
       
 
        mBuilder.setContentIntent(contIntent);
 
        mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());
        }
    private class ejecutarRestTask extends AsyncTask <String, Void, ArrayList <String []>> {      

        
        protected ArrayList <String []> doInBackground(String... urls) {
			// TODO Auto-generated method stub
			httpHandler mijin=new httpHandler();
			ArrayList <String []> parser=new ArrayList <String []>();
			
			parser=mijin.get(urls[0]);
			return parser;
			

            
            
            
		}
        protected void onPostExecute(ArrayList <String []>result) {
        	String [] mijitrin = new String[10];
        	SharedPreferences preferencias=getSharedPreferences("total",Context.MODE_PRIVATE);
		   
	       	Editor editor=preferencias.edit();
	       	editor.putString("numero", ""+result.size());
	       	editor.commit();
        	for(int i=0;i<result.size();i++){
        	mijitrin=result.get(i);
        	Log.d("que fue",mijitrin[1]);
        	manager.insertarr(Integer.parseInt(mijitrin[0]), mijitrin[1], mijitrin[2], mijitrin[3], mijitrin[4], mijitrin[5], mijitrin[6], mijitrin[7]);
        	}
        }
		
	
		
		
		
	

		

		
    
    }

}


