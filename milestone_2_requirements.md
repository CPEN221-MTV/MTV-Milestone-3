# MTV Requirements

Each requirement is a single, precise, verifiable fact about the implementation. Sections link to the relevant part of the [design specification](README.md#solution) (the Solution section and wireframe in the README).

**Conventions used below**

- "Cumulative matrix" = the single 3x3 matrix that stores all transformations applied since the last reset. It starts as the identity matrix.
- Coordinates: +x to the right, +y up, +z toward the viewer (right-handed).
- "Original shape" = the shape before any transformation is applied (defined in section 2).

---

## 1. Application and layout

Design reference: [Solution](README.md#solution), wireframe.

- **APP-1** The application is a desktop application whose Matrix of the Day feature (section 8) communicates with a server.
- **APP-2** The application has exactly one screen.
- **APP-3** The screen is divided into a left panel and a right panel.
- **APP-4** The left panel contains the matrix input grid, the Apply button, and the six preset buttons.
- **APP-5** The right panel contains the 3D rendering area, the Cube button, and the Pyramid button.
- **APP-6** The UI accepts mouse input.
- **APP-7** The UI accepts keyboard input.
- **APP-8** When the window is resized, the left panel, right panel, and all of their contents are resized to fit the new window size without any control becoming hidden or clipped.
- **APP-9** On launch, the cumulative matrix is the identity matrix.
- **APP-10** On launch, the Cube is the selected shape.

## 2. Shapes

Design reference: [Solution](README.md#solution), right panel.

- **SHP-1** The shape selector has exactly two buttons, labelled "Cube" and "Pyramid".
- **SHP-2** The original cube has 8 vertices at every combination of (±1, ±1, ±1) and 12 edges connecting vertices that differ in exactly one coordinate.
- **SHP-3** The original pyramid has a square base with vertices (±1, -1, ±1) and an apex at (0, 1, 0).
- **SHP-4** The original pyramid has 8 edges: the 4 edges of the base and the 4 edges joining each base vertex to the apex.
- **SHP-5** Pressing the Cube button makes the cube the selected shape.
- **SHP-6** Pressing the Pyramid button makes the pyramid the selected shape.
- **SHP-7** When the selected shape changes, the right panel redraws with the new shape transformed by the current cumulative matrix.
- **SHP-8** Changing the selected shape does not change the cumulative matrix.
- **SHP-9** The button of the currently selected shape is visually distinguished from the button of the unselected shape.

## 3. Matrix input

Design reference: [Solution](README.md#solution), left panel.

- **INP-1** The left panel contains a 3x3 grid of 9 text input fields.
- **INP-2** The grid fields are arranged in 3 rows and 3 columns, and entry (row r, column c) is the matrix element in row r, column c.
- **INP-3** On launch, the grid fields contain the identity matrix (1 on the diagonal, 0 elsewhere).
- **INP-4** Each field accepts typed keyboard input.
- **INP-5** A field value is valid if it is a base-10 number, optionally preceded by "-", optionally containing one decimal point (e.g. `2`, `-1`, `0.5`, `-0.25`).
- **INP-6** A field that is empty is invalid.
- **INP-7** A field containing any value that is not valid per INP-5 is invalid.
- **INP-8** The grid contents do not change when any button other than Apply is pressed (including preset buttons and Reset).
- **INP-9** Pressing the Tab key moves keyboard focus to the next field in row-major order.

## 4. Apply button

Design reference: [Solution](README.md#solution), apply button and the worked example.

- **APL-1** The left panel contains one button labelled "Apply" placed below the matrix grid.
- **APL-2** When Apply is pressed and all 9 fields are valid, the cumulative matrix becomes M × C, where M is the matrix in the grid and C is the previous cumulative matrix.
- **APL-3** When Apply is pressed and all 9 fields are valid, the right panel redraws the selected shape with every original vertex v replaced by (new cumulative matrix) × v.
- **APL-4** Pressing Apply n times in a row with the same grid contents applies M n times (the cumulative matrix equals Mⁿ × C).
- **APL-5** Pressing Apply does not change the selected shape.
- **APL-6** Pressing Apply does not change the grid contents.
- **APL-7** A matrix with determinant 0 is accepted and applied like any other valid matrix.
- **APL-8** When Apply is pressed and at least one field is invalid, the cumulative matrix does not change.
- **APL-9** When Apply is pressed and at least one field is invalid, the right panel is not redrawn.
- **APL-10** When Apply is pressed and at least one field is invalid, an error message is displayed in the left panel stating that all 9 entries must be numbers.
- **APL-11** Each invalid field is visually highlighted while the error message is shown.
- **APL-12** The error message and field highlights are removed the next time Apply is pressed with all 9 fields valid.
- **APL-13** The Apply button can be activated with the mouse.
- **APL-14** The Apply button can be activated with the keyboard (focus via Tab, activation via Enter or Space).

## 5. Preset transformations

Design reference: [Solution](README.md#solution), six presets.

- **PRE-1** The left panel contains exactly six preset buttons labelled "Rotate X", "Rotate Y", "Rotate Z", "Double", "Half", and "Reset", placed below the Apply button.
- **PRE-2** Pressing "Rotate X" sets the cumulative matrix to R × C, where R = [[1,0,0],[0,0,-1],[0,1,0]] (90° counterclockwise about +x) and C is the previous cumulative matrix.
- **PRE-3** Pressing "Rotate Y" sets the cumulative matrix to R × C, where R = [[0,0,1],[0,1,0],[-1,0,0]] (90° counterclockwise about +y).
- **PRE-4** Pressing "Rotate Z" sets the cumulative matrix to R × C, where R = [[0,-1,0],[1,0,0],[0,0,1]] (90° counterclockwise about +z).
- **PRE-5** Pressing "Double" sets the cumulative matrix to S × C, where S = [[2,0,0],[0,2,0],[0,0,2]].
- **PRE-6** Pressing "Half" sets the cumulative matrix to S × C, where S = [[0.5,0,0],[0,0.5,0],[0,0,0.5]].
- **PRE-7** After any of the five non-reset presets is pressed, the right panel redraws the selected shape using the new cumulative matrix.
- **PRE-8** Pressing the same preset multiple times applies it multiple times (e.g. pressing "Double" twice scales the shape by 4).
- **PRE-9** Pressing a preset does not change the grid contents.
- **PRE-10** Pressing a preset does not change the selected shape.
- **PRE-11** The Apply error message and field highlights are removed whenever the cumulative matrix or the selected shape changes.
- **PRE-12** All preset buttons can be activated with the mouse and with the keyboard (focus via Tab, activation via Enter or Space).

## 6. Reset

Design reference: [Solution](README.md#solution), reset preset.

- **RST-1** Pressing "Reset" sets the cumulative matrix to the identity matrix.
- **RST-2** After "Reset" is pressed, the right panel redraws the selected shape in its original orientation and scale (original vertices).
- **RST-3** Pressing "Reset" does not change the selected shape.
- **RST-4** Pressing "Reset" does not change the grid contents.
- **RST-5** Pressing "Reset" when the cumulative matrix is already the identity leaves the display unchanged.

## 7. 3D rendering

Design reference: [Solution](README.md#solution), right panel and wireframe.

- **REN-1** The right panel displays the selected shape as a wireframe (edges only, no filled faces).
- **REN-2** Every edge of the selected shape is drawn as a straight line segment between the projected positions of its two transformed vertices.
- **REN-3** The shape is drawn using a fixed camera orientation: the scene is rotated 30° about the y-axis then 20° about the x-axis before orthographic projection onto the screen.
- **REN-4** The camera orientation cannot be changed by the user.
- **REN-5** The shape is drawn centered at the center of the rendering area when the origin is the shape's center (all original shapes are centered on the origin).
- **REN-6** The drawing scale is such that the original cube (identity matrix) occupies approximately 40% of the smaller dimension of the rendering area.
- **REN-7** The drawing scale does not change when a transformation is applied; scaling a shape by a factor k changes its drawn size by k.
- **REN-8** The right panel redraws within 100 ms of any action that changes the cumulative matrix or the selected shape.
- **REN-9** When the rendering area is resized, the shape is redrawn to remain centered, using the scale rule in REN-6.
- **REN-10** A shape whose transformed vertices fall outside the rendering area is clipped to the rendering area and does not draw outside the right panel.
- **REN-11** If the cumulative matrix has determinant 0, the shape is still drawn using REN-1 and REN-2 (flattened shape).

## 8. Matrix of the Day (client and server)

Design reference: [Matrix of the Day](README.md#matrix-of-the-day) (add this section to the README, see milestone2_Architecture.md).

**Client**

- **MOD-1** The left panel contains a button labelled "Matrix of the Day" placed below the Apply button and above the preset buttons.
- **MOD-2** When "Matrix of the Day" is pressed, the client sends exactly one HTTP GET request to the path `/api/matrix-of-the-day` on the server.
- **MOD-3** The request is sent without blocking the user interface: while it is pending, the window continues to respond to input.
- **MOD-4** While a request is pending, the "Matrix of the Day" button is disabled.
- **MOD-5** When the client receives a status 200 response with a valid body, the 9 grid fields are set to the 9 numbers of the returned matrix in row-major order.
- **MOD-6** When the client receives a valid response, the left panel displays the text "Matrix of the Day: " followed by the returned date in the form YYYY-MM-DD.
- **MOD-7** Loading the Matrix of the Day does not change the cumulative matrix, the selected shape, or the drawing in the right panel.
- **MOD-8** If no response arrives within 5 seconds, the grid is not changed and the message "Could not load the Matrix of the Day." is displayed in the left panel.
- **MOD-9** If the response status is not 200, the grid is not changed and the message in MOD-8 is displayed.
- **MOD-10** If the response body is not a JSON object with a "date" string and a "matrix" of 3 arrays of 3 finite numbers, the grid is not changed and the message in MOD-8 is displayed.
- **MOD-11** After any success or failure of a request, the "Matrix of the Day" button is enabled again.
- **MOD-12** When the server is unreachable, the Apply button, preset buttons, shape buttons, and rendering work as specified in sections 2 to 7.

**Server**

- **MOD-13** The server listens for HTTP connections on TCP port 8080.
- **MOD-14** For a GET request to `/api/matrix-of-the-day`, the server responds with status 200 and a JSON body of the form `{"date":"YYYY-MM-DD","matrix":[[a,b,c],[d,e,f],[g,h,i]]}`.
- **MOD-15** The "date" in the response is the current date in UTC.
- **MOD-16** The "matrix" in the response is the entry at index (number of days from 1970-01-01 to that date) mod N in the server's list of N matrices.
- **MOD-17** Two requests made on the same UTC date receive the same matrix.
- **MOD-18** The server's list contains at least 7 matrices, each 3x3 with finite entries.
- **MOD-19** The server responds with status 404 to any request path other than `/api/matrix-of-the-day`.
- **MOD-20** The server responds with status 405 to any request to `/api/matrix-of-the-day` whose method is not GET.

## 9. Out of scope for this version

- Sphere/prism shapes shown (dashed) in the wireframe sketch.
- Hidden (dashed) edges for back-facing edges.
- Undo of a single transformation.
- Mouse-drag rotation of the camera.
- User accounts, and viewing or storing previous days' matrices.
