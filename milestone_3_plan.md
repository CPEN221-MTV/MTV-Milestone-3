---
layout: home
permalink: /
---

# Milestone 3: MTV Project Plan

## Work Coordination

Yehia is our PM and he coordinates our teams work. He will keep track of who's doing what and get our group together to work or call online. His goal isn't to know what everyone is doing like a hawk, but make sure each person is completing their respective components (as described below) on time.

### Project Management Practices

- All work tasks will be complete on GitHub, organized with issues. There will be an issues template with one assignee to complete it, a deadline date, and the ID for the requirement.
- A task should take no more than a few days. If it will take longer, it should be split into sub-tasks.
- As done for previous milestones, we won't commit directly to `main`. Instead, each task will be resolved through PRs and reviewed by at least one other team member.
- Issues, commit messages and test names will all use the IDs from the requirements so we can trace each requirement to the code and tests that cover it.
- Anyone team member blocked for more than a day will share in the group chat instead of waiting for the next meeting.

### Team Meetings

30-minute meetings will be held twice per week:

- During the early-week planning meetings (e.g. Monday) we will review the issues tasks, agree what each person will finish before the next meeting, and sort out dependencies between project components
- During the end-of-week check-in (e.g. Friday), we will review what's been done, what is blocked, and whether our timeline is still ok.

When group work is necessary, we will add a group working session during those weeks. This might be before major milestone deadline submissions or when integrating say the UI elements with `SceneModel`.

Our PM will plan and share the meeting agenda a couple hours before. It'll include what got done, what tasks are blocked, decisions we need to make and who's doing what next. Anyone can add things by asking the PM before the meeting. The PM will also be taking notes during the meetings.

## Communication Tools

We use three tools, and each one has a different job: a group chat for quick day-to-day messages, GitHub for anything about the work itself, and video calls for our meetings and working sessions.

### Messaging

We have an Instagram group chat for messaging. This is best for quick work updates and scheduling meetings. However, we did consider some alternatives:

- Slack and Discord are more organized, but everyone has to make an account, join the workspace/server and remember to check it
- Email is very universal, but too formal for quick back-and-forth messages
- WhatsApp is beloved by our international student members, but not everyone uses it

We landed on Instagram because everyone on the team uses it for daily entertainment. Therefore, messages got viewed and replied to quickly!

### Technical Discussions

The downside with Instagram is that long message chains are hard to organize and get lost. So for technical decisions, we will use GitHub Issues for technical discussion.

This was imposed by the course project so alternatives were not considered. Plus, we are already using GitHub to share and version control our project.

#### Meetings

Our twice-a-week meetings and group working sessions are ideally held in-person (in MCLD) when possible.

However, when someone cannot join, we use the video call feature in Instagram for them to join-in remotely.

With screen-sharing on Instagram desktop, we can even look at code on the same screen to make sure everyone is on the same page. We did consider some video-conferencing alternatives:

- Zoom/MS Teams are the more traditional video-calling tools. However, we are already using Instagram so having our calls there is more natural.

## Component Ownership

| Component              | Layer  | Owner   | Requirements it must meet                                              | Backup (reviews every PR, can take over) |
| ---------------------- | ------ | ------- | ---------------------------------------------------------------------- | ---------------------------------------- |
| `Vector`               | client | Yehia   | supports `Matrix`, `Mesh`, `ViewPanel`                                 | Nashwan                                  |
| `Matrix`               | client | Yehia   | APL-2, PRE-2..PRE-6                                                    | Nashwan                                  |
| `Mesh`                 | client | Yehia   | APL-3, REN-1, REN-2                                                    | Nashwan                                  |
| `Shapes`               | client | Yehia   | SHP-2..SHP-4                                                           | Nashwan                                  |
| `SceneModel`           | client | Nashwan | APL-2..APL-6, PRE-2..PRE-10, RST-1..RST-5, SHP-5..SHP-8, APP-9, APP-10 | Alex                                     |
| `Main`                 | client | Nashwan | APP-1..APP-10                                                          | Alex                                     |
| `ViewPanel`            | client | Alex    | SHP-1, SHP-9, REN-\*                                                   | Mahan                                    |
| `PresetPanel`          | client | Alex    | PRE-1..PRE-12, RST-\*                                                  | Mahan                                    |
| `MatrixInputPanel`     | client | Mahan   | INP-\*, APL-1, APL-8..APL-14, PRE-11, MOD-1..MOD-12                    | Johnny                                   |
| `MatrixOfTheDayClient` | client | Mahan   | MOD-2..MOD-5, MOD-8..MOD-11                                            | Johnny                                   |
| `MatrixOfTheDayModel`  | server | Johnny  | MOD-16..MOD-18                                                         | Yehia                                    |
| `MatrixServer`         | server | Johnny  | MOD-13..MOD-15, MOD-17, MOD-19, MOD-20                                 | Yehia                                    |

### How we split the components

- **Yehia owns the foundation.** `Vector`, `Matrix`, `Mesh` and `Shapes` are small and every other client component depends on them, so one person builds them first (Milestone 1, Nov 17). Yehia is then the first free to help where the team is behind, and he is the backup for the server.
- **Nashwan owns `SceneModel` and `Main`.** `SceneModel` is the centre of the client: all three panels depend on it. `Main` just creates the components and connects them, so the person who owns the central state is best placed to wire it up.
- **Alex owns `ViewPanel` and `PresetPanel`.** Both are driven by `SceneModel` and neither needs input validation, so they can be built in parallel with `MatrixInputPanel`.
- **Mahan owns `MatrixInputPanel` and `MatrixOfTheDayClient`.** `MatrixInputPanel` is the biggest UI component (grid, validation, error messages, and the Matrix of the Day button) and it is the only place `MatrixOfTheDayClient` is used, so one person handles the whole path from a button press to the HTTP request.
- **Johnny owns the server components.** `MatrixOfTheDayModel` and `MatrixServer` depend on nothing on the client, since the JSON format in MOD-14 is already fixed. That makes them a parallel track (Milestone 2b, Nov 19) that fits alongside the PM's coordination work. Johnny also keeps the manual test log and the release checklist.
- **Mahan and Johnny agree the request and response format** in a GitHub Issue before the client and server are connected, since they own the two ends of the Matrix of the Day.
- **The backup reviewer is a different person from the owner** and is the second person who understands each component. Backups form a cycle (Yehia, Nashwan, Alex, Mahan, Johnny, back to Yehia), so every person covers one other person. This is how we cope if an owner is sick or stuck (see the resilience section).

## Project Timeline

Each internal milestone falls just before a Monday or Friday meeting, so that meeting can check it.

| Milestone            | Deadline       | Done when                                                                                                                                                                                |
| -------------------- | -------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **A. Foundations**   | Wed Nov 18     | The project builds and all tests pass with Gradle in IntelliJ on `main`. `Matrix`, `Vector` and the shape loader pass their JUnit tests. The server answers `GET /presets`               |
| **B. MVP**           | Sun Nov 22     | A user can type a matrix, apply it, use the presets, reset and switch shapes. Every check in Sections 1–7 and 12 of the testing plan passes                                              |
| **C. Client–server** | Wed Nov 25     | Saved matrices and server presets work end to end, including on two machines. Sections 8–11 pass                                                                                         |
| **D. Release 1.0**   | **Fri Nov 27** | Features are frozen. The full manual checklist has been run by someone who didn't build each feature. Install guide, coverage report, known bugs and contributions statement are written |
| **E. Demo**          | **Thu Dec 3**  | The demo is rehearsed on Dec 2 on a fresh clone and given in lecture                                                                                                                     |
| **F. Evaluate**      | **Fri Dec 4**  | Each of us has tested other teams' apps and filed issues. We fix the bugs reported to us as they come in                                                                                 |
| **G. Triage**        | **Wed Dec 9**  | Every issue on our repo is labelled and prioritised. Reflections are submitted individually                                                                                              |

## Requirements Verification

Each requirement from the requirements document is verified by one of four methods:

- JUnit will be integrated with our gradel config to test each requirement with 100% class coevrage.
- A scripted manual check will be done by one of us running the app and recorded in a checklist
- We will review and inspect the code to confirm is meets the property
- Not-reified is where there's no check with no provided reason

Numeric comparisons in JUnit tests will use a tolerance of 1x10^-9 per matrix entry

## 1. Application window

| ID       | Method     | Exact check                                                                             | Pass if                                                                                        | Justification                                                    |
| -------- | ---------- | --------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------- |
| R-WIN-01 | Manual     | Launch the client and read the title bar                                                | Title is "MTV – Matrix Transformation Visualizer"                                              | A window property that is fastest to confirm by eye.             |
| R-WIN-02 | Manual     | Launch the client                                                                       | Left panel holds the matrix input and presets, right panel holds the 3D view and shape buttons | Layout is purely visual.                                         |
| R-WIN-03 | Manual     | Launch on a screen larger than 1100×750, then on a display scaled so that it is smaller | Window is 1100×750 on the large screen and fills the small one exactly                         | Depends on the real display, which unit tests can't reproduce.   |
| R-WIN-04 | Manual     | Drag the window corner as small as possible                                             | Window stops shrinking at 800×600                                                              | Resizing is an OS interaction.                                   |
| R-WIN-05 | Manual     | Resize the window to three different sizes                                              | 3D view fills the right panel and the shape stays centred                                      | Visual behaviour.                                                |
| R-WIN-06 | Manual     | Resize to 800×600 and to full screen                                                    | No left-panel control overlaps or is cut off                                                   | Visual behaviour.                                                |
| R-WIN-07 | Manual     | Close the window                                                                        | The client process ends (terminal returns, no Java process left running)                       | OS-level behaviour.                                              |
| R-WIN-08 | Inspection | Read the colour constants in the UI code                                                | Background is `#101010` and shape lines are `#50FF50`, defined once and reused                 | A fixed value in one place; reading it is as reliable as a test. |

## 2. Matrix input

| ID       | Method         | Exact check                                                                             | Pass if                                                             | Justification                                                                         |
| -------- | -------------- | --------------------------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| R-MAT-01 | Manual         | Launch the client                                                                       | Heading "Your matrix" appears above a 3×3 grid of nine fields       | Visual layout.                                                                        |
| R-MAT-02 | JUnit          | Create the matrix-input model and read the nine values                                  | Values equal the identity matrix                                    | Startup state is plain logic and cheap to automate.                                   |
| R-MAT-03 | JUnit          | Parse `"-0.5"`, `"2"`, `".25"`                                                          | Results are -0.5, 2.0 and 0.25                                      | Parsing has many edge cases, and tests catch regressions on every build.              |
| R-MAT-04 | JUnit + Manual | JUnit: parse `""`, `"abc"`, `"1.2.3"`, `"-"`. Manual: type `abc` into a cell            | All four are rejected as invalid, and the cell shows a red border   | Validation logic is automated; the border itself is visual.                           |
| R-MAT-05 | Manual         | Type `abc` into a cell, then replace it with `3`                                        | Red border disappears as soon as the text becomes valid             | Visual behaviour.                                                                     |
| R-MAT-06 | Manual         | Click the top-left cell, press Tab 8 times, then Shift+Tab 8 times                      | Focus moves left-to-right and top-to-bottom, then back the same way | Keyboard focus is a UI behaviour.                                                     |
| R-MAT-07 | JUnit          | Compute the determinant of `[[1,2,3],[0,1,4],[5,6,0]]`, and format a determinant of 2/3 | Determinant is 1, and 2/3 is shown as `0.67`                        | Deterministic math that is easy to get wrong.                                         |
| R-MAT-08 | Manual         | Change a field and watch the determinant                                                | Display updates with no visible delay                               | 100 ms is below noticeable lag, and UI timing is unreliable to measure in unit tests. |
| R-MAT-09 | JUnit          | Make one field invalid and read the determinant display text                            | Text is "—"                                                         | Display logic, easy to automate.                                                      |

## 3. Applying a transformation

| ID       | Method         | Exact check                                                                                      | Pass if                                                                                      | Justification                                                                                |
| -------- | -------------- | ------------------------------------------------------------------------------------------------ | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| R-APP-01 | Manual         | Launch the client                                                                                | Apply button sits directly below the grid                                                    | Visual layout.                                                                               |
| R-APP-02 | JUnit          | From total = I, apply the shear A = `[[1,1,0],[0,1,0],[0,0,1]]`, then B = 90° Z rotation         | Total equals B×A, and does not equal A×B                                                     | The multiply order is the most likely bug; using two matrices that don't commute catches it. |
| R-APP-03 | Manual         | Put focus in a matrix field and press Enter                                                      | The total transformation updates exactly as if Apply had been clicked                        | Key binding is a UI behaviour.                                                               |
| R-APP-04 | JUnit          | Set one cell to `"abc"` and call apply                                                           | Total transformation is unchanged                                                            | Core safety logic, easy to automate.                                                         |
| R-APP-05 | Manual         | With an invalid cell, click Apply                                                                | "Fix the highlighted cells before applying." appears below the button                        | Visible text.                                                                                |
| R-APP-06 | Manual         | After R-APP-05, fix the cell and click Apply                                                     | The message disappears                                                                       | Visible text.                                                                                |
| R-APP-07 | JUnit          | Call apply, then read the nine fields                                                            | Fields are unchanged                                                                         | State logic, easy to automate.                                                               |
| R-APP-08 | JUnit          | From total T0, apply M three times                                                               | Total equals M³×T0                                                                           | Repeated application is a core feature and is pure math.                                     |
| R-APP-09 | JUnit + Manual | JUnit: animation progress at 0, 175 and 350 ms. Manual: click Apply and watch                    | Progress is 0, 0.5 and 1, and the animation looks smooth and lasts about a third of a second | Timing logic is automated; smoothness has to be judged by eye.                               |
| R-APP-10 | Manual         | Click Apply twice in quick succession                                                            | Second animation starts from where the shape is, with no jump                                | Visual continuity.                                                                           |
| R-APP-11 | JUnit + Manual | JUnit: apply `[[1,0,0],[0,1,0],[0,0,0]]` and project every vertex. Manual: apply the same matrix | No exception and every projected coordinate is finite, and the shape appears flattened       | Singular matrices are a classic crash case.                                                  |

## 4. Preset transformations

| ID       | Method         | Exact check                                                                   | Pass if                                                                           | Justification                                     |
| -------- | -------------- | ----------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | ------------------------------------------------- |
| R-PRE-01 | Manual         | Launch the client                                                             | "Presets" heading above Rotate X, Rotate Y, Rotate Z, Double, Half, Reset         | Visual layout.                                    |
| R-PRE-02 | Manual         | Launch the client                                                             | Field labelled "Rotation angle (°)" above the presets, containing `15`            | Visual layout.                                    |
| R-PRE-03 | JUnit          | Build the X rotation for 90° and for 15°                                      | 90° gives `[[1,0,0],[0,0,-1],[0,1,0]]`, and 15° matches the formula               | Exact math with known values.                     |
| R-PRE-04 | JUnit          | Build the Y rotation for 90°                                                  | Result is `[[0,0,1],[0,1,0],[-1,0,0]]`                                            | Exact math with known values.                     |
| R-PRE-05 | JUnit          | Build the Z rotation for 90°                                                  | Result is `[[0,-1,0],[1,0,0],[0,0,1]]`                                            | Exact math with known values.                     |
| R-PRE-06 | JUnit          | Trigger Double and read the fields                                            | Fields hold 2×identity                                                            | Constant value, cheap to check.                   |
| R-PRE-07 | JUnit          | Trigger Half and read the fields                                              | Fields hold 0.5×identity                                                          | Constant value, cheap to check.                   |
| R-PRE-08 | JUnit          | Format 6.1e-17, -0.0 and 0.258819                                             | Results are `0`, `0` and `0.259`                                                  | Rounding and negative zero are easy to get wrong. |
| R-PRE-09 | JUnit          | Trigger each of the five non-Reset presets                                    | Total transformation is unchanged                                                 | State logic.                                      |
| R-PRE-10 | JUnit + Manual | JUnit: set the angle to `"abc"` and trigger Rotate X. Manual: same in the app | Fields are unchanged, and the angle field shows a red border                      | Logic automated; border is visual.                |
| R-PRE-11 | JUnit          | Trigger Reset and read the fields                                             | Fields hold the identity                                                          | State logic.                                      |
| R-PRE-12 | JUnit + Manual | JUnit: apply something, then Reset. Manual: watch Reset                       | Total equals the starting transformation (R-VIEW-08), and the shape animates back | Value automated; animation is visual.             |

## 5. 3D view

| ID        | Method              | Exact check                                                                                                  | Pass if                                                          | Justification                                                     |
| --------- | ------------------- | ------------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------- | ----------------------------------------------------------------- |
| R-VIEW-01 | Manual              | Launch the client                                                                                            | "3D View" heading above a square drawing area                    | Visual layout.                                                    |
| R-VIEW-02 | Manual              | Look at the drawn shape                                                                                      | Only lines in the foreground colour, no filled faces             | Visual.                                                           |
| R-VIEW-03 | JUnit               | Transform vertex (1,0,0) by a 90° Z rotation                                                                 | Result is (0,1,0)                                                | Pure math.                                                        |
| R-VIEW-04 | JUnit               | Transform vertex (0,0,0) by the identity                                                                     | Result has z = 2.5                                               | Pure math.                                                        |
| R-VIEW-05 | JUnit               | Project (1,1,2.5) in a 400×400 area                                                                          | Screen point is (384, 16)                                        | The formula is exact, so the expected value is known.             |
| R-VIEW-06 | JUnit               | Clip an edge with both ends at z = 0.05                                                                      | Edge is not drawn                                                | Pure logic.                                                       |
| R-VIEW-07 | JUnit               | Clip the edge from (-1,0,-0.9) to (1,0,1.1)                                                                  | Visible part runs from (0,0,0.1) to (1,0,1.1)                    | Pure math with a known answer.                                    |
| R-VIEW-08 | JUnit               | Read the starting transformation                                                                             | It equals (35° Y rotation)×(−25° X rotation)                     | Exact value.                                                      |
| R-VIEW-09 | Manual              | Apply a matrix and look at the top-left corner                                                               | Three rows of the total transformation, each value to 3 decimals | Placement is visual; formatting is already covered by R-PRE-08.   |
| R-VIEW-10 | Manual              | Enable the debug repaint counter and click Apply                                                             | At least 30 repaints per second during the animation             | Frame rate depends on the real machine.                           |
| R-VIEW-11 | Inspection + Manual | Check that no timer or loop repaints while idle, then leave the app idle for 5 s with the repaint counter on | No idle repaint code, and 0 repaints counted                     | Code reading confirms the design; the counter confirms behaviour. |

## 6. Shape selection

| ID       | Method       | Exact check                      | Pass if                                          | Justification                                                             |
| -------- | ------------ | -------------------------------- | ------------------------------------------------ | ------------------------------------------------------------------------- |
| R-SHP-01 | Manual       | Launch the client                | "Shape" heading above Cube and Pyramid buttons   | Visual layout.                                                            |
| R-SHP-02 | Manual       | Launch the client                | Cube is drawn and the Cube button is highlighted | Visual.                                                                   |
| R-SHP-03 | Manual       | Click each shape button in turn  | Only the clicked button is highlighted           | Visual.                                                                   |
| R-SHP-04 | Manual       | Apply Double, then click Pyramid | A pyramid is drawn at double size                | Visual.                                                                   |
| R-SHP-05 | JUnit        | Switch shape                     | Total transformation and fields are unchanged    | State logic.                                                              |
| R-SHP-06 | Not verified | —                                | —                                                | Optional feature; only built, and then tested, once the core app is done. |

## 7. Shape geometry

| ID       | Method             | Exact check                                                          | Pass if                                                                                                          | Justification                                 |
| -------- | ------------------ | -------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- | --------------------------------------------- |
| R-GEO-01 | JUnit              | Load the cube                                                        | 8 vertices at every (±0.5, ±0.5, ±0.5), and 12 edges each joining vertices that differ in exactly one coordinate | Geometry data must be exact.                  |
| R-GEO-02 | JUnit              | Load the pyramid                                                     | 4 base vertices at (±0.5, −0.5, ±0.5), apex at (0, 0.5, 0), and 8 edges                                          | Geometry data must be exact.                  |
| R-GEO-03 | Inspection + JUnit | Look for hard-coded vertex lists in the code, and load `shapes.json` | No hard-coded geometry, and the loaded data passes R-GEO-01 and R-GEO-02                                         | Confirms the data really comes from the file. |

## 8. Data files

| ID        | Method | Exact check                                                            | Pass if                                                       | Justification                                    |
| --------- | ------ | ---------------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------ |
| R-DATA-01 | JUnit  | Start the server with a test `presets.json` and request `GET /presets` | Response matches the file                                     | End-to-end check of file loading.                |
| R-DATA-02 | JUnit  | Load the bundled `shapes.json`                                         | Loads without error, with both shapes present                 | File loading is logic.                           |
| R-DATA-03 | Manual | Rename the file, then corrupt it, and start the program each time      | Error message names the file, and the exit status is non-zero | Exit codes are easiest to check from a terminal. |
| R-DATA-04 | JUnit  | Save a matrix, stop the server, restart it, request `GET /saved`       | The saved matrix is still there                               | Persistence is critical and repeatable.          |

## 9. Server

| ID       | Method | Exact check                                                                             | Pass if                                                                                         | Justification                                                       |
| -------- | ------ | --------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ------------------------------------------------------------------- |
| R-SRV-01 | Manual | Run the server with Gradle in IntelliJ with the port set to 9000, then with no argument | Server answers on 9000, then on 8221                                                            | Startup arguments are easiest to check by running the real program. |
| R-SRV-02 | JUnit  | Request `GET /presets`                                                                  | Status 200, and a JSON list where each item has a name and a 3×3 matrix matching `presets.json` | API contract.                                                       |
| R-SRV-03 | JUnit  | Post two matrices, then request `GET /saved`                                            | Both are returned with name, matrix and save time                                               | API contract.                                                       |
| R-SRV-04 | JUnit  | Post with a 1-character name and with a 40-character name                               | Status 201 each time, and both appear in `GET /saved`                                           | Tests the valid edges of the name length.                           |
| R-SRV-05 | JUnit  | Post a missing name, a 41-character name, a 2×3 matrix and a non-number entry           | Status 400 each time, and `GET /saved` is unchanged                                             | Invalid input must never be stored.                                 |
| R-SRV-06 | JUnit  | Post name "a" with M1, then "a" with M2                                                 | `GET /saved` has one entry "a" holding M2                                                       | Replace behaviour.                                                  |
| R-SRV-07 | JUnit  | 10 threads post different names at the same moment                                      | All 10 are returned intact, and `saved.json` is valid JSON                                      | Concurrency bugs only show up under real parallel load.             |
| R-SRV-08 | JUnit  | After a post returns, read `saved.json` directly                                        | The new entry is in the file                                                                    | Confirms write-before-respond.                                      |

## 10. Client–server features in the UI

Server logic is already covered by the JUnit tests in Section 9, so these checks focus on the client's behaviour end to end.

| ID       | Method              | Exact check                                                                                                                    | Pass if                                                                           | Justification                                                  |
| -------- | ------------------- | ------------------------------------------------------------------------------------------------------------------------------ | --------------------------------------------------------------------------------- | -------------------------------------------------------------- |
| R-NET-01 | Manual              | Start the server, then the client with and without an address argument                                                         | Server log shows `GET /presets` from the client each time                         | End-to-end startup behaviour.                                  |
| R-NET-02 | Inspection + Manual | Check that network calls run off the UI thread, then start the server with a 3 s test delay and click buttons during a request | Calls are off the UI thread, and buttons and fields keep working                  | Threading is confirmed by reading; responsiveness by using it. |
| R-NET-03 | Manual              | Start the client with no server running                                                                                        | Window opens with the six built-in presets and "Offline – using built-in presets" | End-to-end failure behaviour.                                  |
| R-NET-04 | Manual              | Add an extra preset to `presets.json`, start both, click it                                                                    | An extra button appears and fills the fields with its matrix                      | Visual, end to end.                                            |
| R-NET-05 | Manual              | Click "Save matrix…" and enter a name                                                                                          | Matrix appears in the Saved list and in `GET /saved`                              | End to end.                                                    |
| R-NET-06 | Manual              | Make a cell invalid, then separately stop the server                                                                           | "Save matrix…" is disabled in both cases                                          | Visual state.                                                  |
| R-NET-07 | Manual              | Save a new matrix                                                                                                              | The Saved list refreshes and shows it                                             | Visual, end to end.                                            |
| R-NET-08 | Manual              | Click a Saved entry                                                                                                            | Fields fill with its matrix and the total transformation is unchanged             | Visual, end to end.                                            |
| R-NET-09 | Manual              | Stop the server after launch and try to save                                                                                   | "Couldn't save – server unreachable" appears and fields are unchanged             | Failure behaviour, end to end.                                 |

## 11. Input devices and accessibility

| ID       | Method | Exact check                                                         | Pass if                                                       | Justification                                      |
| -------- | ------ | ------------------------------------------------------------------- | ------------------------------------------------------------- | -------------------------------------------------- |
| R-ACC-01 | Manual | Click every button, then Tab to each one and press Space            | Every button works both ways                                  | Keyboard use has to be checked in the real UI.     |
| R-ACC-02 | Manual | Tab through every control                                           | The focused control always has a visible outline in `#50FF50` | Visual.                                            |
| R-ACC-03 | Manual | Run each text and background colour pair through a contrast checker | Every ratio is at least 4.5:1                                 | A standard tool gives an exact, repeatable number. |

## 12. Build, testing and process

| ID       | Method     | Exact check                                                           | Pass if                                                        | Justification                                         |
| -------- | ---------- | --------------------------------------------------------------------- | -------------------------------------------------------------- | ----------------------------------------------------- |
| R-BLD-01 | Manual     | Fresh clone on Java 21, build the project with Gradle in IntelliJ     | Build succeeds for both client and server                      | Has to be done on a clean machine, as a marker would. |
| R-BLD-02 | Manual     | Run the client and the server with Gradle in IntelliJ                 | Client window opens and the server is listening                | End to end.                                           |
| R-BLD-03 | Inspection | Read the Gradle build files and imports                               | Gson and FlatLaf (plus JUnit 5) are declared and actually used | Declared in config files.                             |
| R-BLD-04 | Inspection | Compare test names against every JUnit row in Sections 3–5            | Every one has a test named after its requirement ID            | Test naming makes the mapping checkable.              |
| R-BLD-05 | Inspection | Compare test names against R-SRV-02 to R-SRV-08                       | Every one has a test, including the 10-client test             | Same reason.                                          |
| R-BLD-06 | Manual     | Run all tests with Gradle in IntelliJ on `main` before each milestone | All tests pass                                                 | A final check before anything is handed in.           |

## How we'll us verification in our process

- Using our test-driven development approach, JUnit test will be run on our computer before pushing. We'll also only merger PRs if all the tests pass. This just good practice and will help us catch bugs before they make their way into `main`.
- During code reviews, each PR will be reviewed by someone who did not write it. They will also inspect the parts of the code the change touches. This helps us double check that anything that reaches the `main` branch is always checked.
- With manual tests we can go through a full checklist before each major milestone submission. These checklists would likely cover individual aspects and be run by someone who didn't build that part. Having a fresh tester reduces the risk that the implementer tests it in teh way they would expect it to work. This takes a long time, but doing it before major steps is a good compromise.
- Requirements for the minimum viable product (Sections 1–7 and 12) are verified first. The server and client–server rows (8–10) are verified as those features are built, and optional rows are only verified if they are built. This is important because a **working** base app is worth more than a partly working full feature set.
