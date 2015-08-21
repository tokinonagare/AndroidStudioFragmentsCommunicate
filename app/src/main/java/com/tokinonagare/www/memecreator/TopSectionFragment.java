package com.tokinonagare.www.memecreator;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment{

    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
       void createMeme(String Top, String Bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListener) activity;
        } catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttonClicked();
                    }
                }
        );

        return view;
    }


    //Call this when the button is clicked
    public void buttonClicked(){
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }

}
