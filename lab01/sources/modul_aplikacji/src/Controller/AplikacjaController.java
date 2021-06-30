package Controller;

import Biblioteka_package.Encode;
import View.AplikacjaView;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AplikacjaController {
    Encode encode = new Encode();
    AplikacjaView view = new AplikacjaView();
    public void init() {
        view.getCheckButton().addActionListener(e-> {
            try {
                checkChanges();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            }
        });
        view.getChooseButton().addActionListener(e->chooseFile());
        view.getGenerateButton().addActionListener(e-> {
            try {
                generateHash();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            }
        });
    }

    private void generateHash() throws IOException, NoSuchAlgorithmException {
        encode.createHash(view.getDirectoryField().getText());

    }

    private void chooseFile() {
    view.getDirectoryField().setText(encode.chooseFile());
    }

    private void checkChanges() throws IOException, NoSuchAlgorithmException {
        encode.checkHash(view.getDirectoryField().getText());
    }

}
