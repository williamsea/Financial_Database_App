package jhu.edu.database.adroidfinancedatabases.adapters;

import java.util.List;

import jhu.edu.database.adroidfinancedatabases.datamodels.DetailedInfoModel;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.adroidfinancedatabases.R;

public class DetailedInfoAdapter extends ArrayAdapter{
	private LayoutInflater inflater;
	private TextView companyName;
	private TextView attribute1;
	private TextView attribute2;
	private TextView attribute3;
	private TextView attribute4;
	private TextView attribute5;
	private Activity activity;
	private List<DetailedInfoModel> detailedInfoModels;
	
	public DetailedInfoAdapter(Activity activity, List<DetailedInfoModel> detailedInfoModels){
		super(activity, R.layout.detailed_info_layout, detailedInfoModels);
		inflater = activity.getWindow().getLayoutInflater();
		this.activity = activity;
		this.detailedInfoModels = detailedInfoModels;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		inflater = activity.getLayoutInflater();
		view = inflater.inflate(R.layout.detailed_info_layout, null);
		
		companyName = (TextView) view.findViewById(R.id.textView_company_name);
		companyName.setText(detailedInfoModels.get(position).getCompanyName());
		attribute1 = (TextView) view.findViewById(R.id.textView_attribute1);
		attribute1.setText(detailedInfoModels.get(position).getAttribute1());
		attribute2 = (TextView) view.findViewById(R.id.textView_attribute2);
		attribute2.setText(detailedInfoModels.get(position).getAttribute2());
		attribute3 = (TextView) view.findViewById(R.id.textView_attribute3);
		attribute3.setText(detailedInfoModels.get(position).getAttribute3());
		attribute4 = (TextView) view.findViewById(R.id.textView_attribute4);
		attribute4.setText(detailedInfoModels.get(position).getAttribute4());
		attribute5 = (TextView) view.findViewById(R.id.textView_attribute5);
		attribute5.setText(detailedInfoModels.get(position).getAttribute5());
    	
		return view;
	}
}
