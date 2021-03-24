resolvers += Resolver.url("hmrc-sbt-plugin-releases", url("https://https://dl.bintray.com/gatling/sbt-plugins"))(Resolver.ivyStylePatterns)
resolvers += Resolver.url("gatling", url("https://https://dl.bintray.com/gatling/sbt-plugins"))(Resolver.ivyStylePatterns)

addSbtPlugin("io.gatling" % "gatling-sbt" % "2.2.2")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")
