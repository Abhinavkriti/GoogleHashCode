package main.scorer

import main.framework.{ProgressBar, Score}
import main.models.{Cache, Endpoint}

import scala.collection.mutable.ArrayBuffer

object Scorer {
  def compute(endpoints: ArrayBuffer[Endpoint]): Score = {
    val max = 0

    var totalSaved = 0L
    var totalRequests = 0L
    val pb = new ProgressBar("Score", endpoints.size)
    endpoints.foreach{ end =>
      end.requests.foreach{ req =>
        totalSaved += req.qty * (end.latency - end.links.filter(_.cache.videos.contains(req.video.id)).map(_.latency).sorted.headOption.getOrElse(end.latency))
        totalRequests += req.qty
      }
      pb.update()
    }

    Score(totalSaved / totalRequests * 1000, max)
  }
}