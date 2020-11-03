package sample;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.nio.file.Files;

public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    private String operationType;
    private static final DBManager manager = new DBManager();
    private ArrayList<Employee> employees;
    private Employee employee;
    private ArrayList<File> files;
    private String name;
    private AllUserData allUserData;
    private FileSaver fileSaver1;
    private int id;
    private int employee_id_kto;
    private int employee_id_komu;
    private ArrayList<BackUpFile> backUpFiles;
    private ArrayList<File_to_human> file_to_humen;
    private java.sql.Timestamp date;
    private int file_id;
    private int employee_id;
    private String type;
    private ArrayList<FileSaver> fileSavers;


    public Request() {

    }

    public Request(String operationType, AllUserData allUserData, String name) {
        this.operationType = operationType;
        this.allUserData = allUserData;
        this.name = name;
    }

    public Request(String operationType, ArrayList<Employee> employees) {
        this.operationType = operationType;
        this.employees = employees;
    }

    public Request(String operationType, FileSaver fileSavers) {
        this.operationType = operationType;
        this.fileSaver1 = fileSavers;
    }

    public Request(String operationType, Employee employee) {
        this.operationType = operationType;
        this.employee = employee;
    }

    public Request(String operationType, ArrayList<BackUpFile> backUpFiles, int check) {
        this.operationType = operationType;
        this.backUpFiles = backUpFiles;
    }

    public Request(String operationType, ArrayList<File_to_human> file_to_humen, boolean check) {
        this.operationType = operationType;
        this.file_to_humen = file_to_humen;
    }

    public Request(String operationType, ArrayList<FileSaver> fileSavers, String type) {
        this.operationType = operationType;
        this.fileSavers = fileSavers;
        this.type = type;
    }


    public static ArrayList<Employee> returnEmployee() {
        ArrayList<Employee> employees;
        employees = manager.getEmployees();
        return employees;
    }


    public static ArrayList<BackUpFile> returnBackup() {
        ArrayList<BackUpFile> backUpFiles;
        backUpFiles = manager.getBackup();
        return backUpFiles;
    }


    public static AllUserData getFiles(String path, int id) throws IOException, SQLException {
        ArrayList<FileSaver> fileSavers = manager.getFiles(id, false);
        String filePath = new File("").getAbsolutePath();

        File imageFile = new File(filePath + "\\FilesRepository\\photo\\" + path + ".png");
        byte[] bytesImage = Files.readAllBytes(imageFile.toPath());

        return new AllUserData(fileSavers, bytesImage, path);
    }


    public static void updateEmployee(Employee employee) {
        manager.updateEmployee(employee);
    }


    public static void SaveFile(ArrayList<Employee> employees, FileSaver fileSaver) throws IOException {
        String filePath = new File("").getAbsolutePath();
        String path1 = filePath + "/FilesRepository/HR/" + fileSaver.getName();
        File file = new File(path1);
        if (!file.exists()) {
            String delete = filePath + "FilesRepository/HR/" + fileSaver.getOldName();
            File fileDelete = new File(delete);
            if (!fileDelete.exists()) {
                Files.write(Path.of(path1), fileSaver.getFileBytes());
            } else {
                Files.delete(Path.of(delete));
                Files.write(Path.of(path1), fileSaver.getFileBytes());
            }


        } else {
            Files.write(Path.of(path1), fileSaver.getFileBytes());
        }
        FileSaver temp1 = new FileSaver(fileSaver.getType(), fileSaver.getName(), path1, fileSaver.getDesc());

        manager.writeFileToDb(employees, temp1);
    }


    public static void editFile(FileSaver fileSaver, Employee employee) throws IOException, SQLException {
        String filePath = new File("").getAbsolutePath();
        String path1 = filePath + "/FilesRepository/HR/" + fileSaver.getName();
        String delete = filePath + "/FilesRepository/HR/" + fileSaver.getOldName();

        File fileDelete = new File(delete);
        if (!fileDelete.exists()) {

            Files.write(Path.of(path1), fileSaver.getFileBytes());
        } else {
            Files.delete(Path.of(delete));
            Files.write(Path.of(path1), fileSaver.getFileBytes());
            FileSaver temp = new FileSaver(fileSaver.getType(), fileSaver.getName(), path1, fileSaver.getId());
            manager.updateFiles(temp);
        }
    }


    public static void deleteFile(int file_id, int employe_id, int employe_id_komu, java.sql.Timestamp date) throws IOException, SQLException {
        String filePath = new File("").getAbsolutePath();
        FileSaver fileSaver = manager.getOneFile(file_id);
        String path1 = fileSaver.getPath();
        String pathBackUp = filePath + "/BackUpFiles/" + fileSaver.getName();
        FileSaver temp = new FileSaver(fileSaver.getType(), fileSaver.getName(), pathBackUp, file_id);


        manager.updateFiles(temp);
        Files.copy(Path.of(path1), Path.of(pathBackUp), StandardCopyOption.REPLACE_EXISTING);


        manager.saveBackUp(file_id, employe_id, employe_id_komu, "Файл удален у всех сотрудников", date);
        manager.setManyFileToHuman(file_id, true);


    }


    public static void deleteHumanTofile(int file_id, int employe_id_kto, int employe_id_komu, java.sql.Timestamp date) throws SQLException {
        manager.setFileToHuman(file_id, employe_id_komu, true);
        manager.saveBackUp(file_id, employe_id_kto, employe_id_komu, "Файл удален у Сотрудника", date);
    }


    public static void deleteBackUpOneHuman(int id, int file_id, int komu_id) {
        manager.setFileToHuman(file_id, komu_id, false);
        manager.deleteBackup(id);
    }


    public static void deleteBackUpManyHuman(int id, int file_id) {
        manager.setManyFileToHuman(file_id, false);
        manager.deleteBackup(id);
    }


    public static FileSaver getOneFile(int file_id) throws SQLException, IOException {
        FileSaver fileSaver = manager.getOneFile(file_id);
        return new FileSaver(fileSaver.getType(), fileSaver.getName(), Files.readAllBytes(Path.of(fileSaver.getPath())), fileSaver.getId(), fileSaver.getDateTime());
    }


    public static ArrayList<FileSaver> getFilesCheckType(String type) throws SQLException {

        return manager.getFilesCheckType(type);
    }


    public static ArrayList<File_to_human> getFilesToHumanBackup(int file_id) throws SQLException {
        return manager.getFilesToHumanBackup(file_id);
    }


    public static Employee getOneEmployee(int id) {
        return manager.getOneEmployee(id);
    }



    public String getType() {
        return type;
    }

    public java.sql.Timestamp getDate() {
        return date;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setEmployee_id_kto(int employee_id_kto) {
        this.employee_id_kto = employee_id_kto;
    }

    public int getEmployee_id_komu() {
        return employee_id_komu;
    }

    public void setEmployee_id_komu(int employee_id_komu) {
        this.employee_id_komu = employee_id_komu;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public AllUserData getAllUserData() {
        return allUserData;
    }

    public FileSaver getFileSaver1() {
        return fileSaver1;
    }

    public void setFileSaver1(FileSaver fileSaver1) {
        this.fileSaver1 = fileSaver1;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id_kto() {
        return employee_id_kto;
    }
}
