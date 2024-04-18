package com.example.praktikum_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;

public class ConfirmDialogFragment extends DialogFragment implements View.OnClickListener {
    private Button btnCancel, btnDelete;
    DialogListener dialogListener;
    Model model;

    interface DialogListener {
        void setOnClickDeleteButton();
    }

    public void setOnClickDeleteButtonListener(DialogListener dialogListener2) {
        this.dialogListener = dialogListener2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm_dialog, container, false);
        btnCancel = view.findViewById(R.id.button_cancel);
        btnDelete = view.findViewById(R.id.button_delete);
        btnCancel.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        if (getArguments() != null) {
            model = getArguments().getParcelable("post");
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_cancel) {
            getDialog().cancel();
        } else if (v.getId() == R.id.button_delete) {
            DataSource.models.remove(model);
            if (dialogListener != null) {
                dialogListener.setOnClickDeleteButton();
            }
            getDialog().dismiss();
        }
    }


}
