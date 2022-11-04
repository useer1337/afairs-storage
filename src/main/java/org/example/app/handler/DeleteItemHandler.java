package org.example.app.handler;

import javafx.event.EventHandler;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.example.app.graphics.treeitem.AbstractTreeItem;

public class DeleteItemHandler implements EventHandler<KeyEvent> {

  private final TreeView<String> treeView;

  public DeleteItemHandler(TreeView<String> treeView) {
    this.treeView = treeView;
  }

  @Override
  public void handle(KeyEvent keyEvent) {
    if (keyEvent.getCode().equals(KeyCode.DELETE)) {
      ((AbstractTreeItem) treeView.getSelectionModel().getSelectedItem()).deleteItem();
    }
  }
}
