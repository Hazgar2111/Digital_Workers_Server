package sample;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class AllUserData  implements Serializable {
    private static final long serialVersionUID=1L;
    private ArrayList<FileSaver> fileSavers;
    private byte[] image;
    private String surnameName;


    public AllUserData(ArrayList<FileSaver> fileSavers, byte[] image, String surnameName) {
        this.fileSavers = fileSavers;
        this.image = image;
        this.surnameName =surnameName;
    }

    public String getSurnameName() {
        return surnameName;
    }

    public ArrayList<FileSaver> getFileSavers() {
        return fileSavers;
    }

    public void setFileSavers(ArrayList<FileSaver> fileSavers) {
        this.fileSavers = fileSavers;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
