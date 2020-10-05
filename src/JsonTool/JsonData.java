package JsonTool;


import JsonTool.org.JSONArray;
import JsonTool.org.JSONException;
import JsonTool.org.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class JsonData {

    public static void main(String[] args) throws IOException, JSONException {

        JSONObject j;


        try {
            String s = "{\"Data\":{\"Name\":\"MichaelChan\",\"Email\":\"XXXX@XXX.com\",\"Phone\":[1234567,0911123456]}}";
            j = new JSONObject(s);
            Object jsonObj = j.getJSONObject("Data");

            System.out.println(jsonObj);


        } catch (Exception e) {
            e.printStackTrace();
        }
        String path = "Example.json";
        File file = new File(path);

        FileReader fr = new FileReader(file.getName());
        BufferedReader br = new BufferedReader(fr);
        String data = "";
        while (br.ready()) {
            String tmp = br.readLine();
            data += tmp;
            System.out.println(tmp);


        }
        fr.close();
        br.close();
        JSONArray jsonArray=new JSONArray(data);

        System.out.println(jsonArray);

        //ArrayList<MultipleFormat> multiples=new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            System.out.println(jsonObject);
            System.out.println(jsonObject.get("QID"));
            System.out.println(jsonObject.getString("QID"));
            System.out.println(jsonObject.opt("babalala"));
            try{
                System.out.println(jsonObject.get("babalala"));
            }//opt會在key為空引用時回傳null,因此不會出exception
            catch (JSONException e) {
                System.out.println("KEY值錯誤");
                e.printStackTrace();
            }
            System.out.println("====continue====");


        }
        System.out.println("====for End====");

        System.out.println("====End====");
//        System.out.println(jsonArray.getJSONObject(0));
//        System.out.println(jsonArray.getJSONObject(1));

//        JSONObject jsonData = new JSONObject(data);
//        System.out.println(jsonData);
//        System.out.println("===============================");
//
//        //Object jsonOb=jsonData.getString("QID");
//        JSONArray qID = jsonData.getJSONArray("QID");
//        for (int i = 0; i < qID.length(); i++) {
//            System.out.println(qID.get(i));
//        }


    }


}



