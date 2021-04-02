package haqnawaz.org.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonViewAll;
    EditText editName, editAge;
    Switch switchIsActive;
    ListView listViewCustomer;
    DBHelper dbHelper;
    ArrayList<CustomerModel> customers;
    ArrayAdapter<CustomerModel> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.addBtn);
        buttonViewAll = findViewById(R.id.viewBtn);
        editName = findViewById(R.id.nameTextBox);
        editAge = findViewById(R.id.ageTextBox);
        switchIsActive = findViewById(R.id.statusSwitch);
        listViewCustomer = findViewById(R.id.listView);
        refreshRecords();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            CustomerModel customerModel;

            @Override
            public void onClick(View v) {
                if (editAge.getText().toString().isEmpty()  || editName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter name and age.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    customerModel = new CustomerModel(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), switchIsActive.isChecked(), 1);
                    dbHelper = new DBHelper(MainActivity.this);
                    boolean b = dbHelper.addCustomer(customerModel);
                    if (b) {
                        Toast.makeText(MainActivity.this, "Customer added successfully.", Toast.LENGTH_SHORT).show();
                        refreshRecords();
                    } else {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
                editAge.setText("");
                editName.setText("");
            }
        });
        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Records displayed.", Toast.LENGTH_SHORT).show();
                refreshRecords();
            }
        });
        listViewCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] parsedCustomer = customers.get(position).toString().split(",");
                String[] Id = parsedCustomer[0].split(":");
                dbHelper = new DBHelper(MainActivity.this);
                boolean b = dbHelper.deleteCustomer(Id[1]);
                if (b) {
                    Toast.makeText(MainActivity.this, "Customer removed successfully.", Toast.LENGTH_SHORT).show();
                    refreshRecords();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void refreshRecords() {
        dbHelper = new DBHelper(MainActivity.this);
        customers = dbHelper.getCustomersList();
        arrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, customers);
        listViewCustomer.setAdapter(arrayAdapter);
    }
}