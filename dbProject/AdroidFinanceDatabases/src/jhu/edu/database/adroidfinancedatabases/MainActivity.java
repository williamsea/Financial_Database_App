package jhu.edu.database.adroidfinancedatabases;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adroidfinancedatabases.R;


public class MainActivity extends ListActivity {

	List<String> companyName;
	List<String> companyAddress;
	List<String> companyWebsite;
	
	private ArrayAdapter<DataModel> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseOperations();
        dataAdapter = new DataAdapter(this, getModel());
        setListAdapter(dataAdapter);
    }

	private void DatabaseOperations() {
		try {
        	this.deleteDatabase(DatabaseOperator.DATABASE_NAME);
			DatabaseOperator dop = new DatabaseOperator(this);
			SQLiteDatabase sq = dop.getWritableDatabase();
//			sq.execSQL(dop.CREATE_BALANCE_SHEET+dop.CREATE_COMPANY+dop.CREATE_COMPANY_INDUSTRY+dop.CREATE_COMPANY_NEWS+dop.CREATE_COMPATITOR+dop.CREATE_HAS_STOCK+dop.CREATE_INCOME_STATEMENT+dop.CREATE_INDUSTRY+dop.CREATE_KEYSTAT+dop.CREATE_NEWS+dop.CREATE_STOCK);
			dop.putDataCompany(dop, "Apple Inc", "1 Infinite LoopvCupertino, CA 95014, United States", "http://www.apple.com", "Apple Inc designs");
			dop.putDataHasStock(dop, "Apple Inc", "AAPL");
			dop.putDataStock(dop, "AAPL", 115, "2014-11-20", "10:09:00");
			dop.putDataBalanceSheet(dop, "Apple Inc", "2014-09-27", "Cash and Cash Equivalents", 13844000);
			dop.putDataIncomeStatement(dop, "Apple Inc", "2014-09-27", "research development", 6041000);
			dop.putDataCompatitor(dop, "Apple Inc", "Google Inc");
			dop.putDataCompanyIndustry(dop, "Apple Inc", "Electronic Equipment");
			dop.putDataNews(dop, "Apple Rising: Piper, Evercore, Morgan Stanley Hike Targets on iPhone, Watch Prospects", "2014-11-20", " ");
			dop.putDataCompanyNews(dop, "Apple Inc", "Apple Rising: Piper, Evercore, Morgan Stanley Hike Targets on iPhone, Watch Prospects", "2014-11-20", 0, 0);
			dop.putDataKeyStat(dop, "Apple Inc", "intraday", "MarketCap", 653480000000L);
			
			Cursor getCompanyInfo = dop.getCompanyInfo(dop);
			getCompanyInfo.moveToFirst();
			companyName = new ArrayList<String>();
			companyAddress = new ArrayList<String>();
			companyWebsite = new ArrayList<String>();

			do{
				companyName.add(getCompanyInfo.getString(0));
				companyAddress.add(getCompanyInfo.getString(1));
				companyWebsite.add(getCompanyInfo.getString(2));
			}while(getCompanyInfo.moveToNext());
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("failed");
		}
	}

    private List<DataModel> getModel(){
    	List<DataModel> databaseTuples = new ArrayList<DataModel>();
    	for (int i=0;i<companyName.size();i++){
    		DataModel databaseTuple = new DataModel();
    		databaseTuple.setCompanyName(companyName.get(i));
    		databaseTuple.setCompanyAddress(companyAddress.get(i));
    		databaseTuple.setCompanyWebsite(companyWebsite.get(i));
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
