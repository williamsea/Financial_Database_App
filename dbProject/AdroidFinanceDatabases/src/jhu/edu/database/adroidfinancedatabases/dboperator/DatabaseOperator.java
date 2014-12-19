package jhu.edu.database.adroidfinancedatabases.dboperator;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOperator extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "Finance";
	public static String CREATE_COMPANY = "CREATE TABLE Company ( company_name varchar(30) NOT NULL, address varchar(1000), website varchar(30), brief_overview varchar(30000), PRIMARY KEY (company_name) );";
	public static String CREATE_HAS_STOCK = "CREATE TABLE Has_Stock ( company_name varchar(30) NOT NULL, stock_name varchar(30) NOT NULL);";
	public static String CREATE_STOCK = "CREATE TABLE Stock  ( stock_name varchar(30) NOT NULL, value double precision, stock_date varchar(30), stock_time varchar(30), PRIMARY KEY (stock_name,stock_date,stock_time) );";
	public static String CREATE_BALANCE_SHEET = "CREATE TABLE BalanceSheet  ( company_name varchar(30), balance_sheet_date String, data_name varchar(30), value int, PRIMARY KEY (company_name,data_name) );";
	public static String CREATE_INCOME_STATEMENT = "CREATE TABLE Income_statement ( company_name varchar(30), income_statement_date String, data_name varchar(30), value int, PRIMARY KEY (company_name,data_name) );";
	public static String CREATE_COMPATITOR = "CREATE TABLE Competitors ( company_name1 varchar(30), company_name2 varchar(30) );";
	public static String CREATE_INDUSTRY = "CREATE TABLE industry ( industry_name varchar(30), brief_overview varchar(30000), PRIMARY KEY (industry_name) );";
	public static String CREATE_COMPANY_INDUSTRY = "CREATE TABLE Company_industry ( company_name varchar(30), industry_name varchar(30) );";
	public static String CREATE_NEWS = "CREATE TABLE News ( title varchar(30), news_date String, abstracts varchar(30000), PRIMARY KEY (title, news_date) );";
	public static String CREATE_COMPANY_NEWS = "CREATE TABLE Company_news ( company_name varchar(30), title varchar(30), news_date String, positive_effect int, negative_effect int);";
	public static String CREATE_KEYSTAT = "CREATE TABLE Keystats ( company_name varchar(30), stat_term varchar(50), data_name varchar(30), value int, PRIMARY KEY (company_name, data_name) );";
	
	public static final int COMPANY_COLUMN = 4;
	public static final int HAS_STOCK_COLUMN = 2;
	public static final int STOCK_COLUMN = 4;
	public static final int BALANCE_SHEET_COLUMN = 4;
	public static final int INCOME_STATEMENT_COLUMN = 4;
	public static final int COMPATITOR_COLUMN = 2;
	public static final int COMPANY_INDUSTRY_COLUMN = 2;
	public static final int NEWS_COLUMN = 3;
	public static final int COMPANY_NEWS_COLUMN = 5;
	public static final int KEYSTATS_COLUMN = 4;
	

	
	public DatabaseOperator(Context context) {
		super(context, DATABASE_NAME , null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_COMPANY);
		db.execSQL(CREATE_BALANCE_SHEET);
		db.execSQL(CREATE_COMPANY_INDUSTRY);
		db.execSQL(CREATE_COMPANY_NEWS);
		db.execSQL(CREATE_COMPATITOR);
		db.execSQL(CREATE_HAS_STOCK);
		db.execSQL(CREATE_INCOME_STATEMENT);
		db.execSQL(CREATE_INDUSTRY);
		db.execSQL(CREATE_KEYSTAT);
		db.execSQL(CREATE_NEWS);
		db.execSQL(CREATE_STOCK);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	public void deleteDB(Context context){
		context.deleteDatabase(DATABASE_NAME);
	}
	
	public void putDataCompany(DatabaseOperator dop, String companyName, String address, String website, String briefOverview){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("company_name", companyName);
		cv.put("address",address);
		cv.put("website", website);
		cv.put("brief_overview", briefOverview);
		sq.insert("Company", null, cv);
	}

	public void putDataHasStock(DatabaseOperator dop, String company_name, String stock_name){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("company_name", company_name);
		cv.put("stock_name",stock_name);
		sq.insert("Has_Stock", null, cv);		
	}

	public void putDataStock(DatabaseOperator dop, String stock_name, double value, String stock_date, String stock_time){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("stock_name", stock_name);
		cv.put("value", value);
		cv.put("stock_date", stock_date);
		cv.put("stock_time", stock_time);
		sq.insert("Stock", null, cv);
	}

		public void putDataBalanceSheet(DatabaseOperator dop, String company_name, String balance_sheet_date, String data_name, long value){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("company_name", company_name);
		cv.put("balance_sheet_date", balance_sheet_date);
		cv.put("data_name", data_name);
		cv.put("value", value);
		sq.insert("BalanceSheet", null, cv);
	}

		public void putDataIncomeStatement(DatabaseOperator dop, String company_name, String income_statement_date, String data_name, long value){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("company_name", company_name);
		cv.put("income_statement_date", income_statement_date);
		cv.put("data_name", data_name);
		cv.put("value", value);
		sq.insert("Income_statement", null, cv);
	}

		public void putDataCompatitor(DatabaseOperator dop, String company_name1, String company_name2){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("company_name1", company_name1);
		cv.put("company_name2", company_name2);
		sq.insert("Competitors", null, cv);
	}

		public void putDataIndustry(DatabaseOperator dop, String industry_name, String brief_overview){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("industry_name", industry_name);
		cv.put("brief_overview", brief_overview);
		sq.insert("industry", null, cv);
	}

		public void putDataCompanyIndustry(DatabaseOperator dop, String company_name, String industry_name){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("company_name", company_name);
		cv.put("industry_name", industry_name);
		sq.insert("Company_industry", null, cv);
	}

		public void putDataNews(DatabaseOperator dop, String title, String news_date, String abstracts){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("title", title);
		cv.put("news_date", news_date);
		cv.put("abstracts", abstracts);
		sq.insert("News", null, cv);
	}

		public void putDataCompanyNews(DatabaseOperator dop, String company_name, String title, String news_date, int positive_effect, int negative_effect){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("company_name", company_name);
		cv.put("title", title);
		cv.put("news_date", news_date);
		cv.put("positive_effect", positive_effect);
		cv.put("negative_effect", negative_effect);
		sq.insert("Company_news", null, cv);
	}

		public void putDataKeyStat(DatabaseOperator dop, String company_name, String stat_term, String data_name, Long value){
		SQLiteDatabase sq = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("company_name", company_name);
		cv.put("stat_term", stat_term);
		cv.put("data_name", data_name);
		cv.put("value", value);
		sq.insert("Keystats", null, cv);
	}
		
		public Cursor getCompanyInfo(DatabaseOperator dop){
			SQLiteDatabase sq = dop.getReadableDatabase();
			String a = "Company";
			String[] b = {"Apple_Inc"};
			Cursor cr = sq.rawQuery("select * from Company", null);
			return cr;
		}
		
		public Cursor getDetailedInfoStock(DatabaseOperator dop, String companyName){
			SQLiteDatabase sq = dop.getReadableDatabase();
			Cursor cr = sq.rawQuery("select s.* from Stock s , Has_Stock h ,Company c" + " where c.company_name = ? and c.company_name = h.company_name and h.stock_name = s.stock_name", new String[]{companyName});
			return cr;
		}
		public Cursor getDetailedInfoBalanceSheet(DatabaseOperator dop, String companyName){
			SQLiteDatabase sq = dop.getReadableDatabase();
			Cursor cr = sq.rawQuery("select * from BalanceSheet where company_name = ?", new String[]{companyName});
			return cr;
		}
		public Cursor getDetailedInfoIncomeStatement(DatabaseOperator dop, String companyName){
			SQLiteDatabase sq = dop.getReadableDatabase();
			Cursor cr = sq.rawQuery("select * from Income_statement where company_name = ?", new String[]{companyName});
			return cr;
		}
		public Cursor getDetailedInfoCompetitor(DatabaseOperator dop, String companyName){
			SQLiteDatabase sq = dop.getReadableDatabase();
			Cursor cr = sq.rawQuery("select * from Competitors where company_name1 = ?", new String[]{companyName});
			return cr;
		}
		public Cursor getDetailedInfoIndustry(DatabaseOperator dop, String companyName){
			SQLiteDatabase sq = dop.getReadableDatabase();
			Cursor cr = sq.rawQuery("select ci.* from Company_industry ci , Company c where c.company_name = ? and ci.company_name = c.company_name", new String[]{companyName});
			return cr;
		}
		public Cursor getDetailedInfoNews(DatabaseOperator dop, String companyName){
			SQLiteDatabase sq = dop.getReadableDatabase();
			Cursor cr = sq.rawQuery("select n.*, positive_effect, negative_effect from News n , Company_news cn , Company c where c.company_name = ? and c.company_name = cn.company_name and n.title = cn.title", new String[]{companyName});
			return cr;
		}
		public Cursor getDetailedInfoKeyStat(DatabaseOperator dop, String companyName){
			SQLiteDatabase sq = dop.getReadableDatabase();
			Cursor cr = sq.rawQuery("select * from Keystats where company_name = ?", new String[]{companyName});
			return cr;
		}
		
		
		public Cursor aggregateInfoGet(DatabaseOperator dop, int aggregateFunction, String inWhatUp, String inWhatLow, int inCompanyOrIndustry, int inWhatSheet){
			SQLiteDatabase sq = dop.getReadableDatabase();
			Cursor cr;
			String sqlCommand;
			String whatToJoin = "";
			String whatWhere = "";
			String agFunction;
			
			switch (aggregateFunction) {
			case 0:
				agFunction = "max(value)";

				break;
			case 1:
				agFunction = "min(value)";
				
				break;
			case 2:
				agFunction = "avg(value)";
				break;
			case 3:
				agFunction = "count(value)";
				break;
			default: 
				agFunction = "";
				break;
			}
			
			if(inWhatLow.equals("Stock")){
				whatToJoin = "Has_Stock hs, Stock s";
				whatWhere = "c.company_name = hs.company_name and s.stock_name = hs.stock_name";
			}else{
				if(inWhatSheet==1){
				whatToJoin = "BalanceSheet b";
				whatWhere = "b.company_name = c.company_name";
				}else if(inWhatSheet==2){
					whatToJoin = "Income_statement i";
					whatWhere = "i.company_name = c.company_name";
				}else if(inWhatSheet==3){
					whatToJoin = "Keystats k";
					whatWhere = "k.company_name = c.company_name";

				}
			}
			
			if(inCompanyOrIndustry==1){
			sqlCommand = "select "+agFunction+" from Company c, " +whatToJoin + " where c.company_name = ? and " + whatWhere;
			cr = sq.rawQuery(sqlCommand, new String[]{inWhatUp});

			}else if (inCompanyOrIndustry==2){
				sqlCommand = "select " + agFunction + " from Company_industry ci, " + whatToJoin + " where ci.industry_name = ? and "+ whatWhere+ " group by company_name";
				cr = sq.rawQuery(sqlCommand, new String[]{inWhatUp});

			}else{
				sqlCommand = "select " + agFunction + " from " + whatToJoin + " group by company_name";
				cr = sq.rawQuery(sqlCommand, null);
			}
			return cr;
		}
		

		
		

}
