package org.example.app.graphics.treeitem;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TreeItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract TreeItem for add custom ContextMenu
 */
public abstract class AbstractTreeItem extends TreeItem {

  private static final Logger logger = LoggerFactory.getLogger(AbstractTreeItem.class);

  public AbstractTreeItem(String itemName) {
    this.setValue(itemName);
  }

  public abstract ContextMenu getMenu();

  protected void deleteItem() {
    this.getParent().getChildren().remove(this);
  }

  public EventHandler<KeyEvent> getDeleteFromKeyEventHandler() {
    return new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent keyEvent) {
        logger.info(keyEvent.getCode().getName());

        if (keyEvent.getCode().equals(KeyCode.DELETE)) {
          deleteItem();
        }
      }
    };
  }

}
