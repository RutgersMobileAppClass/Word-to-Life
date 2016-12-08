package com.mobileappclass.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class ReaderClass extends Activity {

    private ImageView imageView;
    private int currentPage = 0;
    private Button next, previous;
    private int required_height,required_width;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader_class);

        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                currentPage++;
                render();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                currentPage--;
                render();
            }
        });

        render();
    }



    private void render() {
        try{
            imageView = (ImageView) findViewById(R.id.image);
            //int REQ_WIDTH = imageView.getWidth();
            //int REQ_HEIGHT = imageView.getHeight();
            int REQ_WIDTH = 950;
            int REQ_HEIGHT = 1300;


            Bitmap bitmap = Bitmap.createBitmap(REQ_WIDTH, REQ_HEIGHT, Bitmap.Config.ARGB_4444);
            File file = new File("/sdcard/Download/2series.pdf");
            PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));

            if(currentPage < 0) {
                currentPage = 0;
            } else if(currentPage > renderer.getPageCount()) {
                currentPage = renderer.getPageCount() - 1;
            }

            Matrix m = imageView.getImageMatrix();
            Rect rect = new Rect(0, 50, REQ_WIDTH, REQ_HEIGHT);

            renderer.openPage(currentPage).render(bitmap, rect, m, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            imageView.setImageMatrix(m);
            imageView.setImageBitmap(bitmap);
            imageView.invalidate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
