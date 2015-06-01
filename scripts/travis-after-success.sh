#!/bin/bash

# Coverage reporting
sbt clean coverage test
sbt coveralls

# Deployment to Heroku
if [ "$TRAVIS_BRANCH" = "master" ]; then
  sbt ++$TRAVIS_SCALA_VERSION stage deployHeroku
else
  echo "Branch is not master, skipping deployment."
fi
