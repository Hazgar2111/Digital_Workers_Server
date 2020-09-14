package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainMenuServer.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        int count = 0;
        //launch(args);
        try {
            DBManager manager = new DBManager();
            manager.connect();
            ServerSocket server = new ServerSocket(4444);
            while (true) {
                System.out.println("Waiting for a client");
                Socket socket = server.accept();
                System.out.println("Client " + (count + 1) + ": connected");
                ServerRunnable sr = new ServerRunnable(socket);
                sr.start();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
