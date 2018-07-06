package com.notgodzilla.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class CrimePageActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private List<Crime> crimes;

    private static final String EXTRA_CRIME_ID = "com.notgodzilla.criminalintent.crime_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        UUID crimeUuid = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        this.crimes = CrimeLab.get(this).getCrimes();

        viewPager = (ViewPager) findViewById(R.id.crime_view_pager);
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
               Crime crime = crimes.get(position);
               return CrimeFragment.newInstance(crime.getUuid());
            }

            @Override
            public int getCount() {
                return crimes.size();
            }
        });

        /*Loops through the list of crimes in this CrimePageActivity's PageAdapter
        and finds which one matches the UUID of the crime UUID in the Intent Extra
        By default, ViewPager will display the first item in its Adapter onCreate */
        for(int i = 0; i < crimes.size(); i++) {
            if(crimes.get(i).getUuid().equals(crimeUuid)) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent i = new Intent(packageContext, CrimePageActivity.class);
        i.putExtra(EXTRA_CRIME_ID, crimeId);
        return i;
    }
}
