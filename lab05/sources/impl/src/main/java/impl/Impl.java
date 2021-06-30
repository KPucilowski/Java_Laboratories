package impl;

import api.ClusterAnalysisService;
import api.ClusteringException;
import api.DataSet;

import java.util.ArrayList;
import java.util.Random;

public class Impl implements ClusterAnalysisService {
    public ArrayList<Point> points = new ArrayList<>();
    public ArrayList<Cluster> result = new ArrayList<>();
    int k;
    int size;
    String[][] data = {{}};
    private class Point{
        private int x;
        private int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
        double getDistance(Cluster c,Point p){
            return Math.sqrt(Math.pow((c.getX()-p.x),2)+Math.pow((c.getX()-p.x),2));
        }
    }
    private class Cluster extends Point{
        ArrayList<Point> assignedPoints = new ArrayList<>();
        boolean flag;
        public double distance;
        public Cluster(int x, int y) {
            super(x, y);
            assignedPoints = new ArrayList<>();
            flag=false;
        }

        public ArrayList<Point> getAssignedPoints() {
            return assignedPoints;
        }

        public void setAssignedPoints(ArrayList<Point> assignedPoints) {
            this.assignedPoints = assignedPoints;
        }

        public boolean getFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
        private void setDistances(){
            double max = 0;
            for(Point point : assignedPoints){
                if(point.getDistance(this,point) > max){
                    max = point.getDistance(this,point);
                }
            }
            distance = max;
        }
        public ArrayList<Double> getDistances(){
            ArrayList<Double> returnList = new ArrayList<>();
            for(Cluster cluster : result){
                cluster.setDistances();
                returnList.add(cluster.distance);
            }
            return returnList;
        }
    }


    @Override
    public void setOptions(String[] options) throws ClusteringException {

    }

    @Override
    public String getName() {
        return "kmeans";
    }

    @Override
    public void submit(DataSet ds) throws ClusteringException {
    data = ds.getData();
    size = data.length;
    for(int i = 0;i<size;i++){
        points.add(i,new Point(Integer.parseInt(data[i][0]),Integer.parseInt(data[i][1])));
    }
    kmean();
    }
    private ArrayList<Cluster> generateClusters(int size){
        ArrayList<Cluster> clusters = new ArrayList<>();
        int maxX = Integer.parseInt(data[0][0]);
        int minX = Integer.parseInt(data[0][0]);
        int maxY = Integer.parseInt(data[0][1]);
        int minY = Integer.parseInt(data[0][1]);
        for(int i = 0;i<size;i++){
            if(Integer.parseInt(data[i][0])>maxX){
                maxX= Integer.parseInt(data[i][0]);
            }
            if(Integer.parseInt(data[i][0])<minX){
                minX= Integer.parseInt(data[i][0]);
            }
            if(Integer.parseInt(data[i][1])>maxY){
                maxY= Integer.parseInt(data[i][1]);
            }
            if(Integer.parseInt(data[i][1])<minY){
                minY= Integer.parseInt(data[i][1]);
            }
        }
        int index = size/10;
        for(int i = 0;i<index;i++){
            Random random = new Random();
            Cluster cluster = new Cluster((int) (minX + (maxX - minX) * random.nextDouble()),(int) (minY + (maxY - minY) * random.nextDouble()));
            clusters.add(cluster);
        }
        return clusters;
    }
    private void kmean() {
        result = generateClusters(size);
        double min = 2147483647;
        int index = 0;
        for(int i = 0 ;i<size;i++){
            min = 2147483647;
            for(int j = 0;j<size/10;j++){
                if(points.get(i).getDistance(result.get(j), points.get(i) )<min){
                    min = points.get(i).getDistance(result.get(j), points.get(i));
                    index = j;
                }
            }
            result.get(index).assignedPoints.add(points.get(i));
        }
    }

    @Override
    public DataSet retrieve(boolean clear) throws ClusteringException {
        DataSet dataSet = new DataSet();
        Cluster cluster;
        String[][] ret = new String[size/10][2];
        for(int i = 0;i<size/10;i++){
            cluster = result.get(i);
            ArrayList<Point> points = cluster.assignedPoints;
            ret[i][0] = String.valueOf(cluster.getX());
            ret[i][1] = String.valueOf(cluster.getY());
        }
        dataSet.setData(ret);
        return dataSet;
    }

    public static void main(String[] args) {

    }
}
