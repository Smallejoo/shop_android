package com.example.myapplication.main;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.RequiresPermission;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHelper {
String FilePath="C:\\Users\\Android\\Android_projects\\effiShopProject\\app\\src\\main";
        public static void  WriteToFile(Context context,String Filename,String Username,String Password
        ,String Phone)
        {
            try{

                FileOutputStream fos = context.openFileOutput(Filename, Context.MODE_PRIVATE);
                String data="{Username: "+Username+" Password: "+Password+" Phone: "+Phone+"}\n";
                Log.i("directory",context.getFilesDir().toString());
                fos.write(data.getBytes());
                fos.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        public static String SarchInFile(Context context,String Filename,String Username,String Password
                                         ,String Phone)
        {

            try{
                FileInputStream fis = context.openFileInput(Filename);
                InputStreamReader reader = new InputStreamReader(fis);
                BufferedReader buffer = new BufferedReader(reader);
                String line;
                while ((line=buffer.readLine())!=null)
                {
                    if(line.contains(Username)&&line.contains(Password)&&line.contains(Phone))
                        buffer.close();
                    reader.close();
                    fis.close();
                    Log.i("directory",context.getFilesDir().toString());
                        return  Username;
                }
                buffer.close();
                reader.close();
                fis.close();

            }catch (IOException e)
            {
                e.printStackTrace();

            }

            return "NF";
        }
    public static String SarchInFile(Context context,String Filename,String Username,String Password)
    {

        try{
            FileInputStream fis = context.openFileInput(Filename);
            InputStreamReader reader = new InputStreamReader(fis);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line=buffer.readLine())!=null)
            {
                if(line.contains(Username)&&line.contains(Password)) {
                    buffer.close();
                    reader.close();
                    fis.close();
                    Log.i("directory", context.getFilesDir().toString());

                    return Username;
                }
            }
            buffer.close();
            reader.close();
            fis.close();

        }catch (IOException e)
        {
            e.printStackTrace();

        }

        return "NF";
    }

}
