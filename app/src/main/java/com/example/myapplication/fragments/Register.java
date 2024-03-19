package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.main.FileHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Register() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register.
     */
    // TODO: Rename and change types and number of parameters
    public static Register newInstance(String param1, String param2) {
        Register fragment = new Register();
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
        String fileName="info.txt";
        View view  = inflater.inflate(R.layout.fragment_register, container, false);
        Button regButt= view.findViewById(R.id.RregisterButt);
        regButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText nameText=view.findViewById(R.id.ReditText_name);
                EditText passText=view.findViewById(R.id.ReditText_pass);
                EditText phoneText=view.findViewById(R.id.ReditText_phone);
                String name= (String) nameText.getText().toString();
                String pass= (String) passText.getText().toString();
                String phone= (String) phoneText.getText().toString();
                if(!name.isEmpty()&&!pass.isEmpty()&&!phone.isEmpty())
                {
                    String Got=FileHelper.SarchInFile(getContext(), fileName,name,pass,phone);
                    if(Got.equals(name)||Got.contains(name))
                    {
                        Toast.makeText(getContext(),"your already rigisterd",Toast.LENGTH_LONG).show();
                    }
                    else {
                        FileHelper.WriteToFile(getContext(),fileName,name,pass,phone);
                        Toast.makeText(getContext(),"registered succsess",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getContext(),"Fill all the boxes",Toast.LENGTH_LONG).show();
                }

            }




        });
        Button backB=view.findViewById(R.id.RbacktoMainuButt);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_register_to_log_In_reg);

            }
        });
        return  view;
    }




}