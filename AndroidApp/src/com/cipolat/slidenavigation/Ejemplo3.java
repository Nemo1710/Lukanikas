package com.cipolat.slidenavigation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ejemplo3 extends Activity {
	  private static final String TAG = "bluetooth2";
	  String dato; 
	  Button btnOn, btnOff,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	  TextView txtArduino;
	  Handler h;
	   
	  final int RECIEVE_MESSAGE = 1;		// Status  for Handler
	  private BluetoothAdapter btAdapter = null;
	  private BluetoothSocket btSocket = null;
	  private StringBuilder sb = new StringBuilder();
	  
	  private ConnectedThread mConnectedThread;
	   
	  // servicio SPP UUID 
	  private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
	 
	  // Aqui deben poner la MAC del bluetooth al que van a coenctar
	  private static String address = "20:13:06:19:33:10";
	   
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	 
	    setContentView(R.layout.bluet);
	    dato="110000000001111110";


		  
	    
	    
	    
	    
	    btnOn = (Button) findViewById(R.id.btnOn);					// En el caso de prender un led
	    btnOff = (Button) findViewById(R.id.btnOff);	
	    btn3 = (Button) findViewById(R.id.btn3);
	    btn4 = (Button) findViewById(R.id.btn4);
	    btn5 = (Button) findViewById(R.id.btn5);
	    btn6 = (Button) findViewById(R.id.btn6);
	    btn7 = (Button) findViewById(R.id.btn7);
	    btn8 = (Button) findViewById(R.id.btn8);
	    btn9 = (Button) findViewById(R.id.btn9);
	    
	    // En e caso de apagar un led
	    txtArduino = (TextView) findViewById(R.id.txtArduino);		// TextView para indicar resultado de lso datos que recieb arduino
	    
	    h = new Handler() {
	    	public void handleMessage(android.os.Message msg) {
	    		switch (msg.what) {
	            case RECIEVE_MESSAGE:													// hilo para recibir el mensaje
	            	byte[] readBuf = (byte[]) msg.obj;
	            	String strIncom = new String(readBuf, 0, msg.arg1);					// Crear String para recibir los carcteres del BLuetooth
	            	sb.append(strIncom);												// Concatenar cada caracter
	            	int endOfLineIndex = sb.indexOf("\n \n");							// Determinar el final de la lina
	            	if (endOfLineIndex > 0) { 											// if end-of-line,
	            		String sbprint = sb.substring(0, endOfLineIndex);				// Determinar la cadena
	                    sb.delete(0, sb.length());	
	                    // y limpiar
	                    if(sbprint.equals(dato)){
	                    	 
	                    	Toast.makeText(getApplicationContext(), "Felicitaciones", Toast.LENGTH_SHORT).show();
	                    }
	                	txtArduino.setText(sbprint); 	        // Actualziar el TextView
	                	btnOff.setEnabled(true);
	                	btnOn.setEnabled(true); 
	                }
	            	Log.d(TAG, "...String:"+ sb.toString() +  "Byte:" + msg.arg1 + "...");
	            	break;
	    		}
	        };
		};
	     
	    btAdapter = BluetoothAdapter.getDefaultAdapter();		// Obtener el adaptador del BLuetooth
	    checkBTState();
	    
	    btnOn.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	btnOn.setEnabled(false);
	    	mConnectedThread.write("1");	// Enviar 1 via bluetooth
	        Toast.makeText(getBaseContext(), "Se Prendió el Led", Toast.LENGTH_SHORT).show();
	      }
	    });
	 
	    btnOff.setOnClickListener(new OnClickListener() {
	      public void onClick(View v) {
	    	btnOff.setEnabled(false);  
	    	mConnectedThread.write("0");	// Enviar 0 via Bluetooth
	        Toast.makeText(getBaseContext(), "Turn off LED", Toast.LENGTH_SHORT).show();
	      }
	    });
	  }
	  
	  private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
	      if(Build.VERSION.SDK_INT >= 10){
	          try {
	              final Method  m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", new Class[] { UUID.class });
	              return (BluetoothSocket) m.invoke(device, MY_UUID);
	          } catch (Exception e) {
	              Log.e(TAG, "Could not create Insecure RFComm Connection",e);
	          }
	      }
	      return  device.createRfcommSocketToServiceRecord(MY_UUID);
	  }
	   
	  @Override
	  public void onResume() {
	    super.onResume();
 Log.d(TAG, "...onResume - tratando de conectar...");
	    
	    BluetoothDevice device = btAdapter.getRemoteDevice(address);
	   
	    // Son necesaria dos cosas para realizar una conexion
	    //   la direccion MAC del dispositivo que deseamos conectar
	    //   Un servicio UUID
	    //     UUID for SPP.
	    
		try {
			btSocket = createBluetoothSocket(device);
		} catch (IOException e) {
			errorExit(" Error Fatal", "fallo al crear" + e.getMessage() + ".");
		}
	    
	    /*try {
	      btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
	    } catch (IOException e) {
	      errorExit(" Error Fatal", "fallo al crear" + e.getMessage() + ".");
	    }*/
	   
	    
	    btAdapter.cancelDiscovery();
	   
	    //Estableciendo la conexion
	    Log.d(TAG, "...Conectando...");
	    try {
	      btSocket.connect();
	      Log.d(TAG, "....Conexion ok...");
	    } catch (IOException e) {
	      try {
	        btSocket.close();
	      } catch (IOException e2) {
	        errorExit(" Error Fatal", "In onResume() and unable to close socket during connection failure" + e2.getMessage() + ".");
	      }
	    }
	     
	    // Create a data stream so we can talk to server.
	    Log.d(TAG, "...Creando Socket...");
	   
	    mConnectedThread = new ConnectedThread(btSocket);
	    mConnectedThread.start();
	    String dat=dato.substring(0,1);
	    String dat1=dato.substring(9,10);
		  if(dat.equals("1")&&dat1.equals("0")){
			  if (Build.VERSION.SDK_INT >= 16){				  
				  btnOn.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
			  }else{
					btnOn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
			  }
		 
		   }else if(dat.equals("0")&&dat1.equals("1")){
			   if (Build.VERSION.SDK_INT >= 16){				  
					  btnOn.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
				  }else{
						btnOn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
				  } 
		   }
		  //
		  dat=dato.substring(1,2);
		  dat1=dato.substring(10,11);
			  if(dat.equals("1")&&dat1.equals("0")){
				  if (Build.VERSION.SDK_INT >= 16){				  
					  btnOff.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
				  }else{
						btnOff.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
				  }
			 
			   }else if(dat.equals("0")&&dat1.equals("1")){
				   if (Build.VERSION.SDK_INT >= 16){				  
						  btnOff.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
					  }else{
							btnOff.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
					  } 
			   }
		//
			  dat=dato.substring(2,3);
			  dat1=dato.substring(11,12);
				  if(dat.equals("1")&&dat1.equals("0")){
					  if (Build.VERSION.SDK_INT >= 16){				  
						  btn3.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
					  }else{
							btn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
					  }
				 
				   }else if(dat.equals("0")&&dat1.equals("1")){
					   if (Build.VERSION.SDK_INT >= 16){				  
							  btn3.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
						  }else{
								btn3.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
						  } 
				   }
				  dat=dato.substring(3,4);
				  dat1=dato.substring(12,13);
					  if(dat.equals("1")&&dat1.equals("0")){
						  if (Build.VERSION.SDK_INT >= 16){				  
							  btn4.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
						  }else{
								btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
						  }
					 
					   }else if(dat.equals("0")&&dat1.equals("1")){
						   if (Build.VERSION.SDK_INT >= 16){				  
								  btn4.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
							  }else{
									btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
							  } 
					   }	
					  dat=dato.substring(4,5);
					  dat1=dato.substring(13,14);
						  if(dat.equals("1")&&dat1.equals("0")){
							  if (Build.VERSION.SDK_INT >= 16){				  
								  btn5.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
							  }else{
									btn5.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
							  }
						 
						   }else if(dat.equals("0")&&dat1.equals("1")){
							   if (Build.VERSION.SDK_INT >= 16){				  
									  btn5.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
								  }else{
										btn5.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
								  } 
						   }
						  dat=dato.substring(5,6);
						  dat1=dato.substring(14,15);
							  if(dat.equals("1")&&dat1.equals("0")){
								  if (Build.VERSION.SDK_INT >= 16){				  
									  btn6.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
								  }else{
										btn6.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
								  }
							 
							   }else if(dat.equals("0")&&dat1.equals("1")){
								   if (Build.VERSION.SDK_INT >= 16){				  
										  btn6.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
									  }else{
											btn6.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
									  } 
							   }
							  dat=dato.substring(6,7);
							  dat1=dato.substring(15,16);
								  if(dat.equals("1")&&dat1.equals("0")){
									  if (Build.VERSION.SDK_INT >= 16){				  
										  btn7.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
									  }else{
											btn7.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
									  }
								 
								   }else if(dat.equals("0")&&dat1.equals("1")){
									   if (Build.VERSION.SDK_INT >= 16){				  
											  btn7.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
										  }else{
												btn7.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
										  } 
								   }		  
								  dat=dato.substring(7,8);
								  dat1=dato.substring(16,17);
									  if(dat.equals("1")&&dat1.equals("0")){
										  if (Build.VERSION.SDK_INT >= 16){				  
											  btn8.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
										  }else{
												btn8.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
										  }
									 
									   }else if(dat.equals("0")&&dat1.equals("1")){
										   if (Build.VERSION.SDK_INT >= 16){				  
												  btn8.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
											  }else{
													btn8.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
											  } 
									   }
									  dat=dato.substring(8,9);
									  dat1=dato.substring(17);
										  if(dat.equals("1")&&dat1.equals("0")){
											  if (Build.VERSION.SDK_INT >= 16){				  
												  btn9.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_pressed));
											  }else{
													btn9.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
											  }
										 
										   }else if(dat.equals("0")&&dat1.equals("1")){
											   if (Build.VERSION.SDK_INT >= 16){				  
													  btn9.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.btn_circle_focused));
												  }else{
														btn9.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_focused));
												  } 
										   }
	    
	    
	    
	    
	    
	   
	  }
	 
	  @Override
	  public void onPause() {
	    super.onPause();
	 
	    Log.d(TAG, "...Estado onPause()...");
	  
	    try     {
	      btSocket.close();
	    } catch (IOException e2) {
	      errorExit("Error Fatal", "En onPause() se fallo al intentar cerrar el socket." + e2.getMessage() + ".");
	    }
	  }
	   
	  private void checkBTState() {
	    // Check for Bluetooth support and then check to make sure it is turned on
	    // Emulator doesn't support Bluetooth and will return null
	    if(btAdapter==null) { 
	      errorExit(" Error Fatal", "No soporta Bluetooth");
	    } else {
	      if (btAdapter.isEnabled()) {
	        Log.d(TAG, "...Bluetooth Encendido...");
	      } else {
	        //sentencia para encender el blutooth
	        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	        startActivityForResult(enableBtIntent, 1);
	      }
	    }
	  }
	 
	  private void errorExit(String title, String message){
	    Toast.makeText(getBaseContext(), title + " - " + message, Toast.LENGTH_LONG).show();
	    finish();
	  }
	  public void pintar(String dato){
		  String mijin=dato;
		  String dat=mijin.substring(0,1);
		  if(dat.equals("1")){
			  //btnOn.setBackground(getResources().getDrawable(R.drawable.btn_circle_pressed));
			  Toast.makeText(getApplicationContext(), "color verde", Toast.LENGTH_LONG).show();
			
			  if (Build.VERSION.SDK_INT >= 16)
				  btnOn.setBackground(getResources().getDrawable(R.drawable.btn_circle_pressed));
				else
					btnOn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_pressed));
		  }
		  /*if(aux1[0]=='0'&&aux2[0]=='0'){
			  
		  }else if(aux1[0]=='1'&&aux2[0]=='0'){
			  btnOn.setBackground(getResources().getDrawable(R.drawable.btn_circle_pressed));
			  Toast.makeText(getBaseContext(), "color verde", Toast.LENGTH_LONG).show();
		  }else{
			  
		  }*/
		  
	  }
	 
	  private class ConnectedThread extends Thread {
		    private final InputStream mmInStream;
		    private final OutputStream mmOutStream;
		 
		    public ConnectedThread(BluetoothSocket socket) {
		        InputStream tmpIn = null;
		        OutputStream tmpOut = null;
		 
		        
		        try {
		            tmpIn = socket.getInputStream();
		            tmpOut = socket.getOutputStream();
		        } catch (IOException e) { }
		 
		        mmInStream = tmpIn;
		        mmOutStream = tmpOut;
		    }
		 
		    public void run() {
		        byte[] buffer = new byte[256];  
		        int bytes; 
		        while (true) {
		        	try {
		                bytes = mmInStream.read(buffer);
	                    h.obtainMessage(RECIEVE_MESSAGE, bytes, -1, buffer).sendToTarget();		// Send to message queue Handler
		            } catch (IOException e) {
		                break;
		            }
		        }
		    }
		 
		    public void write(String message) {
		    	Log.d(TAG, "...Dato a enviar: " + message + "...");
		    	byte[] msgBuffer = message.getBytes();
		    	try {
		            mmOutStream.write(msgBuffer);
		        } catch (IOException e) {
		            Log.d(TAG, "...Error al enviar dato: " + e.getMessage() + "...");     
		          }
		    }
		}
}