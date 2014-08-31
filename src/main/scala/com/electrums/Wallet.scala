package com.electrums

import scala.io.Source
import de.flexiprovider.common.math.FlexiBigInt
import java.math.BigInteger

class Wallet {

}

object Wallet {
  def apply(seedWords: List[String]) = {
    val digits = seedWords.map {
      w => WordList.words(w)
    }
    val len = FlexiBigInt.valueOf(seedWords.length)
    val seed = digits.foldLeft(FlexiBigInt.ZERO)((acc, digit) => acc.multiply(len).add(FlexiBigInt.valueOf(digit)))
    
  }

  def main(args: Array[String]) {
    val mnemonic = List("between", "offer", "freely", "choke", "scrape", "ourselves", "cheap", "surprise", "heaven", "puff", "ignore", "orange")
    val w = Wallet(mnemonic)
  }
}

object WordList {
  val words = load()
  
  def load() = {
    val is = getClass().getResourceAsStream("/english.txt")
    val s = Source.fromInputStream(is)
    s.getLines().zipWithIndex.map {
      case (w, i) => w -> i
    }.toMap
  }
}