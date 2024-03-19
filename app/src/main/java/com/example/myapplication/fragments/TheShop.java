package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.SupClasses.Adaptor.Adaptor;
import com.example.myapplication.SupClasses.DAtaBase;
import com.example.myapplication.SupClasses.Item;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TheShop#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TheShop extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String name;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TheShop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TheShop.
     */
    // TODO: Rename and change types and number of parameters
    public static TheShop newInstance(String param1, String param2) {
        TheShop fragment = new TheShop();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ;
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_the_shop, container, false);
        TextView textname=view.findViewById(R.id.S_nameTextView);
        name =getArguments().getString("name");
        textname.setText(name);
        DAtaBase Data=new DAtaBase();
        ArrayList<Item>Datalist=Data.itemsList;
        RecyclerView RV=view.findViewById(R.id.review_theShop);
        RV.setLayoutManager(new LinearLayoutManager(getContext()));
        RV.setLayoutManager(new GridLayoutManager(getContext(), 1));


        Adaptor ADAPTOR=new Adaptor(Datalist,1);
        RV.setAdapter(ADAPTOR);

        Button toCart=view.findViewById(R.id.S_Buybutton);
        toCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
            ArrayList<Item>UpdatedItemList=new ArrayList<Item>();
            for( Item item:Datalist)
            {
                if(item.inList)
                {
                    UpdatedItemList.add(item);
                }

            }
                Bundle Bundlelist=new Bundle();
                Bundlelist.putSerializable("ItemsList",UpdatedItemList);
                Bundlelist.putString("User",name);
                Fragment Cart=new Cart();
                Cart.setArguments(Bundlelist);

                Navigation.findNavController(view).navigate(R.id.action_theShop_to_cart,Bundlelist);


            }
        });
        Button back=view.findViewById(R.id.Shop_backLogin);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_theShop_to_log_In_reg);
            }
        });
        return view;
    }
}