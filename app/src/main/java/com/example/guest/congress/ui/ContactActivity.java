package com.example.guest.congress.ui;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.guest.congress.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactActivity extends ListActivity {


    @Override
    public long getSelectedItemId() {
        return super.getSelectedItemId();
    }

    @Override
    public int getSelectedItemPosition() {
        return super.getSelectedItemPosition();
    }

    ListView mListView;
    Cursor mCursor;
    ArrayList<String> mZipcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

       // mCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        Uri uri = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI;
        String sortOrder = ContactsContract.CommonDataKinds.StructuredPostal.DISPLAY_NAME + " COLLATE LOCALIZED ASC";

        mCursor = getContentResolver().query(uri, null, null, null, sortOrder);

        while(mCursor.moveToNext())
        {
            String  address = mCursor.getString(mCursor.getColumnIndex(StructuredPostal.STREET));
            String[] thisAddress = address.split(" ");
            int position = thisAddress.length - 1;
            String zipcode = thisAddress[position];
            mZipcode.add(zipcode);
            // String  Postcode = mCursor.getString(mCursor.getColumnIndex(StructuredPostal.POSTCODE));
            // String  City = mCursor.getString(mCursor.getColumnIndex(StructuredPostal.CITY));
            // Toast.makeText(this, "Address is : " + address, Toast.LENGTH_LONG).show();

        }


        startManagingCursor(mCursor);

        String [] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID};

        int [] to = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, mCursor, from, to);

        setListAdapter(listAdapter);
        mListView = getListView();
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String zipcode =  mZipcode.get(position);
        Toast.makeText(this, "Result is : " + zipcode, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
