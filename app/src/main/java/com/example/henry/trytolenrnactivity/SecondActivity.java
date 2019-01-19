package com.example.henry.trytolenrnactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
private List<Book> bookList = new ArrayList<>();
private EditText inputText;
private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        intitBook();
        final RecyclerView recyclerView =  findViewById(R.id.recycler_view);
        inputText = findViewById(R.id.edit_text);
        send = findViewById(R.id.button_send);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final BookAdapter adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = inputText.getText().toString();
                Book newbook;
                if(!"".equals(name)){
                    if(bookList.size() % 2 == 0){
                        newbook = new Book(name,0);
                    }
                    else {
                        newbook  = new Book(name,1);
                    }
                    bookList.add(newbook);
                    adapter.notifyItemInserted(bookList.size()-1);
                    recyclerView.scrollToPosition(bookList.size()-1);
                    inputText.setText("");
                }
            }
        });
    }
    private void intitBook(){
        for (int i=0;i<5;i++){
            Book yitian = new Book("C语言程序设计",0);
            bookList.add(yitian);
            Book tianlong = new Book("谭老师牛逼",1);
            bookList.add(tianlong);
        }
    }

}
