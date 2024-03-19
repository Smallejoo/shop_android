package com.example.myapplication.SupClasses;

import com.example.myapplication.R;

import java.util.ArrayList;

public  class DAtaBase {
    public ArrayList<Item>itemsList=new ArrayList<Item>() ;
    public DAtaBase()
    {
       Item Bottle=new Item("water from the river",R.drawable.bottle_29_icon,650);
       Item Bracer=new Item("Nice glove",R.drawable.gauntlets_of_strength_icon,250);
       Item IronBranch=new Item("every day dog food ",R.drawable.iron_branch_icon,50);
       Item Axe=new Item("Axe for cutting some heads",R.drawable.ogre_axe_icon,1000);
       Item Tango=new Item("a Casual gum",R.drawable.tango_icon,90);
       Item Gold=new Item("Gold",R.drawable.gold_symbol,1);
        Item Bottle1=new Item("water from the river",R.drawable.bottle_29_icon,650);
        Item Bracer1=new Item("Nice glove",R.drawable.gauntlets_of_strength_icon,250);
        Item IronBranch1=new Item("every day dog food ",R.drawable.iron_branch_icon,50);
        Item Axe1=new Item("Axe for cutting some heads",R.drawable.ogre_axe_icon,1000);
        Item Tango1=new Item("a Casual gum",R.drawable.tango_icon,90);
        Item Gold1=new Item("Gold",R.drawable.gold_symbol,1);
        Item Bottle2=new Item("water from the river",R.drawable.bottle_29_icon,650);
        Item Bracer2=new Item("Nice glove",R.drawable.gauntlets_of_strength_icon,250);
        Item IronBranch2=new Item("every day dog food ",R.drawable.iron_branch_icon,50);
        Item Axe2=new Item("Axe for cutting some heads",R.drawable.ogre_axe_icon,1000);
        Item Tango2=new Item("a Casual gum",R.drawable.tango_icon,90);
        Item Gold2=new Item("Gold",R.drawable.gold_symbol,1);



         itemsList.add(Axe);
         itemsList.add(Bottle);
         itemsList.add(Bracer);
         itemsList.add(IronBranch);
         itemsList.add(Tango);
         itemsList.add(Gold);
        itemsList.add(Axe1);
        itemsList.add(Bottle1);
        itemsList.add(Bracer1);
        itemsList.add(IronBranch1);
        itemsList.add(Tango1);
        itemsList.add(Gold1);
        itemsList.add(Axe2);
        itemsList.add(Bottle2);
        itemsList.add(Bracer2);
        itemsList.add(IronBranch2);
        itemsList.add(Tango2);
        itemsList.add(Gold2);


    }


}
