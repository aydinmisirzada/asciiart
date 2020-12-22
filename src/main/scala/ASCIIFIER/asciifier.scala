package ASCIIFIER

import Filter.Filter
import Image.GreyscaleImage
import parser.Parser

object ASCIIFIER {

  val conversion: String = "$@B%8&M#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|)1}[]?-_+~>i!lI;:,^`'. "
  var imageString: String = ""

  /*
  * Converts Greyscale image to String
  * @param Greyscale Image
  * @return String
  * */

  def asciify(image: GreyscaleImage): String = {
    imageString = ""
    var grid = image.GetPixelGrid()
    if (Parser.parameters.contains("--flip")){
      if (Parser.parameters("--flip") == "x") {
        grid = Filter.applyFlipX(image)
      }
      if (Parser.parameters("--flip") == "y") {
        grid = Filter.applyFlipY(image)
      }
      if (Parser.parameters("--flip") == "xy" || Parser.parameters("--flip") == "yx") {
        grid = Filter.applyFlipXY(image)
      }
    }

    val width: Int = image.getWidth
    val height: Int = image.getHeight

    for (y <- 0 until height){
      for (x <- 0 until width){
        imageString += conversion((grid(y)(x) * (conversion.length.toFloat / 256)).toInt)
      }
      imageString += "\n"
    }
    imageString
  }

}
