package model;

public class Obra {
    private String id;
    private String name;
    private String description;
    private String clasification;
    private String status;
    private ObraManager manager;

    public static final String CLASIFICATION_A = "CLASIFICATION_A";
    public static final String CLASIFICATION_B = "CLASIFICATION_B";
    public static final String CLASIFICATION_C = "CLASIFICATION_C";


    public Obra() {
    }

    public Obra(String id, String name, String description, String clasification,
                String status, ObraManager manager) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clasification = clasification;
        this.status = status;
        this.manager = manager;
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
        return clasification;
    }

    public void setClasification(String clasification) {
        this.clasification = clasification;
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
}
