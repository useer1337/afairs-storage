package org.example.app.factory;

import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DialogFactory {

  /**
   * Create dialog window for add new items
   */
  public Dialog<String> createItemDialog() {
    var dialog = new Dialog<String>();

    var itemGroupTextField = new TextField();
    itemGroupTextField.setPromptText("Item name");

    var vbox = new VBox(itemGroupTextField);

    dialog.getDialogPane().setContent(vbox);

    var saveButtonType = new ButtonType("Create", ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

    dialog.setResultConverter(buttonType -> {
      if (buttonType.equals(saveButtonType)) {
        return itemGroupTextField.getText();
      }

      return null;
    });

    return dialog;
  }

}
