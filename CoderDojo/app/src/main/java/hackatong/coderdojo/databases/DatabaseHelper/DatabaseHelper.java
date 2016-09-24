package hackatong.coderdojo.databases.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Tabla tipo Usuario, contiene los valores
    // + Niño menor de 13 años
    // + Joven de 13 a 17 años
    // + Adulto / Padre
    // + Voluntario / Mentor
    // + Champion
    String sqlCreateTypeUserParents= "CREATE TABLE TypeUsers"+
            "(id_typeUser INTEGER PRIMARY KEY NOT NULL, " +
            "typeUser TEXT," +
            "description TEXT);";

    String sqlCreateusersParents = "CREATE TABLE Users " +
            "(id_user INTEGER PRIMARY KEY NOT NULL, " +
            "id_typeUser INT," +
            "id_parent INT," +
            "email text,"+
            "username TEXT," +
            "password TEXT, " +
            "name TEXT,"+
            "lastname TEXT,"+
            "CONSTRAINT fk_userType " +
            "FOREIGN KEY  id_typeUser REFERENCES TypeUsers(id_typeUser)," +
            "CONSTRAINT fk_parent " +
            "FOREIGN KEY  id_parent REFERENCES Users(id_user))";

    // String sqlCreateusersChilds = "CREATE TABLE usersChilds " +
    //         "(id_Child INTEGER PRIMARY KEY NOT NULL, " +
    //         ",email text"+
    //         "typeUserChild INT" +
    //         "id_parent INT," +
    //         "username TEXT" +
    //         ",password TEXT, " +
    //         "fullname TEXT," +
    //         "CONSTRAINT fk_parent " +
    //         "FOREIGN KEY  id_parent REFERENCES usersParents(id_parent))"+
    //         "CONSTRAINT fk_ChildType " +
    //         "FOREIGN KEY  typeUserChild REFERENCES typeUserChlds(id_typeUserChild))";

    String sqlCreateEvents = "CREATE TABLE Events " +
            "(id_event INTEGER PRIMARY KEY NOT NULL," +
            "emailContact text,"+
            "name TEXT, " +
            "address TEXT," +
            "description TEXT, " +
            "Date DATE)";

    String sqlCreateEvents = "CREATE TABLE RegisterEvent " +
            "(id_register INTEGER PRIMARY KEY NOT NULL," +
            "id_user INT,"+
            "id_event INT,"+
            "name TEXT, " +
            "Date DATE, " +
            "CONSTRAINT fk_user " +
            "FOREIGN KEY  id_user REFERENCES Users(id_user)," +
            "CONSTRAINT fk_event " +
            "FOREIGN KEY  id_event REFERENCES Events(id_event))";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateTypeUserParents);
        db.execSQL(sqlCreateusersParents);
        db.execSQL(sqlCreateusersChilds);
        db.execSQL(sqlCreateEvents);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior,
                          int versionNueva) {

        db.execSQL("DROP TABLE IF EXISTS TypeUsers, Parents, users,places");

        db.execSQL(sqlCreateTypeUserParents);
        db.execSQL(sqlCreateusersParents);
        db.execSQL(sqlCreateusersChilds);
        db.execSQL(sqlCreateEvents);

    }
}

