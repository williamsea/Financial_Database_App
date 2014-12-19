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

import com.example.adroidfinancedatabases.R;


public class MainActivity extends ListActivity {

    List<String> companyName;
    List<String> companyAddress;
    List<String> companyWebsite;
    EditText editTextAggregation;
    EditText editTextChosenCompany;
    EditText editTextChosenInfo;
	
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
            DefineDatabase(dop);
			
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

			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("failed");
		}
	}

	/**
	 * It's the method of putting data into the database
	 * @param dop
	 */
	private void DefineDatabase(DatabaseOperator dop) {
		dop.putDataCompany(dop, "Apple_Inc", "1 Infinite LoopvCupertino, CA 95014, United States", "http://www.apple.com", "Apple_Inc designs");
		dop.putDataHasStock(dop, "Apple_Inc", "AAPL");
		dop.putDataStock(dop, "AAPL", 112.65, "2014-12-18", "16:00:00");
		dop.putDataStock(dop, "AAPL", 109.29, "2014-12-17", "16:00:00");
		dop.putDataStock(dop, "AAPL", 106.69, "2014-12-16", "16:00:00");
		dop.putDataStock(dop, "AAPL", 108.24, "2014-12-15", "16:00:00");
		dop.putDataStock(dop, "AAPL", 109.85, "2014-12-12", "16:00:00");
		dop.putDataStock(dop, "AAPL", 111.62, "2014-12-11", "16:00:00");
		dop.putDataStock(dop, "AAPL", 111.99, "2014-12-10", "16:00:00");
		dop.putDataStock(dop, "AAPL", 114.13, "2014-12-09", "16:00:00");
		dop.putDataStock(dop, "AAPL", 112.40, "2014-12-08", "16:00:00");
		dop.putDataStock(dop, "AAPL", 114.98, "2014-12-05", "16:00:00");
		dop.putDataStock(dop, "AAPL", 115.46, "2014-12-04", "16:00:00");
		dop.putDataStock(dop, "AAPL", 115.95, "2014-12-03", "16:00:00");
		dop.putDataBalanceSheet(dop, "Apple_Inc", "2014-09-27", "cash and cash equivalents", 13844000);
		dop.putDataBalanceSheet(dop, "Apple_Inc", "2013-12-31", "total assets", 225184000000L);
		dop.putDataBalanceSheet(dop, "Apple_Inc", "2013-12-31", "total liability", 95500000000L);
		dop.putDataIncomeStatement(dop, "Apple_Inc", "2014-09-27", "research development", 6041000);
		dop.putDataIncomeStatement(dop, "Apple_Inc", "2013-12-31", "total income", 57594000000L);
		dop.putDataIncomeStatement(dop, "Apple_Inc", "2013-12-31", "net income", 13072000000L);
		dop.putDataCompatitor(dop, "Apple_Inc", "Google_Inc");
		dop.putDataCompanyIndustry(dop, "Apple_Inc", "Electronic Equipment");
		dop.putDataNews(dop, "Apple Rising: Piper, Evercore, Morgan Stanley Hike Targets on iPhone, Watch Prospects", "2014-11-20", "...");
		dop.putDataCompanyNews(dop, "Apple_Inc", "Apple Rising: Piper, Evercore, Morgan Stanley Hike Targets on iPhone, Watch Prospects", "2014-11-20", 0, 0);
		dop.putDataKeyStat(dop, "Apple_Inc","intraday" ,"MarketCap",660674000000L);
		dop.putDataKeyStat(dop, "Apple_Inc", "intraday","PE",1744L);


		dop.putDataCompany(dop, "Google_Inc", "1600 Amphitheatre Parkway Mountain View, CA 94043", "http://www.google.com", "blabla");
		dop.putDataHasStock(dop, "Google_Inc", "GOOG");
		dop.putDataStock(dop, "GOOG", 511.10, "2014-12-18", "16:00:00");
		dop.putDataStock(dop, "GOOG", 504.89, "2014-12-17", "16:00:00");
		dop.putDataStock(dop, "GOOG", 495.39, "2014-12-16", "16:00:00");
		dop.putDataStock(dop, "GOOG", 513.80, "2014-12-15", "16:00:00");
		dop.putDataStock(dop, "GOOG", 518.66, "2014-12-12", "16:00:00");
		dop.putDataStock(dop, "GOOG", 528.34, "2014-12-11", "16:00:00");
		dop.putDataStock(dop, "GOOG", 526.06, "2014-12-10", "16:00:00");
		dop.putDataStock(dop, "GOOG", 533.37, "2014-12-09", "16:00:00");
		dop.putDataStock(dop, "GOOG", 526.98, "2014-12-08", "16:00:00");
		dop.putDataStock(dop, "GOOG", 525.26, "2014-12-05", "16:00:00");
		dop.putDataStock(dop, "GOOG", 537.31, "2014-12-04", "16:00:00");
		dop.putDataStock(dop, "GOOG", 531.32, "2014-12-03", "16:00:00");
		dop.putDataBalanceSheet(dop, "Google_Inc", "2013-12-31", "total assets", 110920000000L);
		dop.putDataBalanceSheet(dop, "Google_Inc", "2013-12-31", "total liability", 5245000000L);
		dop.putDataIncomeStatement(dop, "Google_Inc", "2013-12-31", "total income", 16858000000L);
		dop.putDataIncomeStatement(dop, "Google_Inc", "2013-12-31", "net income", 3376000000L);
		dop.putDataCompatitor(dop, "Google_Inc","Apple_Inc");
		dop.putDataCompatitor(dop, "Google_Inc","Yahoo!_Inc");
		dop.putDataCompanyIndustry(dop, "Google_Inc", "Internet Information Providers");
		dop.putDataNews(dop, "#PreMarket Primer: Friday, December 19: U.S. Debates A Response To Sony Hackers", "2014-12-19", "...");
		dop.putDataCompanyNews(dop, "Google_Inc", "#PreMarket Primer: Friday, December 19: U.S. Debates A Response To Sony Hackers", "2014-12-19", 0, 0);
		dop.putDataKeyStat(dop, "Google_Inc","intraday", "MarketCap",346710000000L);
		dop.putDataKeyStat(dop, "Google_Inc", "intraday","PE",2690L);

		dop.putDataCompany(dop, "Yahoo!_Inc", "701 First Avenue Sunnyvale, CA 94089 United States ", "http://www.yahoo.com", "blabla");
		dop.putDataHasStock(dop, "Yahoo!_Inc", "YHOO");
		dop.putDataStock(dop, "YHOO", 50.91, "2014-12-18", "16:00:00");
		dop.putDataStock(dop, "YHOO", 50.13, "2014-12-17", "16:00:00");
		dop.putDataStock(dop, "YHOO", 48.86, "2014-12-16", "16:00:00");
		dop.putDataStock(dop, "YHOO", 49.82, "2014-12-15", "16:00:00");
		dop.putDataStock(dop, "YHOO", 50.26, "2014-12-12", "16:00:00");
		dop.putDataStock(dop, "YHOO", 49.95, "2014-12-11", "16:00:00");
		dop.putDataStock(dop, "YHOO", 49.20, "2014-12-10", "16:00:00");
		dop.putDataStock(dop, "YHOO", 50.51, "2014-12-09", "16:00:00");
		dop.putDataStock(dop, "YHOO", 49.62, "2014-12-08", "16:00:00");
		dop.putDataStock(dop, "YHOO", 50.99, "2014-12-05", "16:00:00");
		dop.putDataStock(dop, "YHOO", 50.41, "2014-12-04", "16:00:00");
		dop.putDataStock(dop, "YHOO", 50.28, "2014-12-03", "16:00:00");
		dop.putDataBalanceSheet(dop, "Yahoo_Inc", "2013-12-31", "total assets", 16804960000L);
		dop.putDataBalanceSheet(dop, "Yahoo_Inc", "2013-12-31", "total liability", 3730050000L);
		dop.putDataIncomeStatement(dop, "Yahoo_Inc", "2013-12-31", "total income", 1265800000L);
		dop.putDataIncomeStatement(dop, "Yahoo_Inc", "2013-12-31", "net income", 348190000L);
		dop.putDataCompatitor(dop, "Yahoo!_Inc","Google_Inc");
		dop.putDataCompanyIndustry(dop, "Yahoo!_Inc", "Internet Information Providers");
		dop.putDataNews(dop, "Yahoo Finance 2014 Company of the Year: Under Armour", "2014-12-19", "...");
		dop.putDataCompanyNews(dop, "Yahoo!_Inc", "Yahoo Finance 2014 Company of the Year: Under Armour", "2014-12-19", 0, 0);
		dop.putDataKeyStat(dop, "Yahoo!_Inc", "intraday","MarketCap",48230000000L);
		dop.putDataKeyStat(dop, "Yahoo!_Inc", "intraday","PE",680L );
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
    	String aggregValue;
    	String chosenCompany;
    	String chosenInfo;
    	String out;
    	try{

    	aggregValue = editTextAggregation.getText().toString();
    	chosenCompany = editTextChosenCompany.getText().toString();
    	chosenInfo =  editTextChosenInfo.getText().toString();
        
		DatabaseOperator dop = new DatabaseOperator(this);
        Cursor c8 = dop.aggregateInfoGet(dop, aggregateFunctionTranslater(aggregValue), chosenCompany, chosenInfo, inCompanyOrIndustry(dop, chosenCompany), inWhatSheet(dop, chosenInfo));
        c8.moveToFirst();
        out = c8.getString(0);
        out = out + "";
        c8.close();

    	}catch(Exception e){
    		out = "Illegal Query!";
    		
    	}
    	
    	Intent intent = new Intent(this, QueryResultActivity.class);
    	intent.putExtra("queryResult", out);
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
    
    
    /**
     * It judges whether the input is a company's name or an industry's name.
     * @param dop
     * @param in
     * @return 1 means that it's a company's name, 2 means that it's an industry's name;
     */
    public int inCompanyOrIndustry(DatabaseOperator dop, String in){
        int out;
        SQLiteDatabase sq = dop.getReadableDatabase();
        List<String> companyNames;
        List<String> industryNames;
        Cursor cc = dop.getCompanyInfo(dop);
        cc.moveToFirst();
        companyNames = new ArrayList<String>();
        do{
            companyNames.add(cc.getString(0));
        }while(cc.moveToNext());
        cc.close();
        Cursor cc1 = sq.rawQuery("select industry_name from Company_industry", null);
        cc1.moveToFirst();
        industryNames = new ArrayList<String>();
        do{
            industryNames.add(cc1.getString(0));
        }while(cc1.moveToNext());
        cc1.close();
        
        if(companyNames.contains(in)){
            out = 1;
        }else if (industryNames.contains(in)){
            out = 2;
        }else{
            out = 0;
        }
        return out;
    }
    /**
     * It recognized the input and find which aggregate function the input belongs to;
     * @param in
     * @return 1 corresponds to max, 2 corresponds to min, 3 corresponds to average, 4 corresponds to count.
     */
    private int aggregateFunctionTranslater(String in){
    	in=in.toLowerCase();
        boolean t1 = in.contains("max")||in.contains("most")||in.contains("highest");
        boolean t2 = in.contains("min")||in.contains("smallest")||in.contains("lowest");
        boolean t3 = in.contains("avg")||in.contains("average");
        boolean t4 = in.contains("count")||in.contains("number")||in.contains("time");
        int out;
        if(t1){
            out = 0;
        }else if(t2){
            out = 1;
        }else if(t3){
            out = 2;
        }else if(t4){
            out = 3;
        }else{
            out = 100;
        }
        return out;
    }
    

        
    /**
     * It judges whether the input is in a balance sheet or an income statement or a key statistics
     * @param dop
     * @param in
     * @return 1 corresponds to balance sheet, 2 corresponds to income statement, 3 corresponds to key statistics
     */
    private int inWhatSheet(DatabaseOperator dop, String in){
        int out;
        in = in.toLowerCase();
        SQLiteDatabase sq = dop.getReadableDatabase();
        List<String> whatsInBS;
        List<String> whatsInIS;
        List<String> whatsInKS;
        
        whatsInBS = new ArrayList<String>();
        whatsInIS = new ArrayList<String>();
        whatsInKS = new ArrayList<String>();
        
        Cursor cc = sq.rawQuery("select * from BalanceSheet", null);
        cc.moveToFirst();
        do{
            whatsInBS.add(cc.getString(2));
        }while(cc.moveToNext());
        cc.close();
        
        Cursor cc1 = sq.rawQuery("select * from Income_statement", null);
        cc1.moveToFirst();
        do{
            whatsInIS.add(cc1.getString(2));
        }while(cc1.moveToNext());
        cc1.close();
        
        Cursor cc2 = sq.rawQuery("select * from Keystats", null);
        cc2.moveToFirst();
        do{
            whatsInKS.add(cc2.getString(2));
        }while(cc2.moveToNext());
        cc2.close();
        
        if(whatsInBS.contains(in)){
            out = 1;
        }else if(whatsInIS.contains(in)){
            out = 2;
        }else if(whatsInKS.contains(in)){
            out = 3;
        }else{
            out = 0;
        }
        return out;
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
