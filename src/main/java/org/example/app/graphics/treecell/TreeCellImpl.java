package org.example.app.graphics.treecell;

import javafx.scene.control.TreeCell;
import org.example.app.graphics.treeitem.AbstractTreeItem;

public class TreeCellImpl extends TreeCell<String> {

  @Override
  public void updateItem(String item, boolean empty) {
    super.updateItem(item, empty);

    if (empty) {
      setText(null);
      setGraphic(null);
    } else {
      setText(getItem() == null ? "" : getItem());
      setGraphic(getTreeItem().getGraphic());
      setContextMenu(((AbstractTreeItem) getTreeItem()).getMenu());
      setOnKeyPressed(((AbstractTreeItem) getTreeItem()).getDeleteFromKeyEventHandler());
    }
  }
}
