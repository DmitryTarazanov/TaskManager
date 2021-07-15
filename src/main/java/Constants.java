public final class Constants {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "1234";

    public final class SqlRequest {
        public static final String DB_CREATE = "CREATE TABLE IF NOT EXISTS TODO (ID SERIAL PRIMARY KEY, PROJECT varchar(100) DEFAULT 'PROJECT', CLIENT varchar(70) DEFAULT 'CLIENT', TASK varchar(200) DEFAULT 'IN_PROCESS', STATE varchar(10) NOT NULL DEFAULT 'IN_PROCESS');";
        public static final String DB_SELECT_ALL = "SELECT ID, PROJECT, CLIENT, TASK, STATE FROM TODO;";
        public static final String DB_UPDATE_PROJECT = "UPDATE TODO SET PROJECT = ? WHERE PROJECT = ?;";
        public static final String DB_INSERT_PROJECT = "INSERT INTO TODO (PROJECT) VALUES (?);";
        public static final String DB_DELETE_PROJECT = "DELETE FROM TODO WHERE PROJECT = ?;";
        public static final String DB_INSERT_CLIENT = "UPDATE TODO SET CLIENT = ? WHERE PROJECT = ?;";
        public static final String DB_UPDATE_CLIENT = "UPDATE TODO SET CLIENT = ? WHERE CLIENT = ?;";
        public static final String DB_DELETE_CLIENT = "UPDATE TODO SET CLIENT = 'NONE' WHERE CLIENT = ?;";
        public static final String DB_INSERT_TASK = "UPDATE TODO SET TASK = ? WHERE CLIENT = ?;";
        public static final String DB_UPDATE_TASK = "UPDATE TODO SET TASK = ? WHERE TASK = ?;";
        public static final String DB_DELETE_TASK = "UPDATE TODO SET TASK='NONE' WHERE TASK = ?;";
        public static final String DB_SELECT_PROJECT = "SELECT * FROM TODO WHERE PROJECT=?;";
        public static final String DB_UPDATE_STATE = "UPDATE TODO SET STATE = ? WHERE PROJECT = ?;";
    }
    public static void printMenu(){
        System.out.println("Меню: \n1. Добавить проект.");
        System.out.println("2. Изменить проект.");
        System.out.println("3. Удалить проект.");
        System.out.println("4. Добавить пользователя проекту.");
        System.out.println("5. Изменить пользователя.");
        System.out.println("6. Удалить пользователя.");
        System.out.println("7. Добавить задачу пользователю.");
        System.out.println("8. Изменить задачу.");
        System.out.println("9. Удалить задачу.");
        System.out.println("10. Получить отчет по проекту.");
        System.out.println("11. Изменить статус выполнения проекта.");
        System.out.println("12. Получить отчет по всем проектам.");
        System.out.println("13. Завершить работу.");
    }
}