package com.soumya.possystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

    Button itemButton;
    Button categoryButton;
    Button discountButton;

    public ItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_items, container, false);


        itemButton=(Button) v.findViewById(R.id.items_button);
        categoryButton=(Button) v.findViewById(R.id.category_button);
        discountButton=(Button) v.findViewById(R.id.discount_button);

        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemIntent=new Intent(getActivity(),ItemsActivity.class);
                startActivity(itemIntent);
            }
        });

        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemIntent=new Intent(getActivity(),CategoryActivity.class);
                startActivity(itemIntent);
            }
        });

        discountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemIntent=new Intent(getActivity(),DiscountActivity.class);
                startActivity(itemIntent);
            }
        });

        setHasOptionsMenu(false);
        // Inflate the layout for this fragment
        return v;
    }

}
