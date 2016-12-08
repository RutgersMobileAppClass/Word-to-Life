package com.mobileappclass.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {
    private EditText newTaskText;
    private EditText newTaskDescription;
    private ArrayList<Book> recent_Books;
    private ArrayList<Book> lib_Books;
    private ArrayList<Book> fav_Books;
    Book book;

    //TODO check todo'
    //TODO How to dynamically make functions to open book on image tap
    //TODO How to import book covers( Easy fix make user add isbn )





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        recent_Books = new ArrayList<>();
        lib_Books = new ArrayList<>();
        fav_Books = new ArrayList<>();

        addBooks();

        fillBookstoRecent();
        //addBooktoView(R.id.recentLinearLayout,R.drawable.image9780307474278);

        // Sets up the toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_home);
        setSupportActionBar(myToolbar);


    }






    // Sets up the buttons for the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar_home,menu);

        return super.onCreateOptionsMenu(menu);
    }


    // To Handle AppBar Dropdown button clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){


            case R.id.deleteBook:



                return true;

            case R.id.settings:



                return true;

            default:



                return super.onOptionsItemSelected(item);



        }


    }

    private void addBooks() {
        recent_Books.add(new Book(R.string.tup, R.string.ml, R.drawable.image9780393254594));
        recent_Books.add(new Book(R.string.tgott, R.string.ph, R.drawable.image9781594633669));
        recent_Books.add(new Book(R.string.hpatcc, R.string.jkr, R.drawable.image9781338099133));
        recent_Books.add(new Book(R.string.ff, R.string.jkr, R.drawable.image9781338109061));
    }


    private void addBooktoView(int Layout ,int imageRes) {

        View LinearLayout1 = findViewById(Layout);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0,0);
        layoutParams.height=500;
        layoutParams.width=300;

        layoutParams.setMargins(7,7,15,7);

        ImageView image = new ImageView(this);
        int imageResource = getResources().getIdentifier(String.valueOf(imageRes), null,
                getPackageName());
        Drawable res = getResources().getDrawable(imageResource);

        image.setLayoutParams(layoutParams);
        image.setImageDrawable(res);
        ((ViewGroup) LinearLayout1).addView(image);
    }


    private void fillBookstoRecent() {

        int size = recent_Books.size();
        if(recent_Books.size() <= 0){
            //  Make a Nothing to show textbox
        }

        else if (recent_Books.size()> 5){
            size = 5;
        }
        else {
            size = recent_Books.size();
        }

        for(int i = 0; i < size; ++i){
            addBooktoView(R.id.recentLinearLayout,recent_Books.get(i).getImageResource());
        }

    }



    // Search Button Clicked
    public void searchClick(MenuItem item) {

        LayoutInflater li = LayoutInflater.from(this);
        LinearLayout newtaskLayout = (LinearLayout)li.inflate(R.layout.search_popup,null);

        newTaskText = (EditText) newtaskLayout.getChildAt(0);
        newTaskDescription = (EditText) newtaskLayout.getChildAt(1);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Find Books");
        alertDialogBuilder.setView(newtaskLayout);

        alertDialogBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            // TODO Actually search through Library
                Toast.makeText(HomeScreen.this,"Search Clicked",Toast.LENGTH_LONG).show();


            }
        });

        alertDialogBuilder.setNegativeButton("Cancel",null);
        alertDialogBuilder.show();






    }

    // Library Button Click

    public void libraryTextClick(View view) {

        // TODO Open Library Page

        // Open another view that brings up adding contact stuff


        Intent myIntent = new Intent(HomeScreen.this, Activity_lib.class);


        HomeScreen.this.startActivity(myIntent);






    }

    // Add Button is pressed
    public void addClick(MenuItem item) {





    }
}
