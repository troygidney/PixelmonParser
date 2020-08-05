package me.pokerman99.pixelmonparser;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class main {

    //public static Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().disableHtmlEscaping().create();

    public static void main(String[] args) throws IOException, ParseException {

        File folderDefault = new File("factions_faction");
        File[] listOfFiles = folderDefault.listFiles();

        for (File file : listOfFiles) { //Inside the folder
            openEditFile2(file);

        }


    }

    public static void openEditFile2(File file) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(file.getPath()));
        JSONObject jsonFile = (JSONObject) obj;



        PrintWriter printWriter = new PrintWriter(file.getPath());
        printWriter.write(recalculateJson(jsonFile).toJSONString());

        printWriter.flush();
        printWriter.close();


    }

    private static List<String> roles = new ArrayList<String>() {{
        add("LEADER");
        add("COLEADER");
        add("OFFICER");
        add("MEMBER");
        add("RECRUIT");
        add("ENEMY");
        add("NEUTRAL");
        add("TRUCE");
        add("ALLY");
    }};

    private static JSONObject recalculateJson(JSONObject jsonFile) {
        if (jsonFile.containsKey("perms")) {
            JSONObject perms = (JSONObject) jsonFile.get("perms");


            if (perms.containsKey("container")) {
                JSONArray containerPerms = (JSONArray) perms.get("container");
                containerPerms.clear();
                containerPerms.addAll(roles);
                System.out.println(jsonFile);
                System.out.println("Perms Out");


            } else {
                perms.put("container", JSONArray.toJSONString(roles));
                System.out.println(perms);
                System.out.println("Added");
            }
        } else {
            JsonObject perms = new JsonObject();
            JsonArray containerPerms = new JsonArray();
            for (String role : roles) {
                containerPerms.add(role);
            }
            perms.add("container", containerPerms);

            jsonFile.put("perms", perms);

            System.out.println(jsonFile);
            System.out.println("No Perms Found");

        }

        return jsonFile;
    }
}



