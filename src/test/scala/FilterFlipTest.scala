import Filter.Filter
import Image.GreyscaleImage
import org.scalatest.FunSuite

class FilterFlipTest extends FunSuite {
  test("Flip by x-axis test"){
    val arr1= Array(Array(230,120,99),Array(255,0,100))
    val arr2= Array(Array(10,2,255),Array(50,91,234))

    val img1= new GreyscaleImage()
    img1.SetPixelGrid(2,3)
    img1.FillPixelGrid(arr1)

    val img2= new GreyscaleImage()
    img2.SetPixelGrid(2,3)
    img2.FillPixelGrid(arr2)


    val img3 = Filter.applyFlipX(img1)
    val res3 = Array(Array(255,0,100),Array(230,120,99))
    assert(Comparer.compareMatrices(img3,res3))

    val img4 = Filter.applyFlipX(img2)
    val res4 = Array(Array(50,91,234),Array(10,2,255))
    assert(Comparer.compareMatrices(img4,res4))
  }

  test("Flip by y-axis test"){
    val arr1= Array(Array(230,120,99),Array(255,0,100))
    val arr2= Array(Array(10,2,255),Array(50,91,234))

    val img1= new GreyscaleImage()
    img1.SetPixelGrid(2,3)
    img1.FillPixelGrid(arr1)

    val img2= new GreyscaleImage()
    img2.SetPixelGrid(2,3)
    img2.FillPixelGrid(arr2)


    val img3 = Filter.applyFlipY(img1)
    val res3 = Array(Array(99,120,230),Array(100,0,255))
    assert(Comparer.compareMatrices(img3,res3))

    val img4 = Filter.applyFlipY(img2)
    val res4 = Array(Array(255,2,10),Array(234,91,50))
    assert(Comparer.compareMatrices(img4,res4))
  }
  test("Flip by both axes test"){
    val arr1= Array(Array(230,120,99),Array(255,0,100))
    val arr2= Array(Array(10,2,255),Array(50,91,234))

    val img1= new GreyscaleImage()
    img1.SetPixelGrid(2,3)
    img1.FillPixelGrid(arr1)

    val img2= new GreyscaleImage()
    img2.SetPixelGrid(2,3)
    img2.FillPixelGrid(arr2)


    val img3 = Filter.applyFlipXY(img1)
    val res3 = Array(Array(100,0,255),Array(99,120,230))
    assert(Comparer.compareMatrices(img3,res3))

    val img4 = Filter.applyFlipXY(img2)
    val res4 = Array(Array(234,91,50),Array(255,2,10))
    assert(Comparer.compareMatrices(img4,res4))
  }

}
