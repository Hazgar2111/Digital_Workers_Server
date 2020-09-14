package sample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;

public class WriteFileToDb {
    public static void main(String[] args) throws IOException {
        DBManager dbManager = new DBManager();
        ArrayList<FileSaver> fileSavers = new ArrayList<>();
        String filePath = new File("").getAbsolutePath();
        String pathName = "БашеваВлада";

        String path1 = filePath + "/PrivateAffair/" + pathName + "/Внутренние Документы";
        String path2 = filePath + "/PrivateAffair/" + pathName + "/Командировки";
        String path3 = filePath + "/PrivateAffair/" + pathName + "/Корреспонденция Вход";
        String path4 = filePath + "/PrivateAffair/" + pathName + "/Корреспонденция Исход";
        String path5 = filePath + "/PrivateAffair/" + pathName + "/Личный Состав";
        String path6 = filePath + "/PrivateAffair/" + pathName + "/Производство";

        File dir1 = new File(path1);
        File dir2 = new File(path2);
        File dir3 = new File(path3);
        File dir4 = new File(path4);
        File dir5 = new File(path5);
        File dir6 = new File(path6);

        File[] arrFiles1 = dir1.listFiles();
        File[] arrFiles2 = dir2.listFiles();
        File[] arrFiles3 = dir3.listFiles();
        File[] arrFiles4 = dir4.listFiles();
        File[] arrFiles5 = dir5.listFiles();
        File[] arrFiles6 = dir6.listFiles();

        for (int i = 0; i < Objects.requireNonNull(arrFiles1).length; i++) {
            fileSavers.add(new FileSaver("Внутренние Документы", arrFiles1[i].getName(), arrFiles1[i].getAbsolutePath()));
        }
        for (int i = 0; i < Objects.requireNonNull(arrFiles2).length; i++) {
            fileSavers.add(new FileSaver("Командировки", arrFiles2[i].getName(), arrFiles2[i].getAbsolutePath()));
        }
        for (int i = 0; i < Objects.requireNonNull(arrFiles3).length; i++) {
            fileSavers.add(new FileSaver("Корреспонденция Вход", arrFiles3[i].getName(), arrFiles3[i].getAbsolutePath()));
        }
        for (int i = 0; i < Objects.requireNonNull(arrFiles4).length; i++) {
            fileSavers.add(new FileSaver("Корреспонденция Исход",  arrFiles4[i].getName(), arrFiles4[i].getAbsolutePath()));
        }
        for (int i = 0; i < Objects.requireNonNull(arrFiles5).length; i++) {
            fileSavers.add(new FileSaver("Личный Состав", arrFiles5[i].getName(), arrFiles5[i].getAbsolutePath()));
        }
        for (int i = 0; i < Objects.requireNonNull(arrFiles6).length; i++) {
            fileSavers.add(new FileSaver("Производство", arrFiles6[i].getName(), arrFiles6[i].getAbsolutePath()));
        }

        dbManager.connect();
        ArrayList<Employee> employees = dbManager.getEmployees();
        Employee temp = new Employee();
        for (Employee employee : employees)
        {
            if ((employee.getSurname() + employee.getName()).equals(pathName))
            {
                temp = employee;
            }
        }
        for (FileSaver fileSaver : fileSavers) {
           dbManager.writeFileToDb(temp, fileSaver);
        }
    }
}
