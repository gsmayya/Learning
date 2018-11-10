package tutorial.webapp

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document

import org.scalajs.jquery.jQuery

/**
  * Created by gseethar on 8/15/16.
  */
object TutorialApp extends JSApp {

  /*
  @scala.scalajs.js.annotation.JSExport
  override def main(): Unit = {
    appendPar(document.body, "Hello World")
    jQuery("body").append("<p>Hello World From JQuery</p>")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  @JSExport
  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
    jQuery("body").append("You clicked button from JQuery")
  }
  */
  def main(): Unit = {
    jQuery(setupUI _)
  }

  def setupUI(): Unit = {
    // jQuery("#click-me-button").click(addClickedMessage _)
    jQuery("body").append("<p>Hello World</p>")
    jQuery("""<button type="button">Click me!</button>""")
      .click(addClickedMessage _)
      .appendTo(jQuery("body"))
  }

  def addClickedMessage(): Unit = {
    jQuery("body").append("You clicked the button!")
  }
}
