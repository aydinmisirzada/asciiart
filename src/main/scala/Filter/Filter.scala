package Filter

import Image.GreyscaleImage

object Filter {
  /*
    * Inverts pixel
    * @param pixel in integer format
    * @return inverted pixel integer
  */
    def invertPixel(color: Int): Int = 255 - color

  /*
    * Inverts pixel array
    * @param Greyscale image object
    * @return 2d array of pixels
  */
    def applyInvert(image: GreyscaleImage): Array[Array[Int]] = {
      var grid = image.GetPixelGrid()
      val width = image.getWidth
      val height = image.getHeight

      for (y <- 0 until height) {
        for (x <- 0 until width) {
          grid(y)(x) = 255 - grid(y)(x)
        }
      }

      grid
    }

  /*
    * Changes pixel brightness
    * @param pixel integer and brightness
    * @return pixel integer
  */
    def pixelBrightness(color:Int, brightness: Int): Int = {
      var c = 0
      if(color + brightness > 255)
        c = 255
      else if( color + brightness  < 0)
        c = 0
      else
        c = color + brightness
      c
    }

  /*
    * Applies brightness filter to greyscale image
    * @param Greyscale image object
    * @return 2d array of pixels
  */
    def applyBrightness(image: GreyscaleImage,brightness: Int): Array[Array[Int]] = {
      var grid = image.GetPixelGrid()
      val width = image.getWidth
      val height = image.getHeight

      for (y <- 0 until height) {
        for (x <- 0 until width) {
          grid(y)(x) = pixelBrightness(grid(y)(x),brightness)
        }
      }

      grid
    }

  /*
    * Flips image by x-axis
    * @param Greyscale image object
    * @return 2d array of pixels
  */
    def applyFlipX(image: GreyscaleImage): Array[Array[Int]] = {
      var grid = image.GetPixelGrid()

      val width: Int = image.getWidth
      val height: Int = image.getHeight

      for (x <- 0 until width) {
        for (y <- 0 until height/2) {
          var tmp = grid(height-y-1)(x)
          grid(height-y-1)(x) = grid(y)(x)
          grid(y)(x) = tmp
        }
      }
      grid
    }

  /*
    * Flips image by y-axis
    * @param Greyscale image object
    * @return 2d array of pixels
  */
  def applyFlipY(image: GreyscaleImage): Array[Array[Int]] = {
    var grid = image.GetPixelGrid()


    val width: Int = image.getWidth
    val height: Int = image.getHeight

    for (y <- 0 until height) {
      for (x <- 0 until width/2) {
        var tmp = grid(y)(width-x-1)
        grid(y)(width-x-1) = grid(y)(x)
        grid(y)(x) = tmp
      }
    }
    grid
  }

  /*
    * Flips image by both X and Y axes
    * @param Greyscale image object
    * @return 2d array of pixels
  */
  def applyFlipXY(image: GreyscaleImage): Array[Array[Int]] = {
    var grid = this.applyFlipX(image)

    val width: Int = image.getWidth
    val height: Int = image.getHeight

    for (y <- 0 until height) {
      for (x <- 0 until width/2) {
        var tmp = grid(y)(width-x-1)
        grid(y)(width-x-1) = grid(y)(x)
        grid(y)(x) = tmp
      }
    }
    grid
  }
}
