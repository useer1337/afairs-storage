package org.example.app;

import com.sun.source.doctree.DocTree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.app.graphics.treecell.TreeCellImpl;
import org.example.app.handler.AddItemButtonHandler;
import org.example.app.handler.DeleteItemHandler;
import org.example.app.handler.DoubleClickItemHandler;

public class Main extends Application {

  private static final String ADD_ITEM_BUTTON_TEXT = "Add new group";
  private static final String APPLICATION_NAME = "Affairs Storage";

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws Exception {
    HBox mainBox = new HBox();

    TreeView<String> treeView = createTreeView(mainBox);

    Button addItemButton = new Button(ADD_ITEM_BUTTON_TEXT);
    addItemButton.setOnAction(new AddItemButtonHandler(treeView));

    VBox vBox = new VBox(addItemButton, treeView);
    VBox.setVgrow(treeView, Priority.ALWAYS);

    mainBox.getChildren().add(vBox);

    Scene scene = new Scene(mainBox, 1200, 600);
    stage.setTitle(APPLICATION_NAME);
    stage.setScene(scene);
    stage.show();

  }

  /**
   * Create TreeView element
   */
  private TreeView<String> createTreeView(HBox mainBox) {
    TreeItem<String> rootTreeItem = new TreeItem<>();
    rootTreeItem.setExpanded(true);

    TreeView<String> treeView = new TreeView<>(rootTreeItem);
    treeView.setShowRoot(false);
    treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
      @Override
      public TreeCell<String> call(TreeView<String> stringTreeView) {
        return new TreeCellImpl();
      }
    });
    // TODO костыль, нужно посмотреть и перенести логику в TreeCell
    treeView.setOnKeyPressed(new DeleteItemHandler(treeView));
    treeView.setOnMouseClicked(new DoubleClickItemHandler(mainBox));

    return treeView;
  }

}
