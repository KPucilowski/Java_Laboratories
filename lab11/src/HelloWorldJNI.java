package com.baeldung.jni;

public class HelloWorldJNI {
    public Double[] a;
    public Double[] b;
    public Double c;

    static {
        System.loadLibrary("native");
    }
    public void multi04(){
        Double suma=0.0;
        for(int i=0;i<a.length;i++){
        suma=suma+a[i]*b[i];
        }
        c=suma;
    }
    public static void main(String[] ars){
        HelloWorldJNI m = new HelloWorldJNI();
        m.a= new Double[]{1d, 2d, 3d};
        m.b= new Double[]{4d,5d,6d};
        System.out.println(m.multi01(m.a,m.b).doubleValue());
        System.out.println(m.multi02(m.a).doubleValue());
        m.multi03();
        System.out.println(m.c);



    }

    // Declare a native method sayHello() that receives no arguments and returns void
    private native void sayHello();
    public native Double multi01(Double[] a,Double[] b);
    public native Double multi02(Double[] a);
    public native Double multi03();

}
