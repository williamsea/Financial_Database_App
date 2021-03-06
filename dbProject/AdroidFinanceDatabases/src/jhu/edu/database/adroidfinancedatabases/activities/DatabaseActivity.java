package jhu.edu.database.adroidfinancedatabases.activities;

import java.util.ArrayList;
import java.util.List;

import jhu.edu.database.adroidfinancedatabases.adapters.InfoSelectAdapter;
import jhu.edu.database.adroidfinancedatabases.datamodels.InfoSelectModel;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adroidfinancedatabases.R;

public class DatabaseActivity extends ListActivity {

	List<String> infoNames;
	private ArrayAdapter<InfoSelectModel> infoSelectAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database);
		
		infoSelectAdapter = new InfoSelectAdapter(this, getModel());
        setListAdapter(infoSelectAdapter);
	}

    private List<InfoSelectModel> getModel(){
    	List<InfoSelectModel> infoSelectTuples = new ArrayList<InfoSelectModel>();
    		infoNames = new ArrayList<String>();
    		
    		infoNames.add("Stock");
    		infoNames.add("Balance Sheet");
    		infoNames.add("Income Statement");
    		infoNames.add("Competitor");
    		infoNames.add("Industry");
    		infoNames.add("News");
    		infoNames.add("Key Statistics");
    		
    		for (int i=0;i<infoNames.size();i++){
    		InfoSelectModel infoSelectTuple = new InfoSelectModel();
    		infoSelectTuple.setInfoName(infoNames.get(i));
    		infoSelectTuples.add(infoSelectTuple);
    		}
    	return infoSelectTuples;
    }
    
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
    	Intent intent0 = getIntent();
    	String companyName = intent0.getStringExtra("companyName");
    			
    	Intent intent  = new  Intent(this, DetailedInfoActivity.class);
    	intent.putExtra("infoSelected", infoNames.get(position));
    	intent.putExtra("companyName", companyName);
    	startActivity(intent);
    	
    	Toast toast = Toast.makeText(getApplicationContext(), infoNames.get(position), Toast.LENGTH_LONG);
    	toast.show();
	}
    
    public void onBackButtonClick(View view){
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.database, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
