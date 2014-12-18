package jhu.edu.database.adroidfinancedatabases;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adroidfinancedatabases.R;


public class MainActivity extends ListActivity {

	private ArrayAdapter<DataModel> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dataAdapter = new DataAdapter(this, getModel());
        setListAdapter(dataAdapter);
    }

    private List<DataModel> getModel(){
    	List<DataModel> databaseTuples = new ArrayList<DataModel>();
    	for (int i=0;i<20;i++){
    		DataModel databaseTuple = new DataModel();
    		databaseTuple.setCompanyName("Company Name "+i);
    		databaseTuple.setCompanyAddress("Company Address "+i);
    		databaseTuples.add(databaseTuple);
    	}
    	return databaseTuples;
    }
    
    

    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
    	Intent intent  = new  Intent(this, DatabaseActivity.class);
    	startActivity(intent);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
