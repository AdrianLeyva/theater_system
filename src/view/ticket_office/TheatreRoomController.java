package view.ticket_office;

import view.ticket_office.SeatsHandler.*;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TheatreRoomController {

    private final TheatreRoom view;

    public TheatreRoomController() {
        view = new TheatreRoom();
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
            case "Available":
                switch (seat.getZone().getZoneType()) {
                    case "Broad":
                        seatButton.setBackground(seat.getColor());//cambio de color
                        break;
                    case "Silver":
                        seatButton.setBackground(seat.getColor());
                        break;
                    case "Copper":
                        seatButton.setBackground(seat.getColor());
                        break;
                    case "Gold":
                        seatButton.setBackground(seat.getColor());
                        break;
                    case "Diamond":
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
                    } else {
                        seatButton.setBackground(seat.getColor());
                    }
                }
            }
        });

        return seatButton;
    }

}
