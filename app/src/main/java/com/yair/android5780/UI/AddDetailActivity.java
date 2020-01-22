package com.yair.android5780.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yair.android5780.Entities.Enums;
import com.yair.android5780.Entities.ParcelDetails;
import com.yair.android5780.Entities.Recipient;
import com.yair.android5780.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddDetailActivity extends AppCompatActivity {

    ArrayList<ParcelDetails> parcels = new ArrayList<ParcelDetails>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
                    setSupportActionBar(toolbar);

                    //  initData(10);

                    final FirebaseDatabase database = FirebaseDatabase.getInstance();

                    FloatingActionButton fab = findViewById(R.id.fab);
                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(view, R.string.fab_message, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            DatabaseReference myRef = database.getReference("parcels");
                            Task<Void> task  = addToDatabase(myRef);
                            task.addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                         Toast.makeText(AddDetailActivity.this,"Successful",Toast.LENGTH_LONG ).show();
                        else
                            Toast.makeText(AddDetailActivity.this,"Successful",Toast.LENGTH_LONG ).show();
                    }
                });
            }
        });

        ImageButton call_Button = findViewById(R.id.call_Button);
        call_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("tel: 026547220"));
                intent.setAction(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
        Button showParcelsList = findViewById(R.id.parcel_list_button);
        showParcelsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddDetailActivity.this,HistoryParcelsActivity.class);
                startActivity(intent);
            }
        });
        Button show_Adress_button = findViewById(R.id.goto_find_adress);
        show_Adress_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddDetailActivity.this,AdressActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData(int capacity) {
        Enums.ParcelStatus parcelStatus = Enums.ParcelStatus.sent;
        Enums.ParcelType parcelType = Enums.ParcelType.small;
        Enums.ParcelWeight parcelWeight = Enums.ParcelWeight.under1kg;

        for (int i=0; i < capacity; i++ ){
            parcels.add(new ParcelDetails(parcelStatus,parcelType,parcelWeight,new Recipient("")));
        }

    }

    private Task<Void> addToDatabase(DatabaseReference myRef) {
        Recipient recipient = new Recipient(1,"Moshe","+16505553434");
        try {
            return myRef.push().setValue(new ParcelDetails(Enums.ParcelStatus.inWay, Enums.ParcelType.envelope, Enums.ParcelWeight.under5Kg, recipient));
        }
        catch (Exception e)
        {
            Log.d("addToDatabase", "addToDatabase: " + e.getMessage());
            return null;
        }
    }
}
