package com.example.myapplication.SupClasses.Adaptor;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.SupClasses.Item;

import java.util.ArrayList;

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.ViewHolderCart>
{
    ArrayList<Item> Data;
    int currAmount=0;
    private  OnAmountChangeListner listner;
   public interface  OnAmountChangeListner {
       void  OnAmountChange (int TotalAmount);

   }


    public  CartAdaptor(ArrayList<Item>data,OnAmountChangeListner ListinerToFragment)
    {
        this.Data=data;
        this.listner=ListinerToFragment;
    }

    @NonNull
    @Override
    public ViewHolderCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartcard,parent,false);
        ViewHolderCart Holder=new ViewHolderCart(view);
        return  Holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCart holder, int position) {
        holder.price.setText(String.valueOf(Data.get(position).Price));
        holder.description.setText((Data.get(position).name_desc));
        holder.picture.setImageResource(Data.get(position).picNum);
        TextWatcher WatcherAmount= new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int position1=holder.getAdapterPosition();
                int amount=Integer.parseInt(holder.amount.getText().toString());
                int temp =amount*Data.get(position1).Price;

               listner.OnAmountChange(temp);

            }

        };
        holder.amount.addTextChangedListener(WatcherAmount);
        holder.amount.setTag(WatcherAmount);



    }

    @Override
    public int getItemCount() {
        return  Data.size();
    }

    public static class ViewHolderCart extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView picture;
        EditText amount;
        TextView description;
        TextView price;
        public ViewHolderCart(@NonNull View itemView) {
            super(itemView);
            picture=itemView.findViewById(R.id.Cart_image);
            amount=itemView.findViewById(R.id.Cart_editText);
            description=itemView.findViewById(R.id.Cart_itemDescription);
            price=itemView.findViewById(R.id.Cart_Price);
        }
            @Override
        public void onClick(View v) {

        }
    }
}
