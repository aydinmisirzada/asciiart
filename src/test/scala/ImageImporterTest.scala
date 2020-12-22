import org.scalatest.FunSuite
import FileHandler.ImageImporter
import Image.RGBImage
import main.Main.image

class ImageImporterTest extends  FunSuite{
  test("Wrong image format test") {
    assertThrows[IllegalArgumentException](ImageImporter.read("src/test/images/wrong.txt"))
  }

  test("Existing image test"){
    val image = ImageImporter.read("src/test/images/black.jpg")
    val img_gs = new RGBImage(image).toGreyscale
    val output = img_gs.GetPixelGrid()

    val ref = Array(Array(249,249,249),Array(249,249,249))

    assert(Comparer.compareMatrices(output,ref))

  }

}
