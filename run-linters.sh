PROJECT_ROOT=$(readlink -f $(dirname $0))

# scalastyle
java -jar $PROJECT_ROOT/linters/scalastyle/scalastyle_2.11-0.6.0-batch.jar --config $PROJECT_ROOT/linters/scalastyle/scalastyle_config.xml $PROJECT_ROOT/app/controllers/

# coffeelint
coffeelint $PROJECT_ROOT/app/assets/javascripts/

