import dataBaseController.DataBaseOperation;

import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            Statement statement = connection.createStatement();
            statement.executeUpdate(Constants.SqlRequest.DB_CREATE);
            DataBaseOperation.filling(connection);
            boolean isQuite = false;
            while (!isQuite) {
                Constants.printMenu();
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        PreparedStatement prepareStatement1 = connection.prepareStatement(Constants.SqlRequest.DB_INSERT_PROJECT);
                        System.out.println("Введите новое имя проекта.");
                        scanner.nextLine();
                        String projectName = scanner.nextLine();
                        prepareStatement1.setString(1, projectName);
                        prepareStatement1.executeUpdate();
                        break;
                    case 2:
                        PreparedStatement preparedStatement2 = connection.prepareStatement(Constants.SqlRequest.DB_UPDATE_PROJECT);
                        System.out.println("Введите новое имя проекта.");
                        scanner.nextLine();
                        String newProjectName = scanner.nextLine();
                        System.out.println("Введите имя проекта, необходимое поменять.");
                        String projectOldName = scanner.nextLine();
                        preparedStatement2.setString(1, newProjectName);
                        preparedStatement2.setString(2, projectOldName);
                        preparedStatement2.executeUpdate();
                        break;
                    case 3:
                        PreparedStatement preparedStatement3 = connection.prepareStatement(Constants.SqlRequest.DB_DELETE_PROJECT);
                        System.out.println("Введите имя проекта для удаления. Пользователи и задачи проекта так же будут удалены.");
                        scanner.nextLine();
                        String projectForDelete = scanner.nextLine();
                        preparedStatement3.setString(1, projectForDelete);
                        preparedStatement3.executeUpdate();
                        break;
                    case 4:
                        PreparedStatement preparedStatement4 = connection.prepareStatement(Constants.SqlRequest.DB_INSERT_CLIENT);
                        System.out.println("Введите имя нового клиента.");
                        scanner.nextLine();
                        String clientForInsert = scanner.nextLine();
                        System.out.println("Введите имя проекта, к которому нужно привязать нового клиента.");
                        String byProject = scanner.nextLine();
                        preparedStatement4.setString(1, clientForInsert);
                        preparedStatement4.setString(2, byProject);
                        preparedStatement4.executeUpdate();
                        break;
                    case 5:
                        PreparedStatement preparedStatement5 = connection.prepareStatement(Constants.SqlRequest.DB_UPDATE_CLIENT);
                        System.out.println("Введите имя нового клиента.");
                        scanner.nextLine();
                        String clientNewName = scanner.nextLine();
                        System.out.println("Введите имя клиента, необходимое поменять.");
                        String clientOldName = scanner.nextLine();
                        preparedStatement5.setString(1, clientNewName);
                        preparedStatement5.setString(2, clientOldName);
                        preparedStatement5.executeUpdate();
                        break;
                    case 6:
                        PreparedStatement preparedStatement6 = connection.prepareStatement(Constants.SqlRequest.DB_DELETE_CLIENT);
                        System.out.println("Введите имя клиента для удаленияю");
                        scanner.nextLine();
                        String deleteClient = scanner.nextLine();
                        preparedStatement6.setString(1, deleteClient);
                        preparedStatement6.executeUpdate();
                        break;
                    case 7:
                        PreparedStatement preparedStatement7 = connection.prepareStatement(Constants.SqlRequest.DB_INSERT_TASK);
                        System.out.println("Введите имя новой задачи.");
                        scanner.nextLine();
                        String taskForClient = scanner.nextLine();
                        System.out.println("Введите имя клиента, к которому нужно привязать новую задачу.");
                        String byClient = scanner.nextLine();
                        preparedStatement7.setString(1, taskForClient);
                        preparedStatement7.setString(2, byClient);
                        preparedStatement7.executeUpdate();
                        break;
                    case 8:
                        PreparedStatement preparedStatement8 = connection.prepareStatement(Constants.SqlRequest.DB_UPDATE_TASK);
                        System.out.println("Введите имя нового задания.");
                        scanner.nextLine();
                        String taskNewName = scanner.nextLine();
                        System.out.println("Введите имя задания, необходимое поменять.");
                        String taskOldName = scanner.nextLine();
                        preparedStatement8.setString(1, taskNewName);
                        preparedStatement8.setString(2, taskOldName);
                        preparedStatement8.executeUpdate();
                        break;
                    case 9:
                        PreparedStatement preparedStatement9 = connection.prepareStatement(Constants.SqlRequest.DB_DELETE_TASK);
                        System.out.println("Введите имя задачи для удаления.");
                        scanner.nextLine();
                        String taskForDelete = scanner.nextLine();
                        preparedStatement9.setString(1, taskForDelete);
                        preparedStatement9.executeUpdate();
                        break;
                    case 10:
                        PreparedStatement preparedStatement10 = connection.prepareStatement(Constants.SqlRequest.DB_SELECT_PROJECT);
                        System.out.println("Введите имя проекта для получения отчета по нему.");
                        scanner.nextLine();
                        String projectGet = scanner.nextLine();
                        preparedStatement10.setString(1, projectGet);
                        ResultSet result = preparedStatement10.executeQuery();
                        while (result.next()) {
                            System.out.println("Проект:" + result.getString("project") + " Пользователь:" + result.getString("client") + " Задание:" + result.getString("task") + " Cтатус:" + result.getString("state"));
                        }
                        break;
                    case 11:
                        PreparedStatement preparedStatement11 = connection.prepareStatement(Constants.SqlRequest.DB_UPDATE_STATE);
                        System.out.println("Введите имя проекта, для которого необходимо поменять статус выполнения.");
                        scanner.nextLine();
                        String projectForChange = scanner.nextLine();
                        System.out.println("Наипишите статус выполнения.");
                        String stateChangeStatus = scanner.nextLine();
                        preparedStatement11.setString(1, stateChangeStatus);
                        preparedStatement11.setString(2, projectForChange);
                        preparedStatement11.executeUpdate();
                        break;
                    case 12:
                        Statement statement1 = connection.createStatement();
                        ResultSet res = statement1.executeQuery(Constants.SqlRequest.DB_SELECT_ALL);
                        int columns = res.getMetaData().getColumnCount();
                        while (res.next()) {
                            for (int i = 1; i <= columns; i++) {
                                System.out.print(res.getString(i));
                            }
                            System.out.println();
                        }
                        break;
                    case 13:
                        System.exit(0);
                    default:
                        System.out.println("Команда не распознана! Выберите доступную опцию из меню.");
                }
            }
        } catch (java.sql.SQLException e) {
            System.out.println("No connection with DataBase");
            e.printStackTrace();
        }
    }
}

