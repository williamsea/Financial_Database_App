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
	private TextView attributeName;
	private TextView attributeValue;
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
		
		attributeName = (TextView) view.findViewById(R.id.textView_attribute_name);
		attributeName.setText(detailedInfoModels.get(position).getAttributeName());
		attributeValue = (TextView) view.findViewById(R.id.textView_attribute_value);
		attributeValue.setText(detailedInfoModels.get(position).getAttributeValue());
    	
		return view;
	}
}
