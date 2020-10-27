package sample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class WriteFileToDb {
    public static void main(String[] args) throws IOException {
        DBManager dbManager = new DBManager();
        String filePath = new File("").getAbsolutePath();

        String pathTemp = filePath + "\\FilesRepository\\" + "HR\\";
        String patha = filePath + "/PrivateAffair/";
        File dira = new File(patha);
        File[] arrFilesa = dira.listFiles();

        for (int i=0; i< Objects.requireNonNull(arrFilesa).length; i++) {
            ArrayList<FileSaver> fileSavers = new ArrayList<>();
            String pathName = arrFilesa[i].toString();
            int index = pathName.lastIndexOf("\\");
            String nameEmployee = pathName.substring(index+1);


            System.out.println(nameEmployee);
            String path1 = pathName + "\\Внутренние Документы";
            String path2 = pathName + "\\Командировки";
            String path3 = pathName + "\\Корреспонденция Вход";
            String path4 = pathName + "\\Корреспонденция Исход";
            String path5 = pathName + "\\Личный Состав";
            String path6 = pathName + "\\Производство";

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

            for (int j = 0; j < Objects.requireNonNull(arrFiles1).length; j++) {
                fileSavers.add(new FileSaver("Внутренние Документы", arrFiles1[j].getName(), pathTemp+arrFiles1[j].getName()));
                File temp = new File(pathTemp + arrFiles1[j].getName());
                if (!temp.exists())
                    Files.copy(Path.of(arrFiles1[j].getAbsolutePath()), Path.of(pathTemp + arrFiles1[j].getName()));
            }
            for (int j = 0; j < Objects.requireNonNull(arrFiles2).length; j++) {
                fileSavers.add(new FileSaver("Командировки", arrFiles2[j].getName(), pathTemp+arrFiles2[j].getName()));
                File temp = new File(pathTemp + arrFiles2[j].getName());
                if (!temp.exists())
                    Files.copy(Path.of(arrFiles2[j].getAbsolutePath()), Path.of(pathTemp + arrFiles2[j].getName()));
            }
            for (int j = 0; j < Objects.requireNonNull(arrFiles3).length; j++) {
                fileSavers.add(new FileSaver("Корреспонденция Вход", arrFiles3[j].getName(), pathTemp+arrFiles3[j].getName()));
                File temp = new File(pathTemp + arrFiles3[j].getName());
                if (!temp.exists())
                    Files.copy(Path.of(arrFiles3[j].getAbsolutePath()), Path.of(pathTemp + arrFiles3[j].getName()));
            }
            for (int j = 0; j < Objects.requireNonNull(arrFiles4).length; j++) {
                fileSavers.add(new FileSaver("Корреспонденция Исход",  arrFiles4[j].getName(), pathTemp+arrFiles4[j].getName()));
                File temp = new File(pathTemp + arrFiles4[j].getName());
                if (!temp.exists())
                    Files.copy(Path.of(arrFiles4[j].getAbsolutePath()), Path.of(pathTemp + arrFiles4[j].getName()));
            }
            for (int j = 0; j < Objects.requireNonNull(arrFiles5).length; j++) {
                fileSavers.add(new FileSaver("Личный Состав", arrFiles5[j].getName(), pathTemp+arrFiles5[j].getName()));
                File temp = new File(pathTemp + arrFiles5[j].getName());
                if (!temp.exists())
                    Files.copy(Path.of(arrFiles5[j].getAbsolutePath()), Path.of(pathTemp + arrFiles5[j].getName()));
            }
            for (int j = 0; j < Objects.requireNonNull(arrFiles6).length; j++) {
                fileSavers.add(new FileSaver("Производство", arrFiles6[j].getName(), pathTemp+arrFiles6[j].getName()));
                File temp = new File(pathTemp + arrFiles6[j].getName());
                if (!temp.exists())
                    Files.copy(Path.of(arrFiles6[j].getAbsolutePath()), Path.of(pathTemp + arrFiles6[j].getName()));
            }


            dbManager.connect();
            ArrayList<Employee> employees = dbManager.getEmployees();
            Employee temp = new Employee();
            for (Employee employee : employees)
            {
                if ((employee.getSurname() + employee.getName()).equals(nameEmployee))
                {
                    temp = employee;
                }
            }
            ArrayList<Employee> req = new ArrayList<>();
            req.add(temp);
            for (FileSaver fileSaver : fileSavers) {
                dbManager.writeFileToDb(req, fileSaver);
            }


        }



        /*
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


         */
        /*
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


         */
    }

}
