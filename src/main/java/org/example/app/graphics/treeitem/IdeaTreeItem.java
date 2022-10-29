package org.example.app.graphics.treeitem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class IdeaTreeItem extends AbstractTreeItem{

  public IdeaTreeItem(String itemName) {
    super(itemName);
  }

  @Override
  public ContextMenu getMenu() {
    var deleteMenuItem = new MenuItem("Delete");
    deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        deleteItem();
      }
    });
    return new ContextMenu(deleteMenuItem);
  }
}
