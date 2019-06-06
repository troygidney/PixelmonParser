package me.pokerman99.pixelmonparser;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class main {

    //public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();

    public static void main(String[] args) throws IOException, ParseException {

        File folder = new File("default");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            System.out.println(file.getName());
            System.out.println(file.isDirectory());
            System.out.println("----");
        }






/*        Object obj = new JSONParser().parse(new FileReader("./default/legendaries/Groudon.set.json"));
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
        }*/







    }

}
