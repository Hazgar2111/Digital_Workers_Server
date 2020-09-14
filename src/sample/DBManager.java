package sample;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;


    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/digital_workers?useUnicode=true&serverTimezone=UTC","root","123"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employeesList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String middle_name = resultSet.getString("middle_name");
                String surname = resultSet.getString("surname");
                String phone_number = resultSet.getString("phone_number");
                String dolzhnost = resultSet.getString("dolzhnost");
                String datePriema = resultSet.getString("datePriema");
                String pass = resultSet.getString("pass");
                String login = resultSet.getString("login");
                String trud_dogovor = resultSet.getString("trud_dogovor");
                String email = resultSet.getString("email");

                employeesList.add(new Employee(id, name, middle_name, surname, phone_number, dolzhnost, datePriema, pass, login, trud_dogovor, email));
                //System.out.println(adminsList.get(0).getLogin());
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeesList;
    }


    public ArrayList<FileSaver> getFiles(int id) throws SQLException {
        ArrayList<FileSaver> fileSavers = new ArrayList<>();
        ArrayList<File_to_human> file_to_humen = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM file_to_human where id_employee =?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                int id_employee = resultSet.getInt("id_employee");
                int id_file  = resultSet.getInt("id_file");
                file_to_humen.add(new File_to_human(id1, id_employee, id_file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (File_to_human file: file_to_humen) {
                statement = connection.prepareStatement("SELECT * FROM files where id = ?");
                statement.setInt(1, file.getId_file());
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id1 = resultSet.getInt("id");
                    String name1 = resultSet.getString("name1");
                    String path1  = resultSet.getString("path1");
                    String type1  = resultSet.getString("type1");
                    fileSavers.add(new FileSaver(type1, name1, Files.readAllBytes(Path.of(path1))));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        assert statement != null;
        statement.close();
        return fileSavers;
    }


    public void updateEmployee(Employee employee){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE employee SET name=?, middle_name=?, surname=?, phone_number=?, dolzhnost=?, datePriema=?, pass=?, login=?, trud_dogovor=?, email=?  where id=?");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getMiddle_name());
            statement.setString(3, employee.getSurname());
            statement.setString(4, employee.getPhone_number());
            statement.setString(5, employee.getDolzhnost());
            statement.setString(6, employee.getDatePriema());
            statement.setString(7, employee.getPass());
            statement.setString(8, employee.getLogin());
            statement.setString(9, employee.getTrud_dogovor());
            statement.setString(10, employee.getEmail());
            statement.setInt(11, employee.getId());
            int rows = statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void writeFileToDb(Employee employee, FileSaver fileSaver){
        try{
            String name = fileSaver.getName();
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM files WHERE name1= ?");
            statement.setString(1, name);
            ResultSet resultSet0 = statement.executeQuery();
            int id = 2147483647;
            while (resultSet0.next()) {
                id = resultSet0.getInt("id");
            }
            if (id == 2147483647)
            {
                statement = connection.prepareStatement(
                        "INSERT INTO files (id, name1, path1, type1) VALUES (null, ?, ?, ?)");
                statement.setString(1, fileSaver.getName());
                statement.setString(2, fileSaver.getPath());
                statement.setString(3, fileSaver.getType());
                int rows = statement.executeUpdate();
                statement.close();
            }


            statement = connection.prepareStatement("SELECT id FROM files WHERE path1 = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }

            statement = connection.prepareStatement(
                    "INSERT INTO file_to_human (id, id_employee, id_file) VALUES (null, ?, ?)");
            statement.setInt(1, employee.getId());
            statement.setInt(2, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
