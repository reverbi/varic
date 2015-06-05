module.exports = function(grunt) {
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
  });

  grunt.loadNpmTasks('grunt-contrib-jasmine');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-concat');

  var appSrc = 'app/assets/javascripts/**/*.js';

  grunt.initConfig({
    jasmine: {
      specsAndCoverage: {
        src: appSrc,
        options: {
          specs: 'test/js/specs/**/*.spec.js',
          vendor: [
            'bower_components/angular/angular.js',
            'bower_components/angular-route/angular-route.js',
            'bower_components/angular-mocks/angular-mocks.js',
            'bower_components/angular-bootstrap/ui-bootstrap-tpls.js'
          ],
          summary: true,
          template: require('grunt-template-jasmine-istanbul'),
          templateOptions: {
            coverage: 'grunt-coverage/coverage.json',
            report: [
              {
                type: 'text'
              },
              {
                type: 'html',
                options: {
                  dir: 'grunt-coverage/html'
                }
              },
              {
                type: 'lcovonly',
                options: {
                  dir: 'grunt-coverage/lcov'
                }
              }
            ],
            thresholds: {
              lines: 70,
              statements: 70,
              branches: 70,
              functions: 80
            }
          }
        }
      }
    },
    jshint: {
      all: ['Gruntfile.js', appSrc, 'test/js/**/*.js']
    },
    concat: {
      options: {
        banner: "'use strict';\n\n"
      },
      dist: {
        src: appSrc,
        dest: 'public/javascripts/main.js'
      }
    }
  });

  grunt.registerTask('build', ['concat']);
  grunt.registerTask('test', ['jshint', 'jasmine']);
  grunt.registerTask('default', ['test']);
};
