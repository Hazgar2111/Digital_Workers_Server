package sample;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;


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
                        FileSaver file = r.getFileSaver1();
                        String name = r.getName();
                        Request.SaveFile(name, file);
                    }
                    case "DELETE_FILE" -> {

                    }
                    case "UPDATE_EMPLOYEE" -> Request.updateeEmployee(r.getEmployees().get(0));

                }
            }


            inStream.close();
            outStream.close();
            socket.close();
        }catch (Exception ignored) {
        }
    }
}
