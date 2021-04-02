package haqnawaz.org.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_NAME = "CustomerName";
    public static final String CUSTOMER_AGE = "CustomerAge";
    public static final String ACTIVE_CUSTOMER = "ActiveCustomer";
    public static final String CUSTOMER_ID = "CustomerID";
    public static final String CUST_TABLE = "CustTable";

    public DBHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
        String createTableSTatement = "CREATE TABLE " + CUST_TABLE + "(" + CUSTOMER_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME + " Text, " + CUSTOMER_AGE + " Int, " + ACTIVE_CUSTOMER + " BOOL) ";
        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addCustomer(CustomerModel customerModel){
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put(CUSTOMER_NAME, customerModel.getName());
        cv.put(CUSTOMER_AGE, customerModel.getAge());
        cv.put(ACTIVE_CUSTOMER, customerModel.isActive());
        //NullCoumnHack
        long insert = db.insert(CUST_TABLE, null, cv);
        if (insert == -1) { return false; }
        else{return true;}
    }
    public ArrayList<CustomerModel> getCustomersList()
    {
        ArrayList<CustomerModel> customer=new ArrayList<CustomerModel>();
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from "+CUST_TABLE;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                String name=cursor.getString(1);
                int age=cursor.getInt(2);
                boolean activeStatus=cursor.getInt(3)==1?true:false;
                int id=cursor.getInt((0));
                CustomerModel customerModel=new CustomerModel(name,age,activeStatus,id);
                customer.add(customerModel);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return customer;
    }
    public boolean deleteCustomer(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="delete from "+CUST_TABLE+" where id = "+id;
        int result =db.delete(CUST_TABLE,CUSTOMER_ID + "=" +id,null);
        //int result=1;
        if(result==-1)
        {
            return  false;
        }
        return  true;
    }
}
