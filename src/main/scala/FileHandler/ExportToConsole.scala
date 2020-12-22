package FileHandler

class ExportToConsole(image: String) extends ImageExporter {
  /*
    * Prints string to console
  */
  override def print(): Unit = {
    println(image)
  }
}

