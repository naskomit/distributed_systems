package ds.mr

//import wvlet.airframe.http._

trait IMapReduceRPC[A] {
  type VType = A
  type KVType = KeyValue[A]
  def map(id: String, data: String): Seq[KVType]
  def reduce(key: String, values: Seq[VType]): VType
}
