package jhu.edu.database.adroidfinancedatabases.activities;

import java.util.ArrayList;
import java.util.List;

import jhu.edu.database.adroidfinancedatabases.adapters.DataAdapter;
import jhu.edu.database.adroidfinancedatabases.datamodels.DataModel;
import jhu.edu.database.adroidfinancedatabases.dboperator.DatabaseOperator;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adroidfinancedatabases.QueryResultActivity;
import com.example.adroidfinancedatabases.R;


public class MainActivity extends ListActivity {

    List<String> companyName;
    List<String> companyAddress;
    List<String> companyWebsite;
    EditText editTextAggregation;
    EditText editTextChosenCompany;
    EditText editTextChosenInfo;
////    stock
//    List<String> stockName;
//    List<Double> stockPrice;
//    List<String> stockDate;
//    List<String> stockTime;
////    balance sheet
//    List<String> balanceSheetDate;
//    List<String> balanceSheetName;
//    List<Integer> balanceSheetValue;
////    income statement
//    List<String> incomeStatementDate;
//    List<String> incomeStatementName;
//    List<Integer> incomeStatementValue;
////    competitor
//    List<String> competitor;
////    industry
//    String industry;
////    news
//    List<String> newsTitle;
//    List<String> newsDate;
//    List<String> abstracts;
//    List<Integer> positive_effect;
//    List<Integer> negative_effect;
////    key statistics
//    List<String> statTerm;
//    List<String> statName;
//    List<Integer> statValue;
	
	private ArrayAdapter<DataModel> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseOperations();
        dataAdapter = new DataAdapter(this, getModel());
        setListAdapter(dataAdapter);
        
        editTextAggregation = (EditText) findViewById(R.id.textView_aggregation);
        editTextChosenCompany = (EditText) findViewById(R.id.textView_choose_company);
        editTextChosenInfo= (EditText) findViewById(R.id.textView_choose_info);
    }

	private void DatabaseOperations() {
		try {
        	this.deleteDatabase(DatabaseOperator.DATABASE_NAME);
			DatabaseOperator dop = new DatabaseOperator(this);
			SQLiteDatabase sq = dop.getWritableDatabase();
//			sq.execSQL(dop.CREATE_BALANCE_SHEET+dop.CREATE_COMPANY+dop.CREATE_COMPANY_INDUSTRY+dop.CREATE_COMPANY_NEWS+dop.CREATE_COMPATITOR+dop.CREATE_HAS_STOCK+dop.CREATE_INCOME_STATEMENT+dop.CREATE_INDUSTRY+dop.CREATE_KEYSTAT+dop.CREATE_NEWS+dop.CREATE_STOCK);
			dop.putDataCompany(dop, "Apple_Inc", "1 Infinite LoopvCupertino, CA 95014, United States", "http://www.apple.com", "Apple_Inc designs");
			dop.putDataHasStock(dop, "Apple_Inc", "AAPL");
			dop.putDataStock(dop, "AAPL", 115, "2014-11-20", "10:09:00");
			dop.putDataBalanceSheet(dop, "Apple_Inc", "2014-09-27", "Cash and Cash Equivalents", 13844000);
			dop.putDataIncomeStatement(dop, "Apple_Inc", "2014-09-27", "research development", 6041000);
			dop.putDataCompatitor(dop, "Apple_Inc", "Google Inc");
			dop.putDataCompanyIndustry(dop, "Apple_Inc", "Electronic Equipment");
			dop.putDataNews(dop, "Apple Rising: Piper, Evercore, Morgan Stanley Hike Targets on iPhone, Watch Prospects", "2014-11-20", " ");
			dop.putDataCompanyNews(dop, "Apple_Inc", "Apple Rising: Piper, Evercore, Morgan Stanley Hike Targets on iPhone, Watch Prospects", "2014-11-20", 0, 0);
			dop.putDataKeyStat(dop, "Apple_Inc", "intraday", "MarketCap", 653480000000L);
			
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
            getCompanyInfo.close();

//            balanceSheetDate = new ArrayList<String>();
//            balanceSheetName = new ArrayList<String>();
//            balanceSheetValue = new ArrayList<Integer>();
//            Cursor c1 = dop.getDetailedInfoBalanceSheet(dop, "Apple_Inc");
//            c1.moveToFirst();
//            do{
//                balanceSheetDate.add(c1.getString(1));
//                balanceSheetName.add(c1.getString(2));
//                balanceSheetValue.add(c1.getInt(3));
//            }while(c1.moveToNext());
//            c1.close();
//
//            competitor = new ArrayList<String>();
//            Cursor c2 = dop.getDetailedInfoCompetitor(dop, "Apple_Inc");
//            c2.moveToFirst();
//            do{
//                if(c2.getString(0)!= "Apple_Inc"){
//                    competitor.add(c2.getString(0));
//                }else{
//                    competitor.add(c2.getString(1));
//                }
//            }while(c2.moveToNext());
//            c2.close();
//
//            incomeStatementDate = new ArrayList<String>();
//            incomeStatementName = new ArrayList<String>();
//            incomeStatementValue = new ArrayList<Integer>();
//            Cursor c3 = dop.getDetailedInfoIncomeStatement(dop, "Apple_Inc");
//            c3.moveToFirst();
//            do{
//                incomeStatementDate.add(c3.getString(1));
//                incomeStatementName.add(c3.getString(2));
//                incomeStatementValue.add(c3.getInt(3));
//            }while(c3.moveToNext());
//            c3.close();
//
//            industry = "";
//            Cursor c4 = dop.getDetailedInfoIndustry(dop, "Apple_Inc");
//            c4.moveToFirst();
//            do{
//                industry = (c4.getString(1));
//            }while(c4.moveToNext());
//            c4.close();
//
//            statTerm = new ArrayList<String>();
//            statName = new ArrayList<String>();
//            statValue = new ArrayList<Integer>();
//            Cursor c5 = dop.getDetailedInfoKeyStat(dop, "Apple_Inc");
//            c5.moveToFirst();
//            do{
//                statTerm.add(c5.getString(1));
//                statName.add(c5.getString(2));
//                statValue.add(c5.getInt(3));
//            }while(c5.moveToNext());
//            c5.close();
//
//            newsTitle = new ArrayList<String>();
//            newsDate = new ArrayList<String>();
//            abstracts = new ArrayList<String>();
//            positive_effect = new ArrayList<Integer>();
//            negative_effect = new ArrayList<Integer>();
//            Cursor c6 = dop.getDetailedInfoNews(dop, "Apple_Inc");
//            c6.moveToFirst();
//            do{
//                newsTitle.add(c6.getString(0));
//                newsDate.add(c6.getString(1));
//                abstracts.add(c6.getString(2));
//                positive_effect.add(c6.getInt(3));
//                negative_effect.add(c6.getInt(4));
//            }while(c6.moveToNext());
//            c6.close();
//            
//            stockName = new ArrayList<String>();
//            stockPrice = new ArrayList<Double>();
//            stockDate = new ArrayList<String>();
//            stockTime = new ArrayList<String>();
//            Cursor c7 = dop.getDetailedInfoStock(dop, "Apple_Inc");
//            c7.moveToFirst();
//            do{
//                stockName.add(c7.getString(0));
//                stockPrice.add(c7.getDouble(1));
//                stockDate.add(c7.getString(2));
//                stockTime.add(c7.getString(3));
//            }while(c7.moveToNext());
//            c7.close();

			
			
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
    
    public void onSendQueryButtonClick(View view){
    	Intent intent = new Intent(this, QueryResultActivity.class);
    	startActivity(intent);
    }

    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
    	Intent intent  = new  Intent(this, DatabaseActivity.class);
    	intent.putExtra("companyName", companyName.get(position));
    	startActivity(intent);
    	
    	Toast toast = Toast.makeText(getApplicationContext(), companyName.get(position), Toast.LENGTH_LONG);
    	toast.show();
    	
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
