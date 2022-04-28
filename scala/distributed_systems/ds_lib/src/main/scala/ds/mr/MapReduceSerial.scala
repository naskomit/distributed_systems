package ds.mr

object MapReduceSerial {
  def map_reduce[A](app: IMapReduce[A], inputs: Seq[(String, String)]): Seq[(String, A)] = {
    type VType = A
    type KVType = KeyValue[A]
    val intermediate: Seq[KVType] = inputs.flatMap(input => app.map(input._1, input._2))
    val sorted: Seq[(String, Seq[VType])] = intermediate.groupMap(x => x.key)(kv => kv.value).toSeq
    val result = sorted.map(item => (item._1, app.reduce(item._1, item._2)))
    result
  }
}
