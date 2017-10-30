package model;

import java.util.ArrayList;

public class Obra {
    private String id;
    private String name;
    private String description;
    private String classification;
    private String status;
    private ObraManager manager;
    private ArrayList<Show> showsList;

    public static final String CLASIFICATION_A = "CLASIFICATION_A";
    public static final String CLASIFICATION_B = "CLASIFICATION_B";
    public static final String CLASIFICATION_C = "CLASIFICATION_C";

    public static final String STATUS_AVAILABLE = "AVAILABLE";
    public static final String STATUS_CANCELLED = "CANCELLED";

    public Obra() {
    }

    public Obra(String id, String name, String description, String clasification,
                String status, ObraManager manager) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classification = clasification;
        this.status = status;
        this.manager = manager;
    }

    public Obra(String id, String name, String description, String classification,
                String status, ObraManager manager, ArrayList<Show> showsList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classification = classification;
        this.status = status;
        this.manager = manager;
        this.showsList = showsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClasification() {
        return classification;
    }

    public void setClasification(String clasification) {
        this.classification = clasification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ObraManager getManager() {
        return manager;
    }

    public void setManager(ObraManager manager) {
        this.manager = manager;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public ArrayList<Show> getShowsList() {
        return showsList;
    }

    public void setShowsList(ArrayList<Show> showsList) {
        this.showsList = showsList;
    }
}
