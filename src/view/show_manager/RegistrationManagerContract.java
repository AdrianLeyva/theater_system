package view.show_manager;

public interface RegistrationManagerContract {
    boolean validateFields();
    boolean isValidDateFormat();
    boolean isValidTimeFormat();
}
