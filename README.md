# SPEEDCUBING API
RESTful API for the speedcubing community that provides information about the different methods, algorithms, scrambles, etc. used in the speedcubing world.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction
This API is intended to be used by any developer who wants to create an application related to speedcubing.

## Features
- Get information about the different methods used in speedcubing.
- Get information about the different algorithms used in a method.
- Get cube scrambles.

## Installation
This project has been developed with Intellij IDEA and Java 17 with Gradle, so it is recommended to use this IDE and Java version to run the project. To install the project, follow these steps:
1. Clone the repository.
2. Open the project with Intellij IDEA.
3. Run the project.
4. In the endpoint section you can see the different endpoints that the API offers (This feature is only available in Intellij IDEA).

## Usage
The API is still under development, so it is not available yet.

## Endpoints
Currently, only these endpoints are available, but more will be added in the future.

The API offers the following endpoints:
- **/f2l**: Returns a list of all the F2L algorithms.
- **/f2l/{algorithm}**: Returns the information of the specified F2L algorithm.
- **/f2l/subsets**: Returns a list of all the F2L subsets.
- **/f2l/subsets/{subset}**: Returns a list of all the F2L algorithms of the specified subset.

For further information about the endpoints, you can check the API documentation in Swagger: _(Under development)_

## Contributing
If you want to contribute to this project, you can do it by following these steps:
1. Fork this repository.
2. Create a new branch with the feature name.
3. Commit and push the changes.
4. Create a pull request.
5. Wait for the pull request to be reviewed and merged.

## License
This project is licensed under the GNU GPLv3 License. See the [LICENSE](LICENSE) file for more information.




