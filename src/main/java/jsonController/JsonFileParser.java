package jsonController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
import java.util.List;

public class JsonFileParser {
    private static final String DATA_FROM_FILE_NAME = "name";
    private static final String DATA_FROM_FILE = "jsonData";
    private static final String JSON_DATA_ID = "id";
    private static final String JSON_DATA_PROJECT = "project";
    private static final String JSON_DATA_USER = "client";
    private static final String JSON_DATA_TASK = "task";
    private static final String JSON_DATA_STATE = "state";

    public Root parseFile() {
        Root root = new Root();
        JSONParser parser = new JSONParser();
        String fileRoot = "root";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileRoot))) {
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);
            String name = (String) rootJsonObject.get(DATA_FROM_FILE_NAME);

            JSONArray dataJsonArray = (JSONArray) rootJsonObject.get(DATA_FROM_FILE);
            List<JsonData> jsonDataList = new ArrayList();
            for (Object it : dataJsonArray) {
                JSONObject dataJsonObject = (JSONObject) it;
                long id = (long) dataJsonObject.get(JSON_DATA_ID);
                String project = (String) dataJsonObject.get(JSON_DATA_PROJECT);
                String client = (String) dataJsonObject.get(JSON_DATA_USER);
                String task = (String) dataJsonObject.get(JSON_DATA_TASK);
                String state = (String) dataJsonObject.get(JSON_DATA_STATE);

                JsonData jsonData = new JsonData((int) id, project, client, task, state);
                jsonDataList.add(jsonData);
            }
            root.setName(name);
            root.setJsonData(jsonDataList);
        } catch (IOException e) {
            System.out.println("File for loading data in DataBase not found! Please check its location on your computer.");
            e.printStackTrace();
        } catch (ParseException p) {
            System.out.println("Failed to parse the file! Please check the file format or his correct data.");
            p.printStackTrace();
        }
        return root;
    }
}
