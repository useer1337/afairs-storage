package org.example.app.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;
import javafx.scene.control.TreeView;
import org.example.app.factory.DialogFactory;
import org.example.app.graphics.treeitem.GroupTreeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddItemButtonHandler implements EventHandler<ActionEvent> {

  private static final Logger logger = LoggerFactory.getLogger(AddItemButtonHandler.class);

  private final TreeView<String> treeView;
  private final DialogFactory dialogFactory = new DialogFactory();

  public AddItemButtonHandler(TreeView<String> treeView) {
    this.treeView = treeView;
  }

  @Override
  public void handle(ActionEvent actionEvent) {
    Dialog<String> dialog = dialogFactory.createItemDialog();

    dialog.showAndWait()
        .ifPresentOrElse(groupName -> {
          treeView.getRoot().getChildren().add(new GroupTreeItem(groupName));
        }, () -> {
          logger.warn("Empty result from dialog");
        });
  }
}
