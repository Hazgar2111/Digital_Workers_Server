package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBManager {

    private static Connection connection;


    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/digital_workers?useUnicode=true&serverTimezone=UTC", "root", "123"
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


    public ArrayList<FileSaver> getFiles(int id, boolean editOrno) throws SQLException {
        ArrayList<FileSaver> fileSavers = new ArrayList<>();
        ArrayList<File_to_human> file_to_humen = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM file_to_human where id_employee =? AND editOrno = ?");
            statement.setInt(1, id);
            statement.setBoolean(2, editOrno);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                int id_employee = resultSet.getInt("id_employee");
                int id_file = resultSet.getInt("id_file");
                boolean editOrno1 = resultSet.getBoolean("editOrno");
                boolean delOrno1 = resultSet.getBoolean("delOrno");
                file_to_humen.add(new File_to_human(id1, id_employee, id_file, editOrno1, delOrno1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (File_to_human file : file_to_humen) {
                statement = connection.prepareStatement("SELECT * FROM files where id = ?");
                statement.setInt(1, file.getId_file());
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id1 = resultSet.getInt("id");
                    String name1 = resultSet.getString("name1");
                    String path1 = resultSet.getString("path1");
                    String type1 = resultSet.getString("type1");
                    java.sql.Timestamp dateTime = resultSet.getTimestamp("dateTime");
                    fileSavers.add(new FileSaver(type1, name1, Files.readAllBytes(Path.of(path1)), id1, dateTime));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        assert statement != null;
        statement.close();
        return fileSavers;
    }


    public void updateEmployee(Employee employee) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void writeFileToDb(ArrayList<Employee> employees, FileSaver fileSaver) {
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp date = new java.sql.Timestamp(utilDate.getTime());
            String name = fileSaver.getName();
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM files WHERE name1= ?");
            statement.setString(1, name);
            ResultSet resultSet0 = statement.executeQuery();
            int id = 2147483647;
            while (resultSet0.next()) {
                id = resultSet0.getInt("id");
            }
            if (id == 2147483647) {
                statement = connection.prepareStatement(

                        "INSERT INTO files (id, name1, path1, type1, dateTime, description) VALUES (null, ?, ?, ?, ?, ?)");
                statement.setString(1, fileSaver.getName());
                statement.setString(2, fileSaver.getPath());
                statement.setString(3, fileSaver.getType());
                statement.setTimestamp(4, date);
                statement.setString(5, fileSaver.getDesc());
                int rows = statement.executeUpdate();
                statement.close();
            }


            String path = fileSaver.getPath();
            statement = connection.prepareStatement("SELECT id FROM files WHERE path1 = ?");
            statement.setString(1, path);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            statement.close();

            for (Employee employee : employees) {
                statement = connection.prepareStatement(
                        "INSERT INTO file_to_human (id, id_employee, id_file, editOrNo) VALUES (null, ?, ?, ?)");
                statement.setInt(1, employee.getId());
                statement.setInt(2, id);
                statement.setBoolean(3, false);

                int rows = statement.executeUpdate();
                statement.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateFiles(FileSaver fileSaver) {
        // System.out.println("UpdateFiles: " + fileSaver.getId() + " " + fileSaver.getName()+ " " + fileSaver.getPath()+ " " + fileSaver.getType());
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE files SET name1=?, path1=?, type1=? where id=?");
            statement.setString(1, fileSaver.getName());
            statement.setString(2, fileSaver.getPath());
            statement.setString(3, fileSaver.getType());
            statement.setInt(4, fileSaver.getId());

            int rows = statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveBackUp(int file_id, int employee_id_Kto, int komu_sdelali_employeeId, String action, java.sql.Timestamp sqlTS) throws SQLException {
        PreparedStatement statement;
        if (komu_sdelali_employeeId == 2147483647) {
            statement = connection.prepareStatement(
                    "INSERT INTO backup (id, files_id, action1, kto_sdelal_employeeId, komu_sdelali_employeeId, dateTime ) VALUES (null, ?, ?, ?, null, ?)");
            statement.setInt(1, file_id);
            statement.setString(2, action);
            statement.setInt(3, employee_id_Kto);
            statement.setTimestamp(4, sqlTS);
        } else {
            statement = connection.prepareStatement(
                    "INSERT INTO backup (id, files_id, action1, kto_sdelal_employeeId, komu_sdelali_employeeId, dateTime ) VALUES (null, ?, ?, ?, ?, ?)");
            statement.setInt(1, file_id);
            statement.setString(2, action);
            statement.setInt(3, employee_id_Kto);
            statement.setInt(4, komu_sdelali_employeeId);
            statement.setTimestamp(5, sqlTS);
        }
        int rows = statement.executeUpdate();
        statement.close();
    }


    public ArrayList<BackUpFile> getBackup() {
        ArrayList<BackUpFile> backUpFiles = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM backup");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int files_id = resultSet.getInt("files_id");
                String action1 = resultSet.getString("action1");
                int kto_sdelal_employeeId = resultSet.getInt("kto_sdelal_employeeId");
                int komu_sdelali_employeeId = resultSet.getInt("komu_sdelali_employeeId");
                java.sql.Timestamp dateTime = resultSet.getTimestamp("dateTime");
                backUpFiles.add(new BackUpFile(id, files_id, action1, kto_sdelal_employeeId, komu_sdelali_employeeId, dateTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return backUpFiles;
    }


    public void deleteBackup(int backup_id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM backup WHERE id = ?"
            );
            statement.setInt(1, backup_id);
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteFile(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM files WHERE id = ?"
            );
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setFileToHuman(int file_id, int employee_id, boolean ediOrno) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE file_to_human SET editOrNo=? WHERE id_file = ? AND id_employee = ?"
            );
            statement.setBoolean(1, ediOrno);
            statement.setInt(2, file_id);
            statement.setInt(3, employee_id);
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setManyFileToHuman(int file_id, boolean ediOrno) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE file_to_human SET editOrNo=? WHERE id_file = ?"
            );
            statement.setBoolean(1, ediOrno);
            statement.setInt(2, file_id);
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Employee getOneEmployee(int id) {
        Employee employee = new Employee();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setMiddle_name(resultSet.getString("middle_name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setPhone_number(resultSet.getString("phone_number"));
                employee.setDolzhnost(resultSet.getString("dolzhnost"));
                employee.setDatePriema(resultSet.getString("datePriema"));
                employee.setPass(resultSet.getString("pass"));
                employee.setLogin(resultSet.getString("login"));
                employee.setTrud_dogovor(resultSet.getString("trud_dogovor"));
                employee.setEmail(resultSet.getString("email"));


            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }


    public FileSaver getOneFile(int id) throws SQLException {
        FileSaver fileSaver = new FileSaver();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM files where id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            fileSaver.setId(resultSet.getInt("id"));
            fileSaver.setName(resultSet.getString("name1"));
            fileSaver.setType(resultSet.getString("type1"));
            fileSaver.setPath(resultSet.getString("path1"));
            fileSaver.setDateTime(resultSet.getTimestamp("dateTime"));
        }

        return fileSaver;
    }


    public ArrayList<File_to_human> getFilesToHumanBackup(int file_id) {
        ArrayList<File_to_human> file_to_humen = new ArrayList<>();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM file_to_human where id_file = ? AND editOrno = ?");
            statement.setInt(1, file_id);
            statement.setBoolean(2, true);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                int id_employee = resultSet.getInt("id_employee");
                int id_file = resultSet.getInt("id_file");
                boolean editOrno1 = resultSet.getBoolean("editOrNo");
                boolean delOrno = resultSet.getBoolean("delOrNo");
                file_to_humen.add(new File_to_human(id1, id_employee, id_file, editOrno1, delOrno));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file_to_humen;
    }


    public ArrayList<FileSaver> getFilesCheckType(String type) throws SQLException {
        ArrayList<FileSaver> fileSavers = new ArrayList<>();

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM files where type1 = ?");
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name1 = resultSet.getString("name1");
                String path1 = resultSet.getString("path1");
                String type1 = resultSet.getString("type1");
                java.sql.Timestamp dateTime = resultSet.getTimestamp("dateTime");
                String description = resultSet.getString("description");
                fileSavers.add(new FileSaver(type1, name1, Files.readAllBytes(Path.of(path1)), id1, dateTime, description));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        assert statement != null;
        statement.close();
        return fileSavers;
    }
}
