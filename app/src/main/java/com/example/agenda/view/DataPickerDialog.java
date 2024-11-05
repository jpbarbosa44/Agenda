package com.example.agenda.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DataPickerDialog extends DialogFragment {

    private final DatePickerDialog.OnDateSetListener listener;

    public DataPickerDialog(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public DatePickerDialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        assert getActivity() != null;
        return new DatePickerDialog(getActivity(), listener, year, month, day);
    }
}
