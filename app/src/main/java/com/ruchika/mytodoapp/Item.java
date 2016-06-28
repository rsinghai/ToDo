package com.ruchika.mytodoapp;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by ruchikasinghai on 6/28/16.
 */

@Table(name = "Items")
public class Item extends Model {


    @Column(name = "Name")
    public String name;

    public Item() {
        super();
    }

    public Item(String name) {
        super();
        this.name = name;
    }

    public static List<Item> getAll() {
        // This is how you execute a query
        return new Select()
                .from(Item.class)
                .orderBy("Name ASC")
                .execute();
    }

    /*public String getName() {
        return name;
    }*/


}
