package jhu.edu.database.adroidfinancedatabases.activities;

import java.util.ArrayList;
import java.util.List;

import jhu.edu.database.adroidfinancedatabases.adapters.DetailedInfoAdapter;
import jhu.edu.database.adroidfinancedatabases.datamodels.DetailedInfoModel;
import jhu.edu.database.adroidfinancedatabases.dboperator.DatabaseOperator;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.adroidfinancedatabases.QueryResultActivity;
import com.example.adroidfinancedatabases.R;

public class DetailedInfoActivity extends ListActivity {

	List<String> attribute1;
	List<String> attribute2;
	List<String> attribute3;
	List<String> attribute4;
	List<String> attribute5;
	TextView textViewAttribute1;
	TextView textViewAttribute2;
	TextView textViewAttribute3;
	TextView textViewAttribute4;
	TextView textViewAttribute5;
	TextView textViewTitle;
	

	// stock
	List<String> stockName;
	List<String> stockPrice;
	List<String> stockDate;
	List<String> stockTime;
	// balance sheet
	List<String> balanceSheetDate;
	List<String> balanceSheetName;
	List<String> balanceSheetValue;
	// income statement
	List<String> incomeStatementDate;
	List<String> incomeStatementName;
	List<String> incomeStatementValue;
	// competitor
	List<String> competitor;
	// industry
	List<String> industry;
	// news
	List<String> newsTitle;
	List<String> newsDate;
	List<String> abstracts;
	List<String> positive_effect;
	List<String> negative_effect;
	// key statistics
	List<String> statTerm;
	List<String> statName;
	List<String> statValue;

	String companyName;
	String infoSelected;

	private ArrayAdapter<DetailedInfoModel> detailedInfoAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detailed_info);
		Intent intent = getIntent();
		companyName = intent.getStringExtra("companyName");
		infoSelected = intent.getStringExtra("infoSelected");

		textViewAttribute1 = (TextView) findViewById(R.id.textView_attribute1_fixed);
		textViewAttribute2 = (TextView) findViewById(R.id.textView_attribute2_fixed);
		textViewAttribute3 = (TextView) findViewById(R.id.textView_attribute3_fixed);
		textViewAttribute4 = (TextView) findViewById(R.id.textView_attribute4_fixed);
		textViewAttribute5 = (TextView) findViewById(R.id.textView_attribute5_fixed);
		textViewTitle = (TextView) findViewById(R.id.textView_detailed_info);
		
		getData();

		detailedInfoAdapter = new DetailedInfoAdapter(this, getModel());
		setListAdapter(detailedInfoAdapter);
	}


	

	
	private List<DetailedInfoModel> getModel() {
		List<DetailedInfoModel> detailedInfoTuples = new ArrayList<DetailedInfoModel>();

		attribute1 = new ArrayList<String>();
		attribute2 = new ArrayList<String>();
		attribute3 = new ArrayList<String>();
		attribute4 = new ArrayList<String>();
		attribute5 = new ArrayList<String>();
		

		generateView(detailedInfoTuples);
		
		return detailedInfoTuples;
	}

	private void generateView(List<DetailedInfoModel> detailedInfoTuples) {
		if (infoSelected.equals("Stock")) {
			attribute1 = stockName;
			attribute2 = stockPrice;
			attribute3 = stockDate;
			attribute4 = stockTime;
			
			textViewTitle.setText("Stock");
			textViewAttribute1.setText("Name");
			textViewAttribute2.setText("Price");
			textViewAttribute3.setText("Date");
			textViewAttribute4.setText("Time");
			textViewAttribute5.setText("    ");

			for (int i = 0; i < attribute1.size(); i++) {
				DetailedInfoModel detailedInoTuple = new DetailedInfoModel();
				detailedInoTuple.setCompanyName(companyName);
				detailedInoTuple.setAttribute1(attribute1.get(i));
				detailedInoTuple.setAttribute2(attribute2.get(i));
				detailedInoTuple.setAttribute3(attribute3.get(i));
				detailedInoTuple.setAttribute4(attribute4.get(i));
				detailedInfoTuples.add(detailedInoTuple);
			}
		}
		
		else if (infoSelected.equals("Balance Sheet")) {
			attribute1 = balanceSheetDate;
			attribute2 = balanceSheetName;
			attribute3 = balanceSheetValue;
			
			textViewTitle.setText("Balance Sheet");
			textViewAttribute1.setText("Date");
			textViewAttribute2.setText("Name");
			textViewAttribute3.setText("Value");
			textViewAttribute4.setText("    ");
			textViewAttribute5.setText("    ");

			for (int i = 0; i < attribute1.size(); i++) {
				DetailedInfoModel detailedInoTuple = new DetailedInfoModel();
				detailedInoTuple.setCompanyName(companyName);
				detailedInoTuple.setAttribute1(attribute1.get(i));
				detailedInoTuple.setAttribute2(attribute2.get(i));
				detailedInoTuple.setAttribute3(attribute3.get(i));
				detailedInfoTuples.add(detailedInoTuple);
			}
		}
		
		else if(infoSelected.equals("Income Statement")) {
			attribute1 = incomeStatementDate;
			attribute2 = incomeStatementName;
			attribute3 = incomeStatementValue;
			
			textViewTitle.setText("Income Statement");
			textViewAttribute1.setText("Date");
			textViewAttribute2.setText("Name");
			textViewAttribute3.setText("Value");
			textViewAttribute4.setText("    ");
			textViewAttribute5.setText("    ");

			for (int i = 0; i < attribute1.size(); i++) {
				DetailedInfoModel detailedInoTuple = new DetailedInfoModel();
				detailedInoTuple.setCompanyName(companyName);
				detailedInoTuple.setAttribute1(attribute1.get(i));
				detailedInoTuple.setAttribute2(attribute2.get(i));
				detailedInoTuple.setAttribute3(attribute3.get(i));
				detailedInfoTuples.add(detailedInoTuple);
			}
		}
		
		else if(infoSelected.equals("Competitor")) {
			attribute1 = competitor;

			textViewTitle.setText("Competitor");
			textViewAttribute1.setText("Competitor");
			textViewAttribute2.setText("    ");
			textViewAttribute3.setText("    ");
			textViewAttribute4.setText("    ");
			textViewAttribute5.setText("    ");

			for (int i = 0; i < attribute1.size(); i++) {
				DetailedInfoModel detailedInoTuple = new DetailedInfoModel();
				detailedInoTuple.setCompanyName(companyName);
				detailedInoTuple.setAttribute1(attribute1.get(i));
				detailedInfoTuples.add(detailedInoTuple);
			}
		}
		
		else if(infoSelected.equals("Industry")) {
			attribute1 = industry;
			
			textViewTitle.setText("Industry");
			textViewAttribute1.setText("Industry");
			textViewAttribute2.setText("     ");
			textViewAttribute3.setText("     ");
			textViewAttribute4.setText("     ");
			textViewAttribute5.setText("     ");

			for (int i = 0; i < attribute1.size(); i++) {
				DetailedInfoModel detailedInoTuple = new DetailedInfoModel();
				detailedInoTuple.setCompanyName(companyName);
				detailedInoTuple.setAttribute1(attribute1.get(i));
				detailedInfoTuples.add(detailedInoTuple);
			}
		}
		
		else if(infoSelected.equals("News")) {
			
			attribute1 = newsTitle;
			attribute2 = newsDate;
			attribute3 = abstracts;	
			attribute4 = positive_effect;
			attribute5 = negative_effect;
			
			textViewTitle.setText("News");
			textViewAttribute1.setText("newsTitle");
			textViewAttribute2.setText("newsDate");
			textViewAttribute3.setText("abstracts");
			textViewAttribute4.setText("pos_effect");
			textViewAttribute5.setText("neg_effect");

			for (int i = 0; i < attribute1.size(); i++) {
				DetailedInfoModel detailedInoTuple = new DetailedInfoModel();
				detailedInoTuple.setCompanyName(companyName);
				detailedInoTuple.setAttribute1(attribute1.get(i));
				detailedInoTuple.setAttribute2(attribute2.get(i));
				detailedInoTuple.setAttribute3(attribute3.get(i));
				detailedInoTuple.setAttribute4(attribute4.get(i));
				detailedInoTuple.setAttribute5(attribute5.get(i));
				detailedInfoTuples.add(detailedInoTuple);
			}
		}
		
		else if(infoSelected.equals("Key Statistics")) {
			
			attribute1 = statTerm;
			attribute2 = statName;
			attribute3 = statValue;	

			textViewTitle.setText("Key Statistics");
			textViewAttribute1.setText("statTerm");
			textViewAttribute2.setText("statName");
			textViewAttribute3.setText("statValue");
			textViewAttribute4.setText("     ");
			textViewAttribute5.setText("     ");

			for (int i = 0; i < attribute1.size(); i++) {
				DetailedInfoModel detailedInoTuple = new DetailedInfoModel();
				detailedInoTuple.setCompanyName(companyName);
				detailedInoTuple.setAttribute1(attribute1.get(i));
				detailedInoTuple.setAttribute2(attribute2.get(i));
				detailedInoTuple.setAttribute3(attribute3.get(i));
				detailedInfoTuples.add(detailedInoTuple);
			}
		}
	}

	private void getData() {
		DatabaseOperator dop = new DatabaseOperator(this);

		balanceSheetDate = new ArrayList<String>();
		balanceSheetName = new ArrayList<String>();
		balanceSheetValue = new ArrayList<String>();
		Cursor c1 = dop.getDetailedInfoBalanceSheet(dop, companyName);
		c1.moveToFirst();
		do {
			balanceSheetDate.add(c1.getString(1));
			balanceSheetName.add(c1.getString(2));
			balanceSheetValue.add(c1.getString(3));
		} while (c1.moveToNext());
		c1.close();

		competitor = new ArrayList<String>();
		Cursor c2 = dop.getDetailedInfoCompetitor(dop, companyName);
		c2.moveToFirst();
		do {
			if (c2.getString(0) != companyName) {
				competitor.add(c2.getString(0));
			} else {
				competitor.add(c2.getString(1));
			}
		} while (c2.moveToNext());
		c2.close();

		incomeStatementDate = new ArrayList<String>();
		incomeStatementName = new ArrayList<String>();
		incomeStatementValue = new ArrayList<String>();
		Cursor c3 = dop.getDetailedInfoIncomeStatement(dop, companyName);
		c3.moveToFirst();
		do {
			incomeStatementDate.add(c3.getString(1));
			incomeStatementName.add(c3.getString(2));
			incomeStatementValue.add(c3.getString(3));
		} while (c3.moveToNext());
		c3.close();

		industry = new ArrayList<String>();
		Cursor c4 = dop.getDetailedInfoIndustry(dop, companyName);
		c4.moveToFirst();
		do {
			industry.add(c4.getString(1));
		} while (c4.moveToNext());
		c4.close();

		statTerm = new ArrayList<String>();
		statName = new ArrayList<String>();
		statValue = new ArrayList<String>();
		Cursor c5 = dop.getDetailedInfoKeyStat(dop, companyName);
		c5.moveToFirst();
		do {
			statTerm.add(c5.getString(1));
			statName.add(c5.getString(2));
			statValue.add(c5.getString(3));
		} while (c5.moveToNext());
		c5.close();

		newsTitle = new ArrayList<String>();
		newsDate = new ArrayList<String>();
		abstracts = new ArrayList<String>();
		positive_effect = new ArrayList<String>();
		negative_effect = new ArrayList<String>();
		Cursor c6 = dop.getDetailedInfoNews(dop, companyName);
		c6.moveToFirst();
		do {
			newsTitle.add(c6.getString(0));
			newsDate.add(c6.getString(1));
			abstracts.add(c6.getString(2));
			positive_effect.add(c6.getString(3));
			negative_effect.add(c6.getString(4));
		} while (c6.moveToNext());
		c6.close();

		stockName = new ArrayList<String>();
		stockPrice = new ArrayList<String>();
		stockDate = new ArrayList<String>();
		stockTime = new ArrayList<String>();
		Cursor c7 = dop.getDetailedInfoStock(dop, companyName);
		c7.moveToFirst();
		do {
			stockName.add(c7.getString(0));
			stockPrice.add(c7.getString(1));
			stockDate.add(c7.getString(2));
			stockTime.add(c7.getString(3));
		} while (c7.moveToNext());
		c7.close();
	}
	
    public void onBackButtonClick(View view){
    	Intent intent = new Intent(this, DatabaseActivity.class);
    	startActivity(intent);
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
