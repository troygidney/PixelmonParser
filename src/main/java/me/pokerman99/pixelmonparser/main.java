package me.pokerman99.pixelmonparser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class main {

    //public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();

    public static void main(String[] args) throws IOException, ParseException {

        File folderDefault = new File("default");
        File[] listOfFiles = folderDefault.listFiles();

        for (File file : listOfFiles) { //Inside the default folder
            //System.out.println(file.getName() + " 1");
            if (file.isDirectory()) {
                File[] filesInner = file.listFiles();
                for (File file1 : filesInner) {
                    //System.out.println("\t" + file1.getName() + " 2");
                    if (file1.isDirectory())
                    {//If the folders with the json have another folder in it.
                        File[] dirInner = file1.listFiles();
                        for (File file2 : dirInner) {
                            if (file2.isDirectory()) {
                                //System.out.println(file.getName() + " 3");
                                continue;
                            }
                            openEditFile(file2);


                            //System.out.println(file2.getName());
                        }

                    }
                    else openEditFile(file1);
                }

            }

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

    public static void openEditFile(File file) throws IOException, ParseException {


        Object obj = new JSONParser().parse(new FileReader(file.getPath()));
        JSONObject jsonFile = (JSONObject) obj;
        System.out.println(obj.toString());
        JSONArray jsonSpawnInfo = (JSONArray) jsonFile.get("spawnInfos");

        for (int x = 0; x < jsonSpawnInfo.size(); x++) {
            JSONObject jsonForms = (JSONObject) jsonSpawnInfo.get(x);

            JSONObject jsonCondition = (JSONObject) jsonForms.get("condition");
            if (jsonCondition == null || jsonCondition.isEmpty()) continue;

            JSONObject jsonName = (JSONObject) jsonForms.get("spec");
            JSONArray jsonWeather = (JSONArray) jsonCondition.get("weathers");

            if (jsonWeather == null || jsonWeather.isEmpty()) continue;



            if (jsonWeather.contains("RAIN") && jsonWeather.size() < 2) {

                System.out.println(file.getName());
                System.out.println(jsonName.get("name"));
                System.out.println(jsonWeather.toString());
                System.out.println("\t\t" + true);
                System.out.println("-------------\n");
                jsonWeather.add("STORM");
                jsonWeather.add("SUN");
                PrintWriter pw = new PrintWriter(file.getPath());
                pw.write(jsonFile.toJSONString());
                pw.flush();
                pw.close();
            }

            if (jsonWeather.contains("STORM") && jsonWeather.size() < 2) {

                System.out.println(file.getName());
                System.out.println(jsonName.get("name"));
                System.out.println(jsonWeather.toString());
                System.out.println("\t\t" + true);
                System.out.println("-------------\n");
                jsonWeather.add("RAIN");
                jsonWeather.add("SUN");
                PrintWriter pw = new PrintWriter(file.getPath());
                pw.write(jsonFile.toJSONString());
                pw.flush();
                pw.close();
            }



        }




    }

}
