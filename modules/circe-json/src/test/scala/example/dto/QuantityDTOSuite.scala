package example.dto

import cats.Eq
import io.circe.testing.ArbitraryInstances
import io.circe.testing.golden.GoldenCodecTests
import munit.DisciplineSuite
import org.scalacheck.Arbitrary
import org.scalacheck.Gen

class QuantityDTOSuite extends DisciplineSuite, ArbitraryInstances:
  // Constant generation keeps fixture contents independent of the seed.
  given Arbitrary[QuantityDTO] = Arbitrary(Gen.const(QuantityDTO(2, "kg")))
  given Eq[QuantityDTO] = Eq.fromUniversalEquals

  checkAll("GoldenCodec[QuantityDTO]", GoldenCodecTests[QuantityDTO].goldenCodec)
