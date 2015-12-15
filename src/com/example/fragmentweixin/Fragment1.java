package com.example.fragmentweixin;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment1 extends Fragment {

	private ListView listView;

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		listView = (ListView) getActivity().findViewById(R.id.weixin_lv);
		List<String> list = new ArrayList<String>();
		list = getData();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, list);
		listView.setAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment1, container, false);
	}

	private List<String> getData() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 12; i++)
			list.add("消息" + i);
		return list;
	}
}
