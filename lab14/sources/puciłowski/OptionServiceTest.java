package puciłowski;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.util.List;

public class OptionServiceTest {
    public static final MBeanServer SERVER = ManagementFactory.getPlatformMBeanServer();
    static OptionMBean proxy;
    public static void main(String[] args) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        int jmxPort = 8009;
        JMXServiceURL target = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + jmxPort + "/jmxrmi");
        JMXConnector connector = JMXConnectorFactory.connect(target);

        MBeanServerConnection mbs = connector.getMBeanServerConnection();

        ObjectName oname = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);
        String vendor = (String) mbs.getAttribute(oname, "VmVendor");
        System.out.println(vendor);
        proxy = JMX.newMXBeanProxy(mbs, new ObjectName("puciłowski:type=option"),
                OptionMBean.class);


        ClientGui clientGui = new ClientGui();
        clientGui.getAddButton().addActionListener(e->{
            proxy.add(Integer.parseInt(clientGui.getPriorityField().getText()),clientGui.getNameField().getText());
        });
        clientGui.getDeleteButton().addActionListener(e->{
            proxy.delete(clientGui.getNameField().getText());
        });

    }


    public static void log(Object msg) {
        System.out.println(msg);
    }
}
