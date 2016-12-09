package com.mobileappclass.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.author;

public class BookDetails extends AppCompatActivity {

    private ArrayList<Book> books;
    ImageView imageView;
    TextView title;
    TextView author;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);



        books = new ArrayList<>();
        imageView = (ImageView)findViewById(R.id.bookThumbnail_info);
        title = (TextView)findViewById(R.id.book_title_info);
        author =(TextView)findViewById(R.id.book_author_info);


          if(getIntent().getExtras() != null){

           position = getIntent().getIntExtra("Position",0);
           books = getIntent().getParcelableArrayListExtra("Books");
         }

         title.setText(books.get(position).getName());
         author.setText(books.get(position).getAuthor());
         imageView.setImageResource(books.get(position).getImageResource());


    }

    public void readphone(View view) {

        Intent myIntent = new Intent(BookDetails.this, Reader.class);




        BookDetails.this.startActivity(myIntent);



    }

    public void readVR(View view) {

        Intent myIntent = new Intent(BookDetails.this, BookReadVR.class);

        BookDetails.this.startActivity(myIntent);


    }
}
