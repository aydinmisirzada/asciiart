import Filter.Filter
import Image.GreyscaleImage
import org.scalatest.FunSuite

class FilterInvertTest extends FunSuite
{
  test("Invert filter test")
  {
    val arr1= Array(Array(230,120,99),Array(255,0,100))
    val arr2= Array(Array(10,2,255),Array(50,91,234))

    val img1= new GreyscaleImage()
    img1.SetPixelGrid(2,3)
    img1.FillPixelGrid(arr1)

    val img2= new GreyscaleImage()
    img2.SetPixelGrid(2,3)
    img2.FillPixelGrid(arr2)

    val img3 = Filter.applyInvert(img1)
    val res3 = Array(Array(25,135,156),Array(0,255,155))
    assert(Comparer.compareMatrices(img3,res3))

    val img4 = Filter.applyInvert(img2)
    val res4 = Array(Array(245,253,0),Array(205,164,21))
    assert(Comparer.compareMatrices(img4,res4))
  }
}
