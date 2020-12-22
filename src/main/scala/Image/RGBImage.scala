package Image

import java.awt.Color
import java.awt.image.BufferedImage

class RGBImage(image: BufferedImage) extends Image {
  override def getPixel(x: Int, y: Int): Color = new Color(image.getRGB(x, y))
  def getWidth: Int = image.getWidth
  def getHeight: Int = image.getHeight

  /*
    * Converts RGBImage to Greyscale
    * @param RGBImage
  */
  def toGreyscale: GreyscaleImage = new GreyscaleImage(this)
}
