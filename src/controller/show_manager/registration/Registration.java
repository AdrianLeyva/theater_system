package controller.show_manager.registration;

import controller.BaseController;
import model.Show;

import java.util.ArrayList;
/**
 * This class handles all registration processes of show manager module.
 * @author Adrián Leyva Sánchez
 */
public class Registration extends BaseController implements RegistrationProcess{

    public Registration() {
    }

    @Override
    protected void setupDependencies() {

    }

    @Override
    public void registerContactDataOfObraManager(String phone, String alternativePhone, String email) {

    }

    @Override
    public void registerObraData(String name, String description, String classification) {

    }

    @Override
    public void registerShows(ArrayList<Show> shows) {

    }

    @Override
    public void isAvailableShowDate(ArrayList<Show> shows) {

    }
}
