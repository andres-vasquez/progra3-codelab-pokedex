package bo.upb.programacion3.codelabpokedex.model;

import com.google.gson.annotations.Expose;

public class Pokemon {

    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private int image;

    @Expose
    private String type;

    public Pokemon(int id, String name, int image, String type) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
