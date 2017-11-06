package view.show_manager.registration;

public interface RegistrationManagerContract {
    boolean validateFields();
    boolean isValidDateFormat();
    boolean isValidTimeFormat();
}
