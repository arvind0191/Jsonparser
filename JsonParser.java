package com.infojini.studmonk.parser;

import android.util.Log;

import com.infojini.studmonk.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Arvind on 24/11/15.
 */
public class JsonParser {
    private String subjectName, chapterName, chapterId;
    private int subjectCode, noOfChapter;

    public void parseJsonString(String jsonRawString) {
        try {
            JSONObject jsonRootObject = new JSONObject(jsonRawString);

            /*
                Getting root element from json String
             */
            subjectName = jsonRootObject.optString(Constants.SubjectName).toString();
            subjectCode = Integer.parseInt(jsonRootObject.optString(Constants.SubjectCode).toString());
            noOfChapter = Integer.parseInt(jsonRootObject.optString(Constants.NoOfChapter).toString());


            /*
            Get the instance of JSONArray that contains JSONObjects
             */
            JSONArray jsonArray = jsonRootObject.optJSONArray(Constants.ChapterList);

            /*
            Iterate the jsonArray and print the info of JSONObjects
             */
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                chapterName = jsonObject.optString(Constants.ChapterName).toString();
                chapterId = jsonObject.optString(Constants.ChapterId).toString();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}


