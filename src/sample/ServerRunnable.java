package sample;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class ServerRunnable extends Thread implements Serializable {

    private final Socket socket;
    public ServerRunnable(Socket socket){
        this.socket = socket;
    }


    public void run(){
        Request request = new Request();
        Request r;
        try{
            ObjectOutputStream outStream =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inStream=
                    new ObjectInputStream(socket.getInputStream());


            while((r=(Request)inStream.readObject())!=null)
            {
                switch (r.getOperationType()) {
                    default -> outStream.writeObject("НЕ В ЭТОТ РАЗ! :)"); //отброс всех лишних пакетов
                    case "LIST_EMPLOYEES" -> {
                        ArrayList<Employee> employees = Request.returnEmployee();
                        Request data = new Request("LIST_EMPLOYEES", employees);
                        outStream.writeObject(data);
                    }
                    case "LIST_FILES" -> {
                        AllUserData files = Request.getFiles(r.getName(), r.getId());
                        Request data = new Request("LIST_FILES", files, r.getName());
                        outStream.writeObject(data);
                    }
                    case "SAVE_FILE" -> {
                        Request.SaveFile(r.getEmployees(), r.getFileSaver1());
                    }
                    case "EDIT_FILE" -> {
                        Request.editFile(r.getFileSaver1(), r.getEmployees().get(0));
                    }
                    case "DELETE_FILE" -> {
                        Request.deleteFile(r.getId(), r.getEmployee_id_kto(), 2147483647, r.getDate());
                    }
                    case "DELETE_HUMAN_TO_FILE" -> {
                        Request.deleteHumanTofile(r.getId(), r.getEmployee_id_kto(), r.getEmployee_id_komu(), r.getDate());
                    }
                    case "LIST_BACKUP" -> {
                        ArrayList<BackUpFile> backUpFiles = Request.returnBackup();
                        Request data = new Request("LIST_BACKUP", backUpFiles, 1);
                        outStream.writeObject(data);
                    }
                    case "DELETE_BACKUP" -> {
                        Request.deleteBackUpOneHuman(r.getId(), r.getFile_id(), r.getEmployee_id_komu());
                    }
                    case "DELETE_BACKUP_MANY" -> {
                        Request.deleteBackUpManyHuman(r.getId(), r.getFile_id());
                    }
                    case "LIST_HUMAN_BACKUP" -> {
                        ArrayList<File_to_human> backUpFiles = Request.getFilesToHumanBackup(r.getId());
                        Request data = new Request("LIST_BACKUP", backUpFiles, true);
                        outStream.writeObject(data);
                    }
                    case "ONE_FILE" -> {
                        FileSaver fileSaver = Request.getOneFile(r.getId());
                        Request data = new Request("ONE_FILE", fileSaver);
                        outStream.writeObject(data);
                    }
                    case "ONE_EMPLOYEE" -> {
                        Employee employee = Request.getOneEmployee(r.getId());
                        Request data = new Request("ONE_EMPLOYEE", employee);
                        outStream.writeObject(data);
                    }
                    case "LIST_FILES_TYPE" -> {
                        ArrayList<FileSaver> fileSaver = Request.getFilesCheckType(r.getType());
                        Request data = new Request("LIST_FILES_TYPE", fileSaver, r.getType());
                        outStream.writeObject(data);
                    }
                    case "UPDATE_EMPLOYEE" -> Request.updateEmployee(r.getEmployees().get(0));

                }
            }


            inStream.close();
            outStream.close();
            socket.close();
        }catch (Exception ignored) {
        }
    }
}
