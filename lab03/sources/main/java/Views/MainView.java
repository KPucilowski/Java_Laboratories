package Views;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainView {
    private JPanel contentPane;
    private JTextField question2Field;
    private JLabel question1;
    private JLabel question3;
    private JTextField checkField3;
    private JTextField checkField2;
    private JTextField checkField1;
    private JButton acceptButton1;
    private JButton acceptButton3;
    private JLabel question2_1;
    private JLabel question2_2;
    private JButton acceptButton2;
    private JTextField answerField;
    private JTextField answerField3;
    private JTextField answerField2;
    private JLabel answerLabel1;
    private JLabel answerLabel2;
    private JLabel answerLabel3;
    private JTextField correctAnswerField1;
    private JTextField correctAnswerField2;
    private JTextField correctAnswerField3;
    public String wrong_answer;
    public String right_answer;
    private final JFrame frame;
    public MainView(String language){
        setLanguage(language);
        frame = new JFrame("main/java/App");
        frame.setContentPane(contentPane);
        init();
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void setLanguage(String language) {
        if(language.equals("Polski")){
            Locale.setDefault(new Locale("pl","wr"));
        }else{
            Locale.setDefault(new Locale("en","us"));
        }
        ResourceBundle r=ResourceBundle.getBundle("properties");
        question1.setText(r.getString("question_1"));
        question2_1.setText(r.getString("question_2.1"));
        question2_2.setText(r.getString("question_2.2"));
        question3.setText(r.getString("question_3"));
        acceptButton1.setText(r.getString("button"));
        acceptButton2.setText(r.getString("button"));
        acceptButton3.setText(r.getString("button"));
        right_answer=r.getString("answer_right");
        wrong_answer=r.getString("answer_wrong");
        answerLabel1.setText(r.getString("answer"));
        answerLabel2.setText(r.getString("answer"));
        answerLabel3.setText(r.getString("answer"));
    }
    public void init(){
        acceptButton1.addActionListener(e-> {
            try {
                checkAnswer1();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
        acceptButton2.addActionListener(e-> {
            try {
                checkAnswer2(question2Field.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
        acceptButton3.addActionListener(e-> {
            try {
                checkAnswer3();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
    }

    private void checkAnswer1() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://wft-geo-db.p.rapidapi.com/v1/geo/cities?minPopulation=10000000"))
                .header("x-rapidapi-key", "32218ce6eemsh996ede13da25217p103011jsn32357c73ded7")
                .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String result = response.body();
        int startIndex = result.lastIndexOf(":");
        int endIndex = result.lastIndexOf("}");
        String answer = result.substring(startIndex+1,endIndex-1);
        String user_answer = answerField.getText();
        if(user_answer.equals(answer)){
            checkField1.setText(right_answer);

        }else{
            checkField1.setText(wrong_answer);
            correctAnswerField1.setText(answer);
        }
    }
    private void checkAnswer2(String letter) throws IOException,InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://wft-geo-db.p.rapidapi.com/v1/geo/countries?namePrefix="+letter))
                .header("x-rapidapi-key", "32218ce6eemsh996ede13da25217p103011jsn32357c73ded7")
                .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String result = response.body();
        int startIndex = result.lastIndexOf(":");
        int endIndex = result.lastIndexOf("}");
        String answer = result.substring(startIndex+1,endIndex-1);
        String user_answer = answerField2.getText();
        if(user_answer.equals(answer)){
            checkField2.setText(right_answer);
        }else{
            checkField2.setText(wrong_answer);
            correctAnswerField2.setText(answer);
        }
    }
    private void checkAnswer3() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://wft-geo-db.p.rapidapi.com/v1/geo/cities?countryIds=Q36"))
                .header("x-rapidapi-key", "32218ce6eemsh996ede13da25217p103011jsn32357c73ded7")
                .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String result = response.body();
        int startIndex = result.lastIndexOf(":");
        int endIndex = result.lastIndexOf("}");
        String answer = result.substring(startIndex+1,endIndex-1);
        String user_answer = answerField3.getText();
        if(user_answer.equals(answer)){
            checkField3.setText(right_answer);
        }else{
            checkField3.setText(wrong_answer);
            correctAnswerField3.setText(answer);
        }
    }
}
