package app;

import api.ClusterAnalysisService;
import api.ClusteringException;
import api.DataSet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;

public class AppController {
    public AppController(){
        List<ClusterAnalysisService> myServices = new ArrayList<>(2);
        AppView view = new AppView();
        view.getLoadButton().addActionListener(e->createDataSet(Integer.parseInt(view.getSizeField().getText()),
                Integer.parseInt(view.getMinField().getText()),
                Integer.parseInt(view.getMaxField().getText()),
                Integer.parseInt(view.getMinYField().getText()),
                Integer.parseInt(view.getMaxYField().getText()),view,myServices));

    }

    private void kmeansFunction(List<ClusterAnalysisService> myServices, AppView view, int size, int[][] dataInt,DataSet dataSet) throws ClusteringException {
        ServiceLoader<ClusterAnalysisService> loader = ServiceLoader.load(ClusterAnalysisService.class);
        for(ClusterAnalysisService myService : loader)
        {
            myServices.add(myService);
        }

        myServices.get(0).submit(dataSet);
        DataSet resultSet = new DataSet();
        resultSet = myServices.get(0).retrieve(true);
        String[][] result;
        result = resultSet.getData();
        String[][] data = dataSet.getData();
        String[][] resultClusters = resultSet.getData();
        GraphPanel panel = new GraphPanel(size,data,resultClusters);
        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public DataSet createDataSet(int size,int minX_stored,int maxX_stored,int minY_stored,int maxY_stored,AppView view,List<ClusterAnalysisService> myServices){
        Random random = new Random();
        DataSet dataSet = new DataSet();
        String[][] data = new String[size][2];
        int[][] dataInt = new int[size][2];
        double minX = minX_stored;
        double minY = minY_stored;
        double maxX = maxX_stored;
        double maxY = maxY_stored;
        for(int i = 0;i<size;i++){
            dataInt[i][0]=(int) (minX + (maxX - minX) * random.nextDouble());
            data[i][0]=String.valueOf(dataInt[i][0]);
            dataInt[i][1]=(int) (minY + (maxY - minY) * random.nextDouble());
            data[i][1]=String.valueOf(dataInt[i][1]);
        }

        dataSet.setData(data);
        view.getKmeansButton().addActionListener(e-> {
            try {
                kmeansFunction(myServices,view,size,dataInt,dataSet);
            } catch (ClusteringException clusteringException) {
                clusteringException.printStackTrace();
            }
        });
        return dataSet;
    }
}
