package com.example.c0782918_w2020_mad3125_fp.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.HydroAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.InternetAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.MobileAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.PagerAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityShowBillDetailsBinding;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusHydro;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusInternet;
import com.example.c0782918_w2020_mad3125_fp.fragments.CusMobile;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
public class ShowBillDetailsActivity extends AppCompatActivity {
    ActivityShowBillDetailsBinding showBillDetailsBinding;
    /*private HydroAdapter hydroAdapter;
    private InternetAdapter internetAdapter;
    private MobileAdapter mobileAdapter;*/
    public PagerAdapter pagerAdapter;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    /*private ArrayList<Hydro> hydroArrayList;
    private ArrayList<Mobile> mobileArrayList;
    private ArrayList<Internet> internetArrayList;*/
    Bundle fetch;
    Customer object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showBillDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_show_bill_details);
        Intent myIntent = getIntent();
        fetch = myIntent.getBundleExtra("object");
        object = (Customer) fetch.getSerializable("customerDetail");
        showBillDetailsBinding.setCustomer(object);
       /* hydroAdapter = new HydroAdapter(hydroArrayList);
        internetAdapter = new InternetAdapter(internetArrayList);
        mobileAdapter = new MobileAdapter(mobileArrayList);
*/
        /*setupViewPager(showBillDetailsBinding.vpBills);
        showBillDetailsBinding.vpBills.setAdapter(pagerAdapter);
        showBillDetailsBinding.tabCusBills.setupWithViewPager(showBillDetailsBinding.vpBills);
*/
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fragment_2, new CusHydro());
        mFragmentTransaction.commit();
        Fragment fragValue = null;
        fragValue = new CusHydro();
        mFragmentTransaction.replace(R.id.fragment_2, fragValue);
//       showBillDetailsBinding.tabCusBills.addTab(showBillDetailsBinding.tabCusBills.newTab().setText("HYDRO"),true);
//       showBillDetailsBinding.tabCusBills.addTab(showBillDetailsBinding.tabCusBills.newTab().setText("INTERNET"));
//       showBillDetailsBinding.tabCusBills.addTab(showBillDetailsBinding.tabCusBills.newTab().setText("MOBILE"));
        showBillDetailsBinding.tabCusBills.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mFragmentTransaction = mFragmentManager.beginTransaction();
                Fragment fragValue = null;
                switch(tab.getPosition()){
                    case 0:
                        fragValue = new CusHydro();
                        mFragmentTransaction.replace(R.id.fragment_2, fragValue);
                        break;
                    case 1:
                        fragValue = new CusHydro();
                        mFragmentTransaction.replace(R.id.fragment_2, fragValue);
                        break;
                    case 2:
                        fragValue = new CusHydro();
                        mFragmentTransaction.replace(R.id.fragment_2, fragValue);
                        break;
                }
                mFragmentTransaction.commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    /*private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new CusHydro(), "HYDRO");
        adapter.AddFragment(new CusInternet(),"INTERNET");
        adapter.AddFragment(new CusMobile(),"MOBILE");
        viewPager.setAdapter(adapter);*/
    }
}