package com.example.android.wafarly.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.android.wafarly.Activity.MainActivity;
import com.example.android.wafarly.Activity.Register;
import com.example.android.wafarly.R;

public class DatePickers extends DialogFragment implements View.OnClickListener {
    DatePicker datePicker;
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.datepicker,container,false);
datePicker=view.findViewById(R.id.datpicker);
        button=view.findViewById(R.id.close);
        button.setOnClickListener(this);
        return view;    }

    @Override
    public void onClick(View v) {
        this.dismiss();
        String date=datePicker.getYear()+":"+datePicker.getMonth()+":"+datePicker.getDayOfMonth();
        Register mainActivity= (Register) getActivity();
        mainActivity.setdat(date);
    }
}
