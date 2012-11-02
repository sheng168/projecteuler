
name := "name"

version := "0.2"

organization := "com.company"

//libraryDependencies += "org.slf4j" % "integration" % "1.6.1"

libraryDependencies += "junit" % "junit" % "4.8"

libraryDependencies += "com.novocode" % "junit-interface" % "0.4" % "test"

crossScalaVersions := Seq("2.10.0-RC1") 

//"2.8.1", "2.9.2", 

scalaVersion := "2.10.0-RC1"

retrieveManaged := true

scalaSource in Compile <<= baseDirectory(_ / "src")