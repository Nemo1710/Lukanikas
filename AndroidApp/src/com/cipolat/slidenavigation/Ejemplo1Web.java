package com.cipolat.slidenavigation;

import java.util.ArrayList;
import java.util.Locale;


import rest.httpHandler;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Ejemplo1Web extends Activity implements TextToSpeech.OnInitListener {

	private TextToSpeech textToSpeech;
	Button mijin;
	String val;
	httpHandler mijin1;
	TextView uno,txtuno,txtdos,txttres,txtaux,txtpalabra1,txtpalabra2,txtpalabra3;
	CheckBox primero,checkpalabra1,checkpalabra2,checkpalabra3;
	private ImageButton btnpri,btndos,btntres;
	String cadena;
	int flag=0;
	private final int REQ_CODE_SPEECH_INPUT = 100;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mijin1=new httpHandler();
		setContentView(R.layout.ejemplo11);
		primero=(CheckBox)findViewById(R.id.check1);
		checkpalabra1=(CheckBox)findViewById(R.id.checkpalabra1);
		checkpalabra2=(CheckBox)findViewById(R.id.checkpalabra2);
		checkpalabra3=(CheckBox)findViewById(R.id.checkpalabra3);
		uno=(TextView) findViewById(R.id.textView1);
		txtuno=(TextView) findViewById(R.id.txtv1);
		txtdos=(TextView) findViewById(R.id.txtv2);
		txttres=(TextView) findViewById(R.id.txtv3);
		txtpalabra1=(TextView) findViewById(R.id.txtpalabra1);
		txtpalabra2=(TextView) findViewById(R.id.txtpalabra2);
		txtpalabra3=(TextView) findViewById(R.id.txtpalabra3);
		btnpri=(ImageButton) findViewById(R.id.ibtn3);
		
		txtaux=(TextView) findViewById(R.id.txtaux);
		textToSpeech = new TextToSpeech(getApplicationContext(),this );
		textToSpeech.setLanguage( new Locale( "spa", "ESP" ) );
		
		
		/*uno.setText(getIntent().getExtras().getString("silaba1"));
		txtuno.setText(getIntent().getExtras().getString("silaba2"));
		txtdos.setText(getIntent().getExtras().getString("silaba3"));
		txttres.setText(getIntent().getExtras().getString("silaba4"));*/
		Bundle intent = getIntent().getExtras(); 
		val=intent.getString("extra");
		String [] arrayP = val.split(",");
		cadena="";
		if(arrayP.length==1){
			cadena=val;
			flag=1;
			Toast.makeText(getApplicationContext(), cadena, Toast.LENGTH_SHORT).show();
			 CallAPI tarea = new CallAPI();
	         tarea.execute(cadena);
		}else{
		
		for(int i=1;i<=arrayP.length-1;i++){
			cadena=cadena+arrayP[i]+",";
		}
		cadena = cadena.substring(0, cadena.length()-1); 
		Toast.makeText(getApplicationContext(), cadena, Toast.LENGTH_SHORT).show();
		 CallAPI tarea = new CallAPI();
         tarea.execute(arrayP[0]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//boton en la silaba inicial
		uno.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				speak(uno.getText().toString());
			}
		});
		//boton en la segunda silaba
		txtuno.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!primero.isChecked()){
				speak(txtuno.getText().toString());
				}else{
				speak(uno.getText().toString()+txtuno.getText().toString());	
				}
			}
		});
		txtdos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!primero.isChecked()){
					speak(txtdos.getText().toString());
					}else{
					speak(uno.getText().toString()+txtdos.getText().toString());	
					}
			}
		});
		txttres.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(!primero.isChecked()){
							speak(txttres.getText().toString());
							}else{
							speak(uno.getText().toString()+txttres.getText().toString());	
							}
					}
				});
		
		btnpri.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				promptSpeechInput();
			}
		});
       
	}
	protected void onResume(){
		super.onResume();
		if(checkpalabra1.isChecked()&&checkpalabra2.isChecked()&&checkpalabra3.isChecked()){
			if(flag==1){
				speak("Muy pronto jugaremos m·s");
				flag=0;
				finish();
			}else{
			speak("Felicitaciones, lo lograstÈ");
			Intent i=new Intent(getApplicationContext(),Ejemplo1Web.class);
			i.putExtra("extra",cadena);
			startActivity(i);
			finish();
			}
			
		}
		
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
        {
                Toast.makeText( this, "ERROR LANG_MISSING_DATA | LANG_NOT_SUPPORTED", Toast.LENGTH_SHORT ).show();
        }
	}
	private void speak( String str )
    {
            textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
            //textToSpeech.setSpeechRate( 0.0f );
            //textToSpeech.setPitch( 0.0f );
    }
	/**
	 * Showing google speech input dialog
	 * */
	private void promptSpeechInput() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
				getString(R.string.speech_prompt));

		
		try {
			startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
		} catch (ActivityNotFoundException a) {
			Toast.makeText(getApplicationContext(),
					getString(R.string.speech_not_supported),
					Toast.LENGTH_SHORT).show();
		}
	}
	
	
	//metodo para los toast
	public void mensaje(String mensaje){
		Toast.makeText(getApplicationContext(),mensaje , Toast.LENGTH_SHORT).show();
	}
	
	public void comparar(String dato){
		if(remove1(dato).equals(txtpalabra1.getText().toString())){
			if(!checkpalabra1.isChecked()){
				checkpalabra1.setChecked(true);
			}
		}else if(remove1(dato).equals(txtpalabra2.getText().toString())){
			if(!checkpalabra2.isChecked()){
				checkpalabra2.setChecked(true);
			}
		}else if(remove1(dato).equals(txtpalabra3.getText().toString())){
			if(!checkpalabra3.isChecked()){
				checkpalabra3.setChecked(true);
			}
		}else{
			this.mensaje("Pronuncia mejor");
			speak("Pronuncia mejor");
		}
		
	}

	/**
	 * Receiving speech input
	 * */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		

		switch (requestCode) {
		case REQ_CODE_SPEECH_INPUT: {
			if (resultCode == RESULT_OK && null != data) {
				
				ArrayList<String> result = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				txtaux.setText(result.get(0));
				this.comparar(result.get(0));
				
				
				
			}
			
			
					
			break;
		}

		}
	}
	
	
	public static String remove1(String input) {
        // Cadena de caracteres original a sustituir.
        String original = "·‡‰ÈËÎÌÏÔÛÚˆ˙˘uÒ¡¿ƒ…»ÀÕÃœ”“÷⁄Ÿ‹—Á«";
        // Cadena de caracteres ASCII que reemplazar·n los originales.
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String output = input;
        for (int i=0; i<original.length(); i++) {
            // Reemplazamos los caracteres especiales.
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }//for i
        return output;
    }//remove1
	
	private class CallAPI extends AsyncTask<String, String, String []> {
		
	    @Override
	    protected String [] doInBackground(String... params) {
	    	String [] mensaje = null;
	    	 
	        // HTTP Get
	        try {
	  
	    		
	    		//mensaje=mijin.palabra();
	    		mensaje=mijin1.palabra(params[0]);
	    		//
	    		
	    		
	  
	         } catch (Exception e ) {
	  
	            System.out.println(e.getMessage());
	            Log.e("mijin", e.getMessage());
	            
	  
	         }  
	        return mensaje;
	  
	           
	 
	    }
	 
	    protected void onPostExecute(String [] result) {
	    	
	    	
	    	txtpalabra1.setText(result[0]);
	    	txtpalabra2.setText(result[1]);
	    	txtpalabra3.setText(result[2]);
	    	uno.setText(result[3]);
	    	txtuno.setText(result[4]);
	    	txtdos.setText(result[6]);
	    	txttres.setText(result[5]);
	    	
	    }
	    
	} // end CallAPI 
	
}
