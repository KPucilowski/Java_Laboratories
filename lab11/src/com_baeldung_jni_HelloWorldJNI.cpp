#include "com_baeldung_jni_HelloWorldJNI.h"
#include <iostream>
#include <sstream>
#include <gtk/gtk.h>
 GtkWidget *entry1,*entry2,*entry3,*entry4,*entry5,*entry6,*entry7;
 double * aNew = new double[3];
 double * bNew = new double[3];
static void button_clicked(JNIEnv * env, jobject self){
const char *str;

str=gtk_entry_get_text(GTK_ENTRY(entry1));
double x = atof(str);
aNew[0]=x;

str=gtk_entry_get_text(GTK_ENTRY(entry2));
x = atof(str);
aNew[1]=x;

str=gtk_entry_get_text(GTK_ENTRY(entry3));
x = atof(str);
aNew[2]=x;

str=gtk_entry_get_text(GTK_ENTRY(entry4));
x = atof(str);
bNew[0]=x;

str=gtk_entry_get_text(GTK_ENTRY(entry5));
x = atof(str);
bNew[1]=x;

str=gtk_entry_get_text(GTK_ENTRY(entry6));
x = atof(str);
bNew[2]=x;
double result=(aNew[0]*bNew[0]+aNew[1]*bNew[1]+aNew[2]*bNew[2]);
std::stringstream ss ;
ss << result;
 const char* stringstream2 = ss.str().c_str();
gtk_entry_set_text (GTK_ENTRY (entry7), stringstream2);
}
JNIEXPORT void JNICALL Java_com_baeldung_jni_HelloWorldJNI_sayHello
  (JNIEnv* env, jobject thisObject) {
    std::cout << "Hello from C++ !!" << std::endl;
}
JNIEXPORT jobject JNICALL Java_com_baeldung_jni_HelloWorldJNI_multi01(JNIEnv* env,jobject self,jobjectArray a, jobjectArray b){
    jclass jDbl = env->FindClass("java/lang/Double");

    if(jDbl == NULL){
        return NULL;
    }
    jsize size = env->GetArrayLength(a);
    jmethodID mid = env->GetMethodID(jDbl,"doubleValue","()D");

    double result = 0;

    jobject dA = env->AllocObject(jDbl);
    jobject dB = env->AllocObject(jDbl);

    for(int i = 0;i<size;i++){
    dA = env->GetObjectArrayElement(a,i);
    dB = env->GetObjectArrayElement(b,i);

    jdouble d1 = env->CallDoubleMethod(dA,mid);
    jdouble d2 = env->CallDoubleMethod(dB,mid);
    result = result + d1*d2;
    }

    jobject retVal = env->AllocObject(jDbl);
    jmethodID smid = env->GetStaticMethodID(jDbl,"valueOf","(D)Ljava/lang/Double;");
    retVal = env->CallStaticObjectMethod(jDbl, smid, result);
    std::cout << "Hello from C++ 3!!" << std::endl;
    return retVal;
    }
    JNIEXPORT jobject JNICALL Java_com_baeldung_jni_HelloWorldJNI_multi02
    (JNIEnv * env, jobject self, jobjectArray a){
    jclass jDbl = env->FindClass("java/lang/Double");
    jclass jcls = env->FindClass("com/baeldung/jni/HelloWorldJNI");
    jobject jobj = env->AllocObject(jcls);
    jsize size = env->GetArrayLength(a);
        jmethodID mid = env->GetMethodID(jDbl,"doubleValue","()D");

        double result = 0;

        jobject dA = env->AllocObject(jDbl);
        jobject dB = env->AllocObject(jDbl);
        jclass ClassObject = env->GetObjectClass(self);

        jfieldID arID = env->GetFieldID(ClassObject,"b","[Ljava/lang/Double;");
        jobject arrayB = env->GetObjectField(self,arID);
        jobjectArray* arrayB_object = reinterpret_cast<jobjectArray*>(&arrayB);


        jdouble d1 = env->CallDoubleMethod(dB,mid);
        for(int i = 0;i<size;i++){
            dA = env->GetObjectArrayElement(a,i);
            dB = env->GetObjectArrayElement(*arrayB_object,i);

            jdouble d1 = env->CallDoubleMethod(dA,mid);
            jdouble d2 = env->CallDoubleMethod(dB,mid);
            result = result + d1*d2;
            }

            jobject retVal = env->AllocObject(jDbl);
            jmethodID smid = env->GetStaticMethodID(jDbl,"valueOf","(D)Ljava/lang/Double;");
            retVal = env->CallStaticObjectMethod(jDbl, smid, result);

    return retVal;
    }
    JNIEXPORT void JNICALL Java_com_baeldung_jni_HelloWorldJNI_multi03
      (JNIEnv * env, jobject self){

        gtk_init(NULL, NULL); // here it is.

            GtkWidget * _window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
             GtkWidget *vbox, *hbox;

                GtkWidget *button;
                gint tmp_pos;
            gtk_window_set_position(GTK_WINDOW(_window), GTK_WIN_POS_CENTER);
            gtk_window_set_default_size(GTK_WINDOW(_window), 400, 400);
            gtk_window_set_title(GTK_WINDOW(_window), "Podaj wartości wektorów");

            vbox = gtk_vbox_new (FALSE, 0);
                gtk_container_add (GTK_CONTAINER (_window), vbox);
                gtk_widget_show (vbox);


            entry1 = gtk_entry_new ();
                            gtk_entry_set_max_length (GTK_ENTRY (entry1), 50);
                            gtk_entry_set_text (GTK_ENTRY (entry1), "x1");



                            gtk_box_pack_start (GTK_BOX (vbox), entry1, TRUE, TRUE, 0);
                            gtk_widget_show (entry1);
            entry2 = gtk_entry_new ();
                            gtk_entry_set_max_length (GTK_ENTRY (entry2), 50);
                            gtk_entry_set_text (GTK_ENTRY (entry2), "x2");



                            gtk_box_pack_start (GTK_BOX (vbox), entry2, TRUE, TRUE, 0);
                            gtk_widget_show (entry2);
            entry3 = gtk_entry_new ();
                            gtk_entry_set_max_length (GTK_ENTRY (entry3), 50);
                            gtk_entry_set_text (GTK_ENTRY (entry3), "x3");



                            gtk_box_pack_start (GTK_BOX (vbox), entry3, TRUE, TRUE, 0);
                            gtk_widget_show (entry3);
            entry4 = gtk_entry_new ();
                            gtk_entry_set_max_length (GTK_ENTRY (entry4), 50);
                            gtk_entry_set_text (GTK_ENTRY (entry4), "y1");



                            gtk_box_pack_start (GTK_BOX (vbox), entry4, TRUE, TRUE, 0);
                            gtk_widget_show (entry4);
            entry5 = gtk_entry_new ();
                            gtk_entry_set_max_length (GTK_ENTRY (entry5), 50);
                            gtk_entry_set_text (GTK_ENTRY (entry5), "y2");



                            gtk_box_pack_start (GTK_BOX (vbox), entry5, TRUE, TRUE, 0);
                            gtk_widget_show (entry5);

             entry6 = gtk_entry_new ();
                                         gtk_entry_set_max_length (GTK_ENTRY (entry6), 50);
                                         gtk_entry_set_text (GTK_ENTRY (entry6), "y3");



                                         gtk_box_pack_start (GTK_BOX (vbox), entry6, TRUE, TRUE, 0);
                                         gtk_widget_show (entry6);
                 button = gtk_button_new_with_mnemonic ("Policz");
                	g_signal_connect(button,"clicked",G_CALLBACK(button_clicked),entry1);
                    gtk_box_pack_start (GTK_BOX (vbox), button, TRUE, TRUE, 0);
                    gtk_widget_set_can_default (button, TRUE);
                    gtk_widget_grab_default (button);
                    gtk_widget_show (button);

            entry7 = gtk_entry_new ();
                                        gtk_entry_set_max_length (GTK_ENTRY (entry7), 50);
                                        gtk_entry_set_text (GTK_ENTRY (entry7), "result");



                                        gtk_box_pack_start (GTK_BOX (vbox), entry7, TRUE, TRUE, 0);
                                        gtk_widget_show (entry7);
            g_signal_connect(_window,"destroy",G_CALLBACK(gtk_main_quit),NULL);
            gtk_widget_show_all(_window); 
            gtk_main();

        jclass jDbl = env->FindClass("java/lang/Double");
        jclass ClassObject = env->GetObjectClass(self);

        jfieldID arr_A_id = env->GetFieldID(ClassObject, "a",
        "[Ljava/lang/Double;");
        jfieldID arr_B_id = env->GetFieldID(ClassObject, "b",
        "[Ljava/lang/Double;");

        jmethodID valueOf_id= env->GetStaticMethodID(jDbl, "valueOf",
        "(D)Ljava/lang/Double;");
        jmethodID multi04_id = env->GetMethodID(ClassObject, "multi04",
        "()V");


        jobjectArray new_a_field = env->NewObjectArray(3, jDbl, 0);
        jobjectArray new_b_field = env->NewObjectArray(3, jDbl, 0);
        env->SetObjectField(self, arr_A_id, new_a_field);
        env->SetObjectField(self, arr_B_id, new_b_field);

        jobject arrayA = env->GetObjectField(self, arr_A_id);
        jobject arrayB = env->GetObjectField(self, arr_B_id);
        jobjectArray* arrA = reinterpret_cast<jobjectArray*>(&arrayA);
        jobjectArray* arrB = reinterpret_cast<jobjectArray*>(&arrayB);


        jobject dblA = env->AllocObject(jDbl);
        jobject dblB = env->AllocObject(jDbl);
        double result = 0;
        for(int i=0; i<3; ++i){
        dblA = env->CallStaticObjectMethod(jDbl, valueOf_id, aNew[i]);
        env->SetObjectArrayElement(*arrA, i, dblA);
        dblB = env->CallStaticObjectMethod(jDbl, valueOf_id, bNew[i]);
        env->SetObjectArrayElement(*arrB, i, dblB);
        }

        env->CallVoidMethod(self, multi04_id);

      }

