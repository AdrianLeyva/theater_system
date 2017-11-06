package controller.show_manager;

import controller.BaseController;
import controller.show_manager.cancellation.Cancellation;
import controller.show_manager.registration.Registration;
import controller.show_manager.reschedule.Reschedule;

/**
 * This class allows to handle the three implicit modules into show manager,
 * Registration, Cancellation, Reschedule.
 * @author Adrián Leyva Sánchez
 */
public class ShowManager extends BaseController{
    public Registration registration;
    public Cancellation cancellation;
    public Reschedule reschedule;

    public ShowManager() {
        setupDependencies();
    }

    @Override
    protected void setupDependencies() {
        this.registration = new Registration();
        this.cancellation = new Cancellation();
        this.reschedule = new Reschedule();
    }
}
