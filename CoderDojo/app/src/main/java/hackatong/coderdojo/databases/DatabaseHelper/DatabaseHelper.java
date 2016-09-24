package hackatong.coderdojo.databases.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    String sqlCreateTypeUserParents= "CREATE TABLE typeUsers"+
            "(id_typeUser INTEGER PRIMARY KEY NOT NULL, " +
            "typeUser TEXT" +
            "description TEXT)" ;

    String sqlCreateusersParents = "CREATE TABLE usersParents " +
            "(id_Parent INTEGER PRIMARY KEY NOT NULL, " +
            "typeUserParents INT" +
            ",email text"+
            "username TEXT" +
            ", password TEXT, " +
            "fullname TEXT,"+
            "CONSTRAINT fk_parent FOREIGN KEY  id_parent REFERENCES usersParents(id_parent))";;

    String sqlCreateusersChilds = "CREATE TABLE usersChilds " +
            "(id_Child INTEGER PRIMARY KEY NOT NULL, " +
            ",email text"+
            "id_parent INT," +
            "username TEXT" +
            ",password TEXT, " +
            "fullname TEXT," +
            "CONSTRAINT fk_parent FOREIGN KEY  id_parent REFERENCES usersParents(id_parent))";

    String sqlCreateEvents = "CREATE TABLE Events " +
            "(id_event INTEGER PRIMARY KEY NOT NULL," +
            ",emailContact text"+
            " name TEXT, " +
            "address TEXT" +
            ", description TEXT, " +
            "Date DATE)";

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

