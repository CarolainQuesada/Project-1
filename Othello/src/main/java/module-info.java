module cr.ac.lab.othello {
    requires javafx.controls;
    requires javafx.fxml;

    opens cr.ac.lab.othello to javafx.fxml;
    exports cr.ac.lab.othello;
}
