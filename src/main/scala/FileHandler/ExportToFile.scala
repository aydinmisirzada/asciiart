package FileHandler

import java.io.{BufferedWriter, File, FileWriter}

class ExportToFile(image: String,path: String) extends ImageExporter {
  /*
    * Writes string to .txt file
    * @param image string and path, if pwd is given as path, saves to current directory
  */
  override def print(): Unit = {
    var outputName = ""
    var writeTo = ""

    if (path == "pwd") {
      println("Writing to current directory, using default file name...")
      outputName = ImageImporter.getFileName
      writeTo = "./"
    }

    if (path.charAt(0) != '/') {
      writeTo = "./"+path
    } else {
      writeTo = path
    }
    val outputFile = new File(writeTo + outputName + ".txt")
    val bw = new BufferedWriter(new FileWriter(outputFile))
    bw.write(image)
    bw.close()
  }

}