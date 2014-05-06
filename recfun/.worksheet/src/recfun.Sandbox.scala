package recfun

object Sandbox {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(201); 
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0)
      0
    else if (c == 0 && r == 0)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  };System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(17); val res$0 = 

  pascal(1, 2);System.out.println("""res0: Int = """ + $show(res$0))}
}
