package com.ourapp.drdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PatientUserClass extends AppCompatActivity {

    EditText symptom1, symptom2, symptom3, dateTime, emailEditText, phoneNumberEditText;
    TextView diagnosisTextView;
    Button buttonBook, analyseButton;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("bookings");


    String a = "Headache", b = "Fever", c = "Swelling", d = "Morning Sickness",
            e = "Diarrhoea", f = "Nose Bleed", g = "Running Nose", h = "Vomit", i = "Cravings";

    String x = "Flu", y = "Pregnant", z = "Corona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_user_class);
        // Firebase
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("bookings");

        symptom1 = (EditText) findViewById(R.id.symptom1);
        symptom2 = (EditText) findViewById(R.id.symptom2);
        symptom3 = (EditText) findViewById(R.id.symptom3);
        dateTime = (EditText) findViewById(R.id.dateTime);


        phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);

        diagnosisTextView = (TextView) findViewById(R.id.diagnosisTextView);


        buttonBook = (Button) findViewById(R.id.buttonBook);
        analyseButton = (Button) findViewById(R.id.analyseButton);

        analyseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symptom1Text = symptom1.getText().toString();
                String symptom2Text = symptom2.getText().toString();
                String symptom3Text = symptom3.getText().toString();
                String dateTimeText = dateTime.getText().toString();
                String email = emailEditText.getText().toString();
                String phoneNumber= phoneNumberEditText.getText().toString();

                if(symptom1Text.isEmpty() ||symptom2Text.isEmpty() ||symptom3Text.isEmpty()){
                    Toast.makeText(PatientUserClass.this, "Please fill in the empty symptom", Toast.LENGTH_SHORT).show();
                }

                if(symptom1Text.equals(a) && symptom2Text.equals(b) && symptom3Text.equals(c)) {
                    diagnosisTextView.setText(x);
                }

                if(symptom1Text.equals(d) && symptom2Text.equals(h) && symptom3Text.equals(i)) {
                    diagnosisTextView.setText(y);
                }

                if(symptom1Text.equals(e) && symptom2Text.equals(f) && symptom3Text.equals(g)) {
                    diagnosisTextView.setText(z);
                }
                else{
                    Toast.makeText(PatientUserClass.this, "We do not know what it may be! Please Press the 'BOOK' button to see a Doctor", Toast.LENGTH_LONG).show();
                }
            }
        });
        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String symptom1Text = symptom1.getText().toString();
                String symptom2Text = symptom2.getText().toString();
                String symptom3Text = symptom3.getText().toString();
                String dateTimeText = dateTime.getText().toString();
                String email = emailEditText.getText().toString();
                String phoneNumber= phoneNumberEditText.getText().toString();

                if(symptom1Text.isEmpty() ||symptom2Text.isEmpty() ||symptom3Text.isEmpty() || dateTimeText.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()){
                    Toast.makeText(PatientUserClass.this, "Please fill in everything", Toast.LENGTH_SHORT).show();
                }
                else{
                    sendToDoctor(symptom1Text, symptom2Text, symptom3Text, dateTimeText, email, phoneNumber);
                }
            }
        });
    }

    private void sendToDoctor(String symptom1Text, String symptom2Text, String symptom3Text, String dateTimeText, String email, String phoneNumber) {
        // Create a new booking object with the data
        Appointment booking = new Appointment(symptom1Text, symptom2Text, symptom3Text, dateTimeText, email, phoneNumber);

        // Write the booking object to the database
        ref.push().setValue(booking);

        // Show a success message
        Toast.makeText(PatientUserClass.this, "Booking Successful!", Toast.LENGTH_LONG).show();
    }

}