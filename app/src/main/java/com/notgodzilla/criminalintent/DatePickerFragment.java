package com.notgodzilla.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

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

        View v  = LayoutInflater.from(getActivity()).inflate(R.layout.dialoge_date, null);
        this.datePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);
        this.datePicker.init(year, month, day, null);

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.date_picker_title)
                .setView(v)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

}
