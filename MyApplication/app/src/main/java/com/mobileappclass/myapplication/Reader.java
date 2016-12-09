package com.mobileappclass.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Reader extends AppCompatActivity {

    private ArrayList<Book> book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        book = new ArrayList<>();

        //addPages();
       //fillPagestoView();



    }


    private void addPages() {
        book.add(new Book(R.drawable.page01));
        book.add(new Book(R.drawable.page02));
        book.add(new Book(R.drawable.page03));
        book.add(new Book(R.drawable.page04));
        book.add(new Book(R.drawable.page05));
        book.add(new Book(R.drawable.page06));
        book.add(new Book(R.drawable.page07));
        book.add(new Book(R.drawable.page08));
        book.add(new Book(R.drawable.page09));
        book.add(new Book(R.drawable.page10));


    }



    private void addPagetoView(int Layout ,int imageRes) {

        View LinearLayout1 = findViewById(Layout);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0,0);
        layoutParams.height = 1000;
        layoutParams.width=750;

        layoutParams.setMargins(7,7,15,7);

        ImageView image = new ImageView(this);
        int imageResource = getResources().getIdentifier(String.valueOf(imageRes), null,
                getPackageName());
        Drawable res = getResources().getDrawable(imageResource);

        image.setLayoutParams(layoutParams);
        image.setImageDrawable(res);
        ((ViewGroup) LinearLayout1).addView(image);
    }


    private void fillPagestoView() {

        int size = book.size();
        if(book.size() == 0){
            //  Make a Nothing to show textbox
        }

       else{
            for(int i = 0; i < size; ++i){
                addPagetoView(R.id.readerLinearLayout,book.get(i).getImageResource());
            }
        }



    }



}
