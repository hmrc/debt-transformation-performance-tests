import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"            %% "performance-test-runner"   % "6.1.0"        % Test,
    "org.playframework"      %% "play-ahc-ws-standalone"    % "3.0.7",
    "com.github.nscala-time" %% "nscala-time"               % "2.32.0",
    "org.scalaj"             %% "scalaj-http"               % "2.4.2",
    "com.github.mifmif"       % "generex"                   % "1.0.2",
    "org.apache.pekko"       %% "pekko-http"                % "1.1.0",
    "org.apache.pekko"       %% "pekko-stream"              % "1.1.2",
    "io.circe"               %% "circe-core"                % "0.14.9",
    "io.circe"               %% "circe-generic"             % "0.14.10",
    "io.circe"               %% "circe-parser"              % "0.14.10",
    "com.typesafe.play"      %% "play-json"                 % "2.10.6"

  )
  val dependencyOverrides = Seq(
    "org.scala-lang.modules" %% "scala-parser-combinators" % "2.4.0",
    "org.slf4j"               % "slf4j-api"                % "1.7.30"
  )
}
