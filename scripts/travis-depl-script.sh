#!/bin/bash
if [ "$TRAVIS_BRANCH" = "master" ]; then
  sbt ++$TRAVIS_SCALA_VERSION stage deployHeroku
else
  echo "Branch is not master, skipping deployment."
fi
