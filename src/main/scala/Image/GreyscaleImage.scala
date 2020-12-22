package Image

import parser.Parser
import Filter.Filter

class GreyscaleImage() {
  private var PixelGrid: Array[Array[Int]] = _
  private var height: Int = 0
  private var width: Int = 0

  def getWidth:Int = this.width
  def getHeight:Int = this.height
  def GetPixelGrid(): Array[Array[Int]] = this.PixelGrid

  /*
    * Sets up pixel grid
    * @param height and width parameters
  */
  def SetPixelGrid(h: Int,w: Int): Unit = {
    this.PixelGrid = Array.ofDim[Int](h, w)
    this.height = h
    this.width = w
  }

  /*
    * Fills pixel grid
    * @param 2d array values
  */
  def FillPixelGrid(arr: Array[Array[Int]]): Unit = {
    for (y <- 0 until height) {
      for (x <- 0 until width) {
        this.PixelGrid(y)(x) = arr(y)(x)
      }
    }
  }

  /*
    * Sets pixel value
    * @param pixel grid x and y parameters
  */
  def GreyscalePixel(y: Int,x: Int, value: Int): Unit = {
    this.PixelGrid(y)(x) = value
  }

  /*
    * Greyscale image object constructor from RGBImage
    * @param RGBImage
  */
  def this(RGBImage: RGBImage){
      this()
      val height = RGBImage.getHeight
      val width = RGBImage.getWidth
      this.SetPixelGrid(height,width)

      for (y <- 0 until height) {
        for (x <- 0 until width) {
            val col = RGBImage.getPixel(x,y)

            val red = (col.getRed * 0.3).toInt
            val green: Int = (col.getGreen * 0.59).toInt
            val blue: Int = (col.getBlue * 0.11).toInt

            var color: Int = red + green + blue

            if (Parser.parameters.contains("--invert")){
              color = Filter.invertPixel(color)
            }

            if (Parser.parameters.contains("--brightness")){
              val brightness = Parser.parameters("--brightness").toInt
              color = Filter.pixelBrightness(color,brightness)
            }
            GreyscalePixel(y,x,color)
        }
      }
  }

}
