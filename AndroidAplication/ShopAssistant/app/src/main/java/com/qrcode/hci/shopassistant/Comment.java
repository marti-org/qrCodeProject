package com.qrcode.hci.shopassistant;

/**
 * Created by Martin on 28. 4. 2015.
 */
public class Comment {
    public int id;
    public int likes;
    public int dislikes;
    public int face;
    public String date;
    public String name;
    public String text;

    public Comment(int Id,String Name, int Face,String Date, String Text, int Likes, int Dislikes){
        this.id = Id;
        this.name = Name;
        this.face = Face;
        this.date = Date;
        this.text = Text;
        this.likes = Likes;
        this.dislikes = Dislikes;

    }
}
