package com.example.testmyself;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter extends RecyclerView.Adapter<TestHolder> {

    ArrayList<ProfileClass> listProfile;
    TestAdapter(ArrayList<ProfileClass>list ){
        listProfile = list;
    }
    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_item,parent,false);
        TestHolder testHolder =  new TestHolder(view);
        return  testHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        ProfileClass profileClass = listProfile.get(position);
        holder.textProfile.setText(profileClass.getName());

    }

    @Override
    public int getItemCount() {
        return  listProfile.size();

    }
}
  class  TestHolder extends  RecyclerView.ViewHolder{
    TextView textProfile;

    public TestHolder(@NonNull final View itemView) {
        super(itemView);
        textProfile = itemView.findViewById(R.id.textProfile);



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (getAdapterPosition()){
                    case 0: intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:9375671846"));
                    break;
                    case  1 : intent = new Intent(itemView.getContext(),ProfileActivity.class);
                    break;
                }
                itemView.getContext().startActivity(intent);
                
                


            }
        });



    }
}
