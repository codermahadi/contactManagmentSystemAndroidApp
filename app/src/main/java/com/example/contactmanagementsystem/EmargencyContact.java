package com.example.contactmanagementsystem;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.contactmanagementsystem.adapters.ViewPageAdapter;
import com.example.contactmanagementsystem.frmnt.FrmtFireService;
import com.example.contactmanagementsystem.frmnt.FrmtMadical;
import com.example.contactmanagementsystem.frmnt.FrmtPolice;

public class EmargencyContact extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emargency_contact);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);
        viewPager = (ViewPager) findViewById(R.id.pageViewId);

        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());

        //Add Fragment
        viewPageAdapter.AddFrmt(new FrmtPolice(), "Police");
        viewPageAdapter.AddFrmt(new FrmtFireService(), "Fire Service");
        viewPageAdapter.AddFrmt(new FrmtMadical(), "Medical");

        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_airport_shuttle_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_fingerprint_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_add_circle_outline_black_24dp);

    }
}
