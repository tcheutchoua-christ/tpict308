package com.example.TrivialApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class QuizController {

    Connection con = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    @FXML
    public Label question;

    @FXML
    public Button opt1, opt2, opt3, opt4;

    static int counter = 0;
    static int correct = 0;
    static int wrong = 0;
    String answer;


    public ObservableList<Questions> getQuestions() throws SQLException {
        ObservableList<Questions> questions = FXCollections.observableArrayList();
        String select = "SELECT * FROM questions";
        con = DBconnection.getConnection();
        try {
            statement = con.prepareStatement(select);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Questions quest = new Questions();
                quest.setId(resultSet.getInt("id"));
                quest.setQuestion(resultSet.getString("question"));
                quest.setAnswer(resultSet.getString("answer"));
                quest.setOption1(resultSet.getString("option1"));
                quest.setOption2(resultSet.getString("option2"));
                quest.setOption3(resultSet.getString("option3"));
                quest.setOption4(resultSet.getString("option4"));

                questions.add(quest);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return questions;
    }

    @FXML
    private void initialize() throws SQLException {
        loadQuestions();
    }

    private void loadQuestions() throws SQLException {

        ObservableList<Questions> list = getQuestions();
        question.setText(list.get(counter).getQuestion());
        opt1.setText(list.get(counter).getOption1());
        opt2.setText(list.get(counter).getOption2());
        opt3.setText(list.get(counter).getOption3());
        opt4.setText(list.get(counter).getOption4());

    }

    @FXML
    public void opt1clicked(ActionEvent event) throws SQLException {
        ObservableList<Questions> list = getQuestions();

        if (opt1.getText().equals(list.get(counter).getAnswer())) {
            correct ++;
        }
        else {
            wrong ++;
        }



        if(counter == 3){
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void opt2clicked(ActionEvent event) throws SQLException {
        ObservableList<Questions> list = getQuestions();

        if (opt2.getText().equals(list.get(counter).getAnswer())) {
            correct ++;
        }
        else {
            wrong ++;
        }



        if(counter == 3){
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void opt3clicked(ActionEvent event) throws SQLException {
        ObservableList<Questions> list = getQuestions();

        if (opt3.getText().equals(list.get(counter).getAnswer())) {
            correct ++;
        }
        else {
            wrong ++;
        }



        if(counter == 3){
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void opt4clicked(ActionEvent event) throws SQLException {
        ObservableList<Questions> list = getQuestions();

        System.out.println(list.get(counter).getAnswer());
        System.out.println(opt4.getText());

        if (opt4.getText().equals(list.get(counter).getAnswer())) {
            correct ++;
                    }
        else {
            wrong ++;
        }



        if(counter == 3){
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }


}


