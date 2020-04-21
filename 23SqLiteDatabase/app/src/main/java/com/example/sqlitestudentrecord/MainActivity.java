package com.example.sqlitestudentrecord;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    DatabaseHelper myDB;
    EditText editTextId, editName, editEmail, editCourseCount;
    Button buttonAdd, buttonGetData, buttonUpdate, buttonDelete, buttonViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        editTextId = findViewById(R.id.editText_id);
        editName = findViewById(R.id.editText_name);
        editEmail = findViewById(R.id.editText_email);
        editCourseCount = findViewById(R.id.editText_CC);

        buttonAdd = findViewById(R.id.button_add);
        buttonDelete = findViewById(R.id.button_delete);
        buttonUpdate = findViewById(R.id.button_update);
        buttonGetData = findViewById(R.id.button_view);
        buttonViewAll = findViewById(R.id.button_viewAll);

        addData();
        getData();
        viewAll();
        updateData();
        deleteData();
    }
    public void addData() {

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                String Name  = editName.getText().toString();
                String Email = editEmail.getText().toString();
                String CourseCount = editCourseCount.getText().toString();
                if ( id.equals(String.valueOf("")) &&
                     Name.equals(String.valueOf("")) &&
                     Email.equals(String.valueOf("")) &&
                     CourseCount.equals(String.valueOf(""))) {
                     showMessage("ERROR","ENTER DATA IN ALL FIELDS");
                     editTextId.setError("Enter ID");
                     editName.setError("Enter Name");
                     editEmail.setError("Enter Email");
                     editCourseCount.setError("Enter Course Count");
                     return;
                }
                boolean isInserted = myDB.insertData(editName.getText().toString(), editEmail.getText().toString(), editCourseCount.getText().toString());
                 if (isInserted == true) {
                    Toast.makeText(MainActivity.this, "Data Inserted!",Toast.LENGTH_SHORT).show();
                    editTextNull();
                } else {
                    Toast.makeText(MainActivity.this, "Something went wrong!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void getData() {
        buttonGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                if (id.equals(String.valueOf(""))) {
                    editTextId.setError("Enter ID");
                    return;
                }
                    Cursor cursor = myDB.getData(id);
                    String data = null;
                   if (cursor.getCount() == 0) {
                       showMessage("Error: ","Data Not Found");
                       return;
                   }

                    if (cursor.moveToNext()) {
                        data = "ID: " + cursor.getString(0) + "\n" +
                                "Name: " + cursor.getString(1) + "\n" +
                                "Email: " + cursor.getString(2) + "\n" +
                                "Course Count: " + cursor.getString(3) + "\n";
                    }
                        showMessage("Data: ", data);
                editTextNull();
            }
        });
    }
    public void viewAll() {
        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = myDB.getAllData();

                // small test
                if (cursor.getCount() == 0) {
                    showMessage("Error","No Data Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (cursor.moveToNext()) {
                    buffer.append("ID: "+cursor.getString(0)+"\n");
                    buffer.append("NAME: "+cursor.getString(1)+"\n");
                    buffer.append("EMAIL: "+cursor.getString(2)+"\n");
                    buffer.append("CC: "+cursor.getString(3)+"\n\n");
                }
                showMessage("ALL DATA: ", buffer.toString());
            }
        });


    }
    public void updateData() {
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDB.updateData(editTextId.getText().toString(),
                                                    editName.getText().toString(),
                                                    editEmail.getText().toString(),
                                                    editCourseCount.getText().toString());

                if (isUpdate == true) {
                    Toast.makeText(MainActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                    editTextNull();
                    return;


                } else {
                    Toast.makeText(MainActivity.this, "OOPSS!", Toast.LENGTH_SHORT).show();
                    editTextNull();
                    return;

                }


            }
        });
    }
    public void deleteData() {
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRow = myDB.deleteData(editTextId.getText().toString());

                if (deletedRow > 0) {
                    Toast.makeText(MainActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
                } else {   Toast.makeText(MainActivity.this, "OOPSS!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void editTextNull() {
        editTextId.setText(null);
        editName.setText(null);
        editEmail.setText(null);
        editCourseCount.setText(null);


    }

    private void setError() {
        String id = editTextId.getText().toString();
        String Name  = editName.getText().toString();
        String Email = editEmail.getText().toString();
        String CourseCount = editCourseCount.getText().toString();

    }

}
