package com.example.fragmentweixin;

import android.R.integer;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private View weixinLayout, tongxunluLayout, faxianLayout, woLayout;
	private TextView weixinTv, tongxunluTv, faxianTv, woTv;
	private ImageView weixinIv, tongxunluIv, faxianIv, woIv;
	private Fragment1 fragment1;
	private Fragment2 fragment2;
	private Fragment3 fragment3;
	private Fragment4 fragment4;
	private FragmentManager fm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 初始化
		initViews();

		fm = getFragmentManager();

		// 初识状态是显示微信
		weixinIv.setBackgroundResource(R.drawable.weixin2);
		weixinTv.setTextColor(getResources().getColor(R.color.green));
		showFragment(1);
	}

	void initViews() {
		// 注册各IamgeView
		weixinIv = (ImageView) findViewById(R.id.weixin_iv);
		tongxunluIv = (ImageView) findViewById(R.id.tongxunlu_iv);
		faxianIv = (ImageView) findViewById(R.id.faxian_iv);
		woIv = (ImageView) findViewById(R.id.wo_iv);

		// 注册各TextView
		weixinTv = (TextView) findViewById(R.id.weixin_tv);
		tongxunluTv = (TextView) findViewById(R.id.tongxunlu_tv);
		faxianTv = (TextView) findViewById(R.id.faxian_tv);
		woTv = (TextView) findViewById(R.id.wo_tv);

		// 注册各Layout
		weixinLayout = (View) findViewById(R.id.weixin_layout);
		tongxunluLayout = (View) findViewById(R.id.tongxunlu_layout);
		faxianLayout = (View) findViewById(R.id.faxian_layout);
		woLayout = (View) findViewById(R.id.wo_layout);

		// 各Layout注册监听器
		weixinLayout.setOnClickListener(this);
		tongxunluLayout.setOnClickListener(this);
		faxianLayout.setOnClickListener(this);
		woLayout.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		// 当发生点击时，先清除状态，这里的状态指的是布局里面的图片和文字
		clearState();
		switch (arg0.getId()) {
		case R.id.weixin_layout:
			// 如果点的是微信，将微信布局的图片和文字的颜色变为绿色
			weixinIv.setBackgroundResource(R.drawable.weixin2);
			weixinTv.setTextColor(getResources().getColor(R.color.green));
			// 显示微信的fragment
			showFragment(1);
			break;
		case R.id.tongxunlu_layout:
			tongxunluIv.setBackgroundResource(R.drawable.tongxunlu2);
			tongxunluTv.setTextColor(getResources().getColor(R.color.green));
			showFragment(2);
			break;
		case R.id.faxian_layout:
			faxianIv.setBackgroundResource(R.drawable.faxian2);
			faxianTv.setTextColor(getResources().getColor(R.color.green));
			showFragment(3);
			break;
		case R.id.wo_layout:
			woIv.setBackgroundResource(R.drawable.wo2);
			woTv.setTextColor(getResources().getColor(R.color.green));
			showFragment(4);
			break;
		}
	}

	public void clearState() {
		// 未选中时的图片
		weixinIv.setBackgroundResource(R.drawable.weixin1);
		tongxunluIv.setBackgroundResource(R.drawable.tongxunlu1);
		faxianIv.setBackgroundResource(R.drawable.faxian1);
		woIv.setBackgroundResource(R.drawable.wo1);
		// 未选中时字体颜色
		weixinTv.setTextColor(getResources().getColor(R.color.black));
		tongxunluTv.setTextColor(getResources().getColor(R.color.black));
		faxianTv.setTextColor(getResources().getColor(R.color.black));
		woTv.setTextColor(getResources().getColor(R.color.black));
	}

	public void showFragment(int index) {
		FragmentTransaction ft = fm.beginTransaction();

		// 想要显示一个fragment,先隐藏所有fragment，防止重叠
		hideFragments(ft);

		switch (index) {
		case 1:
			// 如果fragment1已经存在则将其显示出来
			if (fragment1 != null)
				ft.show(fragment1);
			// 否则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add
			else {
				fragment1 = new Fragment1();
				ft.add(R.id.content, fragment1);
			}
			break;
		case 2:
			if (fragment2 != null)
				ft.show(fragment2);
			else {
				fragment2 = new Fragment2();
				ft.add(R.id.content, fragment2);
			}
			break;
		case 3:
			if (fragment3 != null)
				ft.show(fragment3);
			else {
				fragment3 = new Fragment3();
				ft.add(R.id.content, fragment3);
			}
			break;
		case 4:
			if (fragment4 != null)
				ft.show(fragment4);
			else {
				fragment4 = new Fragment4();
				ft.add(R.id.content, fragment4);
			}
			break;
		}
		ft.commit();
	}

	// 当fragment已被实例化，相当于发生过切换，就隐藏起来
	public void hideFragments(FragmentTransaction ft) {
		if (fragment1 != null)
			ft.hide(fragment1);
		if (fragment2 != null)
			ft.hide(fragment2);
		if (fragment3 != null)
			ft.hide(fragment3);
		if (fragment4 != null)
			ft.hide(fragment4);
	}

}
