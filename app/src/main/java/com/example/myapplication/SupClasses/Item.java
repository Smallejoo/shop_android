package com.example.myapplication.SupClasses;

import java.io.Serializable;

public class Item implements Serializable {
 public  String name_desc;
public int Price ;
public int picNum;
public  boolean inList;

public Item(String name,int pic ,int amount)

{
 this.Price=amount;
 this.picNum=pic;
 this.name_desc=name;
 this.inList=false;
}



}
