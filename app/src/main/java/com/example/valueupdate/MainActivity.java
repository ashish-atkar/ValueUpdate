package com.example.valueupdate;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    EditText txtage,txtage2,txtage3,alco1,meth1,suni1;
    Integer s=1;
    Button btnsave;

    DatabaseReference reff;
    DatabaseReference reff1,reff2,alco11,meth11,suni11;

    Member member;
    long maxid=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_db);




        txtage=(EditText)findViewById(R.id.txtage);
        txtage2=(EditText)findViewById(R.id.txtage2);
        alco1=(EditText)findViewById(R.id.alco);
        meth1=(EditText)findViewById(R.id.meth);
        suni1=(EditText)findViewById(R.id.suni);

        btnsave=(Button)findViewById(R.id.btnsave);

        member = new Member();

        reff= FirebaseDatabase.getInstance().getReference().child("Number").child("1").child("age");
        reff1= FirebaseDatabase.getInstance().getReference().child("result");
        reff2= FirebaseDatabase.getInstance().getReference().child("time1");
        alco11= FirebaseDatabase.getInstance().getReference().child("alco");
        meth11= FirebaseDatabase.getInstance().getReference().child("meth");
        suni11= FirebaseDatabase.getInstance().getReference().child("suni");


        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());

               // Integer age=dataSnapshot.getValue().toString();
               // member.setAge(age);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int agea=Integer.parseInt(txtage.getText().toString().trim());
                int resultt=Integer.parseInt(txtage.getText().toString().trim());
                int time=Integer.parseInt(txtage2.getText().toString().trim());
                int alco=Integer.parseInt(alco1.getText().toString().trim());
                int meth=Integer.parseInt(meth1.getText().toString().trim());

                int suni = Integer.parseInt(suni1.getText().toString().trim());


                member.setAge(agea);


                reff.setValue(agea);
                reff1.setValue(resultt);
                reff2.setValue(time);
                alco11.setValue(alco);
                meth11.setValue(meth);
                suni11.setValue(suni);


                Toast.makeText(MainActivity.this,"Data inserted Successfully",Toast.LENGTH_LONG
                ).show();

            }
        });









    }
}
