package org.example.app.handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;
import org.example.app.factory.DialogFactory;
import org.example.app.graphics.treeitem.GroupTreeItem;
import org.example.app.graphics.treeitem.IdeaTreeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddGroupItemHandler implements EventHandler<ActionEvent> {

  private static final Logger logger = LoggerFactory.getLogger(AddGroupItemHandler.class);

  private final GroupTreeItem groupTreeItem;
  private final DialogFactory dialogFactory = new DialogFactory();

  public AddGroupItemHandler(GroupTreeItem groupTreeItem) {
    this.groupTreeItem = groupTreeItem;
  }

  @Override
  public void handle(ActionEvent actionEvent) {
    Dialog<String> dialog = dialogFactory.createItemDialog();

    dialog.showAndWait()
        .ifPresentOrElse(
            groupItemName -> groupTreeItem.getChildren().add(new IdeaTreeItem(groupItemName)),
            () -> logger.warn("Empty result from dialog"));
  }
}
