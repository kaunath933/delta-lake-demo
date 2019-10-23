// This plugin is used to check scala styles.
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

// This plugin is used to generate scala code coverage report.
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

//This plugin is used for duplicate code detection using Copy/Paste Detector (CPD) from the PMD project.
addSbtPlugin("com.github.sbt" % "sbt-cpd" % "2.0.0")