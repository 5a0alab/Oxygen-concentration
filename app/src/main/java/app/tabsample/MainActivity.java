package app.tabsample;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.tabsample.fragments.heartFragment;
import app.tabsample.fragments.homeFragment;
import app.tabsample.fragments.activityFragment;
import app.tabsample.fragments.spoFragment;
//import app.tabsample.legacy.TabSample;


/**
 * @author Adil Soomro
 *
 */
public class MainActivity extends AppCompatActivity {
	/** Called when the activity is first created. */

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int[] icons = {R.drawable.tab_home,
				R.drawable.tab_activity,
				R.drawable.tab_heart,
				R.drawable.tab_spo
		};
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		ViewPager viewPager = (ViewPager) findViewById(R.id.main_tab_content);

		setupViewPager(viewPager);
		tabLayout.setupWithViewPager(viewPager);

		for (int i = 0; i < icons.length; i++) {
			tabLayout.getTabAt(i).setIcon(icons[i]);
		}
		tabLayout.getTabAt(0).select();
		setTitle(getResources().getString(R.string.noteName));

//		//get select position
//		tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//			@Override
//			public void onTabSelected(TabLayout.Tab tab) {
//				if(tab.getPosition()==0){
//					setTitle(getResources().getString(R.string.homepageName));
//				}
//				else if(tab.getPosition()==1){
//					setTitle(getResources().getString(R.string.activityName));
//				}
//				else if (tab.getPosition()==2){
//					setTitle(getResources().getString(R.string.spoName));
//				}
//				else{}
//				Log.d("position", "-----------------------------------------------------"+tab.getPosition());
//			}
//
//			@Override
//			public void onTabUnselected(TabLayout.Tab tab) {
//			}
//
//			@Override
//			public void onTabReselected(TabLayout.Tab tab) {
//			}
//		});

	}



	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.insertNewFragment(new homeFragment());
		adapter.insertNewFragment(new activityFragment());
		adapter.insertNewFragment(new heartFragment());
		adapter.insertNewFragment(new spoFragment());
		viewPager.setAdapter(adapter);
	}

	class ViewPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> mFragmentList = new ArrayList<>();
		public ViewPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragmentList.get(position);
		}

		@Override
		public int getCount() {
			return mFragmentList.size();
		}

		public void insertNewFragment(Fragment fragment) {
			mFragmentList.add(fragment);
		}
	}


}