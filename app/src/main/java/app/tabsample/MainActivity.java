package app.tabsample;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import app.tabsample.fragments.HomeFragment;
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
				R.drawable.tab_search,
				R.drawable.tab_home,
		};
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		ViewPager viewPager = (ViewPager) findViewById(R.id.main_tab_content);

		setupViewPager(viewPager);


		tabLayout.setupWithViewPager(viewPager);

		for (int i = 0; i < icons.length; i++) {
			tabLayout.getTabAt(i).setIcon(icons[i]);
		}
		tabLayout.getTabAt(0).select();
	}

	private void setupViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
		adapter.insertNewFragment(new HomeFragment());
		adapter.insertNewFragment(new activityFragment());
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