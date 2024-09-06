package application;

import java.sql.*;
import javafx.collections.FXCollections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Main extends Application {

	ArrayList<PatinetData> patinets;
	ArrayList<Pharmacy> pharmacy;
	ArrayList<Doctor> Doctor;
	ArrayList<Reports> Report;
	ArrayList<Sales> Sales;
	ArrayList<Company> Company;
	ArrayList<Drugs> Drugs;
	ArrayList<Purchasing> Purchasing;

	Connection connection;

	ObservableList<PatinetData> patinetList;
	ObservableList<Pharmacy> PharmacyList;
	ObservableList<Doctor> DoctorList;
	ObservableList<Reports> ReportsList;
	ObservableList<Sales> SalesList;
	ObservableList<Company> CompanyList;
	ObservableList<Drugs> DrugsList;
	ObservableList<Purchasing> PurchasingList;

	HBox box = new HBox();
	HBox TF1 = new HBox();
	GridPane gp = new GridPane();

	@Override
	public void start(final Stage primaryStage) {

		BorderPane Bp = new BorderPane();
		Label l = new Label("Pharmacy System");
		Bp.setAlignment(l, Pos.CENTER);
		l.setFont(new Font(25));
		Bp.setTop(l);

		VBox choises = new VBox();
		Button aPhar = new Button("Add new Pharmacy");
		aPhar.setPrefWidth(200);
		aPhar.setPrefHeight(50);

		aPhar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HBox one = new HBox();
				Label l1 = new Label("pharmacy ID:");
				TextField t1 = new TextField("");
				one.getChildren().addAll(l1, t1);
				one.setSpacing(20);

				HBox two = new HBox();
				Label l2 = new Label("pharmacy name:");
				TextField t2 = new TextField("");
				two.getChildren().addAll(l2, t2);
				two.setSpacing(20);

				HBox three = new HBox();
				Label l3 = new Label("pharmacy Address:");
				TextField t3 = new TextField("");
				three.getChildren().addAll(l3, t3);
				three.setSpacing(20);

				HBox four = new HBox();
				Label l4 = new Label("pharmacy Phone:");
				TextField t4 = new TextField("");
				four.getChildren().addAll(l4, t4);
				four.setSpacing(20);

				Button add = new Button("Add");
				add.setPrefWidth(200);
				add.setPrefHeight(50);

				add.setOnAction(e -> {
					Pharmacy p = new Pharmacy(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(),
							Integer.parseInt(t4.getText()));

					pharmacy.add(p);
					insertData(p);
					t1.clear();
					t2.clear();
					t3.clear();
					t4.clear();
				});

				VBox forPhar = new VBox();
				forPhar.setSpacing(10);
				forPhar.getChildren().addAll(one, two, three, four, add);

				one.setAlignment(Pos.CENTER);
				two.setAlignment(Pos.CENTER);
				three.setAlignment(Pos.CENTER);
				four.setAlignment(Pos.CENTER);
				add.setAlignment(Pos.CENTER);
				forPhar.setAlignment(Pos.CENTER);

				Scene secondScene = new Scene(forPhar, 400, 250);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Adding new Pharmacy");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		Button aDoc = new Button("Add new Doctor");
		aDoc.setPrefWidth(200);
		aDoc.setPrefHeight(50);

		aDoc.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HBox one = new HBox();
				Label l1 = new Label("Doctor ID:");
				TextField t1 = new TextField("");
				one.getChildren().addAll(l1, t1);
				one.setSpacing(20);

				HBox two = new HBox();
				Label l2 = new Label("Doctor name:");
				TextField t2 = new TextField("");
				two.getChildren().addAll(l2, t2);
				two.setSpacing(20);

				HBox three = new HBox();
				Label l3 = new Label("Doctor Address:");
				TextField t3 = new TextField("");
				three.getChildren().addAll(l3, t3);
				three.setSpacing(20);

				HBox four = new HBox();
				Label l4 = new Label("Doctor Phone:");
				TextField t4 = new TextField("");
				four.getChildren().addAll(l4, t4);
				four.setSpacing(20);

				Button add = new Button("Add");
				add.setPrefWidth(200);
				add.setPrefHeight(50);

				add.setOnAction(e -> {
					Doctor p = new Doctor(Integer.parseInt(t1.getText()), t2.getText(), Integer.parseInt(t4.getText()),
							t3.getText());

					Doctor.add(p);
					insertData(p);
					t1.clear();
					t2.clear();
					t3.clear();
					t4.clear();
				});

				VBox forPhar = new VBox();
				forPhar.setSpacing(10);
				forPhar.getChildren().addAll(one, two, three, four, add);

				one.setAlignment(Pos.CENTER);
				two.setAlignment(Pos.CENTER);
				three.setAlignment(Pos.CENTER);
				four.setAlignment(Pos.CENTER);
				add.setAlignment(Pos.CENTER);
				forPhar.setAlignment(Pos.CENTER);

				Scene secondScene = new Scene(forPhar, 400, 250);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Adding new Doctor");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		Button aPati = new Button("Add new Patient");
		aPati.setPrefWidth(200);
		aPati.setPrefHeight(50);

		aPati.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HBox one = new HBox();
				Label l1 = new Label("Patient ID:");
				TextField t1 = new TextField("");
				one.getChildren().addAll(l1, t1);
				one.setSpacing(20);

				HBox two = new HBox();
				Label l2 = new Label("Patient name:");
				TextField t2 = new TextField("");
				two.getChildren().addAll(l2, t2);
				two.setSpacing(20);

				HBox three = new HBox();
				Label l3 = new Label("Patient Gender:");
				TextField t3 = new TextField("");
				three.getChildren().addAll(l3, t3);
				three.setSpacing(20);

				HBox eight = new HBox();
				Label l8 = new Label("Patient Phone:");
				TextField t8 = new TextField("");
				eight.getChildren().addAll(l8, t8);
				eight.setSpacing(20);

				HBox four = new HBox();
				Label l4 = new Label("Siknes Name:");
				TextField t4 = new TextField("");
				four.getChildren().addAll(l4, t4);
				four.setSpacing(20);

				HBox five = new HBox();
				Label l5 = new Label("Drug ID:");
				TextField t5 = new TextField("");
				five.getChildren().addAll(l5, t5);
				five.setSpacing(20);

				HBox six = new HBox();
				Label l6 = new Label("Doctor ID:");
				TextField t6 = new TextField("");
				six.getChildren().addAll(l6, t6);
				six.setSpacing(20);

				HBox seven = new HBox();
				Label l7 = new Label("Age:");
				TextField t7 = new TextField("");
				seven.getChildren().addAll(l7, t7);
				seven.setSpacing(20);

				Button add = new Button("Add");
				add.setPrefWidth(200);
				add.setPrefHeight(50);

				add.setOnAction(e -> {
					PatinetData p = new PatinetData(Integer.parseInt(t1.getText()), t2.getText(),
							Integer.parseInt(t7.getText()), t3.getText(), Integer.parseInt(t8.getText()), t4.getText(),
							Integer.parseInt(t6.getText()), Integer.parseInt(t5.getText()));

					patinetList.add(p);
					insertData(p);
					t1.clear();
					t2.clear();
					t3.clear();
					t4.clear();
					t5.clear();
					t6.clear();
					t7.clear();
					t8.clear();
				});

				VBox forPhar = new VBox();
				forPhar.setSpacing(10);
				forPhar.getChildren().addAll(one, two, three, eight, four, five, six, seven, add);

				one.setAlignment(Pos.CENTER);
				two.setAlignment(Pos.CENTER);
				three.setAlignment(Pos.CENTER);
				four.setAlignment(Pos.CENTER);
				five.setAlignment(Pos.CENTER);
				six.setAlignment(Pos.CENTER);
				seven.setAlignment(Pos.CENTER);
				eight.setAlignment(Pos.CENTER);
				add.setAlignment(Pos.CENTER);
				forPhar.setAlignment(Pos.CENTER);

				Scene secondScene = new Scene(forPhar, 400, 400);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Adding new Patient");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		Button aRep = new Button("Add new Report");
		aRep.setPrefWidth(200);
		aRep.setPrefHeight(50);

		aRep.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HBox one = new HBox();
				Label l1 = new Label("report ID:");
				TextField t1 = new TextField("");
				one.getChildren().addAll(l1, t1);
				one.setSpacing(20);

				HBox two = new HBox();
				Label l2 = new Label("Purchase ID:");
				TextField t2 = new TextField("");
				two.getChildren().addAll(l2, t2);
				two.setSpacing(20);

				HBox three = new HBox();
				Label l3 = new Label("Drug ID:");
				TextField t3 = new TextField("");
				three.getChildren().addAll(l3, t3);
				three.setSpacing(20);

				HBox four = new HBox();
				Label l4 = new Label("Patient ID:");
				TextField t4 = new TextField("");
				four.getChildren().addAll(l4, t4);
				four.setSpacing(20);

				HBox five = new HBox();
				Label l5 = new Label("Date:");
				TextField t5 = new TextField("");
				five.getChildren().addAll(l5, t5);
				five.setSpacing(20);

				HBox six = new HBox();
				Label l6 = new Label("Doctor ID:");
				TextField t6 = new TextField("");
				six.getChildren().addAll(l6, t6);
				six.setSpacing(20);

				Button add = new Button("Add");
				add.setPrefWidth(200);
				add.setPrefHeight(50);

				add.setOnAction(e -> {
					Reports p = new Reports(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()),
							Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()),
							Integer.parseInt(t6.getText()), t5.getText());

					Report.add(p);
					insertData(p);
					t1.clear();
					t2.clear();
					t3.clear();
					t4.clear();
					t5.clear();
					t6.clear();
				});

				VBox forPhar = new VBox();
				forPhar.setSpacing(10);
				forPhar.getChildren().addAll(one, two, three, four, five, six, add);

				one.setAlignment(Pos.CENTER);
				two.setAlignment(Pos.CENTER);
				three.setAlignment(Pos.CENTER);
				four.setAlignment(Pos.CENTER);
				five.setAlignment(Pos.CENTER);
				six.setAlignment(Pos.CENTER);
				add.setAlignment(Pos.CENTER);
				forPhar.setAlignment(Pos.CENTER);

				Scene secondScene = new Scene(forPhar, 400, 350);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Adding new Report");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}

		});

		Button aSale = new Button("Add new sales");
		aSale.setPrefWidth(200);
		aSale.setPrefHeight(50);

		aSale.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HBox one = new HBox();
				Label l1 = new Label("sales ID:");
				TextField t1 = new TextField("");
				one.getChildren().addAll(l1, t1);
				one.setSpacing(20);

				HBox two = new HBox();
				Label l2 = new Label("Patient ID:");
				TextField t2 = new TextField("");
				two.getChildren().addAll(l2, t2);
				two.setSpacing(20);

				HBox three = new HBox();
				Label l3 = new Label("Drug ID:");
				TextField t3 = new TextField("");
				three.getChildren().addAll(l3, t3);
				three.setSpacing(20);

				HBox four = new HBox();
				Label l4 = new Label("Pharmacy's Company:");
				TextField t4 = new TextField("");
				four.getChildren().addAll(l4, t4);
				four.setSpacing(20);

				HBox five = new HBox();
				Label l5 = new Label("Sale Price:");
				TextField t5 = new TextField("");
				five.getChildren().addAll(l5, t5);
				five.setSpacing(20);

				HBox six = new HBox();
				Label l6 = new Label("Count :");
				TextField t6 = new TextField("");
				six.getChildren().addAll(l6, t6);
				six.setSpacing(20);

				HBox seven = new HBox();
				Label l7 = new Label("Pharmacy ID:");
				TextField t7 = new TextField("");
				seven.getChildren().addAll(l7, t7);
				seven.setSpacing(20);

				Button add = new Button("Add");
				add.setPrefWidth(200);
				add.setPrefHeight(50);

				add.setOnAction(e -> {
					Sales p = new Sales(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()),
							Integer.parseInt(t3.getText()), Integer.parseInt(t6.getText()),
							Integer.parseInt(t7.getText()), t4.getText(), Integer.parseInt(t5.getText()));
					Sales.add(p);
					insertData(p);
					t1.clear();
					t2.clear();
					t3.clear();
					t4.clear();
					t5.clear();
					t6.clear();
					t7.clear();
				});

				VBox forPhar = new VBox();
				forPhar.setSpacing(10);
				forPhar.getChildren().addAll(one, two, three, four, five, six, seven, add);

				one.setAlignment(Pos.CENTER);
				two.setAlignment(Pos.CENTER);
				three.setAlignment(Pos.CENTER);
				four.setAlignment(Pos.CENTER);
				five.setAlignment(Pos.CENTER);
				six.setAlignment(Pos.CENTER);
				seven.setAlignment(Pos.CENTER);
				add.setAlignment(Pos.CENTER);
				forPhar.setAlignment(Pos.CENTER);

				Scene secondScene = new Scene(forPhar, 400, 400);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Adding new Sale");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		Button aCom = new Button("Add new Company");
		aCom.setPrefWidth(200);
		aCom.setPrefHeight(50);

		aCom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HBox one = new HBox();
				Label l1 = new Label("Company ID:");
				TextField t1 = new TextField("");
				one.getChildren().addAll(l1, t1);
				one.setSpacing(20);

				HBox two = new HBox();
				Label l2 = new Label("Company name:");
				TextField t2 = new TextField("");
				two.getChildren().addAll(l2, t2);
				two.setSpacing(20);

				HBox three = new HBox();
				Label l3 = new Label("Company Phone:");
				TextField t3 = new TextField("");
				three.getChildren().addAll(l3, t3);
				three.setSpacing(20);

				Button add = new Button("Add");
				add.setPrefWidth(200);
				add.setPrefHeight(50);

				add.setOnAction(e -> {
					Company p = new Company(Integer.parseInt(t1.getText()), t2.getText(),
							Integer.parseInt(t3.getText()));

					Company.add(p);
					insertData(p);
					t1.clear();
					t2.clear();
					t3.clear();
				});

				VBox forPhar = new VBox();
				forPhar.setSpacing(10);
				forPhar.getChildren().addAll(one, two, three, add);

				one.setAlignment(Pos.CENTER);
				two.setAlignment(Pos.CENTER);
				three.setAlignment(Pos.CENTER);
				add.setAlignment(Pos.CENTER);
				forPhar.setAlignment(Pos.CENTER);

				Scene secondScene = new Scene(forPhar, 400, 250);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Adding new Company");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		Button aDrug = new Button("Add new drug");
		aDrug.setPrefWidth(200);
		aDrug.setPrefHeight(50);

		aDrug.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HBox one = new HBox();
				Label l1 = new Label("drug ID:");
				TextField t1 = new TextField("");
				one.getChildren().addAll(l1, t1);
				one.setSpacing(20);

				HBox two = new HBox();
				Label l2 = new Label("drug name:");
				TextField t2 = new TextField("");
				two.getChildren().addAll(l2, t2);
				two.setSpacing(20);

				HBox three = new HBox();
				Label l3 = new Label("drug Price:");
				TextField t3 = new TextField("");
				three.getChildren().addAll(l3, t3);
				three.setSpacing(20);

				HBox eight = new HBox();
				Label l8 = new Label("Description:");
				TextField t8 = new TextField("");
				eight.getChildren().addAll(l8, t8);
				eight.setSpacing(20);

				HBox four = new HBox();
				Label l4 = new Label("Production Date:");
				TextField t4 = new TextField("");
				four.getChildren().addAll(l4, t4);
				four.setSpacing(20);

				HBox five = new HBox();
				Label l5 = new Label("Expiry Date:");
				TextField t5 = new TextField("");
				five.getChildren().addAll(l5, t5);
				five.setSpacing(20);

				HBox six = new HBox();
				Label l6 = new Label("Quantity :");
				TextField t6 = new TextField("");
				six.getChildren().addAll(l6, t6);
				six.setSpacing(20);

				HBox seven = new HBox();
				Label l7 = new Label("Doctor ID:");
				TextField t7 = new TextField("");
				seven.getChildren().addAll(l7, t7);
				seven.setSpacing(20);

				HBox nine = new HBox();
				Label l9 = new Label("Patient ID:");
				TextField t9 = new TextField("");
				nine.getChildren().addAll(l9, t9);
				nine.setSpacing(20);

				HBox ten = new HBox();
				Label l0 = new Label("Company ID:");
				TextField t0 = new TextField("");
				ten.getChildren().addAll(l0, t0);
				ten.setSpacing(20);

				Button add = new Button("Add");
				add.setPrefWidth(200);
				add.setPrefHeight(50);

				add.setOnAction(e -> {
					Drugs p = new Drugs(Integer.parseInt(t1.getText()), Integer.parseInt(t6.getText()),
							Integer.parseInt(t7.getText()), Integer.parseInt(t9.getText()),
							Integer.parseInt(t0.getText()), t2.getText(), Integer.parseInt(t3.getText()), t8.getText(),
							t4.getText(), t5.getText());
					Drugs.add(p);
					insertData(p);
					t1.clear();
					t2.clear();
					t3.clear();
					t4.clear();
					t5.clear();
					t6.clear();
					t7.clear();
				});

				VBox forPhar = new VBox();
				forPhar.setSpacing(10);
				forPhar.getChildren().addAll(one, two, three, eight, four, five, six, seven, nine, ten, add);

				one.setAlignment(Pos.CENTER);
				two.setAlignment(Pos.CENTER);
				three.setAlignment(Pos.CENTER);
				four.setAlignment(Pos.CENTER);
				five.setAlignment(Pos.CENTER);
				six.setAlignment(Pos.CENTER);
				seven.setAlignment(Pos.CENTER);
				eight.setAlignment(Pos.CENTER);
				nine.setAlignment(Pos.CENTER);
				ten.setAlignment(Pos.CENTER);
				add.setAlignment(Pos.CENTER);
				forPhar.setAlignment(Pos.CENTER);

				Scene secondScene = new Scene(forPhar, 400, 500);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Adding new Drug");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		Button aPurch = new Button("Add new purchasing");
		aPurch.setPrefWidth(200);
		aPurch.setPrefHeight(50);

		aPurch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				HBox one = new HBox();
				Label l1 = new Label("Purchase ID:");
				TextField t1 = new TextField("");
				one.getChildren().addAll(l1, t1);
				one.setSpacing(20);

				HBox two = new HBox();
				Label l2 = new Label("patients ID:");
				TextField t2 = new TextField("");
				two.getChildren().addAll(l2, t2);
				two.setSpacing(20);

				HBox three = new HBox();
				Label l3 = new Label("drug ID:");
				TextField t3 = new TextField("");
				three.getChildren().addAll(l3, t3);
				three.setSpacing(20);

				Button add = new Button("Add");
				add.setPrefWidth(200);
				add.setPrefHeight(50);

				add.setOnAction(e -> {
					Purchasing p = new Purchasing(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()),
							Integer.parseInt(t3.getText()));

					Purchasing.add(p);
					insertData(p);
					t1.clear();
					t2.clear();
					t3.clear();
				});

				VBox forPhar = new VBox();
				forPhar.setSpacing(10);
				forPhar.getChildren().addAll(one, two, three, add);

				one.setAlignment(Pos.CENTER);
				two.setAlignment(Pos.CENTER);
				three.setAlignment(Pos.CENTER);
				add.setAlignment(Pos.CENTER);
				forPhar.setAlignment(Pos.CENTER);

				Scene secondScene = new Scene(forPhar, 400, 250);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Adding new purchasing");
				newWindow.setScene(secondScene);

				// Specifies the modality for new window.
				newWindow.initModality(Modality.WINDOW_MODAL);

				// Specifies the owner Window (parent) for new window
				newWindow.initOwner(primaryStage);

				// Set position of second window, related to primary window.
				newWindow.setX(primaryStage.getX() + 200);
				newWindow.setY(primaryStage.getY() + 100);

				newWindow.show();
			}
		});

		choises.getChildren().addAll(aPhar, aDoc, aPati, aRep, aSale, aCom, aDrug, aPurch);
		choises.setSpacing(20);
		gp.add(choises, 5, 2);
		gp.setAlignment(Pos.CENTER);

		try {
			getPatientData();
			patinetList = FXCollections.observableArrayList(patinets);

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			getPharmacy();
			PharmacyList = FXCollections.observableArrayList(pharmacy);

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			getDoctor();
			DoctorList = FXCollections.observableArrayList(Doctor);

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			getReports();
			ReportsList = FXCollections.observableArrayList(Report);

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			getSales();
			SalesList = FXCollections.observableArrayList(Sales);

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			getDrugs();
			DrugsList = FXCollections.observableArrayList(Drugs);

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			getCompany();
			CompanyList = FXCollections.observableArrayList(Company);

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			getPurchasing();
			PurchasingList = FXCollections.observableArrayList(Purchasing);

		} catch (Exception e) {
			System.out.println(e);
		}

		gp.add(box, 1, 2);
		Bp.setAlignment(gp, Pos.CENTER_RIGHT);
		Bp.setCenter(gp);
		Scene scene = new Scene(Bp, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

	public void connect() {
		try {

//			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			Connection connection = DriverManager
//					.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "insaf123");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "insaf123");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getPatientData() {
		patinets = new ArrayList<>();
		connect();
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from pharmacy.Patients");
			while (r.next()) {
				patinets.add(new PatinetData(Integer.parseInt(r.getString(1)), r.getString(2),
						Integer.parseInt(r.getString(7)), r.getString(3), Integer.parseInt(r.getString(8)),
						r.getString(4), Integer.parseInt(r.getString(6)), Integer.parseInt(r.getString(5))));
			}

			r.close();
			s.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void getCompany() {
		Company = new ArrayList<>();
		connect();
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from pharmacy.Company");
			while (r.next()) {
				Company.add(new Company(Integer.parseInt(r.getString(1)), r.getString(2),
						Integer.parseInt(r.getString(3))));
			}

			r.close();
			s.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void getDoctor() {
		Doctor = new ArrayList<>();
		connect();
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from pharmacy.Doctor");
			while (r.next()) {
				Doctor.add(new Doctor(Integer.parseInt(r.getString(1)), r.getString(2),
						Integer.parseInt(r.getString(4)), r.getString(3)));
			}
			r.close();
			s.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void getDrugs() {
		Drugs = new ArrayList<>();
		connect();
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from pharmacy.drugs");
			while (r.next()) {
				Drugs.add(new Drugs(Integer.parseInt(r.getString(1)), Integer.parseInt(r.getString(6)),
						Integer.parseInt(r.getString(7)), Integer.parseInt(r.getString(9)),
						Integer.parseInt(r.getString(0)), r.getString(2), Integer.parseInt(r.getString(3)),
						r.getString(8), r.getString(4), r.getString(5)));
			}
			r.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getPharmacy() {
		pharmacy = new ArrayList<>();
		connect();
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from pharmacy.pharmacy");
			while (r.next()) {
				pharmacy.add(new Pharmacy(Integer.parseInt(r.getString(1)), r.getString(2), r.getString(3),
						Integer.parseInt(r.getString(4))));
			}
			r.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getPurchasing() {
		Purchasing = new ArrayList<>();
		connect();
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from pharmacy.purchasing");
			while (r.next()) {
				Purchasing.add(new Purchasing(Integer.parseInt(r.getString(1)), Integer.parseInt(r.getString(2)),
						Integer.parseInt(r.getString(3))));
			}
			r.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getReports() {
		Report = new ArrayList<>();
		connect();
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from pharmacy.Reports");
			while (r.next()) {
				Report.add(new Reports(Integer.parseInt(r.getString(1)), Integer.parseInt(r.getString(2)),
						Integer.parseInt(r.getString(3)), Integer.parseInt(r.getString(4)),
						Integer.parseInt(r.getString(6)), r.getString(5)));
			}
			r.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getSales() {
		Sales = new ArrayList<>();
		connect();
		try {
			Statement s = connection.createStatement();
			ResultSet r = s.executeQuery("select * from pharmacy.sales");
			while (r.next()) {
				Sales.add(new Sales(Integer.parseInt(r.getString(1)), Integer.parseInt(r.getString(2)),
						Integer.parseInt(r.getString(3)), Integer.parseInt(r.getString(6)),
						Integer.parseInt(r.getString(7)), r.getString(4), Integer.parseInt(r.getString(5))));
			}
			r.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateName(int id, String name) {
		try {

			connect();
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(
					"update  pharmacy.patients set sname = '" + name + "' where patient_ID = " + id + ";");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

	public void updateAge(int id, int age) {
		try {

			connect();
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(
					"update  pharmacy.patients set age = '" + age + "' where patient_ID = " + id + ";");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

	public void updateGender(int id, String gender) {
		try {

			connect();
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(
					"update  pharmacy.patients set gender = '" + gender + "' where patient_ID = " + id + ";");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

	public void updatePhoneNumber(int id, String phoneNumber) {
		try {

			connect();
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(
					"update  pharmacy.patients set phoneNumber = '" + phoneNumber + "' where patient_ID = " + id + ";");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

	public void updateSiknesName(int id, String siknesName) {
		try {
			connect();
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(
					"update  pharmacy.patients set siknesName = '" + siknesName + "' where patient_ID = " + id + ";");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
		}
	}

	public void insertData(PatinetData p) {
		try {
			connect();
			PreparedStatement a = (PreparedStatement) connection.prepareStatement(
					"insert into pharmacy.patients " + "values(" + p.getId() + "," + "'" + p.getName() + "'" + ","
							+ p.getAge() + "," + "'" + p.getGender() + "'" + "," + p.getPhoneNumber() + ","
							+ "'" + p.getSiknesName() + "'" + "," + p.getDrug_ID() + "," + p.getDoctor_ID() + ");");
			int s = a.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData(Pharmacy p) {
		try {
			connect();
			PreparedStatement a = (PreparedStatement) connection
					.prepareStatement("insert into pharmacy.pharmacy " + "values(" + p.getPharmacy_ID() + "," + "'"
							+ p.getPhname() + "'" + ",'" + p.getAddress() + "'," + p.getPhPhone() + ");");
			int s = a.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData(Doctor p) {
		try {
			connect();
			PreparedStatement a = (PreparedStatement) connection
					.prepareStatement("insert into pharmacy.Doctor " + "values(" + p.getDoctor_ID() + "," + "'"
							+ p.getDname() + "'" + "," + p.getPhone() + "," + "'" + p.getAddress() + "');");
		int s = a.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData(Reports p) {
		try {
			connect();
			PreparedStatement a = (PreparedStatement) connection.prepareStatement("insert into pharmacy.Reports "
					+ "values(" + p.getReport_ID() + "," + p.getPurchase_ID() + "," + p.getDrug_ID() + ","
					+ p.getPatient_ID() + ",'" + p.getDate() + "'," + p.getDoctor_ID() + ");");
		int s = a.executeUpdate();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData(Sales p) {
		try {
			connect();
			PreparedStatement a = (PreparedStatement) connection.prepareStatement("insert into pharmacy.sales "
					+ "values(" + p.getSales_ID() + "," + p.getPatient_ID() + "," + p.getDrugs_ID() + "," + "'"
					+ p.getPhar_com() + "'," + p.getSaleprice() + "," + p.getCount() + "," + p.getPhar_ID() + ");");
		int s = a.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData(Company p) {
		try {
			connect();
			PreparedStatement a = (PreparedStatement) connection.prepareStatement("insert into pharmacy.Company "
					+ "values(" + p.getComp_ID() + "," + "'" + p.getComname() + "'" + "," + p.getcPhone() + ");");
			int s = a.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData(Drugs p) {
		try {
			connect();
			PreparedStatement a = (PreparedStatement) connection.prepareStatement("insert into pharmacy.drugs "
					+ "values(" + p.getDrug_ID() + ",'" + p.getDrname() + "'," + p.getDrprice() + "," + "'"
					+ p.getDescription() + "','" + p.getProduction_Date() + "','" + p.getExpiry_date() + "',"
					+ p.getQuantity() + "," + p.getDoctor_ID() + "," + p.getPatient_ID() + "," + p.getComp_ID() + ");");
		int s = a.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertData(Purchasing p) {
		try {
			connect();
			PreparedStatement a = (PreparedStatement) connection.prepareStatement("insert into pharmacy.purchasing "
					+ "values(" + p.getPurchase_ID() + "," + p.getPatients_ID() + "," + p.getDrug_ID() + ");");
		int s = a.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}