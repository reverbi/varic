#!/bin/bash

# Deployment to Heroku
if [ "$TRAVIS_BRANCH" = "master" ] && [ ! "$TRAVIS_PULL_REQUEST" ]; then
  sbt ++$TRAVIS_SCALA_VERSION stage deployHeroku
else
  echo "Branch is not master or this is a pull request, skipping deployment."
fi
