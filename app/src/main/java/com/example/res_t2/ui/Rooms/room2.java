package com.example.res_t2.ui.Rooms;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.res_t2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class room2 extends AppCompatActivity {


    EditText t1, t2, t3, t4, t5, t6;
    Button btn;
    DatabaseReference reff;
    roomapp rm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);
        t1 = (EditText) findViewById(R.id.editName);
        t2 = (EditText) findViewById(R.id.editEmail);
        t3 = (EditText) findViewById(R.id.editnop);
        t4 = (EditText) findViewById(R.id.editindte);
        t5 = (EditText) findViewById(R.id.editoutdte);
        t6 = (EditText) findViewById(R.id.editphno);
        btn = (Button) findViewById(R.id.subton);
        rm = new roomapp();
        reff = FirebaseDatabase.getInstance().getReference().child("roomapp");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nop = Integer.parseInt(t3.getText().toString().trim());
                int cost = 120 * nop;
                String phn = t6.getText().toString().trim();
                String indte = t4.getText().toString().trim();
                String outdte = t5.getText().toString().trim();
                String usrname = t1.getText().toString().trim();
                String email = t2.getText().toString().trim();

                rm.setCost(cost);
                rm.setNop(nop);
                rm.setUsername(usrname);
                rm.setIndate(indte);
                rm.setOutdate(outdte);
                rm.setTor("Comfort Suite");
                rm.setPhno(phn);

                reff.push().setValue(rm);
                //Toast.makeText(datainsert.this, "Booked Successfully!!")

            }
        });
    }

}