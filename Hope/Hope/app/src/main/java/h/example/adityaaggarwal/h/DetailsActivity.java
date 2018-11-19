package h.example.adityaaggarwal.h;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;

/**
 * Created by adityaaggarwal on 10/29/16.
 */
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.item_name);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button locateButton = (Button)findViewById(R.id.locate_button);
        locateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent to Google Maps
            }
        });


        Button completeTransaction = (Button)findViewById(R.id.complete_transaction_button);
        completeTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogFragment.newInstance().show(getSupportFragmentManager(), "Complete Transaction Dialog");
            }
        });


    }



    public static class CustomDialogFragment extends DialogFragment {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }

        static CustomDialogFragment newInstance() {


            return new CustomDialogFragment();
        }


        @Override
        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            LayoutInflater inflater = getActivity().getLayoutInflater();
            View v = inflater.inflate(R.layout.dialog_complete_transation, null, false);
            final MultiStateToggleButton multiStateToggleButton = (MultiStateToggleButton) v.findViewById(R.id.mstb_multi_id);

            AlertDialog alertDialog = new AlertDialog.Builder(getActivity())

                    .setTitle("Complete Transaction")
                    .setPositiveButton(android.R.string.ok,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Log.d("Aditya test", multiStateToggleButton.getTexts()[multiStateToggleButton.getValue()].toString());
                                }
                            }
                    )
                    .setNegativeButton(android.R.string.cancel,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }
                            }
                    )
                    .create();

            alertDialog.setView(v);
            return alertDialog;
        }
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }







}
