package com.example.contactmanagementsystem.frmnt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactmanagementsystem.R;

public class FrmtMadical extends Fragment {

    View v;
    public FrmtMadical() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.medical_frmt, container, false);
        return v;
    }
}
