package com.mobileappclass.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class BookReadVR extends AppCompatActivity {





    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.activity_book_read_vr);
        }

    /*
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
    */


}
