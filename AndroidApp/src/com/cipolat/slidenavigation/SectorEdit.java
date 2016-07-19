package com.cipolat.slidenavigation;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SectorEdit extends Activity {
	
	private SectorsDbAdapter mDbHelper;
    private EditText mSectorText;
    private Long mRowId;
    private int mPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.edit_sector);
		setTitle(R.string.config);		
		
        mSectorText = (EditText) findViewById(R.id.sector_text);
        Button buttonOk = (Button) findViewById(R.id.button_ok);
        Button buttonDelete = (Button) findViewById(R.id.button_delete);

        mDbHelper = new SectorsDbAdapter(this);
        mDbHelper.open();

        Bundle extras = getIntent().getExtras();
        mRowId = extras != null ? extras.getLong(SectorsDbAdapter.KEY_ROWID)
                                : null;
        mPosition = extras != null ? extras.getInt(SectorsConfig.LIST_POSITION)
                : null;
        populateText();   
        
       
        buttonOk.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
            	saveState();
            	setResult(RESULT_OK);
            	finish();          	
            }
        });
        if (mPosition < 2){
        	buttonDelete.setEnabled(false);
        }
        else
        {
        buttonDelete.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
                mDbHelper.deleteSector(mRowId);
                setResult(RESULT_OK);
                finish();
            }
        });
        }
		
	}
    @Override
    protected void onPause() {
        super.onPause();
        saveState();
    }
    @Override
    protected void onResume() {
        super.onResume();
        populateText();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveState();
        outState.putSerializable(SectorsDbAdapter.KEY_ROWID, mRowId);
    }
    
    private void populateText() {
        if (mRowId != null) {
            Cursor sector = mDbHelper.fetchSector(mRowId);
            startManagingCursor(sector);
            mSectorText.setText(sector.getString(
                    sector.getColumnIndexOrThrow(SectorsDbAdapter.KEY_BODY)));
        }
    }
    
    private void saveState() {
        String body = mSectorText.getText().toString();
        if (body.length() != 0 && mRowId != null) {
             mDbHelper.updateSector(mRowId, body);
        }
    }
}
