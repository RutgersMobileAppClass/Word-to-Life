package com.mobileappclass.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by t_boy on 11/30/2016.
 */

public class BooksAdapter extends BaseAdapter
{
    private final Context mContext;
    private final Book[] books;
//////////////////////////////////////////////////////////////////////////
    public BooksAdapter(Context context, Book[] books)
    {
        this.mContext=context;
        this.books=books;
    }
///////////////////////////////////////////////////////////////////////////
    @Override
    public int getCount() {

        return books.length;
    }


    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ////////////////////////////////
        final Book book=books[position];
        ////////////////////////////////
        if (convertView==null)
        {
            final LayoutInflater layoutInflater= LayoutInflater.from(mContext);
            convertView=layoutInflater.inflate(R.layout.linearlayout_book,null);
        }
        ////////////////////////////////
        final ImageView imageView=(ImageView)convertView.findViewById(R.id.bookThumbnail);
        final TextView textView_title=(TextView) convertView.findViewById(R.id.book_title);
        final TextView textView_author=(TextView)convertView.findViewById(R.id.book_author);

        imageView.setImageResource(book.getImageResource());
        textView_title.setText(mContext.getString(book.getName()));
        textView_author.setText(mContext.getString(book.getAuthor()));
        return convertView;
    }
}
