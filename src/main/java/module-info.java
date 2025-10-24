module claxton {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens claxton to javafx.fxml;
    exports claxton;
}
