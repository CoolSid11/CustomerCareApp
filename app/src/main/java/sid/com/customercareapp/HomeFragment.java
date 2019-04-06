package sid.com.customercareapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sid.com.customercareapp.Adapter.PersonAdapter;
import sid.com.customercareapp.Common.Common;
import sid.com.customercareapp.Model.Person;
import sid.com.customercareapp.StickyRecyclerView.LinearLayoutManagerWithSmoothScroller;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recycler_person;
    LinearLayoutManager layoutManager;

    ArrayList<Person> people = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View homeview = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        recycler_person = (RecyclerView)homeview.findViewById(R.id.HomeRecyclerview);
        layoutManager = new LinearLayoutManagerWithSmoothScroller(getActivity());
        recycler_person.setLayoutManager(layoutManager);
        recycler_person.addItemDecoration(new DividerItemDecoration(getActivity(),layoutManager.getOrientation()));

        createPersonList();
        PersonAdapter adapter = new PersonAdapter(getActivity(),people);
        recycler_person.setAdapter(adapter);
        return homeview;
    }

    private void createPersonList() {
        people = Common.genPeopleGroup();
        people = Common.sortList(people); //Sort
        people = Common.addAlphabets(people); //Add alphabet header


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Common.RESULT_CODE){
            if(resultCode == Activity.RESULT_OK){
                String group_character_clicked = data.getStringExtra("result");
                int postion = Common.findPositionWithName(group_character_clicked,people);
                recycler_person.smoothScrollToPosition(postion);
            }
        }
    }

}
