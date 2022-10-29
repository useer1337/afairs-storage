package org.example.app.graphics.treeitem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import org.example.app.handler.AddGroupItemHandler;

public class GroupTreeItem extends AbstractTreeItem {

  public GroupTreeItem(String itemName) {
    super(itemName);
  }

  @Override
  public ContextMenu getMenu() {
    var addMenuItem = new MenuItem("Add new item");
    addMenuItem.setOnAction(new AddGroupItemHandler(this));

    var deleteMenuItem = new MenuItem("Delete");
    deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        deleteItem();
      }
    });
    return new ContextMenu(addMenuItem, deleteMenuItem);
  }
}
