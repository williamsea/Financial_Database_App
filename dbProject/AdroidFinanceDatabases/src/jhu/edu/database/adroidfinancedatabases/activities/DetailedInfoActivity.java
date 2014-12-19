package jhu.edu.database.adroidfinancedatabases.activities;

import java.util.ArrayList;
import java.util.List;

import jhu.edu.database.adroidfinancedatabases.adapters.DetailedInfoAdapter;
import jhu.edu.database.adroidfinancedatabases.datamodels.DetailedInfoModel;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adroidfinancedatabases.R;

public class DetailedInfoActivity extends ListActivity {

	private ArrayAdapter<DetailedInfoModel> detailedInfoAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detailed_info);
		
		detailedInfoAdapter = new DetailedInfoAdapter(this, getModel());
        setListAdapter(detailedInfoAdapter);
	}

    private List<DetailedInfoModel> getModel(){
    	List<DetailedInfoModel> detailedInfoTuples = new ArrayList<DetailedInfoModel>();
    		List<String> attributeNames = new ArrayList<String>();
    		List<String> attributeValues = new ArrayList<String>();
    		attributeNames.add("Stock");
    		attributeNames.add("Price");
    		attributeNames.add("Hello");
    		attributeValues.add("1");
    		attributeValues.add("2");
    		attributeValues.add("3");
    		
    		for (int i=0;i<attributeNames.size();i++){
    		DetailedInfoModel detailedInoTuple = new DetailedInfoModel();
    		detailedInoTuple.setAttributeName(attributeNames.get(i));
    		detailedInoTuple.setAttributeValue(attributeValues.get(i));
    		detailedInfoTuples.add(detailedInoTuple);
    		}
    	return detailedInfoTuples;
    }
    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detailed_info, menu);
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
