import sbt._

object Dependencies {

  private val gatlingVersion = "3.6.1"

  val test = Seq(
    "com.typesafe"            % "config"                    % "1.4.2"        % Test,
    "uk.gov.hmrc"            %% "performance-test-runner"   % "5.6.0"        % Test,
    "io.gatling"              % "gatling-test-framework"    % gatlingVersion % Test,
    "io.gatling.highcharts"   % "gatling-charts-highcharts" % gatlingVersion % Test,
    "org.playframework"      %% "play-ahc-ws-standalone"    % "3.0.0",
    "com.github.nscala-time" %% "nscala-time"               % "2.22.0",
    "org.scalaj"             %% "scalaj-http"               % "2.4.2",
    "com.github.mifmif"       % "generex"                   % "1.0.2",
    "org.apache.pekko"       %% "pekko-http"                % "1.0.0",
    "org.apache.pekko"       %% "pekko-stream"              % "1.0.1",
    "io.circe"               %% "circe-core"                % "0.14.6",
    "io.circe"               %% "circe-generic"             % "0.14.6",
    "io.circe"               %% "circe-parser"              % "0.14.6"
  )

  val dependencyOverrides = Seq(
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
    "org.slf4j" % "slf4j-api" % "1.7.30"
  )
}
