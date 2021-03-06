package sample;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;

public class FileSaver implements Serializable {
    private static final long serialVersionUID=1L;
    private String type;
    private String oldType;
    private File file;
    private String name;
    private String oldName;
    private byte[] fileBytes;
    private int edit;
    private int id;
    private String path;
    private java.sql.Timestamp dateTime;
    private String desc;


    public FileSaver() {
    }


    public FileSaver(String type, String name, String path) {
        this.type = type;
        this.name = name;
        this.path = path;
    }


    public FileSaver(String type, String name, String path, int id) {
        this.type = type;
        this.name = name;
        this.path = path;
        this.id = id;

    }


    public FileSaver(String type, String name, byte[] fileBytes, int id, java.sql.Timestamp dateTime) {
        this.type = type;
        this.name = name;
        this.fileBytes = fileBytes;
        this.id = id;
        this.dateTime = dateTime;
    }

    public FileSaver(String type, String name, byte[] fileBytes, int id, java.sql.Timestamp dateTime, String desc) {
        this.type = type;
        this.name = name;
        this.fileBytes = fileBytes;
        this.id = id;
        this.dateTime = dateTime;
        this.desc = desc;
    }

    public FileSaver(String type, String name, byte[] fileBytes, String desc) {
        this.type = type;
        this.name = name;
        this.fileBytes = fileBytes;
        this.desc = desc;
    }

    public FileSaver(String type, String oldType,String name, String oldName, byte[] fileBytes, int id) {
        this.type = type;
        this.oldType= oldType;
        this.name = name;
        this.oldName = oldName;
        this.fileBytes = fileBytes;
        this.id = id;
    }


    public FileSaver(String type, File file) {
        this.type = type;
        this.file = file;
    }

    public FileSaver(String type, String name, String path1, String desc) {
        this.type = type;
        this.name = name;
        this.path = path1;
        this.desc = desc;
    }


    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getPath() {
        return path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }

    public String getOldType() {
        return oldType;
    }

    public void setOldType(String oldType) {
        this.oldType = oldType;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
