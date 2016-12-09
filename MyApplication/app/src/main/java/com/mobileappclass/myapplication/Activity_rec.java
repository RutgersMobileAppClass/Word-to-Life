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

public class Activity_rec extends AppCompatActivity {

    private ArrayList<Book> recent_books;
    private EditText newTaskText;
    private EditText newTaskDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);

        recent_books = new ArrayList<>();



        if(getIntent().getExtras() != null){

            recent_books = getIntent().getParcelableArrayListExtra("recentBooks");
        }


        // Sets up the toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_lib);
        setSupportActionBar(myToolbar);


        GridView gridView=(GridView) findViewById(R.id.gridview_LIB);
        BooksAdapter1 booksAdapter=new BooksAdapter1(this,recent_books);
        gridView.setAdapter(booksAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent myIntent1 = new Intent(Activity_rec.this, BookDetails.class);

                Bundle b1 = new Bundle();
                b1.putParcelableArrayList("Books",(ArrayList<? extends Parcelable>) recent_books);
                b1.putInt("Position",position);

                myIntent1.putExtras(b1);
                Activity_rec.this.startActivity(myIntent1);


            }
        });





    }


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
                //Toast.makeText(Activity_lib.this,"Search Clicked",Toast.LENGTH_LONG).show();


            }
        });

        alertDialogBuilder.setNegativeButton("Cancel",null);
        alertDialogBuilder.show();






    }


    public void homeClick_lib(MenuItem item) {



        // TODO open homescreen back

        Intent myIntent = new Intent(Activity_rec.this, HomeScreen.class);


        Activity_rec.this.startActivity(myIntent);







    }







}
