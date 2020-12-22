import org.scalatest.FunSuite
import parser.Parser

class ParserTest extends FunSuite {
    test("Command line parser test"){

      var input1 = Array("--image","img.jpg","--output-console")
      Parser.parse(input1)

      var ref1 = Map("--image" -> "img.jpg", "--output-console" -> "")
      var output1 = Parser.parameters
      assert(output1.equals(ref1))

      var input2 = Array("--image","img.jpg","--output-file","file","--invert","--flip","xy")
      Parser.parse(input2)

      var ref2 = Map("--image" -> "img.jpg", "--output-file" -> "file","--invert" -> "","--flip" -> "xy")
      var output2 = Parser.parameters
      assert(output2.equals(ref2))

      var input3 = Array("--image","img.jpg","--output-file","file","--invert","--flip","xy","--brightness","-5")
      Parser.parse(input3)

      var ref3 = Map("--image" -> "img.jpg", "--output-file" -> "file","--brightness"->"-5","--invert" -> "","--flip" -> "xy","--brightness"->"-5")
      var output3 = Parser.parameters
      assert(output3.equals(ref3))

    }


}
