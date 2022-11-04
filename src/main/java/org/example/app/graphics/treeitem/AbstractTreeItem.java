package org.example.app.graphics.treeitem;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract TreeItem for add custom TreeItem
 */
public abstract class AbstractTreeItem extends TreeItem {

  private static final Logger logger = LoggerFactory.getLogger(AbstractTreeItem.class);

  public AbstractTreeItem(String itemName) {
    this.setValue(itemName);
  }

  public abstract ContextMenu getMenu();

  public void deleteItem() {
    this.getParent().getChildren().remove(this);
  }

}
