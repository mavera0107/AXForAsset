package com.example.ux_project_axforasset;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogBoxFragment extends AppCompatDialogFragment {


    String err_name, err_desc;
    TextView tv_err_desc;
    int type = 0; // 0 = Error Message, 1 = Success validasi di ItemDetails

    ItemDetailsActivity detailspage;

    public DialogBoxFragment(String err_name, String err_desc, int type) {
        this.err_name = err_name;
        this.err_desc = err_desc;
        this.type = type;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        tv_err_desc = view.findViewById(R.id.err_message);
        tv_err_desc.setText(err_desc);

        if(type == 0){
            alertBuilder.setView(view)
                    .setTitle(err_name)
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        } else if (type == 1) {
            alertBuilder.setView(view)
                    .setTitle(err_name)
                    .setPositiveButton("Back to Item Page", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            detailspage.backButtonTes();
                        }
                    });
        }


        return alertBuilder.create();
    }

}
