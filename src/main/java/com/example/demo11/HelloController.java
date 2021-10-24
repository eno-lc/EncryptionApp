package com.example.demo11;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;

public class HelloController {
    @FXML
    private Button getBtn;
    @FXML
    private Button encBtn;
    @FXML
    private Button dcrBtn;
    @FXML
    private Button exitBtn;
    @FXML
    TextField getKeyArea;
    @FXML
    TextField encr1;
    @FXML
    TextField encr2;
    @FXML
    TextField dcr1;
    @FXML
    TextField dcr2;
    @FXML
    Label labelField;

    private char character = ' ';
    private char[] letters;
    private ArrayList<Character> list = new ArrayList<>();
    private ArrayList<Character> shuffledList = new ArrayList<>();


    @FXML
    private void newKey(){
        character = ' ';
        list.clear();
        shuffledList.clear();

        for(int i = 32; i<127; i++){
            list.add(Character.valueOf(character));
            character++;
        }
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);


    }
    @FXML
    private void getKey(){
        newKey();
//       for(Character x : list) {
//             System.out.print(x);
//
//        }
        for(Character x : shuffledList) {
            getKeyArea.appendText(x.toString());

        }

    }
    @FXML
    private void encrypt(){

        String message = encr1.getText();
        letters = message.toCharArray();
        for(int i =0; i< letters.length;i++){
            for(int j =0; j< list.size();j++){
                if(letters[i] == list.get(j)){
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }

        for(char x : letters ){
            encr2.appendText(String.valueOf(x));
        }

    }
    @FXML
    private void decrypt(){

        String message = dcr1.getText();

        letters = message.toCharArray();

        for(int i =0; i< letters.length;i++){
            for(int j =0; j< shuffledList.size();j++){
                if(letters[i] == shuffledList.get(j)){
                    letters[i] = list.get(j);
                    break;
                }
            }
        }

        for(char x : letters ){
            dcr2.appendText(String.valueOf(x));
        }

    }

    @FXML
    private void exit(){
        System.exit(0);
    }

}