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

import com.example.myapplication.R;
import com.example.myapplication.main.FileHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Log_In_reg#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Log_In_reg extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Log_In_reg() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Log_In_reg.
     */
    // TODO: Rename and change types and number of parameters
    public static Log_In_reg newInstance(String param1, String param2) {
        Log_In_reg fragment = new Log_In_reg();
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
        View view =inflater.inflate(R.layout.fragment_log__in_reg, container, false);

        Button regButton=view.findViewById(R.id.RegButt);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_log_In_reg_to_register);
            }
        });
        Button LogIn=view.findViewById(R.id.LogInButt);
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=view.findViewById(R.id.editText_name);
                String Sname=name.getText().toString();
                EditText pass=view.findViewById(R.id.editText_pass);
                String Spass=name.getText().toString();
                String got=FileHelper.SarchInFile(getContext(),"info.txt",Sname,Spass);
                if(got.equals(Sname)&&!Sname.isEmpty()&&!Spass.isEmpty())
                {
                   Bundle bundle=new Bundle();
                    bundle.putString("name",Sname);
                    TheShop fragment=new TheShop();
                    fragment.setArguments(bundle);
                    Navigation.findNavController(view).navigate(R.id.action_log_In_reg_to_theShop,bundle);

                }


            }
        });


        return  view;
    }
}