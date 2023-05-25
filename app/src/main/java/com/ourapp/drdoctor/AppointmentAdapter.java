package com.ourapp.drdoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AppointmentAdapter extends FirebaseRecyclerAdapter<Appointment, AppointmentAdapter.personsViewholder> {

    public AppointmentAdapter(
            @NonNull FirebaseRecyclerOptions<Appointment> options) {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder, int position, @NonNull Appointment model) {

        holder.textDateTime.setText(model.getDateTimeText());
        holder.textemail.setText(model.getEmail());
        holder.textPhoneNumber.setText(model.getPhoneNumber());
        holder.textSymptom1.setText(model.getSymptom1Text());
        holder.textSymptom2.setText(model.getSymptom2Text());
        holder.textSymptom3.setText(model.getSymptom3Text());
    }

    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userentry, parent, false);
        return new AppointmentAdapter.personsViewholder(view);
    }

    class personsViewholder extends RecyclerView.ViewHolder {
        TextView textDateTime, textemail, textPhoneNumber, textSymptom1, textSymptom2, textSymptom3;

        public personsViewholder(@NonNull View itemView) {
            super(itemView);

            textDateTime = itemView.findViewById(R.id.textDateTime);
            textemail = itemView.findViewById(R.id.textemail);
            textPhoneNumber = itemView.findViewById(R.id.textPhoneNumber);
            textSymptom1 = itemView.findViewById(R.id.textSymptom1);
            textSymptom2 = itemView.findViewById(R.id.textSymptom2);
            textSymptom3 = itemView.findViewById(R.id.textSymptom3);
        }
    }
}

