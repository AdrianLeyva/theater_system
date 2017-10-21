package controller.obra_manager;

import controller.BaseController;
import model.Obra;
import model.ObraManager;
import model.Show;
import utils.FolioGenerator;

import java.util.ArrayList;
/**
 * This class handles all registration processes of show manager module.
 * @author Adrián Leyva Sánchez
 */
public class Registration extends BaseController{

    public Registration() {
    }

    @Override
    protected void setupDependencies() {

    }


    public void registerContactDataOfObraManager(String phone, String alternativePhone, String email) {
        ObraManager manager = new ObraManager();

        manager.setId(FolioGenerator.generateFolio());
        manager.setName(phone);
        manager.setBackupPhone(alternativePhone);
        manager.setEmail(email);

        /*
         * Insert query in postgresql
        */
    }

    public void registerObraData(String name, String description, String classification) {
        Obra obra = new Obra();

        obra.setId(FolioGenerator.generateFolio());
        obra.setName(name);
        obra.setDescription(description);
        obra.setClasification(classification);
        /*
         * Insert query in postgresql
        */
    }

    public void registerShows(ArrayList<Show> shows) {
        /*
         * Insert query in postgresql
        */
    }


    public void isAvailableShowDate(ArrayList<Show> shows) {
        /*
         * Insert query in postgresql
        */
    }
}
