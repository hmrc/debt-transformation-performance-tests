
resolvers += "HMRC-open-artefacts-maven" at "https://open.artefacts.tax.service.gov.uk/maven2"
resolvers += Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns)
resolvers += Resolver.url("gatling", url("https://search.maven.org/artifact/io.gatling/gatling-sbt"))(Resolver.ivyStylePatterns)

addSbtPlugin("io.gatling"    % "gatling-sbt"  % "4.9.2")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.0")
addSbtPlugin("uk.gov.hmrc" % "sbt-auto-build" % "3.22.0")

// To use this plugin, run: sbt dependencyUpdates
addSbtPlugin("com.timushev.sbt"  % "sbt-updates"        % "0.6.4")

/* Allows commands like `sbt dependencyBrowseGraph` to view the dependency graph locally. */
addDependencyTreePlugin