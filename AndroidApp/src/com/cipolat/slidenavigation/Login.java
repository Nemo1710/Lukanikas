package com.cipolat.slidenavigation;


import java.util.ArrayList;

import registro.DataBaseManager;
import rest.httpHandler;
import android.app.Fragment;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Fragment {
	Button boton;
	private Cursor cursor;
	private DataBaseManager manager;

	TextView edit;
	SimpleCursorAdapter adapter;
    public Login(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
        View rootView = inflater.inflate(R.layout.login, container, false);
        edit=(TextView) rootView.findViewById(R.id.textView1);
        boton= (Button) rootView.findViewById(R.id.btn_registro_Aceptar);
        ImageView image=(ImageView) rootView.findViewById(R.id.logo_button);
        // Step1 : create the  RotateAnimation object
        RotateAnimation anim = new RotateAnimation(0f, 360f, 0f, 0f);
      
        
        // Step 2:  Set the Animation properties
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.ABSOLUTE);
        anim.setDuration(700);

        // Step 3: Start animating the image
         image.startAnimation(anim);

        // Later. if you want to  stop the animation
        // image.setAnimation(null);
         boton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*ejecutarRestTask uno= new ejecutarRestTask();
				uno.execute("http://rest.intinnover.com/v1/palabras");
				*/
				
				// TODO Auto-generated method stub
				 manager=new DataBaseManager(getActivity().getApplicationContext());
				 //manager.insertarr(2, "cama", "casa", "carro", "ca", "ma", "rro", "sa");
				 //manager.eliminar();
				 //manager.insertarr(2, "camion", "casa", "carro", "ca", "ma", "rro", "sa");
				 Log.e("SQL", "hasta aqui vamos bien");
				 cursor=manager.cargarCursorContactos();
				 String example = null;
				 cursor.moveToFirst();
				 for (int i=1;i<7;i++){
					 cursor.moveToPosition(i);
					 example += (cursor.getString(0)+cursor.getString(2));
				 }
				 
				 
				 

				 
				 edit.setText(example);
				 
				 /*
				 String[] from=new String[]{manager.CN_PALABRA1,manager.CN_PALABRA2,manager.CN_PALABRA3};
			        int[] to=new int[]{android.R.id.text1,android.R.id.text2};
			        
			       
			        adapter=new SimpleCursorAdapter(getActivity().getApplicationContext(), android.R.layout.two_line_list_item, cursor,from,to,0);
			        listview.setAdapter(adapter);
				 */
				   
		
			}
		});
        return rootView;
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
        	mijitrin=result.get(0);
        	boton.setText(result.toString());
        	Toast.makeText(getActivity().getApplicationContext(), mijitrin[1], Toast.LENGTH_SHORT).show();
        }
		
	
		
		
		
	

		

		
    
    }
 
}