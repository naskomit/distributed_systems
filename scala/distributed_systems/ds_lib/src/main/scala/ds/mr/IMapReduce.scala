package ds.mr

case class KeyValue[A](key: String, value: A)

trait IMapReduce[A] {
  type VType = A
  type KVType = KeyValue[A]
  def map(id: String, data: String): Seq[KVType]
  def reduce(key: String, values: Seq[VType]): VType
}
