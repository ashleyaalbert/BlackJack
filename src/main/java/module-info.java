module csci205_final_project {
//    requires java.base;
//    requires java.desktop;
//    requires java.sql;
//    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports org.team04.blackjackmvc;
    opens org.team04.blackjackmvc to javafx.fxml;
    exports org.team04.blackjackmvc.controller;
    opens org.team04.blackjackmvc.controller to javafx.fxml;
//    exports org.team04.blackjackmvc.model;
//    opens org.team04.blackjackmvc.model to javafx.fxml;

}