package org.example.app;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.app.graphics.treecell.TreeCellImpl;
import org.example.app.handler.AddItemButtonHandler;
import org.example.app.handler.DeleteItemHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  private static final String ADD_ITEM_BUTTON_TEXT = "Add new group";

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws Exception {

    TreeView<String> treeView = createTreeView();

    Button addItemButton = new Button(ADD_ITEM_BUTTON_TEXT);
    addItemButton.setOnAction(new AddItemButtonHandler(treeView));

    VBox vBox = new VBox(addItemButton, treeView);
    VBox.setVgrow(treeView, Priority.ALWAYS);

    var htmlEditor = new HTMLEditor();

    HBox hBox = new HBox(vBox, htmlEditor);

    HBox.setHgrow(htmlEditor, Priority.ALWAYS);

    Scene scene = new Scene(hBox, 1200, 600);
    stage.setTitle("Affairs Storage");
    stage.setScene(scene);
    stage.show();

  }

  /**
   * Create TreeView element
   */
  private TreeView<String> createTreeView() {
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

    return treeView;
  }

}
