package org.example.app.handler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.HTMLEditor;
import org.example.app.factory.HTMLEditorFactory;

public class DoubleClickItemHandler implements EventHandler<MouseEvent> {

  private HBox mainBox;

  public DoubleClickItemHandler(HBox mainBox) {
    this.mainBox = mainBox;
  }

  @Override
  public void handle(MouseEvent mouseEvent) {
    if (mouseEvent.getClickCount() == 2) {
      int size = mainBox.getChildren().size();
      if (size > 1){
        mainBox.getChildren().remove(1, size);
      }

      HTMLEditor htmlEditor = new HTMLEditorFactory().createHtmlEditor();
      mainBox.getChildren().add(htmlEditor);
      HBox.setHgrow(htmlEditor, Priority.ALWAYS);
    }
  }

}
