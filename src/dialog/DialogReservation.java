/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialog;

import interface_noyau_fonctionnel.InterfaceNoyauFonctionnel;
import java.awt.EventQueue;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.plaf.ComboBoxUI;
import presentation.FrameReservation;

public class DialogReservation {

    private FrameReservation frameReservation;
    private InterfaceNoyauFonctionnel inf;

    public DialogReservation(InterfaceNoyauFonctionnel inf) {
        this.inf = inf;
    }

    public void initDialog() {
        frameReservation = new FrameReservation();
        frameReservation.initFrame();
        frameReservation.setDialog(this);
        frameReservation.setVisible(true);
    }

    public void handleDateSelectedEvent(LocalDate date) {
        String[] listeHeure = inf.trouverHoraireDisponible(date);
        javax.swing.JComboBox<String> comboheure = new javax.swing.JComboBox<>(listeHeure);
        javax.swing.JComboBox<String> combo =frameReservation.getCombo1();
        combo.setModel(comboheure.getModel());
        combo.setEnabled(true);

        
        
    }

    public void handleTimeSelectedEvent(String time) {
        String[] listePersonne = inf.trouverNbPersonnes();
        javax.swing.JComboBox<String> comboNbpers = new javax.swing.JComboBox<>(listePersonne);
        javax.swing.JComboBox<String> combo =frameReservation.getCombo2();
        combo.setModel(comboNbpers.getModel());
        combo.setEnabled(true);
        
        
    }

    public void handleNumOfPersonsSelectedEvent(int nbPersons) {
        com.github.lgooddatepicker.components.DatePicker datepicker = frameReservation.getDatePicker();
        LocalDate datepanel = datepicker.getDate();
        String[] listeTable = inf.trouverTableDisponible(datepanel.getDayOfMonth(), datepanel.getMonthValue(), nbPersons, frameReservation.getCombo2().getSelectedItem().toString());
        javax.swing.JList<String> jlistTable = new javax.swing.JList<>(listeTable);
        javax.swing.JList<String> listT = frameReservation.getListe();
        listT.setModel(jlistTable.getModel());
        listT.setEnabled(true);
        javax.swing.JLabel image = frameReservation.getImage();
        image.setEnabled(true);
        
        
    }

    public void handleTableSelectedEvent(int numTable) {
        javax.swing.JButton button = frameReservation.getButton1();
        button.setEnabled(true);
        
    }

    public void handleCancelEvent() {
        DialogReservation dialog = frameReservation.getDialog();
        dialog.initDialog();
        frameReservation.setDialog(dialog);

     

    }

    public void handleValidationEvent() {
        com.github.lgooddatepicker.components.DatePicker datepicker = frameReservation.getDatePicker();
        LocalDate datepanel = datepicker.getDate();
        StringBuilder message = new StringBuilder();
        message.append("Reservation validée pour le ");
        message.append(datepicker.getDateStringOrEmptyString());
        message.append(" à ");
        message.append(frameReservation.getCombo1().getSelectedItem().toString());
        message.append(" pour ");
        message.append(frameReservation.getCombo2().getSelectedItem().toString());
        message.append(" personnes à la Table ");
        message.append(frameReservation.getListe().getSelectedValue());
        message.append(".");
     
        int choix = JOptionPane.showConfirmDialog(frameReservation, message.toString(), "Confirmation de réservation", JOptionPane.OK_CANCEL_OPTION, 1);
    }

    public static void main(String[] args) {
        DialogReservation dialog = new DialogReservation(new InterfaceNoyauFonctionnel());
        EventQueue.invokeLater(() -> {
            dialog.initDialog();
        });
    }

}
