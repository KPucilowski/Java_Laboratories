package puciłowski;

import java.util.ArrayList;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.management.ManagementFactory;
import java.util.Comparator;
import java.util.Optional;

public class TicketAutomachine implements Runnable{
    public static int numberCounter = 1;
    public static ArrayList<Ticket> ticketsArrayList = new ArrayList<>();
    DefaultTableModel modelA = new DefaultTableModel();
    AppGui app;
    Option option;
    ObjectName on;
    public static final MBeanServer SERVER = ManagementFactory.getPlatformMBeanServer();
    public void connect(){
        try {
            on = new ObjectName("puciłowski:type=option");
            option = new Option();
            SERVER.registerMBean(option, on);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    public void generateTicket(AppGui app){
        char symbol = 'X';
        int priority = 0;
            String name = app.getChooseBox().getSelectedItem().toString();
            symbol = name.substring(name.length() - 1).charAt(0);
            Optional<OptionChoose> opt = option.optionChooseList.stream().filter(obj->obj.name.equals(name)).findFirst();
            Ticket ticket = new Ticket(opt.get().getPriority(),symbol,numberCounter);
            ticketsArrayList.add(ticket);
            numberCounter++;
            refreshTable();
    }

    public void refreshTable() {
            modelA.setColumnCount(0);
            modelA.setRowCount(0);
            modelA.addColumn("Sprawa");
            for (Ticket ticket : ticketsArrayList) {
                    modelA.addRow(new Object[]{ticket.getName()});
                    app.getTableA().setModel(modelA);
            }

        }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for(int i=app.getChooseBox().getItemCount()-1;i>=0;i--){
                app.getChooseBox().removeItemAt(i);
            }
            option.optionChooseList.stream().forEach(e->{
                app.getChooseBox().addItem(e.name);
            });
            Comparator<Ticket> comparator = Comparator.comparing( Ticket::getPriority );
            if(!ticketsArrayList.isEmpty()) {
                Ticket maxObject = ticketsArrayList.stream().max(comparator).get();
                ticketsArrayList.remove(maxObject);
                refreshTable();
                app.getIdField().setText(maxObject.getName());
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            app.getIdField().setText("");
        }
    }
}
