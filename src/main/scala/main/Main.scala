package main

import ASCIIFIER.ASCIIFIER
import parser.Parser
import FileHandler.{ExportToConsole, ExportToFile, ImageImporter}
import Image.RGBImage

object Main extends App {

  Parser.parse(args)
  var image = ImageImporter.read(Parser.parameters("--image"))
  var greyscaleImage = new RGBImage(image).toGreyscale

  var converted = ASCIIFIER.asciify(greyscaleImage)

  if (Parser.parameters.contains("--output-console")) {
    new ExportToConsole(converted).print()
  } else if (Parser.parameters.contains("--output-file")) {
    new ExportToFile(converted,Parser.parameters("--output-file")).print()
  }

}
