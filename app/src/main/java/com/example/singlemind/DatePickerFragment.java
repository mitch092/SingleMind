package com.example.singlemind;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.time.LocalDate;
import java.util.Optional;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener, DatePickerDialog.OnCancelListener {
    private static final String TAG = "DatePickerFragment";
    private Optional<LocalDate> date = Optional.empty();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        date = Optional.of(LocalDate.of(year, month, day));
    }

    public void onCancel(DialogInterface dialog){
        date = Optional.empty();
    }
}
