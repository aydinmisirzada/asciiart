package Image

import java.awt.Color

trait Image {
    def getPixel(x: Int,y: Int): Color
}

