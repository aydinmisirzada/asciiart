package FileHandler

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object ImageImporter {
  private var originalName: String = ""

  def getFileName: String = originalName

  /*
  * Reads image file
  * @param path to file
  * @return Image object
  */
  def read(path: String): BufferedImage =
    if (path.contains(".png") || path.contains(".jpg") || path.contains(".jpeg")) {
      val pattern = "\\.(png|jpg|jpeg)"
      var readFrom = ""
      originalName = path
      originalName = originalName.replaceFirst(pattern, "")
      if (path.charAt(0) != '/') {
        readFrom = "./"+path
      } else {
        readFrom = path
      }
      val image: BufferedImage = ImageIO.read(new File(readFrom))
      if (image == null)
        throw new IllegalArgumentException("Image can't be read")
      else
        image
    } else
      throw new IllegalArgumentException("File format not valid")
}
