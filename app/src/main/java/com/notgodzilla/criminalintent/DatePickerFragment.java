package com.notgodzilla.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment {

    public static final String EXTRA_DATE = "com.notgodzilla.crimnalintent.date";

    private static final String ARG_DATE = "date";

    private DatePicker datePicker;

    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setArguments(args);
        return datePickerFragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Date date = (Date) getArguments().getSerializable(ARG_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View v  = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);
        this.datePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);
        this.datePicker.init(year, month, day, null);

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.date_picker_title)
                .setView(v)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    //Listener for this AlertDialog (Calendar) for when user selects a date
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        int year = datePicker.getYear();
                        int month = datePicker.getMonth();
                        int day = datePicker.getDayOfMonth();

                        Date selectedDate = new GregorianCalendar(year, month, day).getTime();
                        sendResult(Activity.RESULT_OK, selectedDate);

                    }
                })
                .create();
    }


    //Creates Intent with This DatePickerFragment's date as an extra and calls CrimeFragmentActivity
    private void sendResult(int resultCode, Date date) {
        if(getTargetFragment() != null) {
            Intent i = new Intent();
            i.putExtra(EXTRA_DATE, date);

            //getTargetRequestCode() gets the request code set by setTargetFragment
            getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);

        } else {
            return;
        }
    }

}
