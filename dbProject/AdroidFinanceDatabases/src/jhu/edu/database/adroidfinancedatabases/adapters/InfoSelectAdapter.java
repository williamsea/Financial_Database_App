package jhu.edu.database.adroidfinancedatabases.adapters;

import java.util.List;

import jhu.edu.database.adroidfinancedatabases.datamodels.InfoSelectModel;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.adroidfinancedatabases.R;

public class InfoSelectAdapter extends ArrayAdapter{
	private LayoutInflater inflater;
	private TextView infoName;
	private Activity activity;
	private List<InfoSelectModel> infoSelectModels;
	
	public InfoSelectAdapter(Activity activity, List<InfoSelectModel> infoSelectModels){
		super(activity, R.layout.info_select_layout, infoSelectModels);
		inflater = activity.getWindow().getLayoutInflater();
		this.activity = activity;
		this.infoSelectModels = infoSelectModels;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		inflater = activity.getLayoutInflater();
		view = inflater.inflate(R.layout.info_select_layout, null);
		
		infoName = (TextView) view.findViewById(R.id.textView_info_name);
    	infoName.setText(infoSelectModels.get(position).getInfoName());
    	
		return view;
	}
}
