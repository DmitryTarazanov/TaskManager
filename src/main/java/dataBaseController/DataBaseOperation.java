package dataBaseController;


import jsonController.JsonData;
import jsonController.JsonFileParser;
import jsonController.Root;

import java.sql.*;
import java.util.List;

public class DataBaseOperation {
    public static final String DB_FELLING_DB = "INSERT INTO TODO (PROJECT, CLIENT, TASK, STATE) VALUES (?, ?, ?, ?);";
    public static final String DB_CREATE_DB = "SELECT * FROM TODO";

    public static void filling(Connection con) {
        JsonFileParser jsonFileParser = new JsonFileParser();
        Root root = jsonFileParser.parseFile();
        try (Statement statement = con.createStatement()) {
            PreparedStatement preparedStatement = con.prepareStatement(DB_FELLING_DB);
            ResultSet resultSet = statement.executeQuery(DB_CREATE_DB);
            if(resultSet.next()) {
              return;
            }else {
                List<JsonData> parsedJsonData = root.getJsonData();
                for (int i = 0; i < parsedJsonData.size(); i++) {
                    preparedStatement.setString(1, (parsedJsonData.get(i)).getProject());
                    preparedStatement.setString(2, (parsedJsonData.get(i)).getClient());
                    preparedStatement.setString(3, (parsedJsonData.get(i)).getTask());
                    preparedStatement.setString(4, (parsedJsonData.get(i)).getState());
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println("Check connection with DataBase.");
            e.printStackTrace();
        }
    }
}