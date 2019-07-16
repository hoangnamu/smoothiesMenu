package com.example.smoothiemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.smoothiemenu.object.Smoothy;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private Button checkOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_smoothies);
        checkOutButton = (Button) findViewById(R.id.checkOutButton);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView checkedTextView = (CheckedTextView) view;
                boolean currentChecked = checkedTextView.isChecked();
                Smoothy smoothy = (Smoothy)listView.getItemAtPosition(position);
                smoothy.setActive(!currentChecked);
            }
        });

        Smoothy sapoche = new Smoothy("sapoche", 18);
        Smoothy mango = new Smoothy("mango", 20);
        Smoothy strawberry = new Smoothy("strawberry", 20);

        Smoothy[] menu = new Smoothy[]{sapoche,mango,strawberry};

        ArrayAdapter<Smoothy> arrayAdapter = new ArrayAdapter<Smoothy>(this, android.R.layout.simple_list_item_multiple_choice , menu);

        listView.setAdapter(arrayAdapter);

        for(int i =0 ;i< menu.length; i++){
            listView.setItemChecked(i, menu[i].isActive());
        }

    }

    public void checkOut(View view){
        SparseBooleanArray sp = listView.getCheckedItemPositions();
        int totalAmount = 0 ;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sp.size(); i++){
            if(sp.valueAt(i) == true){
                Smoothy smoothy = (Smoothy) listView.getItemAtPosition(i);
                totalAmount += smoothy.getSmoothyPrice();
            }
        }
        sb.append(totalAmount);
        Toast.makeText(this, "Total price : "+sb.toString(), Toast.LENGTH_LONG).show();
    }
}
