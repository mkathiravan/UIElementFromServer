package net.kathir.simpledemoproject;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.kathir.mylibrary.SimpleInterface;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SimpleInterface {

    public static final String TAG = MainActivity.class.getSimpleName();
    ResponseTypeModel responseTypeModel;
    List<UIDataModel> uiDataModelList;
    List<String> editTextValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchCustomUI("https://demo.ezetap.com/mobileapps/");
    }

    @Override
    public void fetchCustomUI(String url) {

        final ApiInterface requestInterface = ApiClient.getClient(url);

        Call<ResponseTypeModel> call = requestInterface.getInfo();
        call.enqueue(new Callback<ResponseTypeModel>() {
            @Override
            public void onResponse(Call<ResponseTypeModel> call, Response<ResponseTypeModel> response) {

                Log.d(TAG,"RESPONSE_BODY " + response.body().getUidata());

                uiDataModelList = response.body().getUidata();

                updateUI(uiDataModelList);

            }

            @Override
            public void onFailure(Call<ResponseTypeModel> call, Throwable t) {

                Log.d(TAG,"FAILURE_BODY " + t.getMessage());

            }
        });




    }

    @SuppressLint("ResourceType")
    private void updateUI(List<UIDataModel> uiDataModelList) {

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.container);
        linearLayout.setPadding(10,10,10,10);

        final List<EditText> myEditTextList = new ArrayList<>();
        final List<String> myTextViewList = new ArrayList<>();

        final Map<List<String>,List<String>> map =new HashMap<List<String>,List<String>>();

        Map<String,HashMap<String,String>> updatemap = new HashMap<String,HashMap<String,String>>();

        Map<String, String> map2 = new HashMap<String, String>();

        List<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String,String> hashMap = new HashMap<>();


        String lName = "";

        List<String> updateList = new ArrayList<>();

        for (UIDataModel f: uiDataModelList)
        {
            if (f.getUitype().equals("label")) {
                TextView txtView = new TextView(this);
                txtView.setText(f.getValue());
                lName = f.getValue();
                txtView.setId(1);//need for better use
                linearLayout.addView(txtView);
                myTextViewList.add(f.getValue());
            }
            else if(f.getUitype().equals("edittext"))
            {
                EditText editText = new EditText(this);
                editText.setHint(f.getHint());
                linearLayout.addView(editText);
                String text= editText.getText().toString();
                Log.d(TAG,"EDIT_TEXT_VALUE " + text);
                myEditTextList.add(editText);
            }
            else if(f.getUitype().equals("button"))
            {
                Button button = new Button(this);
                button.setText(f.getValue());
                linearLayout.addView(button);

                String finalLName = lName;
                button.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View view) {


                        for(int i =0; i < myEditTextList.size();i++)
                        {
                           // String text = myEditTextList.get(i).getText().toString();

                            hashMap.put(myTextViewList.get(i).toString(), myEditTextList.get(i).getText().toString());

                        }


                        list.add(hashMap);

                        Log.d(TAG,"BEFORE_REVERSE " + list.toString());


                        Collections.reverse(list);

                        Log.d(TAG,"AFTER_REVERSE " + list.toString());

                        String json = new Gson().toJson(list);
                        Log.d(TAG,"CONVERT_TO_JSON " + json);

//                        for (EditText editText : myEditTextList) {
//                            String text = editText.getText().toString();
//                            map2.put(finalLName,text);
//
//                            hashMap.put(finalLName, text);
//
//                            list.add(hashMap);
//
//                            String json = new Gson().toJson(list);
//                            Log.d(TAG,"CONVERT_TO_JSON " + json);
//
//                            editTextValues.add(text);
//                            Log.d(TAG,"ET_VALUES " + text);
//                        }




                        //map.put(myTextViewList,editTextValues);




//                        Gson gson = new GsonBuilder().create();
//                        JsonObject myCustomArray = gson.toJsonTree(map).getAsJsonObject();
//
//                        Log.d(TAG,"ARRAY_VALUES " + myCustomArray);
//
//                        Log.d(TAG,"HASH_MAP_READING_VALUES " + map2.toString());
//
//                        List<HashMap<String, String>> list = new ArrayList<>();
//                        HashMap<String,String> hashMap = new HashMap<>();
//                        hashMap.put("enter_name", "kathir");
//                        hashMap.put("enter_ph", "887833");
//                        hashMap.put("enter_city", "bangalore");
//                        list.add(hashMap);
//
//                        String json = new Gson().toJson(list);
//
//                        Log.d(TAG,"CONVERT_TO_JSON " + json);



                        //map.keySet();


//                        Set<Map.Entry<List<String>, List<String>>> entrySet
//                                = map.entrySet();
//
//                        // Creating an ArrayList of Entry objects
//                        ArrayList<Map.Entry<List<String>, List<String>>> listOfEntry
//                                = new ArrayList<Map.Entry<List<String>, List<String>>>(entrySet);


//                        for(Map.Entry<List<String>, List<String>> listEntry : listOfEntry)
//                        {
//                            System.out.println(String.format("Key (name) is: %s, Value (age) is : %s", listEntry.getKey(), listEntry.getValue()));
//
//                        }
//
//                        System.out.println(listOfEntry);





//
//                        for (Map.Entry<List<String>, List<String>> pair : map.entrySet()) {
//                            System.out.println(String.format("Key (name) is: %s, Value (age) is : %s", pair.getKey(), pair.getValue()));
//                            //Log.d(TAG,"THE KEY IS " + pair.getKey() + "VALUES = " + pair.getValue());
//                        }

                        //map.entrySet().forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue()));

//                        map.forEach((k, v) -> {
//                            System.out.println("Key: " + k + ", Value: " + v);
//                        });


                        Log.d(TAG,"RETREVEs_MAP_VAKUES " + map.size());

//                        for(Map.Entry m:map.entrySet()){
//                            System.out.println(m.getKey()+" "+m.getValue());
//                        }



//                        Log.d(TAG,"LABEL_LST_VALUES " + myTextViewList.toString());
//
//                        Log.d(TAG,"PASSING_DATA_TO_VALUES " + editTextValues.toString());
//
//
//
//
//                        Gson gson = new GsonBuilder().create();
//                        JsonArray myCustomArray = gson.toJsonTree(editTextValues).getAsJsonArray();
//
//                        Log.d(TAG,"ARRAY_VALUES " + myCustomArray);
                    }
                });
            }
//            else if(f.getUitype().equals("edittext"))
//            {
//                EditText editText = new EditText(this);
//                editText.setHint("Enter your name");
//                linearLayout.addView(editText);
//            }
        }

    }

    @Override
    public void fetchImage(String url) {

    }
}