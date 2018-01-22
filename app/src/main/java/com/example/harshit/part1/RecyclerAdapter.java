package com.example.harshit.part1;

/**
 * Created by Harshit on 1/21/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerAdapter  extends RecyclerView.Adapter<Myholder>{

    List<Worldpopulation> list;
    Context context;


    public RecyclerAdapter(List<Worldpopulation> list, Context context){

        this.list=list;
        this.context=context;


    }



    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
       Myholder myHolder=new Myholder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        final Worldpopulation b=list.get(position);

        holder.cname.setText(b.getCountry());
        holder.pop.setText(b.getPopulation());
        String url=b.getFlag();
        Picasso.with(context).load(url).into(holder.image);

        holder.setImageClickListner(new ImageClickListner() {
            @Override
            public void onClick(View view, Integer position, Boolean longevent) {

                    Toast.makeText(context,"IMAGE CLICKED",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context.getApplicationContext(),Main2Activity.class);
                intent.putExtra("yoo", b.getCountry()+"<>"+b.getFlag()+"<>"+b.getPopulation());
                context.startActivity(intent);



            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }






}

class Myholder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLayoutChangeListener{
    TextView cname;
    TextView pop;
    ImageView image;

    ImageClickListner imageClickListner;

    public Myholder(View iview){
        super(iview);


        cname=(TextView)iview.findViewById(R.id.cname);
        pop=(TextView)iview.findViewById(R.id.pop);
        image=(ImageView)iview.findViewById(R.id.image);

        iview.setOnClickListener(this);

    }

    public void setImageClickListner(ImageClickListner imageClickListner){

        this.imageClickListner=imageClickListner;
    }

    @Override
    public void onClick(View v) {

        imageClickListner.onClick(v,getAdapterPosition(),false);

    }



    @Override
    public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {

    }
}
