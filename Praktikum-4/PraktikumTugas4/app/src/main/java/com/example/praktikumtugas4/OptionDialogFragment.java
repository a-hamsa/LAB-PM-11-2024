package com.example.praktikumtugas4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class OptionDialogFragment extends DialogFragment {

    private OnDialogOptionSelectedListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button dialog_btn_batal = view.findViewById(R.id.dialog_btn_batal);
        Button dialog_btn_hapus = view.findViewById(R.id.dialog_btn_hapus);

        dialog_btn_batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        dialog_btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mListener != null) {
                    mListener.onOptionSelected(true);
                }
            }
        });

    }

    public interface OnDialogOptionSelectedListener {
        void onOptionSelected(boolean isDeleteSelected);
    }

    public void setOnDialogOptionSelectedListener(OnDialogOptionSelectedListener listener) {
        mListener = listener;
    }
}
