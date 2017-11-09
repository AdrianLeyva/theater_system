package view.ticket_office;

import controller.ConstantsApp;
import model.Employee;
import model.Show;
import utils.DialogViewer;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class TheatreRoomController {

    private final TheatreRoom view;
    private Employee currentEmployee;
    private Show currentShow;
    private ArrayList<model.Seat> selectedSeats;


    public TheatreRoomController(Object object, Show show) {
        selectedSeats = new ArrayList<>();
        currentEmployee = (Employee)object;
        currentShow = show;
        view = new TheatreRoom(currentEmployee, currentShow, selectedSeats);

    }


    public void setSeats(Seat[][] seat) {
        for (int row = 7; row > -1; row--) {
            for (int column = 0; column < 20; column++) {
                view.getPanel1().add(this.createjButton(seat[column][row]));
            }
        }
        view.getPanel1().updateUI();
        view.setVisible(true);
    }

    private JButton createjButton(final Seat seat) {
        final JButton seatButton = new JButton(seat.getIdSeat());
        seatButton.setMargin(new Insets(1, 1, 1, 1));
        

        switch (seat.getStatus()) {
            case model.Seat.AVAILABLE_STATE:
                switch (seat.getZone().getZoneType()) {
                    case ConstantsApp.Seat.LATA:
                        seatButton.setBackground(seat.getColor());//cambio de color
                        break;
                    case ConstantsApp.Seat.SILVER:
                        seatButton.setBackground(seat.getColor());
                        break;
                    case ConstantsApp.Seat.BRONZE:
                        seatButton.setBackground(seat.getColor());
                        break;
                    case ConstantsApp.Seat.GOLD:
                        seatButton.setBackground(seat.getColor());
                        break;
                    case ConstantsApp.Seat.DIAMOND:
                        seatButton.setBackground(seat.getColor());
                        break;
                    default:
                        break;
                }
                break;
            case "Selled":
                seatButton.setBackground(Color.MAGENTA);
                seatButton.setEnabled(false);
                break;
            default:
                seatButton.setBackground(Color.cyan);
                seatButton.setEnabled(false);
                break;
        }
        seatButton.setOpaque(true);
        seatButton.setBorderPainted(true);
        seatButton.setEnabled(true);
        seatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                {
                    if(seatButton.getBackground().equals(seat.getColor())){
                        seatButton.setBackground(Color.red);
                        selectedSeats.add(new model.Seat(null, seat.getIdSeat(), seat.getStatus(),
                                seat.getZone().zoneType, currentShow.getId()));
                    } else {
                        seatButton.setBackground(seat.getColor());
                        selectedSeats.remove(seat);
                    }
                }
            }
        });

        return seatButton;
    }

}
