import ds.mr.{IMapReduce, KeyValue, MapReduceSerial}
import ds.mr.apps.WordCount
import io.github.classgraph.ClassGraph

import scala.jdk.CollectionConverters._
import scala.util.{Failure, Success, Using}

object MapReduce {
  def read_file(path: String) = scala.io.Source.fromResource(path).mkString

  def scan_resources(folder: String): Seq[String] = {
    Using((new ClassGraph).acceptPaths(folder).scan) {scan_result =>
      scan_result.getAllResources.getPaths.asScala.toSeq
    } match {
      case Success(items) => items
      case Failure(exception) => throw new RuntimeException(s"Cannot read folder $folder")
    }
  }


  def main(args: Array[String]): Unit = {
    val input_folder = args(0)
    val input_files = scan_resources(input_folder)
    val file_content = input_files.map(f => (f, read_file(f)))
    val result = MapReduceSerial.map_reduce(WordCount, file_content).sortBy {
      case (k,v) => v
    }
    println(result)
    println(result.length)
  }



}
