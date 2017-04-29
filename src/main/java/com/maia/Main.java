package com.maia;
import com.google.maps.*;

import javax.swing.*;

import com.google.maps.model.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import com.google.maps.GeoApiContext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;

public class Main {

    public static String key = null;
    public static GeoApiContext context = new GeoApiContext().setApiKey(verifyKey(key));
    public static WhereToEatForm GUI = new WhereToEatForm();

    public static void main(String[] args) throws Exception {
        //key = null;
        //verifyKey(key);
    }


    //Method that checks for key.
    public static String verifyKey(String key){
        //Read key from file
        try(BufferedReader reader = new BufferedReader(new FileReader("key.txt"))){
            key = reader.readLine();
            System.out.printf("Key");
        }catch (Exception ioe){
            System.out.printf("No key file found, or cold not ready key, Please verify key.txt");
            System.exit(-1); //quit program - need to fix before continuing
        }
        return key;
    }

    public static String GetPlace(){

        String place = GUI.getLoc();
        GeocodingResult[] searchResults;
        searchResults = GeocodingApi.newRequest(context).address(place).awaitIgnoreError();
        ArrayList<String> resultList = new <String>ArrayList();
        int i = 0;
        for (GeocodingResult g : searchResults) {
            i = i + 1;
            System.out.println(i + ". " + g.formattedAddress);
            resultList.add(g.formattedAddress);
        }
        String results = "";
        for (String c : resultList){
            results = c + "\n" + results;
        }

        return results;
    }
}
