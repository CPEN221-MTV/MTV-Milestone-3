# MTV Architecture

MTV's architecture uses client-server interactions to handle the Matrix of the day feature. The server will provide the daily transformation through our HTTP API. The server will produce the daily transformation based on the day's date and return a matrix from a fixed list. The of MTV's interactions (e.g. displaying graphics) are handled client-side. To organize this, a model-view controller architecture is used to gather data, display it through the client and handle inputs.

## Application Components

Application structure (for TA, please view the stubs for there in [app](./app/)):

- Main.java
- math
  - Vector.java
  - Matrix.java
- geometry
  - Mesh.java
  - Shapes.java
- model
  - ScreenModel.java
- net
  - MatrixOfTheDatClient.java
- ui
  - ViewPanel.java
  - MatrixInputPanel.java
  - PresetPanel.java

### Main

- `Main` is where the client program begins. When we implement it, it will, in the client, create `SceneModel` and `MatrixOfTheDayClient`, and it will create the three gui windows `MatrixInputPanel`, `PresetPanel` abd `ViewPanel`.
- With our architecture, `Main` just communicated other components when the program starts. It provides `SceneModel` to `MatrixOfTheDayClient`, `MatrixInputPanel`, `PresetPanel` and `ViewPanel`
- It also gives the `MatrixOfTheDayClient` to `MatrixInputPanel`
- `Main` lives on the client
- Requirements: APP-1..APP-10

### Vector

- `Vector` is a 3D vector that's immutable and it can be added to another vector or multiplied by a scalar
- `Vector` doesn't call other components. It's used by `Matrix`, `Mesh` and `ViewPanel`, and its produced by `Matrix` when it multiplies a matrix by a vector. Its verticies are stored by `Mesh`, and `ViewPanel` reads their coordinates to draw them
- `Vector` lives on the client

### Matrix

- `Matrix` is an immutable 3x3 matrix that multiplies a matrix by another matrix, or by some vector.
- `Matrix` can be called by `SceneModel` to multiply two matrices and to create the identity matrix.
- It can also be called by `Mesh` to multiply a matrix by each of its vertices.
- `PresetPanel` also calles it for the rotation and scale matrices.
- And `MatrixInputPanel` too, to build one from the 9 numbers it parsed from the grid
- `Matrix` lives on the client
- Requirements: APL-2, PRE-2..PRE-6

### Mesh

- This component is an immutable wireframe. It stores an array of `Vector` vertices and an array of edges, where each edge is a pair of vertex indices. Calling `transform(Matrix)` returns a new mesh with every vertex multiplied by that matrix.
- `SceneModel` can ask it to `transform` itself using the cumulative matrix. `ViewPanel` can ask it for its vertices and edges so it can draw them. It also uses `Matrix` to multiply each vertex.
- `Mesh` lives on the client
- Requirements: APL-3, REN-1, REN-2

### Shapes

- `Shapes` is there to build the untransformed meshes for the cube and the pyramid
- It also defines the `Shapes` type for the cube and pyramid
- `SceneModel` could ask it for the original mesh of the shape type/type of shape
- And `ViewPanel` uses the types to label and identify its Cube and Pyramid buttons
- `Shapes` lives on the client
- Requirements: SHP-2..SHP-4

### SceneModel

- `SceneMode` stores the user's selected type for `Shapes` and the `Matrix`. It also applies new matricies and can reset it bakc to the identity matrix. It can also change the selected shape and produce the transformed mesh with `Mesh`.
- After every change this component makes, it shares and goes back to listening for more changes to apply.
- `MatrixInputPanel` and `PresetPanel` can ask it to **apply a matrix**.
- `PresetPanel` asks it to reset the visulization
- `ViewPanel` asks it to select a shape and for the transformed mesh
- When the scene is changed, it lets `ViewPanel` and `MatrixInputPanel` know
- `SceneModel` lives on the client
- Requirements: APL-2..APL-6, PRE-2..PRE-10, RST-1..RST-5, SHP-5..SHP-8, APP-9, APP-10

### MatrixInputPanel

- `MatrixInputPanel` is a view (from the Model, View, Controller architecture) that shows the 3×3 grid with the initial identity matrix and the "apply matrix" button.
- When the user hits apply, it checks the nine fields and if they're valid, build the `Matrix` and give it to the `SceneModel`
- `SceneModel` gets told to apply the matrix by `MatrixInputPanel`
- `MatrixOfTheDayClient` sends an API call to get the matrix of the day and recieves it.
- `MatrixInputPanel` lives on the client
- Requirements: INP-\*, APL-1, APL-8..APL-14, PRE-11, MOD-1..MOD-12

### PresetPanel

- `PresentPanel` is the buttons to rotate X, rotate Y, rotate Z, double, halve it and reset
- It sends to `SceneModel` the `matrix` that comes from a tranformation or reset
- `PresetPanel` lives on the client
- Requirements: PRE-1..PRE-12, RST-\*

### ViewPanel

`ViewPanel` draws the transformed mesh as a wireframe and contains the Cube and Pyramid buttons

- When one of the buttons is pressed, it sends the shape to `SceneModel`
- When it's notified of the scene being changed, it asks `SceneModel` for the shape and transformed mesh to visualize
- `ViewPanel` lives on the client
- Requirements: SHP-1, SHP-9, REN-\*

### MatrixOfTheDayClient

- `MatrixOfTheDayClient` is how the client sends a GET request to the HTTP api and parses the JSON response
- `MatrixInputPanel` uses the component to get the matrix and replies with the daily matrix and date
- `MatrixServer` also interacts with it to handle its GET request
- `MatrixOfTheDayClient` lives on the client
- Requirements: MOD-2..MOD-5, MOD-8..MOD-11

## Server Components

Server structure (for TA, please view the stubs for there in [server](./server/)):

- MatrixServer.java
- MatrixOfTheDayModel.java

### MatrixServer

- This is the server's API component where it listens for client requests and replies with the date and that date's matrix
- `MatrixOfTheDatClient` communicates with it for the users' HTTP requests
- `MatrixOfTheDayModel` asks it for the date's matrix
- `MatrixServer` lives on the server
- Requirements: MOD-13..MOD-15, MOD-17, MOD-19, MOD-20.

### MatrixOfTheDayModel

- `MatrixOfTheDayModel` stores the fixed list of matrix transformations to provide on a date
- When `MatrixServer` asks for the daily matrix, it provides it from the fixed list
- `MatrixOfTheDayModel` lives on the servers
- Requirements: MOD-16, MOD-17, MOD-18.
