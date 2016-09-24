package hackatong.coderdojo.databases

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;


public class EventsDataSource {

    private static final String TABLE_NAME = "TypeUsers";
    private static final String COLUMND_ID = "id_TypeUser";
    private static final String COLUMN_TYPE_USER = "typeUser";
    private static final String COLUMN_DESCRIPTION = "description";

    private SQLiteDatabase dbHelper;
    public TypeUsersDataSource(SQLiteDatabase database){
        this.dbHelper = database;
    }

    public String getTypeUsersName(String Name){
        String mName = "Nothing";
        Cursor TypeUsersCursor = dbHelper.rawQuery("SELECT " +
                COLUMN_TYPE_USER + " from " + TABLE_NAME + " WHERE " +
                COLUMN_TYPE_USER
                + "="+"'"+Name+
                "'", null);
//        if (userCursor != null) {
//            userCursor.moveToFirst();
        if(TypeUsersCursor.getCount() > 0){
            TypeUsersCursor.moveToFirst();
            mName = TypeUsersCursor.getString(TypeUsersCursor.getColumnIndex("typeUser"));

        }
        return mName;
    }

    public ArrayList getTypeUsersAllForName(String name) {
        ArrayList<String> mAllTypeUsers = new ArrayList<String>();
        Cursor TypeUsersCursor = dbHelper.rawQuery("SELECT " +
                COLUMN_TYPE_USER+","+
                COLUMN_DESCRIPTION+","+
                " from " + TABLE_NAME +
                " WHERE " + COLUMN_TYPE_USER +
                "="+"'"+name+"'", null);
//        if (userCursor != null) {
//            userCursor.moveToFirst();
        if(TypeUsersCursor.getCount() > 0){
            TypeUsersCursor.moveToFirst();
            String typeUser= TypeUsersCursor.getString(TypeUsersCursor.getColumnIndex(COLUMN_TYPE_USER));
            String description =TypeUsersCursor.getString(TypeUsersCursor.getColumnIndex(COLUMN_DESCRIPTION));
            mAllTypeUsers.add(typeUser);
            mAllTypeUsers.add(description);

        }
        return mAllTypeUsers;
    }
    public ArrayList<String> getTypeUsers() {

        ArrayList<String> typeUserList = new ArrayList<String>();

        Cursor TypeUsersCursor = dbHelper.rawQuery("SELECT typeUser, description FROM TypeUser", null);

        if (TypeUsersCursor != null && TypeUsersCursor.getCount() >= 1) {
            TypeUsersCursor.moveToFirst();

            do {
                String places = TypeUsersCursor.getString(TypeUsersCursor.getColumnIndex("name"))+" - "+placesCursor.getString(placesCursor.getColumnIndex("score"));
                typeUserList.add(places);
            } while (TypeUsersCursor.moveToNext());
        }

        return typeUserList;
    }

    public void saveTypeUsers ( String typeUser, String description){
        ContentValues newTypeUser= new ContentValues();
        newTypeUser.put(COLUMN_TYPE_USER, typeUser);
        newTypeUser.put(COLUMN_DESCRIPTION, description);
        dbHelper.insert(TABLE_NAME, null, newTypeUser);

    }

}


