# circe-golden resource path bug

This example uses sbt 2.0.9, Scala 3.8.4, and circe-golden 0.5.1.

Run these commands from this folder:

```sh
sbt 'circe-json / Test / testOnly example.dto.ResourceDirectorySuite'
sbt 'circe-json / Test / testOnly example.dto.QuantityDTOSuite'
```

The first test fails because circe-golden chooses the wrong folder:

- Expected: `modules/circe-json/src/test/resources`
- Actual: `src/test/resources`

The second test passes, but each run creates a new JSON file in the wrong folder.
The saved JSON file is already in the module folder.

Related issue: https://github.com/circe/circe-golden/issues/111
