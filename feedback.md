# mp2 Feedback

## Grade: 4.5

| Compilation | Timeout | Duration |
|:-----------:|:-------:|:--------:|
|Yes|No|9.35|

## Test Results
### cpen221.mp2.graph.Task1
| Test Status | Count |
| ----------- | ----- |
|tests|9|
|errors|0|
|skipped|0|
|failures|0|
### cpen221.mp2.graph.Task2
| Test Status | Count |
| ----------- | ----- |
|tests|20|
|errors|0|
|skipped|0|
|failures|1|
#### Failed Tests
1. `shortestPath(Graph, Vertex, Vertex, int)[2] (java.lang.AssertionError)`

## Test Coverage
85
## Other Comments
RI is okay. You do not need to include "vertices and edges have different indices" because that is a property that List guarantees. The AF should build on the representation and not be a generic definition. Specs are overall good but patchy. In shortestPath, what would happen if there is no path between two vertices?

**minor: Similar blocks of code found in 2 locations. Consider refactoring.**
file: `src/main/java/cpen221/mp2/controllers/Kamino.java`; lines `222` to `233`

**major: Method `main` has 64 lines of code (exceeds 25 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/controllers/Kamino.java`; lines `71` to `139`

**minor: Method `main` has a Cognitive Complexity of 38 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/controllers/Kamino.java`; lines `71` to `139`

**major: Avoid too many `return` statements within this method.**
file: `src/main/java/cpen221/mp2/controllers/Kamino.java`; lines `127` to `127`

**major: Avoid too many `return` statements within this method.**
file: `src/main/java/cpen221/mp2/controllers/Kamino.java`; lines `89` to `89`

**major: Avoid too many `return` statements within this method.**
file: `src/main/java/cpen221/mp2/controllers/Kamino.java`; lines `81` to `81`

**minor: Similar blocks of code found in 2 locations. Consider refactoring.**
file: `src/main/java/cpen221/mp2/controllers/Kamino.java`; lines `239` to `250`

**minor: Method `equals` has a Cognitive Complexity of 11 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Edge.java`; lines `57` to `68`

**minor: Method `updateDistanceEstimates` has a Cognitive Complexity of 7 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `339` to `353`

**minor: File `Graph.java` has 363 lines of code (exceeds 250 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `1` to `740`

**minor: Method `remove` has a Cognitive Complexity of 6 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `159` to `174`

**minor: Method `diameter` has a Cognitive Complexity of 6 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `559` to `576`

**minor: Method `pruneRandomEdges` has a Cognitive Complexity of 10 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `689` to `739`

**minor: Method `shortestPath` has a Cognitive Complexity of 7 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `264` to `325`

**minor: Method `getClosestNeighbour` has a Cognitive Complexity of 8 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `366` to `391`

**minor: Method `minimumSpanningTree` has a Cognitive Complexity of 18 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `401` to `461`

**minor: Method `shatter` has a Cognitive Complexity of 6 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `584` to `616`

**minor: Method `addDistinctNeighbours` has a Cognitive Complexity of 10 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `629` to `653`

**minor: Method `shortestPath` has 31 lines of code (exceeds 25 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `264` to `325`

**minor: Method `pruneRandomEdges` has 41 lines of code (exceeds 25 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `689` to `739`

**minor: `Graph` has 26 methods (exceeds 20 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `22` to `740`

**minor: Method `updateDistanceEstimates` has 5 arguments (exceeds 4 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `339` to `340`

**minor: Method `minimumSpanningTree` has 42 lines of code (exceeds 25 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/graph/Graph.java`; lines `401` to `461`

**minor: Method `endPhase` has a Cognitive Complexity of 9 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/gui/GUI.java`; lines `252` to `280`

**minor: Method `init` has a Cognitive Complexity of 8 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/gui/GUI.java`; lines `181` to `211`

**minor: Method `doInBackground` has a Cognitive Complexity of 11 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/gui/GUI.java`; lines `326` to `352`

**minor: Method `make` has 6 arguments (exceeds 4 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/gui/Planet.java`; lines `35` to `36`

**minor: Method `keyReleased` has a Cognitive Complexity of 9 (exceeds 5 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/gui/SpacePanel.java`; lines `82` to `113`

**minor: Method `update` has 27 lines of code (exceeds 25 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/gui/SpacePanel.java`; lines `259` to `287`

**minor: `SpacePanel` has 22 methods (exceeds 20 allowed). Consider refactoring.**
file: `src/main/java/cpen221/mp2/gui/SpacePanel.java`; lines `27` to `374`


## Checkstyle Results
### `MillenniumFalcon.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 7 | 8 | `Unused import - cpen221.mp2.models.Link.` |
| 10 | 8 | `Unused import - cpen221.mp2.util.Heap.` |
| 12 | 8 | `Unused import - java.util.ArrayList.` |
| 15 | 8 | `Unused import - java.util.Map.` |
| 17 | 8 | `Unused import - java.util.HashMap.` |
| 19 | 8 | `Unused import - java.util.Stack.` |
| 20 | 8 | `Unused import - java.util.NoSuchElementException.` |
| 22 | 1 | `Duplicate import to line 13 - java.util.Collections.` |
| 24 | 1 | `Redundant import from the java.lang package - java.lang.Math.` |
| 29 | None | `Type Javadoc comment is missing an @author tag.` |
| 44 | 5 | `Missing a Javadoc comment.` |
| 44 | 18 | `Name 'DFS' must match pattern '^[a-z][a-zA-Z0-9]*$'.` |
| 47 | None | `Comment matches to-do format 'TODO:'.` |
| 68 | None | `Missing a Javadoc comment.` |
| 7 | 8 | `Unused import - cpen221.mp2.models.Link.` |
| 10 | 8 | `Unused import - cpen221.mp2.util.Heap.` |
| 12 | 8 | `Unused import - java.util.ArrayList.` |
| 15 | 8 | `Unused import - java.util.Map.` |
| 17 | 8 | `Unused import - java.util.HashMap.` |
| 19 | 8 | `Unused import - java.util.Stack.` |
| 20 | 8 | `Unused import - java.util.NoSuchElementException.` |
| 22 | 1 | `Duplicate import to line 13 - java.util.Collections.` |
| 24 | 1 | `Redundant import from the java.lang package - java.lang.Math.` |
| 29 | None | `Type Javadoc comment is missing an @author tag.` |
| 44 | 5 | `Missing a Javadoc comment.` |
| 44 | 18 | `Name 'DFS' must match pattern '^[a-z][a-zA-Z0-9]*$'.` |
| 47 | None | `Comment matches to-do format 'TODO:'.` |
| 68 | None | `Missing a Javadoc comment.` |
### `Graph.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 3 | None | `Using the '.*' form of import should be avoided - java.util.*.` |
| 10 | None | `Type Javadoc comment is missing an @author tag.` |
| 14 | 5 | `Missing a Javadoc comment.` |
| 51 | None | `'if' have incorrect indentation level 7, expected level should be 8.` |
| 52 | None | `'if' child have incorrect indentation level 11, expected level should be 12.` |
| 53 | None | `'if rcurly' have incorrect indentation level 7, expected level should be 8.` |
| 54 | None | `'else' child have incorrect indentation level 11, expected level should be 12.` |
| 55 | None | `'else' child have incorrect indentation level 11, expected level should be 12.` |
| 56 | None | `'else rcurly' have incorrect indentation level 7, expected level should be 8.` |
| 87 | None | `Comment matches to-do format 'TODO:'.` |
| 93 | 15 | `'if' is not followed by whitespace.` |
| 140 | 5 | `File contains tab characters (this is the first instance).` |
| 180 | 12 | `'for' is not followed by whitespace.` |
| 180 | 25 | `'<' is not preceded with whitespace.` |
| 180 | 26 | `'<' is not followed by whitespace.` |
| 180 | 44 | `'{' is not preceded with whitespace.` |
| 182 | 15 | `'if' is not followed by whitespace.` |
| 186 | 46 | `',' is not followed by whitespace.` |
| 188 | 15 | `'if' is not followed by whitespace.` |
| 216 | 15 | `',' is not followed by whitespace.` |
| 216 | 45 | `',' is not followed by whitespace.` |
| 221 | None | `'for' child have incorrect indentation level 16, expected level should be 12.` |
| 223 | None | `'if' have incorrect indentation level 16, expected level should be 12.` |
| 223 | 19 | `'if' is not followed by whitespace.` |
| 224 | None | `'if' child have incorrect indentation level 20, expected level should be 16.` |
| 225 | None | `'if rcurly' have incorrect indentation level 16, expected level should be 12.` |
| 227 | None | `'for' child have incorrect indentation level 16, expected level should be 12.` |
| 228 | None | `'for' child have incorrect indentation level 16, expected level should be 12.` |
| 229 | None | `'if' have incorrect indentation level 16, expected level should be 12.` |
| 230 | None | `'if' child have incorrect indentation level 20, expected level should be 16.` |
| 230 | 39 | `'typecast' is not followed by whitespace.` |
| 231 | None | `'if rcurly' have incorrect indentation level 16, expected level should be 12.` |
| 242 | None | `Line is longer than 100 characters (found 118).` |
| 268 | 15 | `'if' is not followed by whitespace.` |
| 312 | None | `Line is longer than 100 characters (found 101).` |
| 314 | None | `Line is longer than 100 characters (found 103).` |
| 320 | 67 | `Expected @param tag for 'current'.` |
| 346 | None | `Expected an @return tag.` |
| 354 | 15 | `'if' is not followed by whitespace.` |
| 451 | None | `Expected an @return tag.` |
| 451 | None | `Line is longer than 100 characters (found 103).` |
| 451 | 14 | `Expected @param tag for '<C>'.` |
| 451 | 39 | `Expected @param tag for '<S>'.` |
| 451 | 81 | `Expected @param tag for 'containers'.` |
| 451 | 95 | `Expected @param tag for 'vertex'.` |
| 467 | None | `Comment matches to-do format 'TODO:'.` |
| 530 | 32 | `Expected @param tag for 'subgraph'.` |
| 553 | None | `Comment matches to-do format 'TODO:'.` |
| 590 | 5 | `Missing a Javadoc comment.` |
| 630 | None | `'if' construct must use '{}'s.` |
| 630 | 11 | `'if' is not followed by whitespace.` |
| 630 | 17 | `'!=' is not preceded with whitespace.` |
| 630 | 19 | `'!=' is not followed by whitespace.` |
| 632 | None | `'method def' child have incorrect indentation level 32, expected level should be 8.` |
| 651 | None | `Missing a Javadoc comment.` |
| 655 | 13 | `Missing a Javadoc comment.` |
| 655 | 13 | `Redundant 'public' modifier.` |
| 3 | None | `Using the '.*' form of import should be avoided - java.util.*.` |
| 10 | None | `Type Javadoc comment is missing an @author tag.` |
| 14 | 5 | `Missing a Javadoc comment.` |
| 51 | None | `'if' have incorrect indentation level 7, expected level should be 8.` |
| 52 | None | `'if' child have incorrect indentation level 11, expected level should be 12.` |
| 53 | None | `'if rcurly' have incorrect indentation level 7, expected level should be 8.` |
| 54 | None | `'else' child have incorrect indentation level 11, expected level should be 12.` |
| 55 | None | `'else' child have incorrect indentation level 11, expected level should be 12.` |
| 56 | None | `'else rcurly' have incorrect indentation level 7, expected level should be 8.` |
| 87 | None | `Comment matches to-do format 'TODO:'.` |
| 93 | 15 | `'if' is not followed by whitespace.` |
| 140 | 5 | `File contains tab characters (this is the first instance).` |
| 180 | 12 | `'for' is not followed by whitespace.` |
| 180 | 25 | `'<' is not preceded with whitespace.` |
| 180 | 26 | `'<' is not followed by whitespace.` |
| 180 | 44 | `'{' is not preceded with whitespace.` |
| 182 | 15 | `'if' is not followed by whitespace.` |
| 186 | 46 | `',' is not followed by whitespace.` |
| 188 | 15 | `'if' is not followed by whitespace.` |
| 216 | 15 | `',' is not followed by whitespace.` |
| 216 | 45 | `',' is not followed by whitespace.` |
| 221 | None | `'for' child have incorrect indentation level 16, expected level should be 12.` |
| 223 | None | `'if' have incorrect indentation level 16, expected level should be 12.` |
| 223 | 19 | `'if' is not followed by whitespace.` |
| 224 | None | `'if' child have incorrect indentation level 20, expected level should be 16.` |
| 225 | None | `'if rcurly' have incorrect indentation level 16, expected level should be 12.` |
| 227 | None | `'for' child have incorrect indentation level 16, expected level should be 12.` |
| 228 | None | `'for' child have incorrect indentation level 16, expected level should be 12.` |
| 229 | None | `'if' have incorrect indentation level 16, expected level should be 12.` |
| 230 | None | `'if' child have incorrect indentation level 20, expected level should be 16.` |
| 230 | 39 | `'typecast' is not followed by whitespace.` |
| 231 | None | `'if rcurly' have incorrect indentation level 16, expected level should be 12.` |
| 242 | None | `Line is longer than 100 characters (found 118).` |
| 268 | 15 | `'if' is not followed by whitespace.` |
| 312 | None | `Line is longer than 100 characters (found 101).` |
| 314 | None | `Line is longer than 100 characters (found 103).` |
| 320 | 67 | `Expected @param tag for 'current'.` |
| 346 | None | `Expected an @return tag.` |
| 354 | 15 | `'if' is not followed by whitespace.` |
| 451 | None | `Expected an @return tag.` |
| 451 | None | `Line is longer than 100 characters (found 103).` |
| 451 | 14 | `Expected @param tag for '<C>'.` |
| 451 | 39 | `Expected @param tag for '<S>'.` |
| 451 | 81 | `Expected @param tag for 'containers'.` |
| 451 | 95 | `Expected @param tag for 'vertex'.` |
| 467 | None | `Comment matches to-do format 'TODO:'.` |
| 530 | 32 | `Expected @param tag for 'subgraph'.` |
| 553 | None | `Comment matches to-do format 'TODO:'.` |
| 590 | 5 | `Missing a Javadoc comment.` |
| 630 | None | `'if' construct must use '{}'s.` |
| 630 | 11 | `'if' is not followed by whitespace.` |
| 630 | 17 | `'!=' is not preceded with whitespace.` |
| 630 | 19 | `'!=' is not followed by whitespace.` |
| 632 | None | `'method def' child have incorrect indentation level 32, expected level should be 8.` |
| 651 | None | `Missing a Javadoc comment.` |
| 655 | 13 | `Missing a Javadoc comment.` |
| 655 | 13 | `Redundant 'public' modifier.` |

