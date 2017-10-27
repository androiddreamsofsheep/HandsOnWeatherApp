package edu.dlsu.mobapde.handsonweatherapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by courtneyngo on 07/10/2017.
 */

public class ChangeReadingDialog extends DialogFragment {

    private OnYesSelectedListener onYesSelectedListener;

    public void setOnYesSelectedListener(OnYesSelectedListener onYesSelectedListener) {
        this.onYesSelectedListener = onYesSelectedListener;
    }

    public static ChangeReadingDialog newInstance(boolean reading) {

        Bundle args = new Bundle();

        ChangeReadingDialog fragment = new ChangeReadingDialog();
        args.putBoolean("isCelsius", reading);
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        boolean isCelsius = getArguments().getBoolean("isCelsius");
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setTitle("Change reading")
                .setMessage("Change temperature reading to " + (isCelsius ? "Fahrenheit" : "Celsius") + "?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onYesSelectedListener.onYesSelected();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                });

        return adb.create();
    }

    public interface OnYesSelectedListener{
        public void onYesSelected();
    }
}
