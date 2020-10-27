package sample;

import java.io.Serializable;

public class File_to_human implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id1;
    private int id_employee;
    private int id_file;
    private boolean edirOrno;

    public int getId1() {
        return id1;
    }

    public int getId_employee() {
        return id_employee;
    }

    public int getId_file() {
        return id_file;
    }


    public File_to_human(int id1, int id_employee, int id_file, boolean edirOrno) {
        this.id1 = id1;
        this.id_employee = id_employee;
        this.id_file = id_file;
        this.edirOrno = edirOrno;
    }
}
