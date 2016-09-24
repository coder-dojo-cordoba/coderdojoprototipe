package hackatong.coderdojo.databases.DatabaseHelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;


public class EventsDataSource {

    private static final String TABLE_NAME = "Events";
    private static final String COLUMND_ID = "ID_event";
    private static final String COLUMN_EMAIL_CONTACT = "emailcontact";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_DATE = "date";

    private SQLiteDatabase dbHelper;
    public EventsDataSource(SQLiteDatabase database){
        this.dbHelper = database;
    }

    public String getEventsName(String Name){
        String mName = "Nothing";
        Cursor EventsCursor = dbHelper.rawQuery("SELECT " +
                COLUMN_NAME + " from " + TABLE_NAME + " WHERE " + COLUMN_NAME
                + "="+"'"+Name+
                "'", null);
//        if (userCursor != null) {
//            userCursor.moveToFirst();
        if(EventsCursor.getCount() > 0){
            EventsCursor.moveToFirst();
            mName = EventsCursor.getString(EventsCursor.getColumnIndex("name"));

        }
        return mName;
    }

    public ArrayList getEventsAllForName(String name) {
        ArrayList<String> mAllEvents = new ArrayList<String>();
        Cursor EventsCursor = dbHelper.rawQuery("SELECT " +
                COLUMN_NAME+","+COLUMN_ADDRESS+","+
                COLUMN_DESCRIPTION+","+
                COLUMN_DATE+
                " from " + TABLE_NAME +
                " WHERE " + COLUMN_NAME +
                "="+"'"+name+"'", null);
//        if (userCursor != null) {
//            userCursor.moveToFirst();
        if(EventsCursor.getCount() > 0){
            EventsCursor.moveToFirst();
            String nameplace = EventsCursor.getString(EventsCursor.getColumnIndex(COLUMN_NAME));
            String address =EventsCursor.getString(EventsCursor.getColumnIndex(COLUMN_ADDRESS));
            String description =EventsCursor.getString(EventsCursor.getColumnIndex(COLUMN_DESCRIPTION));
            String date = EventsCursor.getString(EventsCursor.getColumnIndex(COLUMN_DATE));
            mAllEvents.add(nameplace);
            mAllEvents.add(address);
            mAllEvents.add(description);
            mAllEvents.add(date);
        }
        return mAllEvents;
    }
    public ArrayList<String> getEvents() {

        ArrayList<String> eventsList = new ArrayList<String>();

        Cursor EventsCursor = dbHelper.rawQuery("SELECT name, address, description, date FROM events", null);

        if (EventsCursor != null && EventsCursor.getCount() >= 1) {
            EventsCursor.moveToFirst();

            do {
                String places = EventsCursor.getString(EventsCursor.getColumnIndex("name"))+" - "+EventsCursor.getString(EventsCursor.getColumnIndex("score"));
                eventsList.add(places);
            } while (EventsCursor.moveToNext());
        }

        return eventsList;
    }

    public void saveEvents ( String name,String email, String address, String description, String date){
        ContentValues newEvent= new ContentValues();
        newEvent.put(COLUMN_NAME, name);
        newEvent.put(COLUMN_EMAIL_CONTACT, email);
        newEvent.put(COLUMN_ADDRESS, address);
        newEvent.put(COLUMN_DESCRIPTION, description);
        newEvent.put(COLUMN_DATE, date);
        dbHelper.insert(TABLE_NAME, null, newEvent);

    }

    }


