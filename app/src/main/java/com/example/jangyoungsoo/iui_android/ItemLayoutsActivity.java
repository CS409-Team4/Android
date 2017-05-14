package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

public class ItemLayoutsActivity extends AppCompatActivity {
    private boolean isListView = true;
    private ListView il_listview;
    private GridView il_gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlayouts);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        il_listview = (ListView) findViewById(R.id.il_listView);
        il_gridview = (GridView) findViewById(R.id.il_gridView);

        ILListViewAdapter ilListViewAdapter = new ILListViewAdapter(this, recipeTitle, recipeAuthor, image, 175);
        ILListViewAdapter ilGridViewAdapter = new ILListViewAdapter(this, recipeTitle, recipeAuthor, image, 125);
        il_listview.setAdapter(ilListViewAdapter);
        il_gridview.setAdapter(ilGridViewAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent);
//        return true;
        switch (item.getItemId()) {
            case R.id.home:
                finish();
                return true;
            case R.id.action_listview:
                if (isListView) {
                    il_listview.setVisibility(View.GONE);
                    il_gridview.setVisibility(View.VISIBLE);
                    isListView = false;
                } else {
                    il_listview.setVisibility(View.VISIBLE);
                    il_gridview.setVisibility(View.GONE);
                    isListView = true;
                }
                return true;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_itemlayouts, menu);
        return true;
    }

    private String[] recipeTitle = {
            "Dried Meat with Spices",
            "Golden Chicken",
            "Pork Steak with Vegetables",
            "Lamb Cotlets",
            "Salmon Steak",
            "These Rolls..",
            "Chocolate Cake",
            "Rainbow Chocolate Pudding",
            "Ice-cream Sandwich",
            "Le Macarons de Lyon",
            "Le Tiramisu de Treviso",
            "Creme Caramel",
            "Be Fit, Be Healthy Fruit Mix",
            "Ceylon Tea",
            "Orange Juice, Fresh",
            "A Glass of Wine",
            "Barista's Masterpiece",
            "Coffee",
            "Watermelon Dream",
            "Mojito",
            "Raspberry Smoothie",
            "Smootie (Different Flavors)",
            "Soda",
            "Lemon Ice Tea",
            "Crystal Water with Almond Oil",
            "The Fresh Sandwich",
            "The Healthy Sandwich",
            "Crispy Chicken with Avocado Sandwich",
            "Beef Sandwich",
            "Tuna Sandwich",
            "Fruit Cake",
            "A Quick Snack Burger",
            "Chilli Meat Bites",
            "Your Favourite Ribs",
            "Burger at the Max",
            "Special Burger with Fries",
            "Everybody's Dream Hotdog",
            "Quinoa Balls",
            "Bruschetta with Cheese",
            "Quick Toast with Bacon",
            "Special Steak with Fries",
            "Hotdog for Two",
            "Bruschetta with Salmon Fish",
            "Chief's Steak"
    };

    private String[] recipeAuthor = {
            "Nice to Meat You",
            "Chicken's Heaven",
            "Nice to Meat You",
            "Nice to Meat You",
            "Ron's Fishery",
            "Le Bakery de Trevi",
            "The Sweetest Thing",
            "Sweet and Sweeter",
            "The Sweetest Thing",
            "Le Bakery de Trevi",
            "Sweet and Sweeter",
            "The Sweetest Thing",
            "Sweet and Sweeter",
            "The Healthy Bar",
            "The Healthy Bar",
            "Tonight's Bar",
            "The Cafe Near You",
            "Sweet and Sweeter",
            "The Healthy Bar",
            "Tonight's Bar",
            "The Healhy Bar",
            "Sweet and Sweeter",
            "The Healthy Bar",
            "Sweet and Sweeter",
            "The Healthy Bar",
            "Sandwiches and More",
            "Sandwiches and More",
            "Chicken's Heaven",
            "Nice to Meat You",
            "Ron's Fishery",
            "ReFresh",
            "Nice to Meat You",
            "Nice to Meat You",
            "Nice to Meat You",
            "Burger Queen",
            "Burger Queen",
            "Prince Burger",
            "ReFresh",
            "Sandwiches and More",
            "Sandwiches and More",
            "Nice to Meat You",
            "Prince Burger",
            "Ron's Fishery",
            "Nice to Meat You"
    };

    private Integer[] image = {
            R.drawable.paleo1,
            R.drawable.paleo2,
            R.drawable.paleo3,
            R.drawable.paleo4,
            R.drawable.paleo5,
            R.drawable.dessert1,
            R.drawable.dessert2,
            R.drawable.dessert3,
            R.drawable.dessert4,
            R.drawable.dessert5,
            R.drawable.dessert6,
            R.drawable.dessert7,
            R.drawable.dessert8,
            R.drawable.drink1,
            R.drawable.drink2,
            R.drawable.drink3,
            R.drawable.drink4,
            R.drawable.drink5,
            R.drawable.drink6,
            R.drawable.drink7,
            R.drawable.drink8,
            R.drawable.drink9,
            R.drawable.drink10,
            R.drawable.drink11,
            R.drawable.drink12,
            R.drawable.breakfast1,
            R.drawable.breakfast2,
            R.drawable.breakfast3,
            R.drawable.breakfast4,
            R.drawable.breakfast5,
            R.drawable.breakfast6,
            R.drawable.main1,
            R.drawable.main2,
            R.drawable.main3,
            R.drawable.main4,
            R.drawable.main5,
            R.drawable.main6,
            R.drawable.main7,
            R.drawable.main8,
            R.drawable.main9,
            R.drawable.main10,
            R.drawable.main11,
            R.drawable.main12,
            R.drawable.main13
    };

}