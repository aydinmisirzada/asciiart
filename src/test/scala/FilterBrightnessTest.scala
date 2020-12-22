import Filter.Filter
import Image.GreyscaleImage
import org.scalatest.FunSuite

class FilterBrightnessTest extends FunSuite
{
  test("Brightness filter test")
  {
    val arr1= Array(Array(230,120,99),Array(255,0,100))
    val img1= new GreyscaleImage()
    img1.SetPixelGrid(2,3)
    img1.FillPixelGrid(arr1)

    val img1_test = Filter.applyBrightness(img1,3)
    var res = Array(Array(233,123,102),Array(255,3,103))
    assert(Comparer.compareMatrices(img1_test,res))
    //----
    val arr2= Array(Array(10,2,255),Array(50,91,234))
    val img2= new GreyscaleImage()
    img2.SetPixelGrid(2,3)
    img2.FillPixelGrid(arr2)

    val img2_test = Filter.applyBrightness(img2,-10)
    res = Array(Array(0,0,245),Array(40,81,224))
    assert(Comparer.compareMatrices(img2_test,res))
    //-------
    val arr3= Array(Array(10,2,255),Array(50,91,234))
    val img3= new GreyscaleImage()
    img3.SetPixelGrid(2,3)
    img3.FillPixelGrid(arr3)

    val img3_test = Filter.applyBrightness(img3,256)
    res = Array(Array(255,255,255),Array(255,255,255))
    assert(Comparer.compareMatrices(img3_test,res))
    //-----
    val arr4= Array(Array(10,234,0),Array(33,100,224))
    val img4= new GreyscaleImage()
    img4.SetPixelGrid(2,3)
    img4.FillPixelGrid(arr4)

    val img4_test = Filter.applyBrightness(img4,0)
    res = Array(Array(10,234,0),Array(33,100,224))
    assert(Comparer.compareMatrices(img4_test,res))

  }
}
