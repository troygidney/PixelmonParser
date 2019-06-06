package me.pokerman99.pixelmonparser;

import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.Condition;

public class main {

    //public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();

    public static void main(String[] args) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("./default/legendaries/Groudon.set.json"));
        JSONObject jsonFile = (JSONObject) obj;
        JSONArray jsonSpawnInfo = (JSONArray) jsonFile.get("spawnInfos");

        for (int x = 0; x < jsonSpawnInfo.size(); x++) {
            JSONObject jsonForms = (JSONObject) jsonSpawnInfo.get(x);
            JSONObject jsonName = (JSONObject) jsonForms.get("spec");

            JSONObject jsonCondition = (JSONObject) jsonForms.get("condition");
            JSONArray jsonWeather = (JSONArray) jsonCondition.get("weathers");

            if (jsonWeather.contains("RAIN") && jsonWeather.size() < 2) {

            }
            //jsonWeather.add("TEST");

            PrintWriter pw = new PrintWriter("./default/legendaries/Groudon.set.json");
            pw.write(jsonFile.toJSONString());
            pw.flush();
            pw.close();
        }







    }

}
