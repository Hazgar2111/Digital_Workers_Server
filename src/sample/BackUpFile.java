package sample;

import java.io.Serializable;
import java.sql.Timestamp;

public class BackUpFile  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id ;
    private int files_id;
    private String action1;
    private int kto_sdelal_employeeId;
    private int komu_sdelali_employeeId;
    java.sql.Timestamp date;



    public BackUpFile(int id, int files_id, String action1, int kto_sdelal_employeeId, int komu_sdelali_employeeId, java.sql.Timestamp date) {
        this.id = id;
        this.files_id = files_id;
        this.action1 = action1;
        this.kto_sdelal_employeeId = kto_sdelal_employeeId;
        this.komu_sdelali_employeeId =komu_sdelali_employeeId;
        this.date = date;

    }


    public int getKomu_sdelali_employeeId() {
        return komu_sdelali_employeeId;
    }

    public void setKomu_sdelali_employeeId(int komu_sdelali_employeeId) {
        this.komu_sdelali_employeeId = komu_sdelali_employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFiles_id() {
        return files_id;
    }

    public void setFiles_id(int files_id) {
        this.files_id = files_id;
    }

    public String getAction1() {
        return action1;
    }

    public void setAction1(String action1) {
        this.action1 = action1;
    }

    public int getKto_sdelal_employeeId() {
        return kto_sdelal_employeeId;
    }

    public void setKto_sdelal_employeeId(int kto_sdelal_employeeId) {
        this.kto_sdelal_employeeId = kto_sdelal_employeeId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
