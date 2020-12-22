object Comparer {

  def compareMatrices(arr1: Array[Array[Int]], arr2: Array[Array[Int]]) : Boolean = {
    if(arr1.length != arr2.length) {
      return false
    }

    for (row <- arr1.indices)
    {
      if(arr1(row).length!=arr2(row).length)
        return false
    }

    for (row <- arr1.indices)
    {
      for (column <- arr1(0).indices)
      {
        if(arr1(row)(column)!=arr2(row)(column))
          return false
      }
    }
    true
  }


}
