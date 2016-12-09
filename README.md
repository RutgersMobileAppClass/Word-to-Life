## Synopsis

Word to Life is a Book and Comics reader for Virtual Reality Headsets

## Code Example

The Book class which was essential for the app as all the data was accessed through it

public class Book implements Parcelable{

    private  int name;
    private  int author;
    private  int imageResource;
    private boolean isFavorite = false;



    public Book(int name, int author, int imageResource) {
        this.name = name;
        this.author = author;
        this.imageResource = imageResource;
    }

    public Book(int name, int imageResource){
        this.name = name;
        this.imageResource = imageResource;
    }

    public Book(int imageResource){
        this.imageResource = imageResource;
    }
    
    .
    .
    .
    (Continued)
}


## Motivation

Let the Users enjoy immersive reading of Books and Comics. Stimulating their experience with Virtual Reality

## Installation

The APK in the directory can be directly installed to use the Application

## Tests

The application was run on the emulator, then it was tested on the phone and finally tested with a VR headset to ensure functionality

## Contributors

Talha Mahmoood (talham92) and Thinh Ngyuen (thinh911) 

