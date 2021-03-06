package main.params

object Params {
  def isTestCaseE(implicit file: String) = file match {
    case "e_shiny_selfies.txt" => true
    case _ => false
  }
  def getSolver(implicit file: String) = file match {
    case "b_lovely_landscapes.txt" => SolverType.GreedyPhoto
    case "e_shiny_selfies.txt" => SolverType.GreedyPhoto
    case "c_memorable_moments.txt" => SolverType.HamiltonianPath
    case "a_example.txt" => SolverType.GreedySlide
    case _ => SolverType.GreedySlide
  }

  object SolverType extends Enumeration {
    type SolverType = Value
    val GreedyPhoto, GreedySlide, HamiltonianPath = Value
  }
}
