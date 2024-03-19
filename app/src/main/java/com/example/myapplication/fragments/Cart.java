package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.SupClasses.Adaptor.CartAdaptor;
import com.example.myapplication.SupClasses.Item;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cart extends Fragment implements CartAdaptor.OnAmountChangeListner {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cart() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cart.
     */
    // TODO: Rename and change types and number of parameters
    public static Cart newInstance(String param1, String param2) {
        Cart fragment = new Cart();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);
        ArrayList<Item> RistrictedList=(ArrayList<Item>) getArguments().getSerializable("ItemsList");
        RecyclerView RV=view.findViewById(R.id.RV);
        RV.setLayoutManager(new LinearLayoutManager(getContext()));
        CartAdaptor adapter=new CartAdaptor(RistrictedList,this);
        RV.setAdapter(adapter);
        TextView userName=view.findViewById(R.id.Cart_user);
        userName.setText(getArguments().getString("user"));// find why we are not displaying name
        Button backToShop=view.findViewById(R.id.cart_backButton);
        backToShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                bundle.putString("name",getArguments().getString("user"));// if we find there
                //maybe we will find here too why its emty 
                TheShop SI=new TheShop();
                SI.setArguments(bundle);
                Navigation.findNavController(view).navigate(R.id.action_cart_to_theShop);
            }
        });


        Button Buy=view.findViewById(R.id.cart_buy_button);
        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView cartPriceBottom = getView().findViewById(R.id.cart_price_bottom);
                String textContent = cartPriceBottom.getText().toString();
                Toast.makeText(getContext(), "You payed " + textContent, Toast.LENGTH_LONG).show();;
            }
        });



        return view;
    }

    @Override
    public void OnAmountChange(int TotalAmount) {
        TextView cartPriceBottom = getView().findViewById(R.id.cart_price_bottom);
        String what=cartPriceBottom.getText().toString();
        int temp=Integer.parseInt(what);

        temp=temp+TotalAmount;
        cartPriceBottom.setText(String.valueOf(temp));


    }
}