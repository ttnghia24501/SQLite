package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DBHepler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHepler(this);

        insertUser();

        getAllUser();

        updateUser();
        deleteUser();
    }
    private void insertUser(){
        User user = new User("Nguyen Van A ","Male",20);
        String message = db.insertDB(user);
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    private void getAllUser(){
        List<User>listUser =db.getAllUser();
        for(User user :listUser){
            Log.d("USER","name:"+user.getName()+"id:"+user.getId()+"age:"+user.getAge());
        }
    }
    private void updateUser(){
        User user = new User();
        user.setId(3);
        user.setName("Tran Tuan Nghia");
        user.setAge(20);
        String message = db.updateUser(user);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void deleteUser(){
        db.deleteUser(5);

    }
    @Override
    protected void onStop(){
        super.onStop();
        db.close();
    }
}