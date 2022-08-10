package chapter17.ex9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

/**
 * @author swarfte
 * @title Address book
 */
public class Ch17Ex9 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(new AddressBookPane());
        primaryStage.setTitle("Exercise17_09");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class AddressBook implements Serializable {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public AddressBook() {
        name = "";
        street = "";
        city = "";
        state = "";
        zip = "";
        phone = "";
    }

    public AddressBook(String name, String street, String city, String state, String zip, String phone) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

class AddressBookPane extends VBox {
    public AddressBookPane() throws IOException {
        String relativePath = "src/chapter17/ex9/data.dat";
        File file = new File(relativePath);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("Create new file");
            }
        }


        ArrayList<AddressBook> addressBook;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            addressBook = (ArrayList<AddressBook>) (input.readObject());
        } catch (EOFException | ClassNotFoundException e) {
            addressBook = new ArrayList<>();
            AddressBook book = new AddressBook();
            addressBook.add(book);
        }
        class Count {
            int count = 0;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
        Count count = new Count();

        Insets insets = new Insets(10);
        int spacing = 10;
        HBox namePane = new HBox();
        namePane.setPadding(insets);
        namePane.setSpacing(spacing);

        HBox streetPane = new HBox();
        streetPane.setPadding(insets);
        streetPane.setSpacing(spacing);

        HBox cityPane = new HBox();
        cityPane.setPadding(insets);
        cityPane.setSpacing(spacing);

        HBox controlPane = new HBox();
        controlPane.setPadding(insets);
        controlPane.setSpacing(spacing);
        controlPane.setAlignment(Pos.CENTER);

        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        nameField.setText(addressBook.get(count.getCount()).getName());
        nameField.setPrefColumnCount(32);
        namePane.getChildren().addAll(nameLabel, nameField);

        Label streetLabel = new Label("Street");
        TextField streetField = new TextField();
        streetField.setText(addressBook.get(count.getCount()).getStreet());
        streetField.setPrefColumnCount(32);
        streetPane.getChildren().addAll(streetLabel, streetField);

        Label cityLabel = new Label("City");
        TextField cityField = new TextField();
        cityField.setText(addressBook.get(count.getCount()).getCity());
        cityField.setPrefColumnCount(20);
        Label stateLabel = new Label("State");
        TextField stateField = new TextField();
        stateField.setText(addressBook.get(count.getCount()).getState());
        stateField.setPrefColumnCount(2);
        Label zipLabel = new Label("Zip");
        TextField zipField = new TextField();
        zipField.setText(addressBook.get(count.getCount()).getZip());
        zipField.setPrefColumnCount(3);
        cityPane.getChildren().addAll(cityLabel, cityField, stateLabel, stateField, zipLabel, zipField);

        Button addButton = new Button("Add");
        ArrayList<AddressBook> finalAddressBook = addressBook;
        addButton.setOnAction((ActionEvent e) -> {
            AddressBook tempBook = new AddressBook();
            tempBook.setName(nameField.getText());
            tempBook.setStreet(streetField.getText());
            tempBook.setCity(cityField.getText());
            tempBook.setState(stateField.getText());
            tempBook.setZip(zipField.getText());
            finalAddressBook.add(tempBook);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
                output.writeObject(finalAddressBook);
                count.setCount(count.getCount() + 1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        Button firstButton = new Button("First");
        firstButton.setOnAction((ActionEvent e) -> {
            count.setCount(0);
            nameField.setText(finalAddressBook.get(count.getCount()).getName());
            streetField.setText(finalAddressBook.get(count.getCount()).getStreet());
            cityField.setText(finalAddressBook.get(count.getCount()).getCity());
            stateField.setText(finalAddressBook.get(count.getCount()).getState());
            zipField.setText(finalAddressBook.get(count.getCount()).getZip());
        });

        Button nextButton = new Button("Next");
        nextButton.setOnAction((ActionEvent e) -> {
            if (count.getCount() < finalAddressBook.size() - 1) {
                count.setCount(count.getCount() + 1);
                nameField.setText(finalAddressBook.get(count.getCount()).getName());
                streetField.setText(finalAddressBook.get(count.getCount()).getStreet());
                cityField.setText(finalAddressBook.get(count.getCount()).getCity());
                stateField.setText(finalAddressBook.get(count.getCount()).getState());
                zipField.setText(finalAddressBook.get(count.getCount()).getZip());
            }
        });

        Button previousButton = new Button("Previous");
        previousButton.setOnAction((ActionEvent e) -> {
            if (count.getCount() > 0) {
                count.setCount(count.getCount() - 1);
                nameField.setText(finalAddressBook.get(count.getCount()).getName());
                streetField.setText(finalAddressBook.get(count.getCount()).getStreet());
                cityField.setText(finalAddressBook.get(count.getCount()).getCity());
                stateField.setText(finalAddressBook.get(count.getCount()).getState());
                zipField.setText(finalAddressBook.get(count.getCount()).getZip());
            }
        });

        Button lastButton = new Button("Last");
        lastButton.setOnAction((ActionEvent e) -> {
            count.setCount(finalAddressBook.size() - 1);
            nameField.setText(finalAddressBook.get(count.getCount()).getName());
            streetField.setText(finalAddressBook.get(count.getCount()).getStreet());
            cityField.setText(finalAddressBook.get(count.getCount()).getCity());
            stateField.setText(finalAddressBook.get(count.getCount()).getState());
            zipField.setText(finalAddressBook.get(count.getCount()).getZip());
        });

        Button updateButton = new Button("Update");
        updateButton.setOnAction((ActionEvent e) -> {
            AddressBook tempBook = finalAddressBook.get(count.getCount());
            tempBook.setName(nameField.getText());
            tempBook.setStreet(streetField.getText());
            tempBook.setCity(cityField.getText());
            tempBook.setState(stateField.getText());
            tempBook.setZip(zipField.getText());
            finalAddressBook.set(count.getCount(), tempBook);
            try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
                output.writeObject(finalAddressBook);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        controlPane.getChildren().addAll(addButton, firstButton, nextButton, previousButton, lastButton, updateButton);
        getChildren().addAll(namePane, streetPane, cityPane, controlPane);
    }
}
