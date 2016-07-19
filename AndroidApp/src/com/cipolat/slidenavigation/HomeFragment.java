package com.cipolat.slidenavigation;



import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.Toast;

/*  Fragment para seccion perfil */ 
public class HomeFragment extends Fragment  {
	RouletteView mRouletteView;
    public HomeFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.home, container, false);
    	
		
		mRouletteView = (RouletteView) rootView.findViewById(R.id.rouletteView);
		mRouletteView.updateSectors();
    	
    	
        
/*mijin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity().getApplicationContext(), "mijin", Toast.LENGTH_SHORT).show();
			}
		});*/ 
        return rootView;
    }
   
    	
}