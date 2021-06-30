package puciłowski;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanException, InstanceNotFoundException, ReflectionException, IOException, AttributeNotFoundException {
        AppGui app = new AppGui();
        TicketAutomachine machine = new TicketAutomachine();
        machine.connect();
        machine.app = app;
        app.getGenerateButton().addActionListener(e->{
            machine.generateTicket(app);
            machine.refreshTable();
        });
        machine.run();
    }
}
