package controller.reports_manager;

public interface ReportsManagerContract {
    void printCalendar();
    void validatePermissions(String id);
    void getTotalIncomes();
    void finishTicketOficce(String id);
}
