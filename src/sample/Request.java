package sample;


import java.io.*;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.nio.file.Files;

public class Request implements Serializable {
    private static final long serialVersionUID=1L;
    private String operationType;
    private static final DBManager manager = new DBManager();
    private ArrayList<Employee> employees;
    private ArrayList<File> files;
    private String name;
    private AllUserData allUserData;
    private FileSaver fileSaver1;
    private int id;


    public static String encodeImage(byte[] imageByteArray) {
        return Base64.getEncoder().encodeToString(imageByteArray);
    }


    public static byte[] decodeImage(String imageDataString) {
        return Base64.getDecoder().decode(imageDataString);
    }


    public Request() {

    }


    public Request(String operationType, AllUserData allUserData, String name) {
        this.operationType = operationType;
        this.allUserData = allUserData;
        this.name = name;
    }


    public Request(String operationType, FileSaver fileSavers, String name, int check) {
        this.operationType = operationType;
        this.fileSaver1 = fileSavers;
        this.name = name;
    }

    public Request(String operationType, ArrayList<File> files, String name) {
        this.operationType = operationType;
        this.files = files;
        this.name = name;
    }


    public Request(String operationType, ArrayList<Employee> employees) {
        this.operationType = operationType;
        this.employees = employees;
    }


    public static ArrayList<Employee> returnEmployee(){
        ArrayList<Employee> employees;
        employees=manager.getEmployees();
        return employees;
    }


    public static void updateeEmployee(Employee employee){
        manager.updateEmployee(employee);
    }


    public static AllUserData getFiles(String path, int id) throws IOException, SQLException {
        ArrayList<FileSaver> fileSavers = manager.getFiles(id);
        String filePath = new File("").getAbsolutePath();

        File imageFile = new File(filePath + "/PrivateAffair/" + path + "/" + "photo.png");
        byte[] bytesImage = Files.readAllBytes(imageFile.toPath());

        return new AllUserData(fileSavers, bytesImage, path);
    }


    public static void SaveFile(String path, FileSaver fileSaver) throws IOException {
        String filePath = new File("").getAbsolutePath();
        String path1 = filePath + "/PrivateAffair/" + path + "/" + fileSaver.getType() + "/" + fileSaver.getName();
        File file = new File(path1);
        if (!file.exists())
        {
            String delete = filePath + "/PrivateAffair/" + path + "/" + fileSaver.getOldType() + "/" + fileSaver.getOldName();
            File fileDelete = new File(delete);
            if (!fileDelete.exists())
            {
                Files.write(Path.of(path1), fileSaver.getFileBytes());
            }
            else
            {
                Files.delete(Path.of(delete));
                Files.write(Path.of(path1), fileSaver.getFileBytes());
            }

        }
        else
        {
            System.out.println("Else " + path1);
            Files.write(Path.of(path1), fileSaver.getFileBytes());
        }

    }

    public static void DeleteFile(String path, FileSaver fileSaver) throws IOException {
        String filePath = new File("").getAbsolutePath();
        String path1 = filePath + "/PrivateAffair/" + path + "/" + fileSaver.getType() + "/" + fileSaver.getName();
        String pathBackUp = filePath + "/backUpFiles/" + path + "/" + fileSaver.getType() + "/" + fileSaver.getName();
        File file = new File(path1);
        Files.write(Path.of(path1), fileSaver.getFileBytes());
        if(file.delete())
        {
            System.out.println("файл удален");
        }
        else System.out.println("Файла не обнаружено");

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
}
