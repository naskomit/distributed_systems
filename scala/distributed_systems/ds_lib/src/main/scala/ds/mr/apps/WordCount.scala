package ds.mr.apps

import scala.collection.mutable
import ds.mr.{IMapReduce, KeyValue}

object WordCount extends IMapReduce[Int] {
  override def map(id: String, data: String): Seq[KVType] = {
    // The map function is called once for each file of input. The first
    // argument is the name of the input file, and the second is the
    // file's complete contents. You should ignore the input file name,
    // and look only at the contents argument. The return value is a slice
    // of key/value pairs.

    // split contents into an array of words.
    val words = data.split("\\W+")
    val kv_pairs = mutable.ArrayBuffer[KVType]()
    for (word <- words) {
      kv_pairs += new KVType(word, 1)
    }

    kv_pairs.toSeq
  }

  override def reduce(key: String, values: Seq[VType]): VType = {
    values.length
  }
}
