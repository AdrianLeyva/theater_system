package controller.show_manager.registration;

import model.Show;

import java.util.ArrayList;

public interface RegistrationProcess {
    void registerContactDataOfObraManager(String phone, String alternativePhone, String email);
    void registerObraData(String name, String description, String classification);
    void registerShows(ArrayList<Show> shows);
    void isAvailableShowDate(ArrayList<Show> shows);
}
