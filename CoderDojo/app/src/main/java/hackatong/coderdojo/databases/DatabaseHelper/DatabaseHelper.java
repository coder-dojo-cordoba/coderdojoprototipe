package hackatong.coderdojo.databases.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    String sqlCreateTypeUsers= "CREATE TABLE typeUsers"+
            "(id INTEGER PRIMARY KEY NOT NULL, " +
            "typeUser TEXT" +
            "description TEXT)";

    String sqlCreateusersParents = "CREATE TABLE usersParents " +
            "(id INTEGER PRIMARY KEY NOT NULL, " +
            "typeUser INT" +
            "username TEXT" +
            ", password TEXT, " +
            "fullname TEXT)";

    String sqlCreateusersChilds = "CREATE TABLE usersChilds " +
            "(id INTEGER PRIMARY KEY NOT NULL, " +
            "username TEXT" +
            ", password TEXT, " +
            "fullname TEXT)";
    String sqlCreateEvents = "CREATE TABLE Events (id INTEGER PRIMARY KEY NOT NULL," +
            " name TEXT, " +
            "address TEXT" +
            ", comments TEXT, " +
            "score TEXT)";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateTypeUsers);
        db.execSQL(sqlCreateusersParents);
        db.execSQL(sqlCreateusersChilds);
        db.execSQL(sqlCreateEvents);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior,
                          int versionNueva) {

        db.execSQL("DROP TABLE IF EXISTS TypeUsers, Parents, users,places");

        db.execSQL(sqlCreateTypeUsers);
        db.execSQL(sqlCreateusersParents);
        db.execSQL(sqlCreateusersChilds);
        db.execSQL(sqlCreateEvents);

    }
}

