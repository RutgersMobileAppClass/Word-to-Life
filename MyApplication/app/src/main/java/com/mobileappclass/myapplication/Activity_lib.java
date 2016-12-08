package com.mobileappclass.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_lib extends AppCompatActivity {

    private EditText newTaskText;
    private EditText newTaskDescription;

    private ArrayList<Book> Books;
    Book book_clicked;
   // private Book[] books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);
       Books = new ArrayList<>();
        book_clicked = new Book();

        addBooks();

        // Sets up the toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_lib);
        setSupportActionBar(myToolbar);


        GridView gridView=(GridView) findViewById(R.id.gridview_LIB);
        BooksAdapter1 booksAdapter=new BooksAdapter1(this, Books);
        gridView.setAdapter(booksAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent myIntent1 = new Intent(Activity_lib.this, BookDetails.class);

                Bundle b1 = new Bundle();
                b1.putParcelableArrayList("Books",(ArrayList<? extends Parcelable>) Books);
                b1.putInt("Position",position);

                myIntent1.putExtras(b1);
                Activity_lib.this.startActivity(myIntent1);


            }
        });




    }

    // Hardcoded Books




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar_library,menu);

        return super.onCreateOptionsMenu(menu);
    }

    // To Handle AppBar Dropdown button clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){


            case R.id.addBook_lib:



                return true;

            case R.id.deleteBook_lib:



                return true;

            case R.id.settings_lib:



                return true;

            default:



                return super.onOptionsItemSelected(item);



        }


    }

    private void addBooks() {


        Books.add(new Book(R.string.tup, R.string.ml, R.drawable.image9780393254594));
        Books.add(new Book(R.string.tgott, R.string.ph, R.drawable.image9781594633669));
        Books.add(new Book(R.string.hpatcc, R.string.jkr, R.drawable.image9781338099133));
        Books.add(new Book(R.string.ff, R.string.jkr, R.drawable.image9781338109061));
        //Books.add(new Book(R.string.hand_hand_fingers_thumb, R.string.dr_seuss, R.drawable.image9781338099133));
        //Books.add(new Book(R.string.the_very_hungry_caterpillar, R.string.eric_carle, R.drawable.image9780393254594));
       // Books.add(new Book(R.string.the_going_to_bed_book, R.string.sandra_boynton, R.drawable.image9781476738024));
       // Books.add(new Book(R.string.oh_baby_go_baby, R.string.dr_seuss, R.drawable.image9781594633669));
       // Books.add(new Book(R.string.the_tooth_book, R.string.dr_seuss, R.drawable.image9781338099133));
        //Books.add(new Book(R.string.one_fish_two_fish_red_fish_blue_fish, R.string.dr_seuss, R.drawable.image9780393254594));


    }




    // Search Button Clicked
    public void searchClick_lib(MenuItem item) {

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
                Toast.makeText(Activity_lib.this,"Search Clicked",Toast.LENGTH_LONG).show();


            }
        });

        alertDialogBuilder.setNegativeButton("Cancel",null);
        alertDialogBuilder.show();






    }


    public void homeClick_lib(MenuItem item) {



        // TODO open homescreen back

        Intent myIntent = new Intent(Activity_lib.this, HomeScreen.class);

        //MainActivity.this.startActivity(myIntent);


        // Bundle b = new Bundle();
        //b.putStringArrayList("Name_Array", nameArray);
        //b.putStringArrayList("Number_Array", numberArray);
        //b.putStringArrayList("Relation_Array",relationArray);
        //  myIntent = new Intent(HomeScreen.this, Activity_lib.class);
        //myIntent.putExtras(b); //Optional parameters
        Activity_lib.this.startActivity(myIntent);







    }
}
