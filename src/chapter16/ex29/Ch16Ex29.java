package chapter16.ex29;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author swarfte
 * @title Display a calendar
 */
public class Ch16Ex29 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new CalendarPane());
        primaryStage.setTitle("Exercise16_29");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


class CalendarPane extends BorderPane {

    private void display() {
        setPrefSize(700, 300);
        HBox controlPane = new HBox();
        Button priorButton = new Button("Prior");
        Button nextButton = new Button("Next");
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setSpacing(10);
        controlPane.setPadding(new Insets(10));
        controlPane.getChildren().addAll(priorButton, nextButton);

        setBottom(controlPane);

        LocalDate currentDate = LocalDate.now();

        HBox titlePane = new HBox();
        titlePane.setAlignment(Pos.CENTER);
        titlePane.setSpacing(10);
        titlePane.setPadding(new Insets(10));
        Label monthAndYear = new Label(getTitle(currentDate));
        titlePane.getChildren().add(monthAndYear);
        setTop(titlePane);


        class MyDate {
            LocalDate currentDate;

            MyDate(LocalDate currentDate) {
                this.currentDate = currentDate;
            }

            public LocalDate getCurrentDate() {
                return currentDate;
            }

            public void setCurrentDate(LocalDate currentDate) {
                this.currentDate = currentDate;
            }
        }

        MyDate myDate = new MyDate(currentDate);
        GridPane displayCalendarsPane = new GridPane();
        displayCalendarsPane.setAlignment(Pos.TOP_CENTER);
        displayCalendarsPane.setHgap(10);
        displayCalendarsPane.setVgap(10);
        displayCalendarsPane.setPadding(new Insets(10));
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i < 7; i++) {
            Label dayOfWeek = new Label(daysOfWeek[i]);
            displayCalendarsPane.add(dayOfWeek, i, 0);
        }

        priorButton.setOnAction((ActionEvent e) -> {
            LocalDate priorDate = myDate.getCurrentDate().plusMonths(-1);
            myDate.setCurrentDate(priorDate);
            displayCurrentMonth(titlePane, displayCalendarsPane, myDate.getCurrentDate());
        });

        nextButton.setOnAction((ActionEvent e) -> {
            LocalDate nextDate = myDate.getCurrentDate().plusMonths(1);
            myDate.setCurrentDate(nextDate);
            displayCurrentMonth(titlePane, displayCalendarsPane, myDate.getCurrentDate());
        });

        displayCurrentMonth(titlePane, displayCalendarsPane, myDate.getCurrentDate());
        setCenter(displayCalendarsPane);
    }


    public void displayCurrentMonth(HBox titlePane, GridPane displayCalendarsPane, LocalDate currentDate) {
        int count = 0;
        titlePane.getChildren().clear();
        Label monthAndYear = new Label(getTitle(currentDate));
        titlePane.getChildren().add(monthAndYear);

        displayCalendarsPane.getChildren().clear();
        Date date = new Date(currentDate.getYear(), currentDate.getMonth().getValue() - 1, 0);
        int firstDayOfWeek = getDayNumberOld(date) - 1;

        int getMonth = getMonthOfDayMaximum(currentDate.getYear(), currentDate.getMonthValue()) + 1;
        for (int i = 1, j = firstDayOfWeek, k = firstDayOfWeek + 1; i <= getMonth; i++, j++) {
            if (i < k) {
                LocalDate priorMonth = currentDate.plusMonths(-1);
                int getMonthOfPriorMonth = getMonthOfDayMaximum(priorMonth.getYear(), priorMonth.getMonthValue());
                Label priorDay = new Label(String.valueOf(getMonthOfPriorMonth + (i - k + 1)));
                displayCalendarsPane.add(priorDay, i - 1, 1);
            }
            Label day = new Label(String.valueOf(i));
            displayCalendarsPane.add(day, j % 7, 1 + j / 7);
            count++;
        }
        int numberOfNextMonth = (count / 7) * 8 + 1;
        for (int i = count, j = 1; i <= numberOfNextMonth; i++, j++) {
            Label nextDay = new Label(String.valueOf(j));
            displayCalendarsPane.add(nextDay, (count + j) % 7, 1 + i / 7);
        }

    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        display();
    }

    public String getTitle(LocalDate currentDate) {
        return currentDate.getMonth() + ", " + currentDate.getYear();
    }

    public int getMonthOfDayMaximum(int year, int month) {
        Calendar calendar = new GregorianCalendar(year, month, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public int monthNameToNumber(String monthName) {
        return switch (monthName) {
            case "JANUARY" -> 1;
            case "FEBRUARY" -> 2;
            case "MARCH" -> 3;
            case "APRIL" -> 4;
            case "MAY" -> 5;
            case "JUNE" -> 6;
            case "JULY" -> 7;
            case "AUGUST" -> 8;
            case "SEPTEMBER" -> 9;
            case "OCTOBER" -> 10;
            case "NOVEMBER" -> 11;
            case "DECEMBER" -> 12;
            default -> 0;
        };
    }

    public static int getDayNumberOld(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
}