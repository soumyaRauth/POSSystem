package com.soumya.possystem;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import tabs.SlidingTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class SalesFragment extends Fragment {
    private Toolbar mToolbar;

private SlidingTabLayout mSlidingTabLayout;
    private ViewPager viewPager;
    private View view;




    public SalesFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sales, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.view_pager);
        FragmentManager manager = getChildFragmentManager();
        viewPager.setAdapter(new MyFragmentPagerAdapter(manager));
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(viewPager);
        return view;
    }
    //STARTSSSSSSS
    class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    All all = new All();
                    return all;
                case 1:
                    Favorite favorite = new Favorite();
                    return favorite;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:

                    return "All";
                case 1:
                    return "Favorite";

            }
            return null;
        }

    }

    //ENDSSSSSSSSSSSSS
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_user) {
            return true;
        }

        if (id == R.id.barcode_scanner) {
            return true;
        }
        if (id == R.id.search_overflow) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
