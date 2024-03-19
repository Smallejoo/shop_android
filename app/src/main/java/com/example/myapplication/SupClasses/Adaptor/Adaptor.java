package com.example.myapplication.SupClasses.Adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.SupClasses.Item;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.ViewHolder>{
    ArrayList<Item>Data;
    int type;

    public Adaptor (ArrayList<Item> DataList,int type)
    {
        this.Data=DataList;
        this.type=type;
        Log.i("XXXXxxxXXXxxxXXX","Adaptor created");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        try {


            //we use our tool we tell him where from get info then we loud the card we want to loud with data
            View ToolInflator = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent, false);
            ViewHolder holder = new ViewHolder(ToolInflator);// we creeate an instance of this
            return holder;
        }
        catch (Exception e)
        {
            Log.i("XXXXxxxXXXxxx","error in the infletion");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        try {


            Item CurItem = Data.get(position);
            holder.ItemImage.setImageResource(Data.get(position).picNum);
            holder.DescriptionText.setText(Data.get(position).name_desc);
            holder.Price.setText(String.valueOf(Data.get(position).Price));
            if (!CurItem.inList) {
                holder.BuyButton.setText("Buy");
            } else {
                holder.BuyButton.setText("Drop");
            }
            holder.BuyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (CurItem.inList) {
                        holder.BuyButton.setText("Buy");
                        CurItem.inList = false;
                    } else {
                        holder.BuyButton.setText("Drop");
                        CurItem.inList = true;
                    }

                    //notifyItemChanged(position);
                    int curpos = holder.getAdapterPosition();
                    notifyItemChanged(curpos);


                }
            });
        }catch (Exception e)
        {
            Log.i("XXXXxxxXXXxxx","onBiding puting data and click button cus");
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView DescriptionText;
        TextView Price;
        Button BuyButton;
        ImageView ItemImage;
        EditText ItemAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            try {


                DescriptionText = itemView.findViewById(R.id.card_ItemDescription);
                Price = itemView.findViewById(R.id.card_GoldAmountTextView);
                BuyButton = itemView.findViewById(R.id.card_addItemButton);
                ItemImage = itemView.findViewById(R.id.card_ItemPicture);
            }
            catch (Exception e)
            {
                Log.i("XXXXxxxXXXxxx","view holder part problem");
                e.printStackTrace();
            }

        }


        @Override
        public void onClick(View v) {
            // when you click on some thing what will happened
        }
    }
}
