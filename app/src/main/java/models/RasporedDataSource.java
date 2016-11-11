package models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeljko94 on 11.11.2016..
 */
public class RasporedDataSource {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private String[] stupci = {"id", "nastavnik", "predmet", "ucionica", "vrijeme_od", "vrijeme_do"};

    public RasporedDataSource(Context ctx) {
        this.dbHelper = new DatabaseHelper(ctx);
    }

    public void open()
    {
        this.db = this.dbHelper.getWritableDatabase();
    }

    public void close()
    {
        this.db.close();
    }



    public Raspored create(Raspored r)
    {
        ContentValues cv = this.rasporedToContentValues(r);
        long insertId = this.db.insert("raspored",null, cv);
        Cursor c = this.db.query("raspored", stupci, "id = " + String.valueOf(insertId), null, null, null,null);
        c.moveToFirst();
        return this.cursorToRaspored(c);
    }

    public List<Raspored> getAll()
    {
        List<Raspored> rasporedi = new ArrayList<>();
        Cursor c = this.db.rawQuery("SELECT * FROM raspored",null);
        if(c.moveToFirst())
        {
            do {
                rasporedi.add(this.cursorToRaspored(c));
            } while(c.moveToNext());
        }
        return rasporedi;
    }

    public Raspored cursorToRaspored(Cursor c)
    {
        return new Raspored(c.getInt(0),c.getString(1),c.getString(2), c.getString(3), c.getString(4), c.getString(5));
    }

    private ContentValues rasporedToContentValues(Raspored raspored)
    {
        ContentValues cv = new ContentValues();
        cv.put("nastavnik", raspored.getNastavnik());
        cv.put("predmet", raspored.getPredmet());
        cv.put("ucionica", raspored.getUcionica());
        cv.put("vrijeme_od", raspored.getDatum_od());
        cv.put("vrijeme_do", raspored.getDatum_do());
        return cv;
    }
}
