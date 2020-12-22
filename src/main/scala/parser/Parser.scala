package parser

object Parser {
  val usage: String = """
    Usage: run [--image] filename         Specifiy file path
               [--flip] x|y|xy|yx         Apply flip filter
               [--invert]                 Apply invert filter
               [--brightness] n           Enhance/decrease brightness
               [--output-file] filepath   Write the output to file
               [--output-console]         Output the result to console

    Order of options does not matter. Output parameter is required.
  """

  var parameters: Map[String,String] = Map()

  /*
    * Parses command line arguments
    * @param command line arguments
  */
  def parse(arguments: Array[String]):Unit ={
    parameters = parameters.empty
    var i = 0
    if (arguments.length == 0) {
      println(usage)
      throw new IllegalArgumentException("No arguments provided")
    }

    while(i < arguments.length) {
      if (arguments(i)=="--output-console" || arguments(i)=="--invert") {
        parameters += (arguments(i) -> "")
        i += 1
      } else {
        parameters += (arguments(i) -> arguments(i+1))
        i += 2
      }

    }

    if (!Parser.parameters.contains("--output-console") &&  !Parser.parameters.contains("--output-file")){
      throw new IllegalArgumentException("Output format not specified")
    }
  }

}