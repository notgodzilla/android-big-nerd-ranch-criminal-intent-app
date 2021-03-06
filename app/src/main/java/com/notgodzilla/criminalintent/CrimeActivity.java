package com.notgodzilla.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    /*
    * NOTE: This class is no longer in use and has been replaced by CrimePageActivity.
    * Keeping this class here for reference and notes
    *
    */
    private static final String EXTRA_CRIME_ID = "com.notgodzilla.criminalintent.crime_id";

    @Override
    protected Fragment createFragment() {
        UUID id = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(id);
    }

    //Creates new Intent for passing this CrimeActivity's id as an Extra
    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

}
