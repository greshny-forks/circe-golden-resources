package example.dto

import io.circe.testing.golden.Resources
import java.nio.file.Paths
import munit.FunSuite

class ResourceDirectorySuite extends FunSuite:
  test("inferred resource directory matches the module Test / resourceDirectory"):
    val expected = Paths.get(sys.props("example.resourceDirectory")).toAbsolutePath.normalize()
    val inferred = Resources.inferRootDir(classOf[QuantityDTO]).toPath.toAbsolutePath.normalize()
    val codeSource = classOf[QuantityDTO].getProtectionDomain.getCodeSource.getLocation

    println(s"DTO code source: $codeSource")
    println(s"sbt Test / resourceDirectory: $expected")
    println(s"circe-golden inferred directory: $inferred")
    assertEquals(inferred, expected)
