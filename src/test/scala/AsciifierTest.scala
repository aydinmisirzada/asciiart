import Image.GreyscaleImage
import org.scalatest.FunSuite
import ASCIIFIER.ASCIIFIER

class AsciifierTest extends FunSuite {
  test("Asciifier Test"){
    val arr1= Array(Array(255,255,255),Array(255,255,255))
    val img1= new GreyscaleImage()
    img1.SetPixelGrid(2,3)
    img1.FillPixelGrid(arr1)

    var output = ASCIIFIER.asciify(img1)
    var ref = "   \n"+"   \n"
    assert(output == ref)

    val arr2= Array(Array(0,0,0),Array(0,0,0))
    val img2= new GreyscaleImage()
    img2.SetPixelGrid(2,3)
    img2.FillPixelGrid(arr2)

    output = ASCIIFIER.asciify(img2)
    ref = "$$$\n"+"$$$\n"
    assert(output == ref)

  }
}
