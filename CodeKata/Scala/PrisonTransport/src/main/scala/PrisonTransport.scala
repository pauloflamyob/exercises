object PrisonTransport {
  private def calculateCost(length: Int): Int = Math.sqrt(length).ceil.toInt

  private def getPrisonersHandcuffedGroupsToPrisoner(res: List[List[Int]])(prisoner: Int): List[Int] = prisoner :: res.filter(v => v.contains(prisoner)).flatten

  private def getPrisonersNotAssociatedToPrisoner(res: List[List[Int]], prisoner: Int): List[List[Int]] = res.filter(v => !v.contains(prisoner))

  private def buildHandcuffedGroupOfPrisoners(handcuffedPrisoners: List[List[Int]], prisonerPairHandcuffed: List[Int]): List[List[Int]] = {
    val prisonersHandcuffedToPrisoner1And2 = prisonerPairHandcuffed.flatMap(getPrisonersHandcuffedGroupsToPrisoner(handcuffedPrisoners))
    val prisonerHandcuffedNotAssociatedToPrisoner1And2 = prisonerPairHandcuffed.foldLeft(handcuffedPrisoners)(getPrisonersNotAssociatedToPrisoner)
    prisonersHandcuffedToPrisoner1And2.distinct :: prisonerHandcuffedNotAssociatedToPrisoner1And2
  }

  def query(prisonerCount: Int, handcuffCount: Int, handCuffedPairList: List[List[Int]]): Int = {
    val handcuffedGroupOfPrisoners = handCuffedPairList.foldLeft(List[List[Int]]())(buildHandcuffedGroupOfPrisoners)
    val unhandcuffedPrisonerCount = prisonerCount - handcuffedGroupOfPrisoners.flatten.distinct.length
    handcuffedGroupOfPrisoners.map(_.size).map(calculateCost).sum + unhandcuffedPrisonerCount
  }
}