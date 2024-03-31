<div align="center">
<!-- Title: -->
  <a href="https://github.com/TheAlgorithms/">
    <img src="https://raw.githubusercontent.com/TheAlgorithms/website/1cd824df116b27029f17c2d1b42d81731f28a920/public/logo.svg" height="100">
  </a>
  <h1><a href="https://github.com/TheAlgorithms/">The Algorithms</a> - Kotlin</h1>
<!-- Labels: -->
  <!-- First row: -->
  <a href="https://github.com/AppleBoiy/kotlin/blob/master/CONTRIBUTING.md">
    <img src="https://img.shields.io/static/v1.svg?label=Contributions&message=Welcome&color=0059b3&style=flat-square" height="20" alt="Contributions Welcome">
  </a>
  <a href="https://the-algorithms.com/discord">
    <img src="https://img.shields.io/discord/808045925556682782.svg?logo=discord&colorB=7289DA&style=flat-square" height="20" alt="Discord chat">
  </a>
  <a href="https://gitter.im/TheAlgorithms/community">
    <img src="https://img.shields.io/badge/Chat-Gitter-ff69b4.svg?label=Chat&logo=gitter&style=flat-square" height="20" alt="Gitter chat">
  </a>
  <!-- Second row: -->
  <br>
  <a href="https://github.com/AppleBoiy/Kotlin.git">
    <img src="https://img.shields.io/github/actions/workflow/status/AppleBoiy/Kotlin/build.yml?branch=master&label=CI&logo=github&style=flat-square" height="20" alt="GitHub Workflow Status">
  </a>
  <a href="https://github.com/pre-commit/pre-commit">
    <img src="https://img.shields.io/badge/pre--commit-enabled-brightgreen?logo=pre-commit&logoColor=white&style=flat-square" height="20" alt="pre-commit">
  </a>
<!-- Short description: -->
  <h3>All algorithms implemented in Kotlin - for education</h3>
</div>

# Disclaimer

This repository is forked from [TheAlgorithms/Kotlin](https://github.com/TheAlgorithms/Kotlin) and is maintained by [AppleBoiy](https://github.com/AppleBoiy). The original repository is maintained by [TheAlgorithms](https://github.com/TheAlgorithms).


# Contributing Guidelines

first of all, thank you for considering contributing to the Kotlin repository. We welcome contributions from everyone. By participating in this project, you agree to abide by the [code of conduct](.github/CODE_OF_CONDUCT.md).

# Getting Started

Read the [contribution guidelines](.github/CONTRIBUTING.md) to get started.

## Steps to raise a PR
- Fork the [Kotlin Repo](https://github.com/TheAlgorithms/Kotlin)
- Open the forked repo on your local machine through IntelliJ by importing the project as a Gradle project
- Make the changes on your local machine
- Push the changes to the forked repository
- Raise a PR against the master branch

## Usable commands

Gradle is used as the build tool for this project. Here are some useful commands:

- `./gradlew test` - to run the tests
- `./gradlew build` - to build the project

Makefile is also used to run the tests. Here are some useful commands:

- `make scan` - is alias for `gradle test` w/ `--scan` flag
- `make update-hooks` - is alias for `pre-commit install --install-hooks`

## pre-commit

This repository uses [pre-commit](https://pre-commit.com/) to ensure that the code is formatted correctly. To install pre-commit, run the following command:

```bash
pip install pre-commit
```

To install the pre-commit hooks, run the following command:

```bash
pre-commit install --install-hooks
```

To run the pre-commit checks on all files, run the following command:

```bash
pre-commit run --all-files
```


## List of Algorithms

See our [directory](DIRECTORY.md) for easier navigation and a better overview of the project.

# License

The algorithms are released under the [MIT License](LICENSE). You can find out more about it in the [LICENSE](LICENSE) file.
