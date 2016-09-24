package hackatong.coderdojo.databases.DatabaseHelper;

import android.database.sqlite.SQLiteDatabase;

public class EventsDataSource {

    private static final String TABLE_NAME = "Events";
    private static final String COLUMND_ID = "ID_event";
    private static final String COLUMN_EMAIL_CONTACT = "emailcontact";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_ADDRES = "address";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_DATE = "date";

    private SQLiteDatabase dbHelper;
    public EventsDataSource(SQLiteDatabase database)
}
