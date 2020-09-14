package sample;

public class File_to_human {
    private int id1;
    private int id_employee;
    private int id_file;

    public int getId1() {
        return id1;
    }

    public int getId_employee() {
        return id_employee;
    }

    public int getId_file() {
        return id_file;
    }


    public File_to_human(int id1, int id_employee, int id_file) {
        this.id1 = id1;
        this.id_employee = id_employee;
        this.id_file = id_file;
    }
}
