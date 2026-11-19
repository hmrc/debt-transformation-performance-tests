import sbt.*

object Dependencies {

  val test                = Seq(
    "uk.gov.hmrc"            %% "performance-test-runner" % "6.3.0" % Test,
    "org.playframework"      %% "play-ahc-ws-standalone"  % "3.0.13" exclude ("org.scala-lang.modules", "scala-parser-combinators_3"),
    "com.github.nscala-time" %% "nscala-time"             % "3.0.0",
    "com.github.mifmif"       % "generex"                 % "1.0.2",
    "io.circe"               %% "circe-core"              % "0.14.16",
    "io.circe"               %% "circe-generic"           % "0.14.16",
    "io.circe"               %% "circe-parser"            % "0.14.16",
    "com.typesafe.play"      %% "play-json"               % "2.10.8"
  )
  val dependencyOverrides = Seq(
    "org.slf4j" % "slf4j-api" % "2.0.18"
  )
}
