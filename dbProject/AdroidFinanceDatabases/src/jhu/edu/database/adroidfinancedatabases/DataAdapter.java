package jhu.edu.database.adroidfinancedatabases;

import java.util.List;

import com.example.adroidfinancedatabases.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DataAdapter extends ArrayAdapter{
	private LayoutInflater inflater;
	private TextView companyName;
	private TextView companyAddress;
	private Activity activity;
	private List<DataModel> dataModels;
	
	public DataAdapter(Activity activity, List<DataModel> dataModels){
		super(activity, R.layout.tuple_layout, dataModels);
		inflater = activity.getWindow().getLayoutInflater();
		this.activity = activity;
		this.dataModels = dataModels;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		inflater = activity.getLayoutInflater();
		view = inflater.inflate(R.layout.tuple_layout, null);
		
		companyName = (TextView) view.findViewById(R.id.textView_company_name);
    	companyName.setText(dataModels.get(position).getCompanyName());
    	companyAddress = (TextView) view.findViewById(R.id.textView_company_address);
    	companyAddress.setText(dataModels.get(position).getCompanyAddress());
    	
    	
		return view;
	}
	
	
	
}
