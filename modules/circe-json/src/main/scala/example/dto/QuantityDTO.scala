package example.dto

import io.circe.Codec

final case class QuantityDTO(value: Int, unit: String) derives Codec.AsObject
